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
			System.out.println("rank_pay ���̺� �����Ϸ�"); 

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
			System.out.println("part_time ���̺� �����Ϸ�"); 

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
					+ "(Number varchar(15) NOT NUll primary key,"        //�����ȣ 
					+ "Name varchar(15) NOT NULL,"                        //����̸� 
					+ "Recruit varchar(15) NOT NULL,"                    //������� 
					+ "Rank varchar(8),"                                //���� 
					+ "Service_Years int,"                                //�ٹ����� 
					+ "Term_Of_Contract int,"                            //���Ⱓ 
					+ "Part_Time varchar(8),"                            //��ƮŸ������ 
					+ "Service_Hours int,"                                //�ٹ��ð� 
					+ "Family int)";                                    //���� 
			stmt.executeUpdate(createdTable); 
			System.out.println("worker ���̺� �����Ϸ�"); 

		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 
	public void created_pay_Table(){ 
		try{ 
			String createdTable = "CREATE TABLE pay" 
					+ "(Number varchar(15) NOT NUll primary key,"        //�����ȣ 
					+ "Wage int NOT NULL,"								//�Ѽ��ɱ޿�
					+ "Holiday_pay int)";                              	//�ް���   
			stmt.executeUpdate(createdTable); 
			System.out.println("pay ���̺� �����Ϸ�"); 

		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 

	} 
	public void created_holiday_Table(){ 
		try{ 
			String createdTable = "CREATE TABLE holiday" 
					+ "(Number varchar(15) NOT NUll primary key,"        //�����ȣ 
					+ "Month int NOT NULL)";								 //��
			stmt.executeUpdate(createdTable); 
			System.out.println("holiday ���̺� �������Ϸ�\n"); 

		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 

	private void regular_info(){ 
		try{ 
			//worker �Է� 
			String insertSql = "insert into worker(Number, Name, Recruit, Rank, Service_Years, Family) values(?,?,?,?,?,?)"; 
			pstmt = conn.prepareStatement(insertSql); 
			System.out.print("�����ȣ :"); 
			String numberOfworker = Menu.sc.next(); 
			System.out.print("����̸� :"); 
			String nameOfworker = Menu.sc.next(); 
			String recruit = "Regular_worker"; 
			System.out.print("���� :"); 
			String rank = Menu.sc.next(); 
			System.out.print("�ٹ����� :"); 
			int yearsOfservice = Menu.sc.nextInt(); 
			System.out.print("������ :"); 
			int family = Menu.sc.nextInt(); 
			pstmt.setString(1, numberOfworker); 
			pstmt.setString(2, nameOfworker); 
			pstmt.setString(3, recruit); 
			pstmt.setString(4, rank); 
			pstmt.setInt(5, yearsOfservice); 
			pstmt.setInt(6, family); 
			pstmt.executeUpdate(); 
			System.out.println("��ϿϷ�\n"); 

			//�޿��Է� 
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
			System.out.print("�����ȣ :"); 
			String numberOfworker = Menu.sc.next(); 
			System.out.print("����̸� :"); 
			String nameOfworker = Menu.sc.next(); 
			String recruit = "temp_worker"; 
			System.out.print("���� :"); 
			String rank = Menu.sc.next(); 
			System.out.print("���Ⱓ :"); 
			int termOfcontract = Menu.sc.nextInt(); 
			System.out.print("������ :"); 
			int family = Menu.sc.nextInt(); 
			pstmt.setString(1, numberOfworker); 
			pstmt.setString(2, nameOfworker); 
			pstmt.setString(3, recruit); 
			pstmt.setString(4, rank); 
			pstmt.setInt(5, termOfcontract); 
			pstmt.setInt(6, family); 
			pstmt.executeUpdate(); 
			System.out.println("��ϿϷ�\n"); 

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
			System.out.print("�����ȣ :"); 
			String numberOfworker = Menu.sc.next(); 
			System.out.print("����̸� :"); 
			String nameOfworker = Menu.sc.next(); 
			String recruit = "part_worker"; 
			System.out.print("��ƮŸ�� :"); 
			String timeOfpart = Menu.sc.next(); 
			System.out.print("�ٹ��ð� :"); 
			int hoursOfservice = Menu.sc.nextInt(); 
			System.out.print("������ :"); 
			int family = Menu.sc.nextInt(); 
			pstmt.setString(1, numberOfworker); 
			pstmt.setString(2, nameOfworker); 
			pstmt.setString(3, recruit); 
			pstmt.setString(4, timeOfpart); 
			pstmt.setInt(5, hoursOfservice); 
			pstmt.setInt(6, family); 
			pstmt.executeUpdate(); 
			System.out.println("��ϿϷ�\n"); 

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
		System.out.println("1. ������ 2. �������� 3. �ð���"); 
		System.out.print("����>> "); 
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
					System.out.println("\n\t ���� �޿� ���\n"); 
					System.out.println("������ȣ\t�޿�"); 
					System.out.println("=========================="); 
				} 
				String resultRecord="";  
				resultRecord = resultRecord + result.getInt("Number")+"\t\t"; 
				resultRecord = resultRecord + result.getInt("Wage")+"\t"; 
				System.out.println(resultRecord); 
				count++; 
			} 
			System.out.println("=========================="); 
			System.out.println(count+"���� ���ڵ尡 �˻��Ǿ����ϴ�.\n"); 
		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 
	
	private void regular_search_pay_Recorid(){ 
		try{ 
			System.out.print("�����ȣ : "); 
			String numberOfworker = Menu.sc.next(); 

			ResultSet result = stmt.executeQuery("SELECT * " 
					+ "FROM pay, worker " 
					+ "WHERE worker.Number='"+numberOfworker+"' AND worker.Number = pay.Number"); 

			int count=0; 
			while(result.next()){ 
				if(count==0){ 
					System.out.println("\n\t �����ȣ "+numberOfworker+"�� �����޿�\n"); 
					System.out.println("������ȣ\t�̸�\t\t�޿�\t"); 
					System.out.println("=============================================="); 
				} 
				String resultRecord="";  
				resultRecord = resultRecord + result.getString("worker.Number")+"\t\t"; 
				resultRecord = resultRecord + result.getString("worker.Name")+"\t\t"; 
				resultRecord = resultRecord + result.getInt("pay.Wage")+"\t\t"; 
				System.out.println(resultRecord+"\n"); 
				if(count==0){ 
					System.out.println("����\t\t�ٹ�����\t������\t"); 
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
			System.out.print("�����ȣ : "); 
			String numberOfworker = Menu.sc.next(); 

			ResultSet result = stmt.executeQuery("SELECT * " 
					+ "FROM pay, worker " 
					+ "WHERE worker.Number='"+numberOfworker+"' AND worker.Number = pay.Number"); 

			int count=0; 
			while(result.next()){ 
				if(count==0){ 
					System.out.println("\n\t �����ȣ "+numberOfworker+"�� �����޿�\n"); 
					System.out.println("������ȣ\t\t�̸�\t\t�޿�\t\t"); 
					System.out.println("=============================================="); 
				} 
				String resultRecord="";  
				resultRecord = resultRecord + result.getString("worker.Number")+"\t\t"; 
				resultRecord = resultRecord + result.getString("worker.Name")+"\t\t"; 
				resultRecord = resultRecord + result.getInt("pay.Wage")+"\t\t"; 
				System.out.println(resultRecord+"\n"); 
				if(count==0){ 
					System.out.println("����\t\t���Ⱓ\t������\t\t"); 
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
			System.out.print("�����ȣ : "); 
			String numberOfworker = Menu.sc.next(); 

			ResultSet result = stmt.executeQuery("SELECT * " 
					+ "FROM pay, worker " 
					+ "WHERE worker.Number='"+numberOfworker+"' AND worker.Number = pay.Number"); 

			int count=0; 
			while(result.next()){ 
				if(count==0){ 
					System.out.println("\n\t �����ȣ "+numberOfworker+"�� �����޿�\n"); 
					System.out.println("������ȣ\t�̸�\t\t�޿�\t\t"); 
					System.out.println("=============================================="); 
				} 
				String resultRecord="";  
				resultRecord = resultRecord + result.getString("worker.Number")+"\t\t"; 
				resultRecord = resultRecord + result.getString("worker.Name")+"\t\t"; 
				resultRecord = resultRecord + result.getInt("pay.Wage")+"\t\t"; 
				System.out.println(resultRecord+"\n"); 
				if(count==0){ 
					System.out.println("��ƮŸ��\t��Ʈ�ð�\t������\t\t"); 
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
		System.out.println("1. ������ 2. �������� 3. �ð���"); 
		System.out.print("����>> "); 
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
			System.out.print("�����ȣ :"); 
			String numberOfworker = Menu.sc.next();
			System.out.print("����Ƚ�� :"); 
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
			System.out.println("�����ȣ :");
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

