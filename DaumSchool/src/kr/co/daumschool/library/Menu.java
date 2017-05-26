package kr.co.daumschool.library;

import java.util.Scanner;


//선택버튼
interface INIT_MENU {
	int JOIN=1, QUIT=2, SEARCH=3, LIST=4, LOGIN=5, BOOK_RELATED=6, EXIT=7;
}

interface RANTAL_RETURN{
	int LIST=1, RANTAl=2, RETURN=3, EXIT=4;
}

interface BOOK_RELATED{
	int LIST=1, REGISTER=2, MODIFY=3, DELETE=4, INQUIRY=5, EXIT=6;

}

//예외처리
class MenuChoiceException extends Exception {
	int choice;
	public MenuChoiceException(int choice){
		super("잘못된 선택이 이뤄졌습니다.");
		this.choice = choice;
	}
	public void showWrongChoice(){
		System.out.println(choice+"번 에 해당하는 선택은 존재하지 않습니다.");
	}
}

//초기메뉴, 스캐너 함수
public class Menu {
	public static Scanner sc = new Scanner(System.in);
	public static void showMenu(){
		System.out.println("선택하세요...");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원탈퇴");
		System.out.println("3. 회원검색");
		System.out.println("4. 회원목록");
		System.out.println("5. 로그인 ▶▶ 도서대여 & 도서반납");
		System.out.println("6. 도서등록 & 수정 & 삭제 & 조회");
		System.out.println("7. 프로그램 종료");
		System.out.print("선택: ");
	}
	
}