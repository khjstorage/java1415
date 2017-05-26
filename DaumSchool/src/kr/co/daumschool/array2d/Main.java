package kr.co.daumschool.array2d;

import java.util.Random;
import java.util.Scanner;

interface INIT_MENU{
	int BOOKING = 1, SEARCH = 2, CANCEL = 3, CALCULATION = 4, EXIT = 5;
}

class MenuViewer {
	public static Scanner sc = new Scanner(System.in);

	public static void showMenu() {
		System.out.println("\n선택하세요...");
		System.out.println("1. 좌석예약");
		System.out.println("2. 좌석조회");
		System.out.println("3. 예약해지");
		System.out.println("4. 금액계산");
		System.out.println("5. 종료");
		System.out.print("선택: ");
	}
}


public class Main {
	public static void main(String[] args) {

		Seat_info[][] seat = new Seat_info[3][6];
		Random r = new Random();

		//좌석 초기화
		int digit=0;
		System.out.println("┌ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ좌석표ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ┐");
		for(int row=0; row<seat.length; row++){
			System.out.print("│");
			for(int col=0; col<seat[row].length; col++){
				Seat_info t = new Seat_info();
				t.setSeat_num(String.valueOf(++digit));	//	String a = String.valueOf(100) = String a = ""+100;	
				t.setBook("(x)");
				seat[row][col] = t;
				System.out.print(seat[row][col].getSeat_num());
				System.out.print(seat[row][col].getBook()+"\t ");
			}
			System.out.println("│");
		}
		System.out.println("└ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ┘");

		while(true){
			MenuViewer.showMenu();
			int choice = MenuViewer.sc.nextInt();

			if (choice < INIT_MENU.BOOKING || choice > INIT_MENU.EXIT){
				System.out.println("1~5번 중에 다시 선택해주세요");
			}

			switch(choice){


			case INIT_MENU.BOOKING:

				System.out.println("예약할 좌석을 선택하세요(1~18번)");
				int book_num = MenuViewer.sc.nextInt();
				if(book_num<0 || book_num>18)
					System.out.print("다시 ");
				for(int row=0; row<seat.length; row++){
					for(int col=0; col<seat[row].length; col++){
						if(seat[row][col].getSeat_num().equals(String.valueOf(book_num))){
							if(seat[row][col].getBook()=="(x)" && seat[row][col].getBook()!=("(O)")){
								seat[row][col].setBook("(O)");
								System.out.println(seat[row][col].getSeat_num()+"번이 예약 됐습니다.");
								System.out.print(seat[row][col].getSeat_num()+"번의 비밀번호를 입력해주세요 >>");
								int pin = MenuViewer.sc.nextInt();
								seat[row][col].setPassword(pin);
							}else{
								System.out.println("already booked");
								System.out.print("다시 ");
							}
						}
					}

				}
				break;

			case INIT_MENU.SEARCH:
				System.out.println("좌석조회표 입니다.");
				for(int row=0; row<seat.length; row++){
					for(int col=0; col<seat[row].length; col++){
						System.out.print(seat[row][col].getSeat_num());
						System.out.print(seat[row][col].getBook()+"\t");
					}
					System.out.println("");
				}
				break;


			case INIT_MENU.CANCEL:
				System.out.println("취소할 좌석번호를 선택하세요");
				int cancle_num = MenuViewer.sc.nextInt();
				if(cancle_num<0 || cancle_num>18)
					System.out.print("다시 ");

				for(int row=0; row<seat.length; row++){
					for(int col=0; col<seat[row].length; col++){
						if(seat[row][col].getSeat_num().equals(String.valueOf(cancle_num))){
							if(seat[row][col].getBook()=="(O)"){
								System.out.print(seat[row][col].getSeat_num()+"번의 비밀번호를 입력해주세요 >>");
								int pin = MenuViewer.sc.nextInt();

								if(seat[row][col].getPassword()==pin){
									seat[row][col].setBook("(x)");
									System.out.println(seat[row][col].getSeat_num()+"번이 예약취소 됐습니다.");
								}else{
									System.out.println("password is wrong");
								}

							}else{
								System.out.println("yet not booked");
							}
						}	
					}
				}
				break;



			case INIT_MENU.CALCULATION:
				System.out.println("Total cost of booked");
				int random_total_money=0;
				for(int row=0; row<seat.length; row++){
					for(int col=0; col<seat.length; col++){
						if(seat[row][col].getBook().equals("(O)")){
							int random_money = r.nextInt(200000)+100000; //r.nextInt(100) = 0~99숫자 +100 100~299
							seat[row][col].setMoney(random_money);
							random_total_money += seat[row][col].getMoney();
						}
					}
				}
				System.out.println("Total coast is "+ ((random_total_money/1000)*1000));
				break;

			case INIT_MENU.EXIT:
				System.out.println("종료합니다");
				return;


			}//switch
		}//while
	}//main
}//Class

