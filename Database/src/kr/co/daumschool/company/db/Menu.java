package kr.co.daumschool.company.db;

import java.util.Scanner;


public class Menu {
    public static Scanner sc = new Scanner(System.in);

    public static int main_Menu(){
        System.out.println("======company �޿�========");
        System.out.println("1.�������");
        System.out.println("2.���� �޿� ���");
        System.out.println("3.Ư�� ���� �޿� ����");
        System.out.println("4.�ް� ������ �Է�");
        System.out.println("5.�ް��� ����");
        System.out.println("6.����");
        System.out.print("�������� (0 to 6 selection) : ");
        int choice = Menu.sc.nextInt();
        return choice;
    }
}

 
