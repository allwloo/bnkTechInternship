SELECT DISTINCT(SUBSTR(job, 1,5)) FROM emp WHERE job = 'SALESMAN'; 
-- 시험 낼 수 있음** SELECT 뒤에 바로 쓰임

-- emp테이블에서 부서번호가 10번부서인 사원의 입사일중 월만 추출해서 출력
-- 
SELECT ename, deptno, SUBSTR(hiredate,4,2) "입사한 월", job FROM emp WHERE deptno = 10;

SELECT SUBSTR('HelloWorld', 6)
FROM dual;
SELECT SUBSTR('HelloWorld', -4) FROM dual;

SELECT empno, ename, deptno
FROM emp
WHERE LOWER(ename) = 'scott';

--emp 테이블에서 blake라는 사람의 사원번호, 부서번호, 이름을 출력 첫번째 글짜가 대문자가 출력되도록

SELECT empno, deptno, INITCAP(ename)  
FROM emp 
WHERE ename = 'BLAKE';

-- 사원의 이름 마지막 6번쩨 철자가 R인 사원의 이름을 검색
SELECT ename
FROM emp
WHERE INSTR(ename, 'R') = 6; 

-- 이번 과목평가에 응용해서 낼게요
--emp 테이블에서 사원의 이름이 't'로 끝나는
SELECT ename, job, hiredate
FROM emp
WHERE ename like '%S';

SELECT ename, job, hiredate
FROM emp
WHERE INSTR(ename,'S', -1,1) = LENGTH(ename);

SELECT ename, job, hiredate
FROM emp
WHERE SUBSTR(ename, -1, 1) = 'S';

SELECT empno, ename, job, CONCAT(empno, ename) ename,CONCAT(ename,empno) e_empno, CONCAT(ename, job) e_job FROM emp;

SELECT LPAD('abc', 6, '*') FROM dual;
SELECT RPAD('abc', 6, '*') FROM dual;

-- SELECT TRIM('aaababaaa', 'a')FROM dual 이거 안됨
SELECT TRIM('a' from 'aaababaaa') FROM dual;

SELECT TRIM('    bab    ') FROM dual;
SELECT TRIM('    ba b    ') FROM dual; -- 가운데 공백 제거는 안된다.

-- 가운데 공백을 제거하려면 replace를 사용

SELECT REPLACE('    ba b    ', ' ', '') FROM dual;


SELECT ROUND(45.926, 2)FROM dual; -- 소숫점 두번째 자리까지 출력 반올림은 세번째 자리에서
SELECT ROUND(45.926, -1) FROM dual;

SELECT sysdate+100 FROM dual;
SELECT sysdate-1 FROM dual;

SELECT TRUNC(abs(sysdate- to_Date('2022-07-18', 'YYYY-MM-DD')),3) FROM dual; -- 함수 중첩

SELECT sysdate-to_date('1998-01-21', 'YYYY-MM-DD') FROM dual;

SELECT ename,hiredate,sysdate,sysdate-TO_DATE(hiredate, 'RR-MM-DD') "Total days",
        abs(TRUNC((sysdate-hiredate)/7.0)) Weeks,
        abs(ROUND(mod((sysdate-hiredate),7),0)) DAYS FROM emp;
        
SELECT ename, hiredate, add_months(hiredate, 5) a_month
FROM emp
WHERE deptno in (10)
ORDER BY hiredate desc;

SELECT ename, hiredate, to_char(hiredate, '"19"YY"년" MM"월" DD"일') t_kor
FROM emp
WHERE deptno = 20
ORDER BY hiredate desc;

-- 오늘 날짜가 1년중 몇번째 주인지 조회한다.
SELECT CEIL(TO_CHAR(sysdate, 'WW')/7) test
FROM dual;

SELECT TO_DATE('1998-01-21', 'YY-MM-DD')
FROM dual;

--각 사원드르이 이름, 입사일, 입사일로부터 여섯 달 경과 후 첫번째 일요일의 날짜를 년도 4자리/ 월 2자리/ 일자 형태로 나오도록 조회
SELECT ename, hiredate,
        TO_CHAR(NEXT_DAY(TRUNC(ADD_MONTHS(TO_DATE(hiredate,'RR/MM/DD'),6)), '일요일'),
        'YYYY/MM/DD') "NEXT 6 Month"
FROM emp; -- 수정 요망

