package kr.co.daumschool.company.db; 

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 

import kr.co.daumschool.item.db.Menu; 

public class ControlCompany { 
	Connection conn = null; 
	Statement stmt = null; 
	PreparedStatement pstmt = null; 

	job_regular_worker jrw = new job_regular_worker(); 
	job_temporary_worker jtw = new job_temporary_worker(); 
	job_part_time_worker jptw = new job_part_time_worker(); 

	public ControlCompany(){ 
		try{ 
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println("Successfully Driver loding"); 
		}catch(java.lang.ClassNotFoundException e){ 
			System.err.print("CLassNotFoundEXception :" +e.getMessage()); 
			return; 
		} 

		String user = "hyunjin"; 
		String password = "0509"; 
		String URL = "jdbc:mysql://127.0.0.1:3306/company"; 

		try{ 
			conn=DriverManager.getConnection(URL, user, password); 
			stmt = conn.createStatement(); 
			System.out.println("Use DB : company"); 
			System.out.println("Account : hyunjin\n"); 
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
	public void created_rank_pay_Table(){ 
		try{ 
			String createdTable = "CREATE TABLE rank_pay" 
					+ "(Rank varchar(8) NOT NUll," 
					+ "Rank_pay int NOT NULL," 
					+ "Base_pay int NOT NULL,"
					+ "Hoilday_pay int NOT NULL)"; 
			stmt.executeUpdate(createdTable); 
			System.out.println("rank_pay 테이블 생성완료"); 

			String insertSql1 = "insert into rank_pay(Rank,Rank_pay,Base_pay,Hoilday_pay) values('SaWon','150000','1500000','50000')"; 
			stmt.executeUpdate(insertSql1); 
			String insertSql2 = "insert into rank_pay(Rank,Rank_pay,Base_pay,Hoilday_pay) values('DaeRi','200000','2000000','66000')"; 
			stmt.executeUpdate(insertSql2); 
			String insertSql3 = "insert into rank_pay(Rank,Rank_pay,Base_pay,Hoilday_pay) values('GwaJang','250000','2500000','83000')"; 
			stmt.executeUpdate(insertSql3); 
			String insertSql4 = "insert into rank_pay(Rank,Rank_pay,Base_pay,Hoilday_pay) values('ChaJang','300000','3000000','100000')"; 
			stmt.executeUpdate(insertSql4); 
			String insertSql5 = "insert into rank_pay(Rank,Rank_pay,Base_pay,Hoilday_pay) values('BuJang','400000','4000000','130000')"; 
			stmt.executeUpdate(insertSql5); 

		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 
	public void created_part_time_Table(){ 
		try{ 
			String createdTable = "CREATE TABLE part_time_pay" 
					+ "(Part_Time varchar(8) NOT NULL," 
					+ "Part_Pay int NOT NULL)"; 
			stmt.executeUpdate(createdTable); 
			System.out.println("part_time 테이블 생성완료"); 

			String insertSql1 = "insert into part_time_pay(part_time, part_pay) values('part1','15000')"; 
			stmt.executeUpdate(insertSql1); 

			String insertSql2 = "insert into part_time_pay(part_time, part_pay) values('part2','10000')"; 
			stmt.executeUpdate(insertSql2); 

			String insertSql3 = "insert into part_time_pay(part_time, part_pay) values('part3','8000')"; 
			stmt.executeUpdate(insertSql3); 


		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 
	public void created_worker_Table(){ 
		try{ 
			String createdTable = "CREATE TABLE worker" 
					+ "(Number varchar(15) NOT NUll primary key,"        //사원번호 
					+ "Name varchar(15) NOT NULL,"                        //사원이름 
					+ "Recruit varchar(15) NOT NULL,"                    //고용형태 
					+ "Rank varchar(8),"                                //직급 
					+ "Service_Years int,"                                //근무연수 
					+ "Term_Of_Contract int,"                            //계약기간 
					+ "Part_Time varchar(8),"                            //파트타임형태 
					+ "Service_Hours int,"                                //근무시간 
					+ "Family int)";                                    //가족 
			stmt.executeUpdate(createdTable); 
			System.out.println("worker 테이블 생성완료"); 

		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 
	public void created_pay_Table(){ 
		try{ 
			String createdTable = "CREATE TABLE pay" 
					+ "(Number varchar(15) NOT NUll primary key,"        //사원번호 
					+ "Wage int NOT NULL,"								//총수령급여
					+ "Holiday_pay int)";                              	//휴가비   
			stmt.executeUpdate(createdTable); 
			System.out.println("pay 테이블 생성완료"); 

		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 

	} 
	public void created_holiday_Table(){ 
		try{ 
			String createdTable = "CREATE TABLE holiday" 
					+ "(Number varchar(15) NOT NUll primary key,"        //사원번호 
					+ "Month int NOT NULL)";								 //월
			stmt.executeUpdate(createdTable); 
			System.out.println("holiday 테이블 차생성완료\n"); 

		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 

	private void regular_info(){ 
		try{ 
			//worker 입력 
			String insertSql = "insert into worker(Number, Name, Recruit, Rank, Service_Years, Family) values(?,?,?,?,?,?)"; 
			pstmt = conn.prepareStatement(insertSql); 
			System.out.print("사원번호 :"); 
			String numberOfworker = Menu.sc.next(); 
			System.out.print("사원이름 :"); 
			String nameOfworker = Menu.sc.next(); 
			String recruit = "Regular_worker"; 
			System.out.print("직위 :"); 
			String rank = Menu.sc.next(); 
			System.out.print("근무연수 :"); 
			int yearsOfservice = Menu.sc.nextInt(); 
			System.out.print("가족수 :"); 
			int family = Menu.sc.nextInt(); 
			pstmt.setString(1, numberOfworker); 
			pstmt.setString(2, nameOfworker); 
			pstmt.setString(3, recruit); 
			pstmt.setString(4, rank); 
			pstmt.setInt(5, yearsOfservice); 
			pstmt.setInt(6, family); 
			pstmt.executeUpdate(); 
			System.out.println("등록완료\n"); 

			//급여입력 
			double money =jrw.getSalary(numberOfworker); 
			String updateSql = "INSERT INTO pay(Number, Wage) values(?,?)"; 
			pstmt = conn.prepareStatement(updateSql); 
			pstmt.setString(1, numberOfworker); 
			pstmt.setDouble(2, money); 
			pstmt.executeUpdate(); 
		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 
	private void temporay_info(){ 
		try{ 
			String insertSql = "insert into worker(Number, Name, Recruit, Rank, Term_Of_Contract, Family) values(?,?,?,?,?,?)"; 
			pstmt = conn.prepareStatement(insertSql); 
			System.out.print("사원번호 :"); 
			String numberOfworker = Menu.sc.next(); 
			System.out.print("사원이름 :"); 
			String nameOfworker = Menu.sc.next(); 
			String recruit = "temp_worker"; 
			System.out.print("직위 :"); 
			String rank = Menu.sc.next(); 
			System.out.print("계약기간 :"); 
			int termOfcontract = Menu.sc.nextInt(); 
			System.out.print("가족수 :"); 
			int family = Menu.sc.nextInt(); 
			pstmt.setString(1, numberOfworker); 
			pstmt.setString(2, nameOfworker); 
			pstmt.setString(3, recruit); 
			pstmt.setString(4, rank); 
			pstmt.setInt(5, termOfcontract); 
			pstmt.setInt(6, family); 
			pstmt.executeUpdate(); 
			System.out.println("등록완료\n"); 

			double money =jtw.getSalary(numberOfworker); 
			String updateSql = "INSERT INTO pay(Number, Wage) values(?,?)"; 
			pstmt = conn.prepareStatement(updateSql); 
			pstmt.setString(1, numberOfworker); 
			pstmt.setDouble(2, money); 
			pstmt.executeUpdate(); 
		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 
	private void partTime_info(){ 
		try{ 
			String insertSql = "insert into worker(Number, Name, Recruit, Part_time, Service_Hours, Family) values(?,?,?,?,?,?)"; 
			pstmt = conn.prepareStatement(insertSql); 
			System.out.print("사원번호 :"); 
			String numberOfworker = Menu.sc.next(); 
			System.out.print("사원이름 :"); 
			String nameOfworker = Menu.sc.next(); 
			String recruit = "part_worker"; 
			System.out.print("파트타임 :"); 
			String timeOfpart = Menu.sc.next(); 
			System.out.print("근무시간 :"); 
			int hoursOfservice = Menu.sc.nextInt(); 
			System.out.print("가족수 :"); 
			int family = Menu.sc.nextInt(); 
			pstmt.setString(1, numberOfworker); 
			pstmt.setString(2, nameOfworker); 
			pstmt.setString(3, recruit); 
			pstmt.setString(4, timeOfpart); 
			pstmt.setInt(5, hoursOfservice); 
			pstmt.setInt(6, family); 
			pstmt.executeUpdate(); 
			System.out.println("등록완료\n"); 

			double money = jptw.getSalary(numberOfworker); 
			String updateSql = "INSERT INTO pay(Number, Wage) values(?,?)"; 
			pstmt = conn.prepareStatement(updateSql); 
			pstmt.setString(1, numberOfworker); 
			pstmt.setDouble(2, money); 
			pstmt.executeUpdate(); 
		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 
	public void insertRecord(){ 
		System.out.println("1. 정규직 2. 비정규직 3. 시간제"); 
		System.out.print("선택>> "); 
		int choice = Menu.sc.nextInt(); 

		switch(choice){ 
		case 1: 
			regular_info(); 
			break; 
		case 2: 
			temporay_info(); 
			break; 
		case 3: 
			partTime_info(); 
			break; 
		default: 
			System.out.println("\n\tPlease select again from the beginning\n"); 
		} 
	} 

	public void display_pay_Record(){ 
		try{ 
			ResultSet result = stmt.executeQuery("SELECT * FROM pay"); 
			int count=0; 
			while(result.next()){ 
				if(count==0){ 
					System.out.println("\n\t 직원 급여 목록\n"); 
					System.out.println("직원번호\t급여"); 
					System.out.println("=========================="); 
				} 
				String resultRecord="";  
				resultRecord = resultRecord + result.getInt("Number")+"\t\t"; 
				resultRecord = resultRecord + result.getInt("Wage")+"\t"; 
				System.out.println(resultRecord); 
				count++; 
			} 
			System.out.println("=========================="); 
			System.out.println(count+"개의 레코드가 검색되었습니다.\n"); 
		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 
	
	private void regular_search_pay_Recorid(){ 
		try{ 
			System.out.print("사원번호 : "); 
			String numberOfworker = Menu.sc.next(); 

			ResultSet result = stmt.executeQuery("SELECT * " 
					+ "FROM pay, worker " 
					+ "WHERE worker.Number='"+numberOfworker+"' AND worker.Number = pay.Number"); 

			int count=0; 
			while(result.next()){ 
				if(count==0){ 
					System.out.println("\n\t 사원번호 "+numberOfworker+"번 직원급여\n"); 
					System.out.println("직원번호\t이름\t\t급여\t"); 
					System.out.println("=============================================="); 
				} 
				String resultRecord="";  
				resultRecord = resultRecord + result.getString("worker.Number")+"\t\t"; 
				resultRecord = resultRecord + result.getString("worker.Name")+"\t\t"; 
				resultRecord = resultRecord + result.getInt("pay.Wage")+"\t\t"; 
				System.out.println(resultRecord+"\n"); 
				if(count==0){ 
					System.out.println("직위\t\t근무연수\t가족수\t"); 
					System.out.println("=============================================="); 
				} 
				String resultRecord2=""; 
				resultRecord2 = resultRecord2 + result.getString("worker.Rank")+"\t\t"; 
				resultRecord2 = resultRecord2 + result.getInt("worker.Service_Years")+"\t\t"; 
				resultRecord2 = resultRecord2 + result.getInt("worker.Family")+"\t\t"; 
				System.out.println(resultRecord2+"\n"); 
			} 

		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 
	private void temporay_search_pay_Recorid(){ 
		try{ 
			System.out.print("사원번호 : "); 
			String numberOfworker = Menu.sc.next(); 

			ResultSet result = stmt.executeQuery("SELECT * " 
					+ "FROM pay, worker " 
					+ "WHERE worker.Number='"+numberOfworker+"' AND worker.Number = pay.Number"); 

			int count=0; 
			while(result.next()){ 
				if(count==0){ 
					System.out.println("\n\t 사원번호 "+numberOfworker+"번 직원급여\n"); 
					System.out.println("직원번호\t\t이름\t\t급여\t\t"); 
					System.out.println("=============================================="); 
				} 
				String resultRecord="";  
				resultRecord = resultRecord + result.getString("worker.Number")+"\t\t"; 
				resultRecord = resultRecord + result.getString("worker.Name")+"\t\t"; 
				resultRecord = resultRecord + result.getInt("pay.Wage")+"\t\t"; 
				System.out.println(resultRecord+"\n"); 
				if(count==0){ 
					System.out.println("직위\t\t계약기간\t가족수\t\t"); 
					System.out.println("=============================================="); 
				} 
				String resultRecord2=""; 
				resultRecord2 = resultRecord2 + result.getString("worker.Rank")+"\t\t"; 
				resultRecord2 = resultRecord2 + result.getInt("worker.Term_Of_Contract")+"\t\t"; 
				resultRecord2 = resultRecord2 + result.getInt("worker.Family")+"\t\t"; 
				System.out.println(resultRecord2+"\n"); 
			} 

		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 
	private void partTime_search_pay_Recorid(){ 
		try{ 
			System.out.print("사원번호 : "); 
			String numberOfworker = Menu.sc.next(); 

			ResultSet result = stmt.executeQuery("SELECT * " 
					+ "FROM pay, worker " 
					+ "WHERE worker.Number='"+numberOfworker+"' AND worker.Number = pay.Number"); 

			int count=0; 
			while(result.next()){ 
				if(count==0){ 
					System.out.println("\n\t 사원번호 "+numberOfworker+"번 직원급여\n"); 
					System.out.println("직원번호\t이름\t\t급여\t\t"); 
					System.out.println("=============================================="); 
				} 
				String resultRecord="";  
				resultRecord = resultRecord + result.getString("worker.Number")+"\t\t"; 
				resultRecord = resultRecord + result.getString("worker.Name")+"\t\t"; 
				resultRecord = resultRecord + result.getInt("pay.Wage")+"\t\t"; 
				System.out.println(resultRecord+"\n"); 
				if(count==0){ 
					System.out.println("파트타임\t파트시간\t가족수\t\t"); 
					System.out.println("=============================================="); 
				} 
				String resultRecord2=""; 
				resultRecord2 = resultRecord2 + result.getString("worker.Part_Time")+"\t\t"; 
				resultRecord2 = resultRecord2 + result.getInt("worker.Service_Hours")+"\t\t"; 
				resultRecord2 = resultRecord2 + result.getInt("worker.Family")+"\t\t"; 
				System.out.println(resultRecord2+"\n"); 
			} 

		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 
	public void search_pay_Record(){ 
		display_pay_Record();
		System.out.println("1. 정규직 2. 비정규직 3. 시간제"); 
		System.out.print("선택>> "); 
		int choice = Menu.sc.nextInt(); 

		switch(choice){ 
		case 1: 
			regular_search_pay_Recorid(); 
			break; 
		case 2: 
			temporay_search_pay_Recorid(); 
			break; 
		case 3: 
			partTime_search_pay_Recorid(); 
			break; 
		default: 
			System.out.println("\n\tPlease select again from the beginning\n"); 
		} 
	} 
	
	public void holiday_insertRecord(){
		try{
			System.out.print("사원번호 :"); 
			String numberOfworker = Menu.sc.next();
			System.out.print("월차횟수 :"); 
			int month_use = Menu.sc.nextInt();
			
			String insertSql = "insert into holiday(Number, Month) values(?,?)"; 
			pstmt = conn.prepareStatement(insertSql); 
			pstmt.setString(1, numberOfworker); 
			pstmt.setInt(2, month_use); 
			pstmt.executeUpdate(); 
			
		
		}catch(SQLException e){ 
			System.err.println("SQL Error:"+e.getMessage()); 
		} 
	}
	
	
	public void holiday_pay_insertRecord(){
		try{
			System.out.println("사원번호 :");
			String numberOfworker = Menu.sc.next();
			
			double holiday_pay = jrw.gethoilday_Salary(numberOfworker);
			System.out.println(holiday_pay);
			String updateSql = "UPDATE pay SET Holiday_pay='?' WHERE Number='?'";
			pstmt = conn.prepareStatement(updateSql);
			pstmt.setDouble(1, holiday_pay); 
			pstmt.setString(2, numberOfworker); 
			pstmt.executeUpdate(); 
			
		}catch(SQLException e){ 
			System.err.println("SQL Error:"+e.getMessage()); 
		}
	}

}

