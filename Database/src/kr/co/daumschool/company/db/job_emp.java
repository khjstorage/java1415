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

	String numberOfworker;  			  //�����ȣ 
	String nameOfworker;    				//����̸� 
	String recruit;         		 	  //ä������(������,��������,�ð���) 
	String rank;          				  //���� 
	int month_use;						//�ް� ����
	int family;               			 //���� �� 
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