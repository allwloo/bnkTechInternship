SELECT * FROM emp;
-- 비교연산자
/*
emp 테이블에서 sal가 2500~3500 사이에 들어있는 사원의 이름과 sla을 검색
*/
SELECT ename, sal FROM emp WHERE 
sal >= 2500 and sal <= 3500;

SELECT ename, sal FROM emp WHERE sal BETWEEN 2500 AND 3500;-- between은 low가 먼저 나와야하낟
/*
emp 테이블에서 사원번호가 7369이거나 7521이거나 7782인 사원을 검색
*/

SELECT * FROM emp WHERE empno=7369;
SELECT * FROM emp WHERE empno=7521;
SELECT * FROM emp WHERE empno=7782;

-- 2STEP
SELECT * FROM emp WHERE empno=7369 or empno=7521 or empno=7782;
SELECT * FROM emp WHERE empno!=7369 and empno<>7521 and empno!=7782;

-- 3STEP
SELECT * FROM emp WHERE EMPNO in(7369,7521,7782);
SELECT * FROM emp WHERE EMPNO not in(7369,7521,7782);

-- 와일드카드(%,_)와 라이크 연산자
-- emp 테이블에서 S로 이름이 시작되는 사원을 탐색, 그 사람의 job도 검색
SELECT ename,job FROM emp WHERE ename LIKE 'S%';
-- emp 테이브에서 사원의 이름에 s가 포함되어진 사원의 ㅣㅇ름과 job을 검색
SELECT ename, job FROM emp WHERE ename LIKE '%S%';
SELECT ename, job FROM emp WHERE ename LIKE '_M%';

SELECT ename, job, hiredate FROM emp WHERE hiredata LIKE '82%';