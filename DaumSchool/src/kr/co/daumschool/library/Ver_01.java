package kr.co.daumschool.library;

public class Ver_01 {
	public static void main(String[] args) {
		
		Libray_Manager control = new Libray_Manager();
	
		int choice;

		while(true){
			try{
				Menu.showMenu();
				choice = Menu.sc.nextInt();

				if(choice < INIT_MENU.JOIN || choice > INIT_MENU.EXIT)
					throw new MenuChoiceException(choice);

				switch(choice){

				case INIT_MENU.JOIN:						//회원가입
					control.input_Member_Info();
					break;	
				case INIT_MENU.QUIT:						//회원탈퇴
					control.quit_Data();
					break;
				case INIT_MENU.SEARCH:					//회원검색
					control.search_Member_Info();
					break;
				case INIT_MENU.LIST:						//회원목록
					control.show_all_member();
					break;
				case INIT_MENU.LOGIN:					//로그인
					control.login();
					break;

				case INIT_MENU.BOOK_RELATED:			//도서등록 & 수정 & 삭제 & 조회
					control.book_related();
					break;
				case INIT_MENU.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;

				}
			}catch (MenuChoiceException e){
				e.showWrongChoice();
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다. \n");
			}
		}
	}

}




/*default :
	System.out.println("메뉴 선택을 처음부터 다시 진행합니다. \n");*/









