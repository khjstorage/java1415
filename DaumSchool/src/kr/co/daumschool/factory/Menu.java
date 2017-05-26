package kr.co.daumschool.factory;

import java.util.Scanner;

class Menu {
	public static Scanner sc = new Scanner(System.in);

	public static int main_Menu(){
		System.out.println("\n────────────────────창고 재고시스템────────────────────");
		System.out.println("    ①. 구매");
		System.out.println("    ②. 조회(회원 구매정보)");
		System.out.println("    ③. 재고(현재 창고 상태)");
		System.out.println("    ④. 인기품목(회원 구매품목중 가장 많이 팔린물품)");
		System.out.println("    ⑤. 종료");
		System.out.println("──────────────────────────────────────────────────");
		System.out.print("▶▶선택 (1~5) : ");
		int choice = Menu.sc.nextInt();
		return choice;

	}

}