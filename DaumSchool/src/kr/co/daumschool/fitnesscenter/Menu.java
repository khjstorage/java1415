package kr.co.daumschool.fitnesscenter;

import java.util.Scanner;
/*
 * ���θ޴�
 * �����ڸ޴�
 *  ����ȸ�������޴�
 * ����ڸ޴�
 */
class Menu {
	public static Scanner sc = new Scanner(System.in);

	public static int main_Menu(){
		System.out.println("����������������������������java �ｺ�������α׷�����������������������������");
		System.out.println("    ��. ������ �α���");
		System.out.println("    ��. ȸ�� �α���");
		System.out.println("    ��. �ｺŬ�� ȸ������");
		System.out.println("    ��. ��  �� : ���α׷�����");
		System.out.println("����������������������������������������������������������������������������������������");
		System.out.print("�������� (1~3) : ");
		int choice = Menu.sc.nextInt();
		return choice;

	}

	public static int admin_Menu(){
		System.out.println("�����������������������������������ｺ�����ڸ�妡��������������������������������");
		System.out.println("   ��. Ʈ���̴װ�ȹ�� ����");
		System.out.println("   ��. ȸ������");
		System.out.println("      ����2-1. ��üȸ������");
		System.out.println("      ����2-1. ȸ������ �˻� �� ������(Ʈ���̴� ��ȹ��)");
		System.out.println("      ����2-2. ȸ������ ����");
		System.out.println("      ����2-3. ȸ������ ����");
		System.out.println("      ����2-4. ������");
		System.out.println("   ��. ��ȣ����");
		System.out.println("   ��. �����޴�");
		System.out.println("����������������������������������������������������������������������������������������");
		System.out.print("�������� (1~4) : ");
		int choice = Menu.sc.nextInt();
		return choice;
	}

	public static int member_Menu(){
		System.out.println("������������������������������������������ڸ�妡������������������������������������");
		System.out.println("   ��. Ʈ���̴װ�ȹ������");
		System.out.println("   ��. �ｺŬ����������");
		System.out.println("   ��. �α׾ƿ�");
		System.out.println("   ��. �����޴�");
		System.out.println("����������������������������������������������������������������������������������������");
		System.out.print("�������� (1~3) : ");
		int choice = Menu.sc.nextInt();
		return choice;
	}

	public static int member_Run_Menu(){
		System.out.println("��������������������������������������ȸ�� ������������������������������������������");
		System.out.println("   ��. ��üȸ������");
		System.out.println("   ��. ȸ���˻� �� ������");
		System.out.println("   ��. ȸ����������");
		System.out.println("   ��. ȸ������");
		System.out.println("   ��. �����޴�");
		System.out.println("����������������������������������������������������������������������������������������");
		System.out.print("�������� (1~5) : ");
		int choice = Menu.sc.nextInt();
		return choice;
	}
	

	
}