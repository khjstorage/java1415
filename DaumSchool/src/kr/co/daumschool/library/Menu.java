package kr.co.daumschool.library;

import java.util.Scanner;


//���ù�ư
interface INIT_MENU {
	int JOIN=1, QUIT=2, SEARCH=3, LIST=4, LOGIN=5, BOOK_RELATED=6, EXIT=7;
}

interface RANTAL_RETURN{
	int LIST=1, RANTAl=2, RETURN=3, EXIT=4;
}

interface BOOK_RELATED{
	int LIST=1, REGISTER=2, MODIFY=3, DELETE=4, INQUIRY=5, EXIT=6;

}

//����ó��
class MenuChoiceException extends Exception {
	int choice;
	public MenuChoiceException(int choice){
		super("�߸��� ������ �̷������ϴ�.");
		this.choice = choice;
	}
	public void showWrongChoice(){
		System.out.println(choice+"�� �� �ش��ϴ� ������ �������� �ʽ��ϴ�.");
	}
}

//�ʱ�޴�, ��ĳ�� �Լ�
public class Menu {
	public static Scanner sc = new Scanner(System.in);
	public static void showMenu(){
		System.out.println("�����ϼ���...");
		System.out.println("1. ȸ������");
		System.out.println("2. ȸ��Ż��");
		System.out.println("3. ȸ���˻�");
		System.out.println("4. ȸ�����");
		System.out.println("5. �α��� ���� �����뿩 & �����ݳ�");
		System.out.println("6. ������� & ���� & ���� & ��ȸ");
		System.out.println("7. ���α׷� ����");
		System.out.print("����: ");
	}
	
}