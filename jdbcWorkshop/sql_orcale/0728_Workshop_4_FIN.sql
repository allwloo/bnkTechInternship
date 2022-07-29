-- ### equi join ###

-- 1.  emp�� dept Table�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿���  ����϶�.

SELECT d.deptno, d.dname, e.ename, e.sal
FROM dept d, emp e
WHERE d.deptno = e.deptno;



-- 2.  �̸��� ��SMITH���� ����� �μ����� ����϶�.

SELECT d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno and e.ename = 'SMITH';


--  ### Non Equi join ###
--3. �����ȣ, �̸� ,����, �޿�, �޿��� ���, ���� ��, ���� ���� ����϶�.

SELECT e.empno, e.ename, e.job, s.grade, s.losal, s.hisal
FROM emp e, salgrade s
WHERE e.sal>=s.losal AND e.sal <= s.hisal;

 
-- ### outer join ###
-- 4.  dept Table�� �ִ� ��� �μ��� ����ϰ�, emp Table�� �ִ� 
-- DATA�� JOIN�Ͽ� ��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ��� �϶�.

SELECT e.ename, e.deptno, d.dname, e.sal
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;


-- ###self join###
-- 5.  emp Table�� �ִ� empno�� mgr�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�.
��SMTH�� �Ŵ����� FORD�̴١�

SELECT e.ename||'�� �Ŵ����� '||m.ename||'�̴�'
FROM emp e, emp m
WHERE e.mgr = m.empno;




-- ### join �ǽ� ###

-- 1. �����ڰ� 7698�� ����� �̸�, �����ȣ, �����ڹ�ȣ, �����ڸ��� ����϶�.

SELECT e.empno, e.ename, e.mgr, m.ename
FROM emp e, emp m
WHERE e.mgr = m.empno and e.mgr = 7698;



-- 2. ������ MANAGER�̰ų� CLERK�� ����� �����ȣ, �̸�, �޿�, ����, �μ���

SELECT e.empno, e.ename, e.sal, e.job, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno and
(job = 'MANAGER' or job = 'CLERK');


-- ### SubQuery ###
-- 1.  ��SMITH'�� ������ ���� ����� �̸�, �μ���, �޿�, ������  ����϶�.

SELECT  e.ename, d.dname, e.sal, e.job
FROM emp e, dept d
WHERE d.deptno = e.deptno
AND (SELECT job FROM emp WHERE ename = 'SMITH' ) = job;


-- 2.  ��JONES���� �����ִ� �μ��� ��� ����� �����ȣ, �̸�, �Ի���, �޿��� ����϶�.

SELECT e.empno, e.ename, e.hiredate, e.sal
FROM emp e, dept d
WHERE d.deptno = e.deptno
AND (SELECT d.deptno FROM dept d, emp e WHERE d.deptno = e.deptno and e.ename = 'JONES') = d.deptno;


-- 3.  ��ü ����� ��ձ޿����� �޿��� ���� ����� �����ȣ, �̸�,�μ���, �Ի���, ����, �޿��� ����϶�.


SELECT e.empno, e.ename, d.dname, d.loc, e.sal
FROM emp e, dept d
WHERE d.deptno = e.deptno and e.sal > (SELECT avg(sal) FROM emp);


-- 4. 10�� �μ��� ���� ���� �ϴ� ����� �����ȣ, �̸�, �μ���,����, �޿��� �޿��� ���� ������ ����϶�.

SELECT e.empno, e.ename, d.dname, d.loc, e.sal
FROM emp e, dept d
WHERE e.deptno = d.deptno AND e.job in (
    SELECT job FROM emp WHERE deptno = 10
)
ORDER BY e.sal DESC;



-- 5.  10�� �μ� �߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, �̸�, �μ���, �Ի���, ������ ����϶�.

SELECT e.empno, e.ename, d.dname, e.hiredate, d.loc
FROM dept d, emp e
WHERE e.deptno = d.deptno AND d.deptno = 10 AND e.job NOT IN
(SELECT e.job FROM dept d, emp e WHERE d.deptno = e.deptno AND d.deptno = 30)


--6.  ��KING���̳� ��JAMES'�� �޿��� ���� ����� �����ȣ, �̸�,�޿��� ����϶�.

SELECT e.empno, e.ename, e.sal
FROM emp e
WHERE sal IN (SELECT sal FROM emp WHERE ename = 'KING' or ename = 'JAMES');



-- 7.  �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ,�̸�, �޿��� ����϶�.


SELECT empno, ename, sal
FROM emp
WHERE sal > ALL(SELECT sal FROM emp WHERE deptno = 30);

