package kr.co.daumschool.fitnesscenter;

import java.util.Scanner;
/*
 * 메인메뉴
 * 관리자메뉴
 *  └→회원관리메뉴
 * 사용자메뉴
 */
class Menu {
	public static Scanner sc = new Scanner(System.in);

	public static int main_Menu(){
		System.out.println("──────────────java 헬스관리프로그램──────────────");
		System.out.println("    ①. 관리자 로그인");
		System.out.println("    ②. 회원 로그인");
		System.out.println("    ③. 헬스클럽 회원가입");
		System.out.println("    ④. 종  료 : 프로그램종료");
		System.out.println("────────────────────────────────────────────");
		System.out.print("▶▶선택 (1~3) : ");
		int choice = Menu.sc.nextInt();
		return choice;

	}

	public static int admin_Menu(){
		System.out.println("─────────────────헬스관리자모드─────────────────");
		System.out.println("   ①. 트레이닝계획서 수정");
		System.out.println("   ②. 회원관리");
		System.out.println("      ├→2-1. 전체회원보기");
		System.out.println("      ├→2-1. 회원정보 검색 및 상세정보(트레이닝 계획서)");
		System.out.println("      ├→2-2. 회원정보 수정");
		System.out.println("      ├→2-3. 회원정보 삭제");
		System.out.println("      └→2-4. 나가기");
		System.out.println("   ③. 암호변경");
		System.out.println("   ④. 이전메뉴");
		System.out.println("────────────────────────────────────────────");
		System.out.print("▶▶선택 (1~4) : ");
		int choice = Menu.sc.nextInt();
		return choice;
	}

	public static int member_Menu(){
		System.out.println("───────────────────사용자모드───────────────────");
		System.out.println("   ①. 트레이닝계획서선택");
		System.out.println("   ②. 헬스클럽정보보기");
		System.out.println("   ③. 로그아웃");
		System.out.println("   ④. 이전메뉴");
		System.out.println("────────────────────────────────────────────");
		System.out.print("▶▶선택 (1~3) : ");
		int choice = Menu.sc.nextInt();
		return choice;
	}

	public static int member_Run_Menu(){
		System.out.println("───────────────────회원 관리───────────────────");
		System.out.println("   ①. 전체회원보기");
		System.out.println("   ②. 회원검색 및 상세정보");
		System.out.println("   ③. 회원정보수정");
		System.out.println("   ④. 회원삭제");
		System.out.println("   ⑤. 이전메뉴");
		System.out.println("────────────────────────────────────────────");
		System.out.print("▶▶선택 (1~5) : ");
		int choice = Menu.sc.nextInt();
		return choice;
	}
	

	
}