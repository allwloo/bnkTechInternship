-- 1) emp ���̺� ������ Ȯ���ϼ���.

SELECT * FROM emp;

-- 2) �μ���ȣ�� 20���� �μ��� ��� �� �����ȣ, �̸�, ������ ����ϼ���.

SELECT empno, ename, sal FROM emp WHERE deptno = 20;


-- 3) �����ȣ�� 7521�� ��� �� �̸�, �Ի���, �μ���ȣ�� ����ϼ���

SELECT ename, hiredate, deptno FROM emp WHERE empno = 7521;

-- 4) �̸��� JONES�� ����� ��� ������ ����ϼ���

SELECT * FROM emp WHERE ename = 'JONES';

-- 5) ������ MANAGER�� ����� ��� ������ ����ϼ���

SELECT * FROM emp WHERE job = 'MANAGER';

-- 6)������ MANAGER�� �ƴ� ����� ��� ������ ����ϼ���

SELECT * FROM emp WHERE job != 'MANAGER';

-- 7) �޿��� $1000 �̻��� ����� �̸�, �޿�, �μ���ȣ�� ����ϼ���

SELECT ename, sal, empno FROM emp WHERE sal >= 1000;

-- 8) �޿��� $1,600���� ũ�� $3,000���� ���� ����� �̸�, ����, �޿��� ����ϼ���.

SELECT ename, job, sal FROM emp WHERE sal > 1600 and sal < 3000;

-- 9) �Ի����� 80�⵵�� ����� ��� ������ ����ϼ���

SELECT * FROM emp WHERE hiredate LIKE '80%';


-- 10) �Ի����� 81/12/09 ���� ���� �Ի��� ������� ��� ������ ����ϼ���.

SELECT * FROM emp WHERE TO_CHAR(hiredate,'YYMMDD') < '811209';

-- 11) �̸��� S�� �����ϴ� ����� �����ȣ, �̸�, �Ի���, �޿��� ����ϼ���.

SELECT ename, hiredate, sal FROM emp WHERE ename LIKE 'S%';

-- 12) �̸� �� S�ڰ� �� �ִ� ����� ��� ������ ����ϼ���.

SELECT * FROM emp WHERE ename LIKE '%S%';

-- 13) Ŀ�̼��� NULL�� ����� ������ ����ϼ���.

SELECT * FROM emp WHERE comm is null;

-- 14) Ŀ�̼��� NULL�� �ƴ� ����� ��� ������ ����ϼ���.

SELECT * FROM emp WHERE comm is not null;

--15) �μ��� 30�� �μ��̰� �޿��� $1,500 �̻��� ����� �̸�, �μ� ,������ ����ϼ���.

SELECT ename, job, sal FROM emp WHERE sal >= 1500 and deptno = 30;

-- 16) �μ���ȣ�� 30�� ��� �� �����ȣ ������ �����ϼ���.

SELECT * FROM emp WHERE deptno = 30 ORDER BY empno;

-- 17) �޿��� ���� ������ �����ϼ���.

SELECT * FROM emp ORDER BY sal DESC;

-- 18) �μ���ȣ�� ASCENDING ������ �� �޿��� ���� ��� ������  ����ϼ���.

SELECT * FROM emp ORDER BY deptno, sal DESC;

-- 19) emp Table���� �̸�, �޿�, Ŀ�̼� �ݾ�(sal*comm/100), �Ѿ�(sal + comm)��  ���Ͽ� �Ѿ��� ���� ������ ����ϼ���. 
-- ��, Ŀ�̼��� NULL�� ����� �����Ѵ�.

SELECT ename, sal, sal*comm/100 "Ŀ�̼� �ݾ�", sal+comm �Ѿ� FROM emp WHERE comm is not null ORDER BY sal+comm desc;


-- 20)  10�� �μ��� ��� ����鿡�� �޿��� 13%�� ���ʽ��� �����ϱ�� �Ͽ���. �̸�, �޿�, ���ʽ� �ݾ�, �μ���ȣ�� ����ϼ���.

SELECT ename, sal, sal*0.13 "���ʽ� �ݾ�", deptno FROM emp WHERE deptno = 10;
