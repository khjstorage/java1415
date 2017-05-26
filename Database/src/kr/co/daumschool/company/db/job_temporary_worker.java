package kr.co.daumschool.company.db; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
class job_temporary_worker extends job_emp { 
     
    int termOfcontract;            //계약기간 
    int base_pay;                //기본급여 
    int rank_pay;                //직급수당 
         
    public job_temporary_worker(){ 
        super(); 
    } 
    
    @Override 
    public double getSalary(String number){ 
        //기본급여+(계약기간*직급수당/2)-세금 
 
        try{ 
            ResultSet result_worker = stmt.executeQuery("SELECT * FROM worker WHERE Number='"+number+"'"); 
            while(result_worker.next()){ 
                termOfcontract = result_worker.getInt("Term_Of_Contract"); 
                rank = result_worker.getString("Rank"); 
            } 
             
            ResultSet result_rank_pay = stmt.executeQuery("SELECT * FROM rank_pay WHERE Rank='"+rank+"'"); 
            while(result_rank_pay.next()){ 
                base_pay = result_rank_pay.getInt("Base_pay"); 
                rank_pay = result_rank_pay.getInt("Rank_pay"); 
            } 
 
            money = (base_pay+(termOfcontract * (rank_pay/2) * family)); 
            money = money - (money * TAX_RATE); 
 
            return money; 
 
        }catch(SQLException e){ 
            System.out.println("SQL Error:"+e.getMessage()); 
        } 
        return 0; 
    }

 
} 