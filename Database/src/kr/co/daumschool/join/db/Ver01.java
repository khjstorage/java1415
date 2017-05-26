package kr.co.daumschool.join.db;

public class Ver01 {
	public static void main(String[] args) {
		ControlJoin cjdb = new ControlJoin(); 
		
		int choice;
		while((choice=Menu.start_Menu())!=6){
			switch(choice){
			//cart 테이블 생성 (한번만)
			case 0:
				cjdb.createdTable();
				break;
			case 1:
				cjdb.insertRecord();
				break;
			case 2:
				cjdb.login();
				break;
			case 3:
				cjdb.logout();
				break;
			case 4:
				cjdb.displayRecord();
				break;
			case 5:
				cjdb.disconnectDB();
				return;
			default:
				System.out.println("0 to 5 selection again.");

			}
		}
	}
}

