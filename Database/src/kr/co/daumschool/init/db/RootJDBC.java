package kr.co.daumschool.init.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class RootJDBC {

	Connection conn = null;
	Statement stmt = null;

	//DB 연결
	public void connect(String _dbname, String _user, String _password){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Successfully Driver loding");
		}catch(java.lang.ClassNotFoundException e){
			System.err.print("CLassNotFoundEXception : ");
			System.err.print(e.getMessage());
			return;
		}
		String URL = "jdbc:mysql://127.0.0.1:3306/"+_dbname+"";
		String user = _user;
		String password =_password;
		try{
			conn=DriverManager.getConnection(URL, user, password);
			stmt = conn.createStatement();
			System.out.println("Successfully connected to DBMS!(admin)\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//DB 연결해제
	public void disconnectDB(){
		try{
			System.out.println("Successfully disconnect to DBMS!\n ");
			if(conn!=null) conn.close();
			if(stmt!=null) stmt.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	//DB 생성
	public void createDB(){
		try{
			String start = "START TRANSACTION";
			stmt.executeUpdate(start);
			System.out.print("create DB :");
			String created = Menu.sc.next();
			if(created.equals("mysql")){
				System.out.println("mysql DB is not created");
			}else{
				String createDB = "create database "+created+";";
				stmt.executeUpdate(createDB);
				System.out.println("successfully created db\n");
			}
			String commit = "COMMIT";
			String rollback = "ROLLBACK";
			System.out.print("commit(1) 하시겠습니까 rollback(2)하시겠습니까? :");
			int cr = Menu.sc.nextInt();
			if(cr==1){
				stmt.executeUpdate(commit);
				System.out.println(created+"DB가 생성 되었습니다.");
			}else if(cr==2){
				stmt.executeUpdate(rollback);
				System.out.println("ROLLBACK 되었습니다.");
			}

		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//DB 삭제
	public void dropDB(){
		try{
			String start = "START TRANSACTION";
			stmt.executeUpdate(start);
			System.out.print("drop DB :");
			String deleteDB = Menu.sc.next();
			String dropDB = "drop database jsptest;;";
			stmt.executeUpdate(dropDB);
			System.out.println("successfully drop db\n");
			String commit = "COMMIT";
			String rollback = "ROLLBACK";
			System.out.print("commit(1) 하시겠습니까 rollback(2)하시겠습니까? :");
			int cr = Menu.sc.nextInt();
			if(cr==1){
				stmt.executeUpdate(commit);
				System.out.println(deleteDB+"DB가 삭제 되었습니다.");
			}else if(cr==2){
				stmt.executeUpdate(rollback);
				System.out.println("ROLLBACK 되었습니다.");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//권한받은 DB목록보기 (excuteQuery)
	public void displayDB(){
		try{
			ResultSet result =stmt.executeQuery("show databases;");
			int count=0;
			while(result.next()){
				if(count==0) System.out.println("DB목록");
				String resultDB = result.getString(1);
				System.out.println(resultDB);
				count++;
			}
			System.out.println(count+"개의 DB가 검색되었습니다.\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//DB 사용자추가
	public void addUser(){
		try{
			String start = "START TRANSACTION";
			stmt.executeUpdate(start);
			System.out.print("add User :"); 
			String userName = Menu.sc.next();
			System.out.print("add User PIN :"); 
			String userPassword = Menu.sc.next();
			String insertUser = "insert into user(host, user, password, ssl_cipher, x509_issuer, x509_subject)" + " values ('localhost','"+userName+"',password('"+userPassword+"'),0,0,0);";
			stmt.executeUpdate(insertUser);
			System.out.println("successfully created user\n");
			String commit = "COMMIT";
			String rollback = "ROLLBACK";
			System.out.print("commit(1) 하시겠습니까 rollback(2)하시겠습니까? :");
			int cr = Menu.sc.nextInt();
			if(cr==1){
				stmt.executeUpdate(commit);
				System.out.println("user사용자"+userName+" 계정이 추가 되었습니다.");
			}else if(cr==2){
				stmt.executeUpdate(rollback);
				System.out.println("ROLLBACK 되었습니다.");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//DB 사용자삭제
	public void deleteUser(){
		try{
			String start = "START TRANSACTION";
			stmt.executeUpdate(start);
			System.out.print("delete User :"); 
			String userName = Menu.sc.next();
			String deleteUser = "delete from user where user='"+userName+"';";
			stmt.executeUpdate(deleteUser);
			System.out.println("successfully delete user\n");
			String commit = "COMMIT";
			String rollback = "ROLLBACK";
			System.out.print("commit(1) 하시겠습니까 rollback(2)하시겠습니까? :");
			int cr = Menu.sc.nextInt();
			if(cr==1){
				stmt.executeUpdate(commit);
				System.out.println("user사용자"+userName+" 계정이 삭제 되었습니다.");
			}else if(cr==2){
				stmt.executeUpdate(rollback);
				System.out.println("ROLLBACK 되었습니다.");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//서버갱신
	public void renewalServer(){
		try{
			String flushDB = "flush privileges;";
			stmt.executeUpdate(flushDB);
			System.out.println("successfully server renewal\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//사용자 권한부여
	public void grantUser(){
		try{
			String start = "START TRANSACTION";
			stmt.executeUpdate(start);
			System.out.print("used DB :");
			String useDB = Menu.sc.next();
			System.out.print("grant User :");
			String userDB = Menu.sc.next();
			String insertValues = "insert into db values('localhost', '"+useDB+"', '"+userDB+"','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y');";
			stmt.executeUpdate(insertValues);
			System.out.println("successfully grant user\n");
			String commit = "COMMIT";
			String rollback = "ROLLBACK";
			System.out.print("commit(1) 하시겠습니까 rollback(2)하시겠습니까? :");
			int cr = Menu.sc.nextInt();
			if(cr==1){
				stmt.executeUpdate(commit);
				System.out.println(userDB+"계정이 "+useDB+"에 권한이 부여되었습니다.");
			}else if(cr==2){
				stmt.executeUpdate(rollback);
				System.out.println("ROLLBACK 되었습니다.");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

}



