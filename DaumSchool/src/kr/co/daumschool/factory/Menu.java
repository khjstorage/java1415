package kr.co.daumschool.factory;

import java.util.Scanner;

class Menu {
	public static Scanner sc = new Scanner(System.in);

	public static int main_Menu(){
		System.out.println("\n����������������������������������������â�� ���ý��ۦ���������������������������������������");
		System.out.println("    ��. ����");
		System.out.println("    ��. ��ȸ(ȸ�� ��������)");
		System.out.println("    ��. ���(���� â�� ����)");
		System.out.println("    ��. �α�ǰ��(ȸ�� ����ǰ���� ���� ���� �ȸ���ǰ)");
		System.out.println("    ��. ����");
		System.out.println("����������������������������������������������������������������������������������������������������");
		System.out.print("�������� (1~5) : ");
		int choice = Menu.sc.nextInt();
		return choice;

	}

}