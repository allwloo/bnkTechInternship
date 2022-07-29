SELECT deptno, AVG(sal) FROM emp;
== not a single 


  SELECT ename, mgr, deptno
  FROM EMP
  WHERE mgr IN (SELECT mgr FROM emp WHERE ename IN ('FORD','BLAKE'));
  

SELECT ename AS name, sal, sal*12 "Annual Sal"
FROM emp;

SELECT ename || ' is a '|| job AS "Employees Detials" FROM emp;

SELECT ROWID, ROWNUM, ename, empno FROM emp;

SELECT COUNT(DISTINCT(JOB)) FROM emp;

SELECT empno, ename, job, sal FROM emp WHERE job = 'MANAGER';

SELECT empno, ename, job, sal
FROM emp
WHERE sal >= 3000;

SELECT ename, sal, deptno
FROM emp
WHERE deptno != 30;

SELECT empno, ename, job, sal
FROM emp
WHERE comm IS NOT NULL;

SELECT ename, INSTR(ename, 'L', 3, 1) FROM emp;

SELECT ename, job, LTRIM(job,'A'), sal, LTRIM(sal,1)
FROM emp
WHERE deptno = 20;

SELECT ename,REPLACE(ename,'SC','*?') 변경결과
FROM emp
WHERE deptno = 20;

SELECT sysdate FROM emp;

SELECT ename, hiredate, sysdate, sysdate-hiredate "Total Days",
        trunc((sysdate()-hiredate)/7,0) Weeks,
        round(mod((sysdate-hiredate),7),0) DAYS
FROM emp
ORDER BY sysdate-hiredate desc;

SELECT ename, hiredate, hiredate +3, hiredate + 5/24
FROM emp
WHERE deptno = 30;

SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal
            FROM emp
            WHERE empno = 7566);
            
            
SELECT empno, ename, job, hiredate, sal
FROM emp
WHERE job = (SELECT job FROM emp
                            WHERE empno = 7521)
AND sal > (SELECT sal FROM emp
            WHERE empno = 7934);
            
SELECT ename, deptno, sal, hiredate
FROM emp
WHERE sal = (SELECT MAX(sal) FROM emp);

DELETE FROM emp WHERE empno = 7369;

UPDATE emp SET ename = '근영', sal = 30000 WHERE empno=7499;

SELECT * FROM emp;

-- 날짜함수 조지기

INSERT INTO emp (empno, ename, sal) VALUES (3000,'욱진',10000);

SELECT *
FROM dept d RIGHT OUTER JOIN emp e
ON d.deptno=e.deptno; 

SELECT *
FROM emp
WHERE sal IN (SELECT sal FROM emp WHERE sal = 5000);

SELECT e.empno, e.ename, e.sal;

SELECT DISTINCT deptno FROM emp;

SELECT ename, job, hiredate FROM emp WHERE SUBSTR(ename, -1, 1) = 'S';