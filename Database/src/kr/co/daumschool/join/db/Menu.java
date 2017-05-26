package kr.co.daumschool.join.db;

import java.util.Scanner;

public class Menu {
	public static Scanner sc = new Scanner(System.in);

	public static int start_Menu(){
		System.out.println("======회원가입 메뉴========");
		System.out.println("1.회원가입");
		System.out.println("2.로그인");
		System.out.println("3.로그아웃");
		System.out.println("4.조회");
		System.out.println("5.종료");
		System.out.print("▶▶선택 (0 to 5 selection) : ");
		int choice = Menu.sc.nextInt();
		return choice;
	}	
}
