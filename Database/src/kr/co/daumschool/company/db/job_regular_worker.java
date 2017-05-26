package kr.co.daumschool.company.db; 

import java.sql.ResultSet; 
import java.sql.SQLException; 

class job_regular_worker extends job_emp{ 

	int service_years;            //근무연수 
	int base_pay;                //기본급 
	int rank_pay;                //직급수당 
	double family_pay;            //가족수당 

	public job_regular_worker(){ 
		super(); 
	} 

	@Override 
	public double getSalary(String number){ 
		//기본급여+(근무연수*직급수당*가족수당)-세금 

		try{ 
			ResultSet result_worker = stmt.executeQuery("SELECT * FROM worker WHERE Number='"+number+"'"); 
			while(result_worker.next()){ 
				service_years = result_worker.getInt("Service_Years"); 
				family = result_worker.getInt("Family"); 
				family_pay = family * 0.05; 
				rank = result_worker.getString("Rank"); 
			} 

			ResultSet result_rank_pay = stmt.executeQuery("SELECT * FROM rank_pay WHERE Rank='"+rank+"'"); 
			while(result_rank_pay.next()){ 
				base_pay = result_rank_pay.getInt("Base_pay"); 
				rank_pay = result_rank_pay.getInt("Rank_pay"); 
			} 

			money = (base_pay+(service_years * rank_pay * family_pay)); 
			money = money - (money * TAX_RATE); 

			return money; 

		}catch(SQLException e){ 
			System.err.println("SQL Error:"+e.getMessage()); 
		} 
		return 0; 
	}

	public double gethoilday_Salary(String number){
		try{
			ResultSet result_worker = stmt.executeQuery("SELECT * FROM worker WHERE Number='"+number+"'"); 
			while(result_worker.next()){ 
				rank = result_worker.getString("Rank"); 
			}

			ResultSet result_rank_pay = stmt.executeQuery("SELECT * FROM rank_pay WHERE Rank='"+rank+"'"); 
			while(result_rank_pay.next()){ 
				hoilday_money = result_rank_pay.getInt("Hoilday_pay");
			}
			
			ResultSet result_holiday = stmt.executeQuery("SELECT * FROM holiday WHERE Number='"+number+"'"); 
			while(result_holiday.next()){ 
				month_use = result_rank_pay.getInt("Month");
			}

			return hoilday_money = (hoilday_money * (12-month_use));

		}catch(SQLException e){ 
			System.out.println("SQL Error:"+e.getMessage()); 
		}
		return 0; 
	}
	

}


