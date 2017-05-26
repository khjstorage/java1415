package kr.co.daumschool.cinema.db;


public class Ver01 {
    public static void main(String args[]){

        ControlBooking cbdb = new ControlBooking();

        int choice=0;
        while((choice=Menu.main_Menu())!=6){
            switch(choice){
            case 0:
                cbdb.created_Seat_Table();
                cbdb.created_Member_Table();
                //테이블 생성
                return;
            case 1:
                cbdb.insertRecord();
                //회원가입
                break;
            case 2:
                //좌석조회
                cbdb.displayRecord();
                break;
            case 3:
                //예약하기
                cbdb.updateSeat();
                break;
            case 4:
                //회원 예약정보보기
                cbdb.member_book_list();
                break;
            case 5:
                //비회원 예약정보보기
                cbdb.nomember_book_list();
                break;
            case 6:
                cbdb.disconnectDB();
                //종료
                return;
            default:
                System.out.println("0 to 6 selection again.");

            }
        }
    }

} 