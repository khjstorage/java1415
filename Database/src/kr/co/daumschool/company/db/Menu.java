package kr.co.daumschool.company.db;

import java.util.Scanner;


public class Menu {
    public static Scanner sc = new Scanner(System.in);

    public static int main_Menu(){
        System.out.println("======company 급여========");
        System.out.println("1.직원등록");
        System.out.println("2.직원 급여 목록");
        System.out.println("3.특정 직원 급여 보기");
        System.out.println("4.휴가 개월수 입력");
        System.out.println("5.휴가비 정산");
        System.out.println("6.종료");
        System.out.print("▶▶선택 (0 to 6 selection) : ");
        int choice = Menu.sc.nextInt();
        return choice;
    }
}

 
