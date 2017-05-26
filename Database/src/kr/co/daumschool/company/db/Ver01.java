package kr.co.daumschool.company.db;

public class Ver01 {
    public static void main(String args[]){

        ControlCompany ccdb = new ControlCompany();
        
        int choice=0;
        while((choice=Menu.main_Menu())!=6){
            switch(choice){
            case 0:
                ccdb.created_worker_Table();
                ccdb.created_rank_pay_Table();
                ccdb.created_part_time_Table();
                ccdb.created_pay_Table();
                ccdb.created_holiday_Table();
                return;
            case 1:
                ccdb.insertRecord();
                break;
            case 2:
                ccdb.display_pay_Record();
                break;
            case 3:
                ccdb.search_pay_Record();
                break;
            case 4:
            	ccdb.holiday_insertRecord();
                break;
            case 5:
            	ccdb.holiday_pay_insertRecord();
            	break;
            case 6:
                ccdb.disconnectDB();
                return;
            default:
                System.out.println("0 to 6 selection again.");


            }
        }
    }
}