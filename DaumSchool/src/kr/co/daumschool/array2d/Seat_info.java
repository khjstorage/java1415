package kr.co.daumschool.array2d;

public class Seat_info {

    private String seat_num;
    private String book;
    private int money;
    private int password;
    
    public Seat_info(){
        
    }
    
    //�¼���ȣ
    public String getSeat_num() {
        return seat_num;
    }
    public void setSeat_num(String seat_num) {
        this.seat_num = seat_num;
    }
    
    //����Ȯ��
    public String getBook() {
        return book;
    }
    public void setBook(String book) {
        this.book = book;
    }
    
    //�ݾ�
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    
    //��й�ȣ
    public int getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }

}
