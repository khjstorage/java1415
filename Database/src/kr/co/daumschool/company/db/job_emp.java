package kr.co.daumschool.company.db; 

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement; 

abstract class job_emp { 

	Connection conn = null; 
	Statement stmt = null; 
	PreparedStatement pstmt = null; 

	String numberOfworker;  			  //사원번호 
	String nameOfworker;    				//사원이름 
	String recruit;         		 	  //채용형태(정규직,비정규직,시간제) 
	String rank;          				  //직위 
	int month_use;						//휴가 사용수
	int family;               			 //가족 수 
	final double TAX_RATE = 0.10;  
	double money;
	double hoilday_money;

	public job_emp(){ 
		try{ 
			Class.forName("com.mysql.jdbc.Driver"); 
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
		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		} 
	} 

	public abstract double getSalary(String number); 
	

	


}