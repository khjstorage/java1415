package kr.co.daumschool.item.db;

import java.util.Scanner;

public class Menu {
	public static Scanner sc = new Scanner(System.in);

	public static int item_Menu(){
		System.out.println("======상품테이블 메뉴========");
		System.out.println("1.상품 입력");
		System.out.println("2.상품 입고(상품 재고량 +)");
		System.out.println("3.상품 출고(상품 재고량 -)");
		System.out.println("4.상품 테이블 보기");
		System.out.println("5.종료");
		System.out.print("▶▶선택 (0 to 5 selection) : ");
		int choice = Menu.sc.nextInt();
		return choice;
	}
	
}
