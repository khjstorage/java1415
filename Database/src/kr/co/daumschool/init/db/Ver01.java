package kr.co.daumschool.init.db;

import java.io.IOException;

public class Ver01 {
	public static void main(String[] args) throws IOException{

		RootJDBC rootJdbc = new RootJDBC();
		UserJDBC userJdbc = new UserJDBC();
		
		int choice;

		while((choice=Menu.main_Menu())!=22){
			switch(choice){
			case 1:
				rootJdbc.connect("mysql", "root", "h2lloworld");
				break;
			case 2:
				rootJdbc.disconnectDB();
				return;
			case 3:
				rootJdbc.createDB();
				break;
			case 4:
				rootJdbc.dropDB();
				break;
			case 5:
				rootJdbc.displayDB();
				break;
			case 6:
				rootJdbc.addUser();
				break;
			case 7:
				rootJdbc.deleteUser();
				break;
			case 8:
				rootJdbc.renewalServer();
				break;
			case 9:
				rootJdbc.grantUser();
				break;
			case 10:
				userJdbc.userLogin();
				break;
			case 11:
				userJdbc.displayDB();
				break;
			case 12:
				userJdbc.createdTable();
				break;
			case 13:
				userJdbc.alterAddRecord();
				break;
			case 14:
				userJdbc.insertRecord();
				break;
			case 15:
				userJdbc.updateRecord();
				break;
			case 16:
				userJdbc.deleteRecord();
				break;
			case 17:
				userJdbc.displayRecord();
				break;
			case 18:
				userJdbc.cntRecord();
				break;
			case 19:
				userJdbc.cntName();
				break;
			case 20:
				userJdbc.cntId();
				break;
			case 21:
				userJdbc.cntAge();
				break;
			case 22:
				return;
			default:
				System.out.println("0 to 20 selection again.");

			}
		}
	}
	
}




