 package kr.co.daumschool.cinema.db;

import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);

    public static int main_Menu(){
        System.out.println("======��Ʈ�ó׸�========");
        System.out.println("1.ȸ������");
        System.out.println("2.�¼� ��ȸ");
        System.out.println("3.�¼� ����");
        System.out.println("4.ȸ�� ���� ����");
        System.out.println("5.��ȸ�� ���� ����");
        System.out.println("6.����");
        System.out.print("�������� (0 to 6 selection) : ");
        int choice = Menu.sc.nextInt();
        return choice;
    }
    
}