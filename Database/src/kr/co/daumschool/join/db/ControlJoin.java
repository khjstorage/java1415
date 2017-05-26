package kr.co.daumschool.join.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.co.daumschool.order.db.Menu;


public class ControlJoin {

	Connection conn = null;
	static Statement stmt = null;

	String id;
	String pin;
	String myid;
	String mypin;

	public ControlJoin(){
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
			String createdTable = "CREATE TABLE ��"
					+ "(�����̵� varchar(11) NOT NULL primary key,"
					+ "���̸�  varchar(10) NOT NULL,"
					+ "����  int,"
					+ "���  varchar(6) NOT NULL,"
					+ "����  varchar(10));";
			stmt.executeUpdate(createdTable);
			System.out.println("�� ���̺� ����\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
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
		id = Menu.sc.next();
		System.out.print("��й�ȣ: ");
		pin = Menu.sc.next();

		try{
			ResultSet result = stmt.executeQuery("SELECT * FROM �� WHERE �����̵� ='"+id+"'");
			while(result.next()){
				if(pin.equals(result.getString("��й�ȣ"))){
					System.out.println("�α��� ����!\n");
					myid = id;
					mypin = pin;
				}else if(!pin.equals(result.getString("��й�ȣ"))){
					System.out.println("�α��� ����! ��й�ȣ�� Ȯ�����ּ���\n");
					break;
				}
			}
		}catch(SQLException e){
			System.err.println("SQL Error:"+e.getMessage());
		}
	}

	public void logout(){
		try{
			if(myid.equals(id) && mypin.equals(pin)){
				System.out.println("�α׾ƿ� ����\n");
				myid = "";
				mypin = "";
			}
		}catch(Exception e){
			System.err.println(e.getMessage()+"\n");
		}
	}

	public void displayRecord(){
		try{
			ResultSet result = stmt.executeQuery("SELECT * FROM ��");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n\t\t\t �� �����̼� \n");
					System.out.println("�����̵�\t���̸�\t����\t���\t����\t��й�ȣ");
					System.out.println("====================================================================");
				}
				String resultID = result.getString("�����̵�")+"\t\t";
				String resultName = result.getString("���̸�")+"\t\t";
				String resultAge = result.getInt("����")+"\t";
				String resultGrade = result.getString("���")+"\t";
				String resultJob = result.getString("����")+"\t";
				System.out.print(resultID);
				System.out.print(resultName);
				System.out.print(resultAge);
				System.out.print(resultGrade);
				System.out.print(resultJob);
				for(int i =0; i<result.getString("��й�ȣ").length(); i++){
					String pinstar = "*";
					System.out.print(pinstar);
				}
				System.out.println();
				count++;
			}
			System.out.println("=====================================================================");
			System.out.println(count+"���� ȸ���� ��ϵǾ��ֽ��ϴ�.\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
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

}
