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
			String createdTable = "CREATE TABLE 주문"
					+ "(주문번호 int NOT NULL AUTO_INCREMENT primary key,"
					+ "주문고객 varchar(11) NOT NULL,"
					+ "주문제품 varchar(10) NOT NULL,"
					+ "수량 int NOT NULL)";
			stmt.executeUpdate(createdTable);
			System.out.println("주문 테이블 생성\n");
		}catch(SQLException e){
			System.err.println("SQL Error:"+e.getMessage());
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
		String id = Menu.sc.next();
		System.out.print("비밀번호: ");
		String pin = Menu.sc.next();

		try{
			ResultSet result = stmt.executeQuery("SELECT * FROM 고객 WHERE 고객아이디 ='"+id+"'");
			while(result.next()){
				if(pin.equals(result.getString("비밀번호"))){
					System.out.println("로그인 성공!\n");
					myid = id;
					mypin = pin;
					memberMenu();
				}else if(!pin.equals(result.getString("비밀번호"))){
					System.out.println("로그인 실패! 비밀번호를 확인해주세요\n");
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
	
	private void orderItem(){
		try{
			String insertSql = "insert into 주문(주문고객,주문제품,수량) values(?,?,?)";
			pstmt = conn.prepareStatement(insertSql);

			System.out.print("주문제품 :");
			String item_order = Menu.sc.next();
			System.out.print("구입개수 :");
			int item_quantity = Menu.sc.nextInt();
			

			int stock_status=0;
			
			ResultSet result = stmt.executeQuery("SELECT * FROM 제품 WHERE 제품명='"+item_order+"' AND 재고량>0");
			while(result.next()){
				pstmt.setString(1, myid);
				pstmt.setString(2, item_order);
				pstmt.setInt(3, item_quantity);
				stock_status = result.getInt("재고량");
			}	
					
			if(stock_status>0){							   // (현재창고재고 - 구입한개수) 제품릴레이션 업데이트
				String updatetSQL = "UPDATE 제품 SET 재고량="+(stock_status-item_quantity)+" WHERE 제품명='"+item_order+"'";
				pstmt.executeUpdate();
				stmt.executeUpdate(updatetSQL);
				System.out.println("주문이 완료되었습니다.\n");
			}else{
				System.out.println("매진상품 입니다.\n");
			}
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	private void backItem(){
		try{
			System.out.print("반품할 제품 :");
			String item_back = Menu.sc.next();
			System.out.print("반품할 제품(주문번호) :");
			String item_back_num = Menu.sc.next();
			
			String deleteSql = "DELETE "+
							   "FROM 주문 " +
							   "WHERE 주문제품 ='"+item_back+"' AND 주문번호='"+item_back_num+"' AND 주문고객 IN (SELECT 고객아이디 " +
							   																				     "FROM 고객 " +
							   																				     "WHERE 고객아이디 ='"+myid+"')";
			//이걸 public int aaa(String item_back)
			//		return 재고량
			//메서드화...해서 반품할 제품(번호)만으로 반품 처리하게
			ResultSet result_item = stmt.executeQuery("SELECT * FROM 제품 WHERE 제품명='"+item_back+"'");
			int factory_stock_status=0;	  //반품된 제품 늘리기 위한 기존 제품 재고량
			while(result_item.next()){
				factory_stock_status= result_item.getInt("재고량");
			}
			
			
			ResultSet result = stmt.executeQuery("SELECT * FROM 주문 WHERE 주문번호='"+item_back_num+"'");
			int order_stock_status=0;			//고객이 주문한 상품 반품 수량
			while(result.next()){
				order_stock_status = result.getInt("수량");
			}
			
			if(order_stock_status!=0){						//  (현재창고재고 + 반품된개수) 제품릴레이션 업데이트
				String updatetSQL = "UPDATE 제품 SET 재고량="+(factory_stock_status+order_stock_status)+" WHERE 제품명='"+item_back+"'";
				stmt.executeUpdate(updatetSQL);
				stmt.executeUpdate(deleteSql);
				System.out.println("반품처리 완료되었습니다.\n");
			}
			
		}catch(SQLException e){
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	private void myOrder(){
		try{
			ResultSet result = stmt.executeQuery("Select 주문번호, 주문제품, SUM(수량) AS '총 주문량' FROM 주문 WHERE 주문고객='"+myid+"' GROUP BY 주문번호;");
			int count=0;
			while(result.next()){
				if(count==0){
					System.out.println("\n\t"+myid+"고객님의 장바구니\n");
					System.out.println("주문번호\t주문제품\t총 주문량");
					System.out.println("==========================================");
				}				
				String resultRecord = result.getInt("주문번호")+"\t\t";
				resultRecord = resultRecord + result.getString("주문제품")+"\t";
				resultRecord = resultRecord + result.getInt("총 주문량");
				System.out.println(resultRecord);
				count++;
			}
			System.out.println("==========================================");
			System.out.println(count+"개의 상품이 장바구니에 있습니다.\n");
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
























