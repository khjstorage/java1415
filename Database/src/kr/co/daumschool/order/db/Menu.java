package kr.co.daumschool.order.db;

import java.util.Scanner;

public class Menu {
	public static Scanner sc = new Scanner(System.in);

	public static int main_Menu(){
		System.out.println("======���� �޴�========");
		System.out.println("1.ȸ������");
		System.out.println("2.�α���");
		System.out.println("3.����");
		System.out.print("�������� (0 to 3 selection) : ");
		int choice = Menu.sc.nextInt();
		return choice;
	}

	public static int member_Menu(){
		System.out.println("======ȸ�� �޴�========");
		System.out.println("1.��ü ��ǰ ����");
		System.out.println("2.��ǰ ����");
		System.out.println("3.��ǰ ��ǰ");
		System.out.println("4.�� ��ٱ���");
		System.out.println("5.�α׾ƿ�");
		System.out.print("�������� (0 to 5 selection) : ");
		int choice = Menu.sc.nextInt();
		return choice;
	}

}
