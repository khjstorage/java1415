package kr.co.daumschool.order.db;


public class Ver01 {
	public static void main(String args[]){
		ControlOrder codb = new ControlOrder();
		
		int choice;
		while((choice=Menu.main_Menu())!=3){
			switch(choice){
			case 0:
				//cart 테이블 생성 (한번만)
				codb.createdTable();
				return;
			case 1:
				codb.insertRecord();
				break;
			case 2:
				codb.login();
				break;
			case 3:
				codb.disconnectDB();
				return;
			default:
				System.out.println("0 to 3 selection again.");

			}
		}
	}
}