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
			String createdTable = "CREATE TABLE 제품"
					+ "(제품번호 int NOT NULL primary key,"
					+ "제품명 varchar(10) NOT NULL,"
					+ "재고량 int NOT NULL,"
					+ "단가 int NOT NULL);";
			stmt.executeUpdate(createdTable);
			System.out.println("제품 테이블 생성\n");
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	public void insertItem(){
		try{
			String insertSql = "insert into 제품(제품번호,제품명,재고량,단가) values(?,?,?,?)";
			pstmt = conn.prepareStatement(insertSql);

			System.out.print("제품번호 :");
			int itemnum = Menu.sc.nextInt();
			System.out.print("제품명 :");
			String itemname = Menu.sc.next();
			System.out.print("재고량 :");
			int itemprice = Menu.sc.nextInt();
			System.out.print("단가 :");
			int itemamount = Menu.sc.nextInt();

			pstmt.setInt(1, itemnum);
			pstmt.setString(2, itemname);
			pstmt.setInt(3, itemprice);
			pstmt.setInt(4, itemamount);
			pstmt.executeUpdate();
			System.out.println("등록완료\n");

		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	public void updateInPut(){
		try{
			ResultSet result = stmt.executeQuery("SELECT * FROM 제품 ");

			System.out.print("제품명 :");
			String itemname = Menu.sc.next();

			while(result.next()){
				if(itemname.equals(result.getString("제품명"))){
					int existing = result.getInt("재고량");
					System.out.print("재고량 :");
					int ItemAmount = Menu.sc.nextInt();
					String updatetSQL = "UPDATE 제품 SET 재고량=? WHERE 제품명=?";
					pstmt = conn.prepareStatement(updatetSQL);
					pstmt.setString(2, itemname);
					pstmt.setInt(1, existing+ItemAmount);
					pstmt.executeUpdate();
					System.out.println("수정완료\n");
					break;
				}
			}						
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	public void updateOutPut(){
		try{
			ResultSet result = stmt.executeQuery("SELECT * FROM 제품");

			System.out.print("제품명 :");
			String itemname = Menu.sc.next();

			while(result.next()){
				if(itemname.equals(result.getString("제품명"))){
					int existing = result.getInt("재고량");
					System.out.print("재고량 :");
					int ItemAmount = Menu.sc.nextInt();
					String updatetSQL = "UPDATE 제품 SET 재고량=? WHERE 제품명=?";
					pstmt = conn.prepareStatement(updatetSQL);
					pstmt.setString(2, itemname);
					pstmt.setInt(1, existing-ItemAmount);
					pstmt.executeUpdate();
					System.out.println("수정완료\n");
					break;
				}
			}						
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	public void displayRecord(){
		try{
			ResultSet result = stmt.executeQuery("SELECT * FROM 제품");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n\t\t 제품 릴레이션\n");
					System.out.println("제품번호\t제품명\t\t재고량\t단가");
					System.out.println("==============================================");
				}
				String resultRecord = "    "+result.getInt("제품번호")+"\t\t";
				resultRecord = resultRecord + result.getString("제품명")+"\t";
				resultRecord = resultRecord + result.getInt("재고량")+"\t";
				resultRecord = resultRecord + result.getInt("단가")+"\t";
				System.out.println(resultRecord);
				count++;
			}
			System.out.println("==============================================");
			System.out.println(count+"개의 레코드가 검색되었습니다.\n");
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
