package kr.co.daumschool.init.db;


import java.util.Scanner;

class Menu {
	public static Scanner sc = new Scanner(System.in);

	public static int main_Menu(){
		System.out.println("======Data Base root========");
		System.out.println("1.DB ����");
		System.out.println("2.DB �������� (����)");
		System.out.println("3.DB ����");
		System.out.println("4.DB ����");
		System.out.println("5.DB ���");
		System.out.println("6.DB ������߰�");
		System.out.println("7.DB ����ڻ���");
		System.out.println("8.��������");
		System.out.println("9.����� ���Ѻο�\n");
		System.out.println("======Data Base user========");
		System.out.println("10.����� �α���");
		System.out.println("11.���Ѻο��� DB���");
		System.out.println("12.�����̼� ����");
		System.out.println("13.���ο� �Ӽ��߰�");
		System.out.println("14.Ʃ�� ����");
		System.out.println("15.Ʃ�� ����");
		System.out.println("16.Ʃ�� ����\n");
		System.out.println("==========SELECT============");
		System.out.println("17.�����̼� ��ȸ");
		System.out.println("18.SELECT (�����Լ��� �̿�)");
		System.out.println("19.SELECT (LIKE�� �̿�)");
		System.out.println("20.SELECT (�����Լ�+LIKE�� �̿�)");
		System.out.println("21.SELECT (�����Լ�+�񱳾���ڸ� �̿�)\n");
		
		System.out.print("�������� (0 to 20 selection) : ");
		int choice = Menu.sc.nextInt();
		return choice;

	}
}