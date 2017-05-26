package kr.co.daumschool.order.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControlOrder {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String myid;
	String mypin;

	public ControlOrder(){
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

	public void createdTable(){
		try{
			String createdTable = "CREATE TABLE �ֹ�"
					+ "(�ֹ���ȣ int NOT NULL AUTO_INCREMENT primary key,"
					+ "�ֹ��� varchar(11) NOT NULL,"
					+ "�ֹ���ǰ varchar(10) NOT NULL,"
					+ "���� int NOT NULL)";
			stmt.executeUpdate(createdTable);
			System.out.println("�ֹ� ���̺� ����\n");
		}catch(SQLException e){
			System.err.println("SQL Error:"+e.getMessage());
		}
	}
	
	public void insertRecord(){
		System.out.print("���̵� :");
		String id = Menu.sc.next();
		System.out.print("��й�ȣ :");
		String pin = Menu.sc.next();
		System.out.print("�̸� :");
		String name = Menu.sc.next();
		System.out.print("���� :");
		int age = Menu.sc.nextInt();
		//���
		String grade = "silver";
		System.out.print("���� :");
		String job = Menu.sc.next();

		try{
			String insertData = "INSERT INTO ��(�����̵�, ��й�ȣ, ���̸�, ����, ���, ����)"
					+ " VALUES ('"+id+"','"+pin+"','"+name+"','"+age+"','"+grade+"','"+job+"');";
			ResultSet result = stmt.executeQuery("SELECT * FROM ��");
			while(result.next()){
				if(result.getString("�����̵�").equals(id)){
					System.out.print(result.getString("�����̵�"));
					System.out.println(" �� �̹� ��ϵ� id �Դϴ�.\n");
					return;
				}
			}
			stmt.executeUpdate(insertData);		
			System.out.println("��ϿϷ�\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}
		
	public void login(){
		System.out.print("���̵�: ");
		String id = Menu.sc.next();
		System.out.print("��й�ȣ: ");
		String pin = Menu.sc.next();

		try{
			ResultSet result = stmt.executeQuery("SELECT * FROM �� WHERE �����̵� ='"+id+"'");
			while(result.next()){
				if(pin.equals(result.getString("��й�ȣ"))){
					System.out.println("�α��� ����!\n");
					myid = id;
					mypin = pin;
					memberMenu();
				}else if(!pin.equals(result.getString("��й�ȣ"))){
					System.out.println("�α��� ����! ��й�ȣ�� Ȯ�����ּ���\n");
					break;
				}
			}
		}catch(SQLException e){
			System.err.println("SQL Error:"+e.getMessage());
		}
	}

	public void disconnectDB(){
		try{
			System.out.println("Successfully disconnect to DBMS!\n ");
			if(conn!=null) conn.close();
			if(stmt!=null) stmt.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	private void memberMenu(){
		int choice;
		while((choice=Menu.member_Menu())!=6){
			switch(choice){
			case 1:
				displayRecord();
				break;
			case 2:
				orderItem();
				break;
			case 3:
				backItem();
				break;
			case 4:
				myOrder();
				break;
			case 5:
				logout();
				return;
			default:
				System.out.println("0 to 5 selection again.");
			}
		}
	}
	
	private void displayRecord(){
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
	
	private void orderItem(){
		try{
			String insertSql = "insert into �ֹ�(�ֹ���,�ֹ���ǰ,����) values(?,?,?)";
			pstmt = conn.prepareStatement(insertSql);

			System.out.print("�ֹ���ǰ :");
			String item_order = Menu.sc.next();
			System.out.print("���԰��� :");
			int item_quantity = Menu.sc.nextInt();
			

			int stock_status=0;
			
			ResultSet result = stmt.executeQuery("SELECT * FROM ��ǰ WHERE ��ǰ��='"+item_order+"' AND ���>0");
			while(result.next()){
				pstmt.setString(1, myid);
				pstmt.setString(2, item_order);
				pstmt.setInt(3, item_quantity);
				stock_status = result.getInt("���");
			}	
					
			if(stock_status>0){							   // (����â����� - �����Ѱ���) ��ǰ�����̼� ������Ʈ
				String updatetSQL = "UPDATE ��ǰ SET ���="+(stock_status-item_quantity)+" WHERE ��ǰ��='"+item_order+"'";
				pstmt.executeUpdate();
				stmt.executeUpdate(updatetSQL);
				System.out.println("�ֹ��� �Ϸ�Ǿ����ϴ�.\n");
			}else{
				System.out.println("������ǰ �Դϴ�.\n");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	private void backItem(){
		try{
			System.out.print("��ǰ�� ��ǰ :");
			String item_back = Menu.sc.next();
			System.out.print("��ǰ�� ��ǰ(�ֹ���ȣ) :");
			String item_back_num = Menu.sc.next();
			
			String deleteSql = "DELETE "+
							   "FROM �ֹ� " +
							   "WHERE �ֹ���ǰ ='"+item_back+"' AND �ֹ���ȣ='"+item_back_num+"' AND �ֹ��� IN (SELECT �����̵� " +
							   																				     "FROM �� " +
							   																				     "WHERE �����̵� ='"+myid+"')";
			//�̰� public int aaa(String item_back)
			//		return ���
			//�޼���ȭ...�ؼ� ��ǰ�� ��ǰ(��ȣ)������ ��ǰ ó���ϰ�
			ResultSet result_item = stmt.executeQuery("SELECT * FROM ��ǰ WHERE ��ǰ��='"+item_back+"'");
			int factory_stock_status=0;	  //��ǰ�� ��ǰ �ø��� ���� ���� ��ǰ ���
			while(result_item.next()){
				factory_stock_status= result_item.getInt("���");
			}
			
			
			ResultSet result = stmt.executeQuery("SELECT * FROM �ֹ� WHERE �ֹ���ȣ='"+item_back_num+"'");
			int order_stock_status=0;			//���� �ֹ��� ��ǰ ��ǰ ����
			while(result.next()){
				order_stock_status = result.getInt("����");
			}
			
			if(order_stock_status!=0){						//  (����â����� + ��ǰ�Ȱ���) ��ǰ�����̼� ������Ʈ
				String updatetSQL = "UPDATE ��ǰ SET ���="+(factory_stock_status+order_stock_status)+" WHERE ��ǰ��='"+item_back+"'";
				stmt.executeUpdate(updatetSQL);
				stmt.executeUpdate(deleteSql);
				System.out.println("��ǰó�� �Ϸ�Ǿ����ϴ�.\n");
			}
			
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	private void myOrder(){
		try{
			ResultSet result = stmt.executeQuery("Select �ֹ���ȣ, �ֹ���ǰ, SUM(����) AS '�� �ֹ���' FROM �ֹ� WHERE �ֹ���='"+myid+"' GROUP BY �ֹ���ȣ;");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n\t"+myid+"������ ��ٱ���\n");
					System.out.println("�ֹ���ȣ\t�ֹ���ǰ\t�� �ֹ���");
					System.out.println("==========================================");
				}				
				String resultRecord = result.getInt("�ֹ���ȣ")+"\t\t";
				resultRecord = resultRecord + result.getString("�ֹ���ǰ")+"\t";
				resultRecord = resultRecord + result.getInt("�� �ֹ���");
				System.out.println(resultRecord);
				count++;
			}
			System.out.println("==========================================");
			System.out.println(count+"���� ��ǰ�� ��ٱ��Ͽ� �ֽ��ϴ�.\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}
		
	private void logout(){
		myid="";
		mypin="";
		System.out.println();
	}

}
























