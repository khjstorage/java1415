package kr.co.daumschool.init.db;


import java.util.Scanner;

class Menu {
	public static Scanner sc = new Scanner(System.in);

	public static int main_Menu(){
		System.out.println("======Data Base root========");
		System.out.println("1.DB 연결");
		System.out.println("2.DB 연결해제 (종료)");
		System.out.println("3.DB 생성");
		System.out.println("4.DB 삭제");
		System.out.println("5.DB 목록");
		System.out.println("6.DB 사용자추가");
		System.out.println("7.DB 사용자삭제");
		System.out.println("8.서버갱신");
		System.out.println("9.사용자 권한부여\n");
		System.out.println("======Data Base user========");
		System.out.println("10.사용자 로그인");
		System.out.println("11.권한부여된 DB목록");
		System.out.println("12.릴레이션 생성");
		System.out.println("13.새로운 속성추가");
		System.out.println("14.튜플 삽입");
		System.out.println("15.튜플 수정");
		System.out.println("16.튜플 삭제\n");
		System.out.println("==========SELECT============");
		System.out.println("17.릴레이션 조회");
		System.out.println("18.SELECT (집계함수를 이용)");
		System.out.println("19.SELECT (LIKE를 이용)");
		System.out.println("20.SELECT (집계함수+LIKE를 이용)");
		System.out.println("21.SELECT (집계함수+비교언산자를 이용)\n");
		
		System.out.print("▶▶선택 (0 to 20 selection) : ");
		int choice = Menu.sc.nextInt();
		return choice;

	}
}