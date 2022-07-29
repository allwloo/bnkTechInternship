-- CLARK 사원보다 더 많은 급여를 받는 사람을 검색.

SELECT sal FROM emp WHERE ename = 'CLARK';

SELECT ename, sal FROM emp WHERE sal > 2450;

-- step 2
-- 서브쿼리(INNER QUERY)는 반드시 ()로 싸여져야 한다
SELECT ename, sal FROM emp WHERE sal>(SELECT sal FROM emp WHERE ename = 'CLARK'); -- 리턴되는 2450: 스칼라 값 ONE ROW ONE COLUMN

-- 서브쿼리의 반대 메인쿼리(OUTER QUERY)

SELECT empno, ename, job, sal, deptno
FROM emp
WHERE sal < (SELECT avg(sal) FROM emp);

SELECT deptno, min(sal)
FROM emp
GROUP BY deptno
HAVING min(sal) > (SELECT min(sal) FROM emp WHERE deptno = 20);

-- emp 테이블에서 급여를 가장 적게받는 사람 3명을 검색

SELECT ename, job, sal 
FROM (SELECT * FROM emp ORDER BY sal)
WHERE rownum<=3;

/*
sal < ANY -> 최대값 보다 작은 sal 구하기
sal > ANY -> 최소값 보다 작은 sal 구하기

sal < ALL -> 최소값 보다 작은 sal
sal > ALL -> 최대값 보다 작은 sal
*/

SELECT ename, job, hiredate, deptno
FROM emp
WHERE job != 'salesman' and  sal > (SELECT max(sal) FROM emp WHERE job = 'salesman');

SELECT mgr, deptno
FROM emp
WHERE ename IN ('FORD', 'BLAKE');

SELECT ename, mgr, deptno
FROM emp
WHERE mgr IN (SELECT mgr FROM EMP
                            WHERE ename IN ('FORD','BLAKE'))
AND deptno IN (SELECT deptno FROM EMP
                            WHERE ename IN ('FORD', 'BLAKE'))
AND ename NOT IN ('FORD','BLAKE');

SELECT ename, mgr, deptno
FROM emp
WHERE mgr IN(7839, 7566) AND
        deptno IN(30,20)
        AND ename NOT IN ('FORD','BLAKE');

SELECT ename, mgr, deptno
FROM emp
WHERE (mgr,deptno) IN (SELECT mgr, deptno
                        FROM emp
                        WHERE ename IN ('FORD','BLAKE'))
AND ename NOT IN ('FORD','BLAKE');

SELECT ename, mgr, deptno
FROM emp
WHERE (mgr, deptno) IN ((7839,30),(7566,20))
        AND ename NOT IN ('FORD','BLAKE');
        
CREATE table trade(
   quantitiy number not null,
   ssn varchar2(20),
   stock_num varchar2(20)
);

CREATE table CUSTOMER(
    ssn varchar2(20),
    name varchar2(50), 
    address varchar2(100),
    CONSTRAINT customer_pk PRIMARY KEY(ssn)
);

CREATE table stock(
    stock_num varchar2(10),
    price number,
    CONSTRAINT stock_pk PRIMARY KEY(stock_num)
);

ALTER TABLE trade
ADD CONSTRAINT ssn_fk foreign KEY(ssn) references customer (ssn);

ALTER TABLE trade
ADD CONSTRAINT stock_num_fk foreign KEY(stock_num) references stock (stock_num);