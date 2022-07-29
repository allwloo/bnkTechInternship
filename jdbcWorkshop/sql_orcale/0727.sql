SELECT * FROM emp WHERE ename LIKE '%s';

SELECT COUNT(-1) FROM emp;

SELECT COUNT(MGR) FROM emp;

--emp 테이블에서 부서 변호

SELECT  COUNT(DISTINCT(deptno)) FROM emp;

SELECT MIN(ename), MAX(ename), MIN(hiredate), MAX(hiredate) FROM emp;

SELECT AVG(sal), MAX(sal), MIN(sal), SUM(sal)
FROM emp
WHERE job = 'SALESMAN';

SELECT COUNT(-1) 총인원, COUNT(comm), AVG(comm) 보너스평균1 FROM emp;

SELECT AVG(NVL(comm,0)) 보너스평균2 FROM emp;

SELECT ROUND(AVG(sal)) FROM emp;

-- GROUP BY 절
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno;



-- 정렬
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno 
ORDER BY 2;

--3)Alias
--GROUP BY절 뒤에 Alias는 절대 사용 불가
SELECT deptno DNAME, ROUND(AVG(sal)) AvgSalary 
FROM emp 
GROUP BY deptno
ORDER BY 1;


--4)Alias
--ORDER BY절 뒤에는 사용 가능(Alias를 사용하는게 더 좋음)
SELECT deptno DNAME, ROUND(AVG(sal)) AvgSalary 
FROM emp 
GROUP BY deptno
ORDER BY AvgSalary;


SELECT deptno, COUNT(-1), AVG(sal), MIN(sal), max(sal), sum(sal)
FROM emp
GROUP BY deptno
ORDER BY sum(sal) desc;

SELECT job, count(-1), TRUNC(AVG(sal)), SUM(sal) FROM emp
GROUP BY job;

-- emp테이블에서 각 부서별 평균 급여를 구할건데요 그중에서 평균급여가 2000달러 이상
-- 인 사원의 이름, 평균급여를 검색
-- WHERE절에서는 그룹함수를 사용할 수 없다.
SELECT deptno, AVG(sal) 평균급여
FROM emp
GROUP BY deptno
HAVING AVG(sal) >= 2000;

SELECT deptno, count(-1), sum(sal)
FROM emp
GROUP BY deptno
HAVING count(-1) > 4;

SELECT deptno, avg(sal), sum(sal)
FROM emp
GROUP BY deptno
HAVING max(sal) > 2900;

SELECT job, avg(sal), SUM(sal)
FROM emp
GROUP BY job
HAVING avg(sal) >= 3000;

SELECT deptno, AVG(sal)
FROM emp
WHERE JOB = 'CLERK'
GROUP BY deptno
HAVING AVG(sal) > 1000;

SELECT MAX(SUM(sal))
FROM emp
GROUP BY deptno;

-- 입사년도별 인원수를 출력...

SELECT TO_CHAR(hiredate, 'YY') 입사년도, COUNT(-1) 인원수
FROM emp
GROUP BY TO_CHAR(hiredate, 'YY');

-- 20번 부서에서 가장 먼저 입사한 사원

SELECT deptno, MIN(TO_CHAR(hiredate, 'RR/MM/DD')
FROM emp
GROUP BY deptno
HAVING deptno = 20;

-- -소그룹간의 합계를 계산하는 기능
-- GROUP BY 절로 묶인 각각의 소그룹합계와 전체 합계 모두를 구하는 기능
SELECT deptno, count(-1), sum(sal)
FROM emp
GROUP BY ROLLUP(deptno);

SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY deptno, job;


SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno, job);

SELECT * FROM emp;
SELECT * FROM dept;

-- 1) 카티시안 결과 출력(조인 조건을 안줬다)
SELECT * FROM emp, dept;

-- EQUI 조인
-- 2) 조인조건을 지정
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno;-- 컬럼명을 직접 명시, 불필요한 컬럼명 노출되지 않도록
-- 

-- 3) 조인조건을 지정 + 컬럼명을 구체적으로 명시
-- 테이블 명을 명시해야 성능 저하의 원인이 되지 않음
SELECT empno, ename, emp.deptno, dname, loc 
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- 4) 컬럼명을 구체적으로 명시 + 컬럼명앞에 테이블명을 지정
SELECT e.empno, e.ename, e.deptno, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- 5) 4번 + 테이블 알리아스


-- 사원이름, 급여, 부서번호, 부서위치
SELECT e.ename, e.sal, e.deptno, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno AND e.sal >= 2000 AND e.deptno = 30;

SELECT e.empno, e.ename, e.job, e.sal, s.grade, s.losal, s.hisal
FROM salgrade s, emp e
WHERE e.sal >= s.losal AND e.sal <= s.hisal;

-- a,b 테이블을 조인할 경우, 조건에 맞지 않는 데이터도 표시하고 싶을 때

SELECT e.ename, e.deptno 부서번호1, d.deptno 부서번호2, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno; -- +는 데이터가 부족한 쪽에 붙인다.

-- RIGHT JOIN

SELECT e.ename, e.deptno 부서번호1, d.deptno 부서번호2, d.dname
FROM emp e RIGHT OUTER JOIN dept d -- RIGHT OUT JOIN은 데이터가 있는 쪽을 기준으로 삼는다.
ON e.deptno = d.deptno;


-- 예제 1 123p
SELECT e.empno, e.ename, e.job,e.deptno e_deptno,
    d.deptno d_deptno, d.dname
FROM dept d, emp e
WHERE d.deptno = e.deptno(+);

--예제 5 124p
SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND e.sal > 2000;

--예제 6 125p
SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno;

SELECT (e.ename||'의 매니저는'||m.ename||'입니다')
FROM emp e , emp m
WHERE e.mgr = m.empno;

--FULL OUTER JOIN
--두 테이블 모두 한가지씩 이상의 부족한 데이터를 가지고 있는 경우

CREATE TABLE outera (sawonid number(3));
CREATE TABLE outerb (sawonid number(3));

INSERT INTO outera VALUES(10);
INSERT INTO outera VALUES(20);
INSERT INTO outera VALUES(40);


INSERT INTO outerb VALUES(10);
INSERT INTO outerb VALUES(20);
INSERT INTO outerb VALUES(30);

SELECT sawonid FROM outera FULL OUTER JOIN outerb USING(sawonid);

-- SELF JOIN

/*
1. 특정사원의 상사 이름을 검색
2. 먼저 특정사원을 EML 테이블에서 검색 BLAKE
3. BLAKE에 대한 상사 번호를 검색... 7389
----
7839에 해당하는 사원번호를 검색
해당 사원번호의 이름을 검색


*/

SELECT * FROM (SELECT empno, ename, mgr FROM emp) e,
(SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;

SELECT e.empno, e.ename 사원이름, m.ename 상사이름
FROM emp e, emp m
WHERE e.mgr = m.empno
AND
e.ename = 'BLAKE';