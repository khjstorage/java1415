package kr.co.daumschool.join.db;

import java.util.Scanner;

public class Menu {
	public static Scanner sc = new Scanner(System.in);

	public static int start_Menu(){
		System.out.println("======ȸ������ �޴�========");
		System.out.println("1.ȸ������");
		System.out.println("2.�α���");
		System.out.println("3.�α׾ƿ�");
		System.out.println("4.��ȸ");
		System.out.println("5.����");
		System.out.print("�������� (0 to 5 selection) : ");
		int choice = Menu.sc.nextInt();
		return choice;
	}	
}
