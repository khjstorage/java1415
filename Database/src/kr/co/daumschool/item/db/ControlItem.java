package kr.co.daumschool.item.db;

import java.sql.*;

public class ControlItem {

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;

	public ControlItem(){
		String user = "hyunjin";
		String password = "0509";
		String URL = "jdbc:mysql://127.0.0.1:3306/shop_DB";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Successfully Driver loding");
		}catch(java.lang.ClassNotFoundException e){
			System.err.print("CLassNotFoundEXception : ");
			System.err.print(e.getMessage());
			return;
		}
		try{
			conn=DriverManager.getConnection(URL, user, password);
			stmt = conn.createStatement();
			System.out.println("Use DB : hyunjinDB \nAccount : hyunjin\n");

		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	public void createdTable() {
		try{
			String createdTable = "CREATE TABLE ��ǰ"
					+ "(��ǰ��ȣ int NOT NULL primary key,"
					+ "��ǰ�� varchar(10) NOT NULL,"
					+ "��� int NOT NULL,"
					+ "�ܰ� int NOT NULL);";
			stmt.executeUpdate(createdTable);
			System.out.println("��ǰ ���̺� ����\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	public void insertItem(){
		try{
			String insertSql = "insert into ��ǰ(��ǰ��ȣ,��ǰ��,���,�ܰ�) values(?,?,?,?)";
			pstmt = conn.prepareStatement(insertSql);

			System.out.print("��ǰ��ȣ :");
			int itemnum = Menu.sc.nextInt();
			System.out.print("��ǰ�� :");
			String itemname = Menu.sc.next();
			System.out.print("��� :");
			int itemprice = Menu.sc.nextInt();
			System.out.print("�ܰ� :");
			int itemamount = Menu.sc.nextInt();

			pstmt.setInt(1, itemnum);
			pstmt.setString(2, itemname);
			pstmt.setInt(3, itemprice);
			pstmt.setInt(4, itemamount);
			pstmt.executeUpdate();
			System.out.println("��ϿϷ�\n");

		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	public void updateInPut(){
		try{
			ResultSet result = stmt.executeQuery("SELECT * FROM ��ǰ ");

			System.out.print("��ǰ�� :");
			String itemname = Menu.sc.next();

			while(result.next()){
				if(itemname.equals(result.getString("��ǰ��"))){
					int existing = result.getInt("���");
					System.out.print("��� :");
					int ItemAmount = Menu.sc.nextInt();
					String updatetSQL = "UPDATE ��ǰ SET ���=? WHERE ��ǰ��=?";
					pstmt = conn.prepareStatement(updatetSQL);
					pstmt.setString(2, itemname);
					pstmt.setInt(1, existing+ItemAmount);
					pstmt.executeUpdate();
					System.out.println("�����Ϸ�\n");
					break;
				}
			}						
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	public void updateOutPut(){
		try{
			ResultSet result = stmt.executeQuery("SELECT * FROM ��ǰ");

			System.out.print("��ǰ�� :");
			String itemname = Menu.sc.next();

			while(result.next()){
				if(itemname.equals(result.getString("��ǰ��"))){
					int existing = result.getInt("���");
					System.out.print("��� :");
					int ItemAmount = Menu.sc.nextInt();
					String updatetSQL = "UPDATE ��ǰ SET ���=? WHERE ��ǰ��=?";
					pstmt = conn.prepareStatement(updatetSQL);
					pstmt.setString(2, itemname);
					pstmt.setInt(1, existing-ItemAmount);
					pstmt.executeUpdate();
					System.out.println("�����Ϸ�\n");
					break;
				}
			}						
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	public void displayRecord(){
		try{
			ResultSet result = stmt.executeQuery("SELECT * FROM ��ǰ");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n\t\t ��ǰ �����̼�\n");
					System.out.println("��ǰ��ȣ\t��ǰ��\t\t���\t�ܰ�");
					System.out.println("==============================================");
				}
				String resultRecord = "    "+result.getInt("��ǰ��ȣ")+"\t\t";
				resultRecord = resultRecord + result.getString("��ǰ��")+"\t";
				resultRecord = resultRecord + result.getInt("���")+"\t";
				resultRecord = resultRecord + result.getInt("�ܰ�")+"\t";
				System.out.println(resultRecord);
				count++;
			}
			System.out.println("==============================================");
			System.out.println(count+"���� ���ڵ尡 �˻��Ǿ����ϴ�.\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	public void disconnectDB(){
		try{
			System.out.println("Successfully disconnect to DBMS!\n ");
			if(conn!=null) conn.close();
			if(pstmt!=null) pstmt.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
