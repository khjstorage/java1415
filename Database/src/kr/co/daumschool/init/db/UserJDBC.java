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

	//사용자계정 로그인
	public void userLogin(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Successfully Driver loding");
		}catch(java.lang.ClassNotFoundException e){
			System.err.print("CLassNotFoundEXception : ");
			System.err.print(e.getMessage());
			return;
		}	
		System.out.print("유저 아이디 :");
		String _user = Menu.sc.next();
		String user = _user;

		System.out.print("유저 비밀번호 :");
		String _password = Menu.sc.next();
		String password =_password;

		System.out.print("사용할 DB :");
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

	//릴레이션 생성 (information)
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

			System.out.print("commit(1) 하시겠습니까 rollback(2)하시겠습니까? :");
			int check = Menu.sc.nextInt();
			if(check == 1){
				String commit = "COMMIT";
				stmt.executeUpdate(commit);
				System.out.println("COMMIT 되었습니다.");
			}else if(check == 2){
				String rollback = "ROLLBACK";
				stmt.executeUpdate(rollback);
				System.out.println("ROLLBACK 되었습니다.");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//튜플 삽입	
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
			System.out.print("commit(1) 하시겠습니까 rollback(2)하시겠습니까? :");
			int cr = Menu.sc.nextInt();
			if(cr==1){
				stmt.executeUpdate(commit);
				System.out.println(cnt+"개의 레코드가 information Table에 삽입되었습니다.\n");
			}else if(cr==2){
				stmt.executeUpdate(rollback);
				System.out.println("ROLLBACK 되었습니다.");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//새로운 속성 추가
	public void alterAddRecord(){
		try{
			String alterAddSQL = "ALTER TABLE Item ADD ItemAmount int";
			stmt.executeUpdate(alterAddSQL);
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}


	//튜플 수정
	public void updateRecord(){
		try{
			String start = "START TRANSACTION";
			stmt.executeUpdate(start);
			String updateData = "UPDATE information SET info_id = 'apple' WHERE info_name ='aaa';";
			stmt.executeUpdate(updateData);
			System.out.println("successfully update Table\n");
			String commit = "COMMIT";
			String rollback = "ROLLBACK";
			System.out.print("commit(1) 하시겠습니까 rollback(2)하시겠습니까? :");
			int cr = Menu.sc.nextInt();
			if(cr==1){
				stmt.executeUpdate(commit);
				System.out.println(updateData+"sql문이 실행되었습니다.\n");
			}else if(cr==2){
				stmt.executeUpdate(rollback);
				System.out.println("ROLLBACK 되었습니다.");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}

	}

	//튜플 삭제
	public void deleteRecord(){
		try{
			String start = "START TRANSACTION";
			stmt.executeUpdate(start);
			String deleteData = "DELETE FROM information WHERE info_age ='18';";
			stmt.executeUpdate(deleteData);
			System.out.println("successfully delete Table (나이가 18살인 레코드삭제)\n");
			String commit = "COMMIT";
			String rollback = "ROLLBACK";
			System.out.print("commit(1) 하시겠습니까 rollback(2)하시겠습니까? :");
			int cr = Menu.sc.nextInt();
			if(cr==1){
				stmt.executeUpdate(commit);
				System.out.println(deleteData+"sql문이 실행되었습니다.\n");
			}else if(cr==2){
				stmt.executeUpdate(rollback);
				System.out.println("ROLLBACK 되었습니다.");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}


	//DB보기 (excuteQuery)
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
			System.out.println(count+"개의 DB가 권한부여 됐습니다.\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}



	//릴레이션 조회
	public void displayRecord(){
		try{
			ResultSet result = stmt.executeQuery("SELECT * FROM item");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n\tinformation 릴레이션");
					System.out.println("고객아이디\t고객이름\t고객나이");
					System.out.println("==========================================");
				}
				String resultRecord = result.getString("info_id")+"\t\t";
				resultRecord = resultRecord + result.getString("info_name")+"\t\t";
				resultRecord = resultRecord + result.getString("info_age");
				System.out.println(resultRecord);
				count++;
			}
			System.out.println("==========================================");
			System.out.println(count+"개의 레코드가 검색되었습니다.\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//SELECT (집계함수를 이용)
	public void cntRecord(){
		try{
			ResultSet result = stmt.executeQuery("SELECT COUNT(*) from information");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n\tinformation 튜플 개수");
					System.out.println("==========================================");
				}
				String resultRecord = result.getString(1);
				System.out.println(resultRecord+"개의 레코드가 검색되었습니다.\n");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//SELECT (LIKE를 이용)
	public void cntName(){
		try{
			ResultSet result = stmt.executeQuery("SELECT info_id, info_name, info_age FROM information WHERE info_name LIKE '_____';");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n이름이 5자인 고객의 고객아이디,이름,나이");
					System.out.println("고객아이디\t고객이름\t고객나이");
					System.out.println("==========================================");
				}
				String resultRecord = result.getString("info_id")+"\t\t";
				resultRecord = resultRecord + result.getString("info_name")+"\t\t";
				resultRecord = resultRecord + result.getString("info_age");
				System.out.println(resultRecord);
				count++;
			}
			System.out.println("==========================================");
			System.out.println(count+"개의 레코드가 검색되었습니다.\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//SELECT (집계함수+LIKE를 이용)
	public void cntId(){
		try{
			ResultSet result = stmt.executeQuery("SELECT COUNT(info_id) FROM information WHERE info_id LIKE '%op%';");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n아이디에 'op'가 들어간 고객의 수");
					System.out.println("==========================================");
				}
				String resultRecord = result.getString(1);
				System.out.println(resultRecord+"개의 레코드가 검색되었습니다.\n");
				count++;
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	//SELECT (집계함수+비교언산자를 이용
	public void cntAge(){
		try{
			ResultSet result = stmt.executeQuery("SELECT COUNT(info_age) FROM information WHERE info_age>=20 AND info_age<=24;");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n나이가 20살이상 24살이하 고객의 수");
					System.out.println("==========================================");
				}
				String resultRecord = result.getString(1);
				System.out.println(resultRecord+"개의 레코드가 검색되었습니다.\n");
				count++;
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}


}