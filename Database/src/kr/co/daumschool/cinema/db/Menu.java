 package kr.co.daumschool.cinema.db;

import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);

    public static int main_Menu(){
        System.out.println("======비트시네마========");
        System.out.println("1.회원가입");
        System.out.println("2.좌석 조회");
        System.out.println("3.좌석 예약");
        System.out.println("4.회원 예약 정보");
        System.out.println("5.비회원 예약 정보");
        System.out.println("6.종료");
        System.out.print("▶▶선택 (0 to 6 selection) : ");
        int choice = Menu.sc.nextInt();
        return choice;
    }
    
}