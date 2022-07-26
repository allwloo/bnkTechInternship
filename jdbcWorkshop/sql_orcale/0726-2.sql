SELECT DISTINCT(SUBSTR(job, 1,5)) FROM emp WHERE job = 'SALESMAN'; 
-- ���� �� �� ����** SELECT �ڿ� �ٷ� ����

-- emp���̺��� �μ���ȣ�� 10���μ��� ����� �Ի����� ���� �����ؼ� ���
-- 
SELECT ename, deptno, SUBSTR(hiredate,4,2) "�Ի��� ��", job FROM emp WHERE deptno = 10;

SELECT SUBSTR('HelloWorld', 6)
FROM dual;
SELECT SUBSTR('HelloWorld', -4) FROM dual;

SELECT empno, ename, deptno
FROM emp
WHERE LOWER(ename) = 'scott';

--emp ���̺��� blake��� ����� �����ȣ, �μ���ȣ, �̸��� ��� ù��° ��¥�� �빮�ڰ� ��µǵ���

SELECT empno, deptno, INITCAP(ename)  
FROM emp 
WHERE ename = 'BLAKE';

-- ����� �̸� ������ 6���� ö�ڰ� R�� ����� �̸��� �˻�
SELECT ename
FROM emp
WHERE INSTR(ename, 'R') = 6; 

-- �̹� �����򰡿� �����ؼ� ���Կ�
--emp ���̺��� ����� �̸��� 't'�� ������
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

-- SELECT TRIM('aaababaaa', 'a')FROM dual �̰� �ȵ�
SELECT TRIM('a' from 'aaababaaa') FROM dual;

SELECT TRIM('    bab    ') FROM dual;
SELECT TRIM('    ba b    ') FROM dual; -- ��� ���� ���Ŵ� �ȵȴ�.

-- ��� ������ �����Ϸ��� replace�� ���

SELECT REPLACE('    ba b    ', ' ', '') FROM dual;


SELECT ROUND(45.926, 2)FROM dual; -- �Ҽ��� �ι�° �ڸ����� ��� �ݿø��� ����° �ڸ�����
SELECT ROUND(45.926, -1) FROM dual;

SELECT sysdate+100 FROM dual;
SELECT sysdate-1 FROM dual;

SELECT TRUNC(abs(sysdate- to_Date('2022-07-18', 'YYYY-MM-DD')),3) FROM dual; -- �Լ� ��ø

SELECT sysdate-to_date('1998-01-21', 'YYYY-MM-DD') FROM dual;

SELECT ename,hiredate,sysdate,sysdate-TO_DATE(hiredate, 'RR-MM-DD') "Total days",
        abs(TRUNC((sysdate-hiredate)/7.0)) Weeks,
        abs(ROUND(mod((sysdate-hiredate),7),0)) DAYS FROM emp;
        
SELECT ename, hiredate, add_months(hiredate, 5) a_month
FROM emp
WHERE deptno in (10)
ORDER BY hiredate desc;

SELECT ename, hiredate, to_char(hiredate, '"19"YY"��" MM"��" DD"��') t_kor
FROM emp
WHERE deptno = 20
ORDER BY hiredate desc;

-- ���� ��¥�� 1���� ���° ������ ��ȸ�Ѵ�.
SELECT CEIL(TO_CHAR(sysdate, 'WW')/7) test
FROM dual;

SELECT TO_DATE('1998-01-21', 'YY-MM-DD')
FROM dual;

--�� ����帣�� �̸�, �Ի���, �Ի��Ϸκ��� ���� �� ��� �� ù��° �Ͽ����� ��¥�� �⵵ 4�ڸ�/ �� 2�ڸ�/ ���� ���·� �������� ��ȸ
SELECT ename, hiredate,
        TO_CHAR(NEXT_DAY(TRUNC(ADD_MONTHS(TO_DATE(hiredate,'RR/MM/DD'),6)), '�Ͽ���'),
        'YYYY/MM/DD') "NEXT 6 Month"
FROM emp; -- ���� ���

