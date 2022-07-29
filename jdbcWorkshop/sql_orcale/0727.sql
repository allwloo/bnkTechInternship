SELECT * FROM emp WHERE ename LIKE '%s';

SELECT COUNT(-1) FROM emp;

SELECT COUNT(MGR) FROM emp;

--emp ���̺��� �μ� ��ȣ

SELECT  COUNT(DISTINCT(deptno)) FROM emp;

SELECT MIN(ename), MAX(ename), MIN(hiredate), MAX(hiredate) FROM emp;

SELECT AVG(sal), MAX(sal), MIN(sal), SUM(sal)
FROM emp
WHERE job = 'SALESMAN';

SELECT COUNT(-1) ���ο�, COUNT(comm), AVG(comm) ���ʽ����1 FROM emp;

SELECT AVG(NVL(comm,0)) ���ʽ����2 FROM emp;

SELECT ROUND(AVG(sal)) FROM emp;

-- GROUP BY ��
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno;



-- ����
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno 
ORDER BY 2;

--3)Alias
--GROUP BY�� �ڿ� Alias�� ���� ��� �Ұ�
SELECT deptno DNAME, ROUND(AVG(sal)) AvgSalary 
FROM emp 
GROUP BY deptno
ORDER BY 1;


--4)Alias
--ORDER BY�� �ڿ��� ��� ����(Alias�� ����ϴ°� �� ����)
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

-- emp���̺��� �� �μ��� ��� �޿��� ���Ұǵ��� ���߿��� ��ձ޿��� 2000�޷� �̻�
-- �� ����� �̸�, ��ձ޿��� �˻�
-- WHERE�������� �׷��Լ��� ����� �� ����.
SELECT deptno, AVG(sal) ��ձ޿�
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

-- �Ի�⵵�� �ο����� ���...

SELECT TO_CHAR(hiredate, 'YY') �Ի�⵵, COUNT(-1) �ο���
FROM emp
GROUP BY TO_CHAR(hiredate, 'YY');

-- 20�� �μ����� ���� ���� �Ի��� ���

SELECT deptno, MIN(TO_CHAR(hiredate, 'RR/MM/DD')
FROM emp
GROUP BY deptno
HAVING deptno = 20;

-- -�ұ׷찣�� �հ踦 ����ϴ� ���
-- GROUP BY ���� ���� ������ �ұ׷��հ�� ��ü �հ� ��θ� ���ϴ� ���
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

-- 1) īƼ�þ� ��� ���(���� ������ �����)
SELECT * FROM emp, dept;

-- EQUI ����
-- 2) ���������� ����
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno;-- �÷����� ���� ���, ���ʿ��� �÷��� ������� �ʵ���
-- 

-- 3) ���������� ���� + �÷����� ��ü������ ���
-- ���̺� ���� ����ؾ� ���� ������ ������ ���� ����
SELECT empno, ename, emp.deptno, dname, loc 
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- 4) �÷����� ��ü������ ��� + �÷���տ� ���̺���� ����
SELECT e.empno, e.ename, e.deptno, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- 5) 4�� + ���̺� �˸��ƽ�


-- ����̸�, �޿�, �μ���ȣ, �μ���ġ
SELECT e.ename, e.sal, e.deptno, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno AND e.sal >= 2000 AND e.deptno = 30;

SELECT e.empno, e.ename, e.job, e.sal, s.grade, s.losal, s.hisal
FROM salgrade s, emp e
WHERE e.sal >= s.losal AND e.sal <= s.hisal;

-- a,b ���̺��� ������ ���, ���ǿ� ���� �ʴ� �����͵� ǥ���ϰ� ���� ��

SELECT e.ename, e.deptno �μ���ȣ1, d.deptno �μ���ȣ2, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno; -- +�� �����Ͱ� ������ �ʿ� ���δ�.

-- RIGHT JOIN

SELECT e.ename, e.deptno �μ���ȣ1, d.deptno �μ���ȣ2, d.dname
FROM emp e RIGHT OUTER JOIN dept d -- RIGHT OUT JOIN�� �����Ͱ� �ִ� ���� �������� ��´�.
ON e.deptno = d.deptno;


-- ���� 1 123p
SELECT e.empno, e.ename, e.job,e.deptno e_deptno,
    d.deptno d_deptno, d.dname
FROM dept d, emp e
WHERE d.deptno = e.deptno(+);

--���� 5 124p
SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND e.sal > 2000;

--���� 6 125p
SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno;

SELECT (e.ename||'�� �Ŵ�����'||m.ename||'�Դϴ�')
FROM emp e , emp m
WHERE e.mgr = m.empno;

--FULL OUTER JOIN
--�� ���̺� ��� �Ѱ����� �̻��� ������ �����͸� ������ �ִ� ���

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
1. Ư������� ��� �̸��� �˻�
2. ���� Ư������� EML ���̺��� �˻� BLAKE
3. BLAKE�� ���� ��� ��ȣ�� �˻�... 7389
----
7839�� �ش��ϴ� �����ȣ�� �˻�
�ش� �����ȣ�� �̸��� �˻�


*/

SELECT * FROM (SELECT empno, ename, mgr FROM emp) e,
(SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;

SELECT e.empno, e.ename ����̸�, m.ename ����̸�
FROM emp e, emp m
WHERE e.mgr = m.empno
AND
e.ename = 'BLAKE';