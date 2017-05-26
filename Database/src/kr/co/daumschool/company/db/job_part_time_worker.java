package kr.co.daumschool.company.db; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
class job_part_time_worker extends job_emp { 
     
    int part_pay;                //파트별 알바 급액 
    int service_hours;            //알바 시간 
    String part_time;             
     
    
    public job_part_time_worker(){ 
        super(); 
    } 
    
    @Override
    public double getSalary(String number){ 
        //(파트*알바시간)-세금 
         
        try{  
            ResultSet result_worker = stmt.executeQuery("SELECT * FROM worker WHERE Number='"+number+"'"); 
            while(result_worker.next()){ 
                service_hours = result_worker.getInt("Service_Hours"); 
                part_time = result_worker.getString("Part_Time"); 
            } 
 
            ResultSet result_part_time_pay = stmt.executeQuery("SELECT * FROM part_time_pay WHERE Part_Time='"+part_time+"'"); 
            while(result_part_time_pay.next()){ 
                part_pay = result_part_time_pay.getInt("Part_Pay"); 
            } 
 
            money = (part_pay * service_hours); 
            money = money - (money * TAX_RATE); 
 
            return money; 
 
        }catch(SQLException e){ 
            System.out.println("SQL Error:"+e.getMessage()); 
        } 
        return 0; 
    }

 
 
}