package kr.co.daumschool.init.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserJDBC {

	Connection conn = null;
	Statement stmt = null;

	//����ڰ��� �α���
	public void userLogin(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Successfully Driver loding");
		}catch(java.lang.ClassNotFoundException e){
			System.err.print("CLassNotFoundEXception : ");
			System.err.print(e.getMessage());
			return;
		}	
		System.out.print("���� ���̵� :");
		String _user = Menu.sc.next();
		String user = _user;

		System.out.print("���� ��й�ȣ :");
		String _password = Menu.sc.next();
		String password =_password;

		System.out.print("����� DB :");
		String _dbname = Menu.sc.next();
		String URL = "jdbc:mysql://127.0.0.1:3306/"+_dbname+"";


		/*String user = "hyunjin";
			String password = "0509";
			String URL = "jdbc:mysql://127.0.0.1:3306/hyunjindb";
		 */
		try{
			conn=DriverManager.getConnection(URL, user, password);
			stmt = conn.createStatement();
			System.out.println("Successfully connected to DBMS!(user)\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//�����̼� ���� (information)
	public void createdTable(){
		try{
			String start = "START TRANSACTION";
			stmt.executeUpdate(start);

			String createdTable = "CREATE TABLE Item"
					+ "(ItemNum int NOT NULL AUTO_INCREMENT primary key,"
					+ "ItemName varchar(15) NOT NULL,"
					+ "ItemPrice int NOT NULL)";
			stmt.executeUpdate(createdTable);
			System.out.println("successfully created Table\n");

			System.out.print("commit(1) �Ͻðڽ��ϱ� rollback(2)�Ͻðڽ��ϱ�? :");
			int check = Menu.sc.nextInt();
			if(check == 1){
				String commit = "COMMIT";
				stmt.executeUpdate(commit);
				System.out.println("COMMIT �Ǿ����ϴ�.");
			}else if(check == 2){
				String rollback = "ROLLBACK";
				stmt.executeUpdate(rollback);
				System.out.println("ROLLBACK �Ǿ����ϴ�.");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//Ʃ�� ����	
	public void insertRecord(){
		int cnt = 0;
		try{
			String start = "START TRANSACTION";
			stmt.executeUpdate(start);
			String insertData ="INSERT INTO information VALUES ";
			String recordInfo[]=
				{insertData +"('opgg','abaad','18')",
					insertData +"('opgg','aaaa','19')",
					insertData +"('lpgg','bbcdb','23')",
					insertData +"('lpgg','bfbb','15')",
					insertData +"('opgg','bgacb','25')",
					insertData +"('opgg','aabcb','17')",
					insertData +"('lpgg','bggb','18')",
					insertData +"('lpgg','bcb','88')",
					insertData +"('opgg','bbqqb','20')",
					insertData +"('opgg','bab','25')",
					insertData +"('mpgg','ccccc','24')"};
			while(cnt<recordInfo.length){
				stmt.executeUpdate(recordInfo[cnt]);
				cnt++;
			}
			String commit = "COMMIT";
			String rollback = "ROLLBACK";
			System.out.print("commit(1) �Ͻðڽ��ϱ� rollback(2)�Ͻðڽ��ϱ�? :");
			int cr = Menu.sc.nextInt();
			if(cr==1){
				stmt.executeUpdate(commit);
				System.out.println(cnt+"���� ���ڵ尡 information Table�� ���ԵǾ����ϴ�.\n");
			}else if(cr==2){
				stmt.executeUpdate(rollback);
				System.out.println("ROLLBACK �Ǿ����ϴ�.");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//���ο� �Ӽ� �߰�
	public void alterAddRecord(){
		try{
			String alterAddSQL = "ALTER TABLE Item ADD ItemAmount int";
			stmt.executeUpdate(alterAddSQL);
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}


	//Ʃ�� ����
	public void updateRecord(){
		try{
			String start = "START TRANSACTION";
			stmt.executeUpdate(start);
			String updateData = "UPDATE information SET info_id = 'apple' WHERE info_name ='aaa';";
			stmt.executeUpdate(updateData);
			System.out.println("successfully update Table\n");
			String commit = "COMMIT";
			String rollback = "ROLLBACK";
			System.out.print("commit(1) �Ͻðڽ��ϱ� rollback(2)�Ͻðڽ��ϱ�? :");
			int cr = Menu.sc.nextInt();
			if(cr==1){
				stmt.executeUpdate(commit);
				System.out.println(updateData+"sql���� ����Ǿ����ϴ�.\n");
			}else if(cr==2){
				stmt.executeUpdate(rollback);
				System.out.println("ROLLBACK �Ǿ����ϴ�.");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}

	}

	//Ʃ�� ����
	public void deleteRecord(){
		try{
			String start = "START TRANSACTION";
			stmt.executeUpdate(start);
			String deleteData = "DELETE FROM information WHERE info_age ='18';";
			stmt.executeUpdate(deleteData);
			System.out.println("successfully delete Table (���̰� 18���� ���ڵ����)\n");
			String commit = "COMMIT";
			String rollback = "ROLLBACK";
			System.out.print("commit(1) �Ͻðڽ��ϱ� rollback(2)�Ͻðڽ��ϱ�? :");
			int cr = Menu.sc.nextInt();
			if(cr==1){
				stmt.executeUpdate(commit);
				System.out.println(deleteData+"sql���� ����Ǿ����ϴ�.\n");
			}else if(cr==2){
				stmt.executeUpdate(rollback);
				System.out.println("ROLLBACK �Ǿ����ϴ�.");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}


	//DB���� (excuteQuery)
	public void displayDB(){
		try{
			ResultSet result =stmt.executeQuery("show databases;");
			int count=0;
			while(result.next()){
				if(count==0) System.out.println("DB���");
				String resultDB = result.getString(1);
				System.out.println(resultDB);
				count++;
			}
			System.out.println(count+"���� DB�� ���Ѻο� �ƽ��ϴ�.\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}



	//�����̼� ��ȸ
	public void displayRecord(){
		try{
			ResultSet result = stmt.executeQuery("SELECT * FROM item");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n\tinformation �����̼�");
					System.out.println("�����̵�\t���̸�\t������");
					System.out.println("==========================================");
				}
				String resultRecord = result.getString("info_id")+"\t\t";
				resultRecord = resultRecord + result.getString("info_name")+"\t\t";
				resultRecord = resultRecord + result.getString("info_age");
				System.out.println(resultRecord);
				count++;
			}
			System.out.println("==========================================");
			System.out.println(count+"���� ���ڵ尡 �˻��Ǿ����ϴ�.\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//SELECT (�����Լ��� �̿�)
	public void cntRecord(){
		try{
			ResultSet result = stmt.executeQuery("SELECT COUNT(*) from information");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n\tinformation Ʃ�� ����");
					System.out.println("==========================================");
				}
				String resultRecord = result.getString(1);
				System.out.println(resultRecord+"���� ���ڵ尡 �˻��Ǿ����ϴ�.\n");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//SELECT (LIKE�� �̿�)
	public void cntName(){
		try{
			ResultSet result = stmt.executeQuery("SELECT info_id, info_name, info_age FROM information WHERE info_name LIKE '_____';");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n�̸��� 5���� ���� �����̵�,�̸�,����");
					System.out.println("�����̵�\t���̸�\t������");
					System.out.println("==========================================");
				}
				String resultRecord = result.getString("info_id")+"\t\t";
				resultRecord = resultRecord + result.getString("info_name")+"\t\t";
				resultRecord = resultRecord + result.getString("info_age");
				System.out.println(resultRecord);
				count++;
			}
			System.out.println("==========================================");
			System.out.println(count+"���� ���ڵ尡 �˻��Ǿ����ϴ�.\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//SELECT (�����Լ�+LIKE�� �̿�)
	public void cntId(){
		try{
			ResultSet result = stmt.executeQuery("SELECT COUNT(info_id) FROM information WHERE info_id LIKE '%op%';");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n���̵� 'op'�� �� ���� ��");
					System.out.println("==========================================");
				}
				String resultRecord = result.getString(1);
				System.out.println(resultRecord+"���� ���ڵ尡 �˻��Ǿ����ϴ�.\n");
				count++;
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//SELECT (�����Լ�+�񱳾���ڸ� �̿�
	public void cntAge(){
		try{
			ResultSet result = stmt.executeQuery("SELECT COUNT(info_age) FROM information WHERE info_age>=20 AND info_age<=24;");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n���̰� 20���̻� 24������ ���� ��");
					System.out.println("==========================================");
				}
				String resultRecord = result.getString(1);
				System.out.println(resultRecord+"���� ���ڵ尡 �˻��Ǿ����ϴ�.\n");
				count++;
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}


}