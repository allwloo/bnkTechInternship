SELECT d.deptno, d.dname, e.ename, e.sal
FROM dept d, emp e
WHERE d.deptno = e.deptno;

SELECT *
FROM dept;


SELECT e.empno, e.ename, d.dname, d.loc, e.sal
FROM emp e, dept d
WHERE e.deptno = d.deptno AND e.job in (
    SELECT job FROM emp WHERE deptno = 10
)
ORDER BY e.sal DESC;

SELECT d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno and e.ename = 'SMITH';

SELECT e.empno, e.ename, e.job, s.grade, s.losal, s.hisal
FROM emp e, salgrade s
WHERE e.sal>=s.losal AND e.sal <= s.hisal;

-- ### outer join ###
-- 4.  dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라

SELECT e.ename, d.deptno, d.dname, e.sal
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;

SELECT e.ename||'의 매니저는 '||m.ename||'이다'
FROM emp e, emp m
WHERE e.mgr = m.empno;

SELECT e.empno, e.ename, e.mgr, m.ename
FROM emp e, emp m
WHERE e.mgr = m.empno and e.mgr = 7698;

SELECT e.empno, e.ename
FROM emp e, emp m
WHERE e.mgr = 7698;


SELECT e.empno, e.ename, e.sal, e.job, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno and
(job = 'MANAGER' or job = 'CLERK');

SELECT ename, job, deptno FROM emp;

SELECT  e.ename, d.dname, e.sal, e.job
FROM emp e, dept d
WHERE d.deptno = e.deptno
AND (SELECT job FROM emp WHERE ename = 'SMITH' ) = job;

SELECT e.empno, e.ename, e.hiredate, e.sal
FROM emp e, dept d
WHERE d.deptno = e.deptno
AND (SELECT d.deptno FROM dept d, emp e WHERE d.deptno = e.deptno and e.ename = 'JONES') = d.deptno;

SELECT e.empno, e.ename, d.dname, d.loc, e.sal
FROM emp e, dept d
WHERE d.deptno = e.deptno and e.sal > (SELECT avg(sal) FROM emp);

DELETE FROM emp WHERE empno = 8001;

SELECT e.empno, e.ename, d.dname, e.hiredate, d.loc
FROM dept d, emp e
WHERE e.deptno = d.deptno AND d.deptno = 10 AND e.job NOT IN
(SELECT e.job FROM dept d, emp e WHERE d.deptno = e.deptno AND d.deptno = 30);

SELECT * FROM dept, emp
WHERE dept.deptno = emp.deptno;

SELECT e.job FROM dept d, emp e WHERE d.deptno = 30;

SELECT e.empno, e.ename, e.sal
FROM emp e
WHERE sal IN (SELECT sal FROM emp WHERE ename = 'KING' or ename = 'JAMES');

select sal
from emp;

SELECT empno, ename, sal
FROM emp
WHERE sal > ALL(SELECT sal FROM emp WHERE deptno = 30);
