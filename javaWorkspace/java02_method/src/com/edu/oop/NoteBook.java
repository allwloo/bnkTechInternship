package com.edu.oop;
/*
 * ���� �ٽ� �̽�
 * 
 * object Class							|					~ Test (�׽�Ʈ Ŭ����, ���� Ŭ����)
 * ������ ���� = ������ ���										main() �� �ִ� ---> ������ ���
 * 						
 * �������													1.��ü����==Ŭ������ ����� �޸𸮿� �ø���
 * �ʵ�(�������) : ���� ����Ǵ� ����								2.����
 * �޼ҵ�(�Լ�)  : ���											   �ʵ� -> �� �Ҵ�
 * 															    �޼ҵ� -> ȣ��
 
 *�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
 */
public class NoteBook {
	//1. �ʵ� ����
	public String brand;
	public int price;
	public int serialNumber;
	
	//2. �޼ҵ�
	public void printNoteBookInfo() //�޼ҵ� ����� .. return type + �޼ҵ� �̸� (�Ű�����)
	{
		System.out.println("NoteBookInfo :: "+brand+","+price+","+serialNumber); // �޼ҵ� ������
	}
	
	//3. �޼ҵ� �߰�
	// ��Ʈ���� �귣�带 �����ϴ� ����� �߰�.
	
	public String getBrand() {
		return brand; // �޼ҵ带 ȣ���� �������� ���� ���ϵȴ�.
	}
}
