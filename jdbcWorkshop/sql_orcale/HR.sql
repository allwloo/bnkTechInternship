SELECT * FROM emp;
-- �񱳿�����
/*
emp ���̺��� sal�� 2500~3500 ���̿� ����ִ� ����� �̸��� sla�� �˻�
*/
SELECT ename, sal FROM emp WHERE 
sal >= 2500 and sal <= 3500;

SELECT ename, sal FROM emp WHERE sal BETWEEN 2500 AND 3500;-- between�� low�� ���� ���;��ϳ�
/*
emp ���̺��� �����ȣ�� 7369�̰ų� 7521�̰ų� 7782�� ����� �˻�
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

-- ���ϵ�ī��(%,_)�� ����ũ ������
-- emp ���̺��� S�� �̸��� ���۵Ǵ� ����� Ž��, �� ����� job�� �˻�
SELECT ename,job FROM emp WHERE ename LIKE 'S%';
-- emp ���̺꿡�� ����� �̸��� s�� ���ԵǾ��� ����� �Ӥ����� job�� �˻�
SELECT ename, job FROM emp WHERE ename LIKE '%S%';
SELECT ename, job FROM emp WHERE ename LIKE '_M%';

SELECT ename, job, hiredate FROM emp WHERE hiredata LIKE '82%';