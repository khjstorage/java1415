package kr.co.daumschool.item.db;

public class Ver01 {
	public static void main(String args[]){
		ControlItem cidb = new ControlItem(); 

		int choice;
		while((choice=Menu.item_Menu())!=6){
			switch(choice){
			case 0:
				//cart 테이블 생성 (한번만)
				cidb.createdTable();
				break;
			case 1:
				cidb.insertItem();
				break;
			case 2:
				cidb.updateInPut();
				break;
			case 3:
				cidb.updateOutPut();
				break;
			case 4:
				cidb.displayRecord();
				break;
			case 5:
				cidb.disconnectDB();
				return;
			default:
				System.out.println("0 to 5 selection again.");

			}
		}
	}
}