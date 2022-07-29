-- CLARK ������� �� ���� �޿��� �޴� ����� �˻�.

SELECT sal FROM emp WHERE ename = 'CLARK';

SELECT ename, sal FROM emp WHERE sal > 2450;

-- step 2
-- ��������(INNER QUERY)�� �ݵ�� ()�� �ο����� �Ѵ�
SELECT ename, sal FROM emp WHERE sal>(SELECT sal FROM emp WHERE ename = 'CLARK'); -- ���ϵǴ� 2450: ��Į�� �� ONE ROW ONE COLUMN

-- ���������� �ݴ� ��������(OUTER QUERY)

SELECT empno, ename, job, sal, deptno
FROM emp
WHERE sal < (SELECT avg(sal) FROM emp);

SELECT deptno, min(sal)
FROM emp
GROUP BY deptno
HAVING min(sal) > (SELECT min(sal) FROM emp WHERE deptno = 20);

-- emp ���̺��� �޿��� ���� ���Թ޴� ��� 3���� �˻�

SELECT ename, job, sal 
FROM (SELECT * FROM emp ORDER BY sal)
WHERE rownum<=3;

/*
sal < ANY -> �ִ밪 ���� ���� sal ���ϱ�
sal > ANY -> �ּҰ� ���� ���� sal ���ϱ�

sal < ALL -> �ּҰ� ���� ���� sal
sal > ALL -> �ִ밪 ���� ���� sal
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