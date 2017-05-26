package kr.co.daumschool.cinema.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;


public class ControlBooking {


    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;

    public ControlBooking(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Successfully Driver loding");
        }catch(java.lang.ClassNotFoundException e){
            System.err.print("CLassNotFoundEXception :" +e.getMessage());
            return;
        }

        String user = "hyunjin";
        String password = "0509";
        String URL = "jdbc:mysql://127.0.0.1:3306/cinema";

        try{
            conn=DriverManager.getConnection(URL, user, password);
            stmt = conn.createStatement();
            System.out.println("Use DB : cinema");
            System.out.println("Account : hyunjin\n");
        }catch(SQLException e){
            System.out.println("SQL Error:"+e.getMessage());
        }
    }

    public void created_Seat_Table(){
        try{
            String createdTable = "CREATE TABLE seat"
                    + "(Seat_Number int NOT NULL AUTO_INCREMENT primary key,"
                    + "Seat_Grade char(1) NOT NULL,"
                    + "Seat_Price int NOT NULL,"
                    + "Seat_Booking_Name varchar(15))";
            stmt.executeUpdate(createdTable);
            System.out.println("seat 테이블 생성완료\n");

            for(int i=1; i<=30; i++){
                String insertSql = "insert into seat(Seat_Grade,Seat_Price) values(?,?)";
                pstmt = conn.prepareStatement(insertSql);
                if(i<=10){
                    pstmt.setString(1, "S");
                    pstmt.setInt(2, 10000);
                }else if(i<=20){
                    pstmt.setString(1, "A");
                    pstmt.setInt(2, 7000);
                }else{
                    pstmt.setString(1, "B");
                    pstmt.setInt(2, 3000);
                }
                pstmt.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println("SQL Error:"+e.getMessage());
        }
    }

    public void created_Member_Table(){
        try{
            String createdTable = "CREATE TABLE member"
                    + "(Member_Name varchar(15) NOT NULL,"
                    + "Member_Phone int NOT NULL primary key,"
                    + "Seat_Number int,"
                    + "Seat_Price int,"
                    + "Member_Tier char(1) NOT NULL)";
            stmt.executeUpdate(createdTable);
            System.out.println("member 테이블 생성완료\n");
        }catch(SQLException e){
            System.out.println("SQL Error:"+e.getMessage());
        }
    }

    Random r = new Random();

    public void insertRecord(){
        System.out.print("이름 : ");
        String name = Menu.sc.next();
        System.out.print("번호 : ");
        String pin = Menu.sc.next();
        if(Integer.parseInt(pin)<=99999 && Integer.parseInt(pin)<=999999){
            System.out.println("6자리 숫자 입력\n");
            return;
        }

        //등급
        int tierTemp = r.nextInt(3)+1;
        String tier ="";
        if(tierTemp==1){
            tier = "P";
        }else if(tierTemp==2){
            tier ="G";
        }else{
            tier = "S";
        }
        try{
            String insertData = "INSERT INTO member(Member_Name, Member_Phone, Member_Tier)"
                    + " VALUES ('"+name+"', '"+pin+"', '"+tier+"');";
            ResultSet result = stmt.executeQuery("SELECT * FROM member");
            while(result.next()){
                if(result.getString("Member_Phone").equals(name)){
                    System.out.print(result.getString("Member_Phone"));
                    System.out.println("(은)는 이미 등록된 번호(식별) 입니다.\n");
                    return;
                }
            }
            stmt.executeUpdate(insertData);
            System.out.println();
        }catch(SQLException e){
            System.out.println("SQL Error:"+e.getMessage());
        }
    }

    public void displayRecord(){
        try{
            int result_Number=0;
            String result_Booking_name="";
            int count=1;

            ResultSet result = stmt.executeQuery("SELECT Seat_Number,Seat_Booking_Name FROM seat");
            while(result.next()){
                result_Number = result.getInt("Seat_Number");
                result_Booking_name = result.getString("Seat_Booking_Name");

                if(count==1) System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ좌 석 표ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
                Seat_info t = new Seat_info();
                t.setSeat_num(result_Number);
                t.setSeat_booking(result_Booking_name);
                if(0<result_Number && result_Number<=5)    System.out.print(" ");
                if(5<result_Number && result_Number<=9)    System.out.print(" ");
                System.out.print(t.getSeat_num()+" ");
                System.out.print(t.getSeat_booking()+" \t");

                if(count==5)     System.out.println("");
                if(count==10)     System.out.println("");
                if(count==15)     System.out.println("");
                if(count==20)     System.out.println("");
                if(count==25)     System.out.println("");
                if(count==30)    System.out.println("");
                count++;
            }
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            System.out.println((count-1)+"개의 자리가 검색되었습니다.");
            displayPrice();

        }catch(SQLException e){
            System.out.println("SQL Error:"+e.getMessage());
        }
    }

    public void displayPrice(){
        try{
            int result_Price=0;

            ResultSet result_10000 = stmt.executeQuery("SELECT Seat_Price FROM seat WHERE Seat_Price='10000'");
            while(result_10000.next()) result_Price = result_10000.getInt("Seat_Price");
            System.out.println("1~10번째자리 가격은 "+result_Price+"원 입니다.");

            ResultSet result_7000 = stmt.executeQuery("SELECT Seat_Price FROM seat WHERE Seat_Price='7000'");
            while(result_7000.next()) result_Price = result_7000.getInt("Seat_Price");
            System.out.println("11~20번째자리 가격은 "+result_Price+"원 입니다.");

            ResultSet result_3000 = stmt.executeQuery("SELECT Seat_Price FROM seat WHERE Seat_Price='3000'");
            while(result_3000.next()) result_Price = result_3000.getInt("Seat_Price");
            System.out.println("11~20번째자리 가격은 "+result_Price+"원 입니다.\n");

        }catch(SQLException e){
            System.out.println("SQL Error:"+e.getMessage());
        }
    }

    public void updateSeat(){
        try{

            System.out.print("번호 :");
            int reserve_phone = Menu.sc.nextInt();
            if(reserve_phone<=99999 && reserve_phone<=999999){
                System.out.println("6자리 숫자 입력\n");
                return;
            }

            System.out.print("몇자리 예약 하시겠습니까? :");
            int numOfseat = Menu.sc.nextInt();

            for(int i=1; i<=numOfseat; i++){
                System.out.print("예약할 좌석("+i+") :");
                int bookOfseat = Menu.sc.nextInt();

                if(check_table(reserve_phone, bookOfseat)==false){
                    i--;
                }
            }
        }catch(Exception e){
            System.out.println("SQL Error:"+e.getMessage());
        }
    }

    public boolean check_table(int reserve_phone, int reserve_number){
        try{
            int seat_number = 0;
            String seat_booking_name = "";

            ResultSet result_seat = stmt.executeQuery("SELECT * FROM seat WHERE Seat_Number='"+reserve_number+"'");
            while(result_seat.next()){
                seat_number = result_seat.getInt("Seat_Number");
                seat_booking_name = result_seat.getString("Seat_Booking_Name");
                if(seat_booking_name!=null){
                    System.out.println(seat_number+"번 자리는 예약 자리입니다.\n");
                    return false;
                }
            }
            String updateSql = "UPDATE seat SET Seat_Booking_Name='"+reserve_phone+"' WHERE Seat_Number='"+reserve_number+"'";
            stmt.executeUpdate(updateSql);

        }catch(SQLException e){
            System.out.println("SQL Error:"+e.getMessage());
        }
        return true;
    }

    public void member_book_list(){
        try{
            int seat_number=0;
            int member_price=0;
            int hap_price=0;
            int all_seat=0;
            String check_tier="";

            System.out.print("번호 :");
            String reserve_phone = Menu.sc.next();

            ResultSet result_seat = stmt.executeQuery("SELECT * FROM seat WHERE Seat_Booking_Name='"+reserve_phone+"';");
            while(result_seat.next()){

                member_price = result_seat.getInt("Seat_Price");
                hap_price = hap_price + member_price;

                seat_number = result_seat.getInt("Seat_Number");
                System.out.print(seat_number);
                System.out.print(" ");

                all_seat++;
            }
            System.out.println("번 자리입니다.");

            ResultSet result_member = stmt.executeQuery("SELECT * FROM member WHERE Member_Phone='"+reserve_phone+"';");
            while(result_member.next()){
                check_tier = result_member.getString("Member_Tier");
            }

            if(check_tier.equals("P")){
                hap_price = (int) (hap_price - (hap_price * 0.10));
                System.out.println("플래티넘 회원입니다 10% DC");

            }else if(check_tier.equals("G")){
                hap_price = (int) (hap_price - (hap_price * 0.07));
                System.out.println("골드 회원입니다 7% DC");

            }else if(check_tier.equals("S")){
                hap_price = (int) (hap_price - (hap_price * 0.03));
                System.out.println("실버 회원입니다 3% DC");

            }else{
                System.out.println("회원이 아닙니다. 5번 메뉴(비회원전용)을 선택해주세요.\n");
                return;
            }

            String updateSql = "UPDATE member SET Seat_Number='"+all_seat+"', Seat_Price='"+hap_price+"' WHERE Member_Phone='"+reserve_phone+"'";
            stmt.executeUpdate(updateSql);

            System.out.println("회원 가격은 "+hap_price+"원 입니다.\n");

        }catch(SQLException e){
            System.out.println("SQL Error:"+e.getMessage());
        }
    }

    public void nomember_book_list(){
        try{

            int seat_num=0;
            int be_member_price=0;
            int hap_price=0;

            System.out.print("번호 :");
            String reserve_phone = Menu.sc.next();

            ResultSet result_seat = stmt.executeQuery("SELECT * FROM seat WHERE Seat_Booking_Name='"+reserve_phone+"';");
            while(result_seat.next()){
                be_member_price=result_seat.getInt("Seat_Price");
                hap_price = hap_price + be_member_price;

                seat_num=result_seat.getInt("Seat_Number");
                System.out.print(seat_num);
                System.out.print(" ");
            }
            System.out.println("번 자리입니다.");
            System.out.println("비회원 가격은 "+hap_price+"원 입니다.\n");

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


} 