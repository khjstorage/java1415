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
                //���̺� ����
                return;
            case 1:
                cbdb.insertRecord();
                //ȸ������
                break;
            case 2:
                //�¼���ȸ
                cbdb.displayRecord();
                break;
            case 3:
                //�����ϱ�
                cbdb.updateSeat();
                break;
            case 4:
                //ȸ�� ������������
                cbdb.member_book_list();
                break;
            case 5:
                //��ȸ�� ������������
                cbdb.nomember_book_list();
                break;
            case 6:
                cbdb.disconnectDB();
                //����
                return;
            default:
                System.out.println("0 to 6 selection again.");

            }
        }
    }

} 