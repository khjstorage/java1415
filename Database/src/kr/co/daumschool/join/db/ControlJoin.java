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
			String createdTable = "CREATE TABLE 고객"
					+ "(고객아이디 varchar(11) NOT NULL primary key,"
					+ "고객이름  varchar(10) NOT NULL,"
					+ "나이  int,"
					+ "등급  varchar(6) NOT NULL,"
					+ "직업  varchar(10));";
			stmt.executeUpdate(createdTable);
			System.out.println("고객 테이블 생성\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}
	
	public void insertRecord(){
		System.out.print("아이디 :");
		String id = Menu.sc.next();
		System.out.print("비밀번호 :");
		String pin = Menu.sc.next();
		System.out.print("이름 :");
		String name = Menu.sc.next();
		System.out.print("나이 :");
		int age = Menu.sc.nextInt();
		//등급
		String grade = "silver";
		System.out.print("직업 :");
		String job = Menu.sc.next();

		try{
			String insertData = "INSERT INTO 고객(고객아이디, 비밀번호, 고객이름, 나이, 등급, 직업)"
					+ " VALUES ('"+id+"','"+pin+"','"+name+"','"+age+"','"+grade+"','"+job+"');";
			ResultSet result = stmt.executeQuery("SELECT * FROM 고객");
			while(result.next()){
				if(result.getString("고객아이디").equals(id)){
					System.out.print(result.getString("고객아이디"));
					System.out.println(" 는 이미 등록된 id 입니다.\n");
					return;
				}
			}
			stmt.executeUpdate(insertData);		
			System.out.println("등록완료\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	public void login(){
		System.out.print("아이디: ");
		id = Menu.sc.next();
		System.out.print("비밀번호: ");
		pin = Menu.sc.next();

		try{
			ResultSet result = stmt.executeQuery("SELECT * FROM 고객 WHERE 고객아이디 ='"+id+"'");
			while(result.next()){
				if(pin.equals(result.getString("비밀번호"))){
					System.out.println("로그인 성공!\n");
					myid = id;
					mypin = pin;
				}else if(!pin.equals(result.getString("비밀번호"))){
					System.out.println("로그인 실패! 비밀번호를 확인해주세요\n");
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
				System.out.println("로그아웃 성공\n");
				myid = "";
				mypin = "";
			}
		}catch(Exception e){
			System.err.println(e.getMessage()+"\n");
		}
	}

	public void displayRecord(){
		try{
			ResultSet result = stmt.executeQuery("SELECT * FROM 고객");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n\t\t\t 고객 릴레이션 \n");
					System.out.println("고객아이디\t고객이름\t나이\t등급\t직업\t비밀번호");
					System.out.println("====================================================================");
				}
				String resultID = result.getString("고객아이디")+"\t\t";
				String resultName = result.getString("고객이름")+"\t\t";
				String resultAge = result.getInt("나이")+"\t";
				String resultGrade = result.getString("등급")+"\t";
				String resultJob = result.getString("직업")+"\t";
				System.out.print(resultID);
				System.out.print(resultName);
				System.out.print(resultAge);
				System.out.print(resultGrade);
				System.out.print(resultJob);
				for(int i =0; i<result.getString("비밀번호").length(); i++){
					String pinstar = "*";
					System.out.print(pinstar);
				}
				System.out.println();
				count++;
			}
			System.out.println("=====================================================================");
			System.out.println(count+"명의 회원이 등록되어있습니다.\n");
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
