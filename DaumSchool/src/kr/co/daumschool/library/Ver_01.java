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

				case INIT_MENU.JOIN:						//ȸ������
					control.input_Member_Info();
					break;	
				case INIT_MENU.QUIT:						//ȸ��Ż��
					control.quit_Data();
					break;
				case INIT_MENU.SEARCH:					//ȸ���˻�
					control.search_Member_Info();
					break;
				case INIT_MENU.LIST:						//ȸ�����
					control.show_all_member();
					break;
				case INIT_MENU.LOGIN:					//�α���
					control.login();
					break;

				case INIT_MENU.BOOK_RELATED:			//������� & ���� & ���� & ��ȸ
					control.book_related();
					break;
				case INIT_MENU.EXIT:
					System.out.println("���α׷��� �����մϴ�.");
					return;

				}
			}catch (MenuChoiceException e){
				e.showWrongChoice();
				System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�. \n");
			}
		}
	}

}




/*default :
	System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�. \n");*/









