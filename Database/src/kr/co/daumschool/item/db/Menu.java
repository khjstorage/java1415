package kr.co.daumschool.item.db;

import java.util.Scanner;

public class Menu {
	public static Scanner sc = new Scanner(System.in);

	public static int item_Menu(){
		System.out.println("======��ǰ���̺� �޴�========");
		System.out.println("1.��ǰ �Է�");
		System.out.println("2.��ǰ �԰�(��ǰ ��� +)");
		System.out.println("3.��ǰ ���(��ǰ ��� -)");
		System.out.println("4.��ǰ ���̺� ����");
		System.out.println("5.����");
		System.out.print("�������� (0 to 5 selection) : ");
		int choice = Menu.sc.nextInt();
		return choice;
	}
	
}
