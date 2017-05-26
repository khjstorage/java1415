package kr.co.daumschool.order.db;

import java.util.Scanner;

public class Menu {
	public static Scanner sc = new Scanner(System.in);

	public static int main_Menu(){
		System.out.println("======메인 메뉴========");
		System.out.println("1.회원가입");
		System.out.println("2.로그인");
		System.out.println("3.종료");
		System.out.print("▶▶선택 (0 to 3 selection) : ");
		int choice = Menu.sc.nextInt();
		return choice;
	}

	public static int member_Menu(){
		System.out.println("======회원 메뉴========");
		System.out.println("1.전체 제품 보기");
		System.out.println("2.제품 구매");
		System.out.println("3.제품 반품");
		System.out.println("4.내 장바구니");
		System.out.println("5.로그아웃");
		System.out.print("▶▶선택 (0 to 5 selection) : ");
		int choice = Menu.sc.nextInt();
		return choice;
	}

}
