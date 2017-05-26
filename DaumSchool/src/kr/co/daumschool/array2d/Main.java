package kr.co.daumschool.array2d;

import java.util.Random;
import java.util.Scanner;

interface INIT_MENU{
	int BOOKING = 1, SEARCH = 2, CANCEL = 3, CALCULATION = 4, EXIT = 5;
}

class MenuViewer {
	public static Scanner sc = new Scanner(System.in);

	public static void showMenu() {
		System.out.println("\n�����ϼ���...");
		System.out.println("1. �¼�����");
		System.out.println("2. �¼���ȸ");
		System.out.println("3. ��������");
		System.out.println("4. �ݾװ��");
		System.out.println("5. ����");
		System.out.print("����: ");
	}
}


public class Main {
	public static void main(String[] args) {

		Seat_info[][] seat = new Seat_info[3][6];
		Random r = new Random();

		//�¼� �ʱ�ȭ
		int digit=0;
		System.out.println("���ѤѤѤѤѤѤѤѤѤ��¼�ǥ�ѤѤѤѤѤѤѤѤѤѤѦ�");
		for(int row=0; row<seat.length; row++){
			System.out.print("��");
			for(int col=0; col<seat[row].length; col++){
				Seat_info t = new Seat_info();
				t.setSeat_num(String.valueOf(++digit));	//	String a = String.valueOf(100) = String a = ""+100;	
				t.setBook("(x)");
				seat[row][col] = t;
				System.out.print(seat[row][col].getSeat_num());
				System.out.print(seat[row][col].getBook()+"\t ");
			}
			System.out.println("��");
		}
		System.out.println("���ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѦ�");

		while(true){
			MenuViewer.showMenu();
			int choice = MenuViewer.sc.nextInt();

			if (choice < INIT_MENU.BOOKING || choice > INIT_MENU.EXIT){
				System.out.println("1~5�� �߿� �ٽ� �������ּ���");
			}

			switch(choice){


			case INIT_MENU.BOOKING:

				System.out.println("������ �¼��� �����ϼ���(1~18��)");
				int book_num = MenuViewer.sc.nextInt();
				if(book_num<0 || book_num>18)
					System.out.print("�ٽ� ");
				for(int row=0; row<seat.length; row++){
					for(int col=0; col<seat[row].length; col++){
						if(seat[row][col].getSeat_num().equals(String.valueOf(book_num))){
							if(seat[row][col].getBook()=="(x)" && seat[row][col].getBook()!=("(O)")){
								seat[row][col].setBook("(O)");
								System.out.println(seat[row][col].getSeat_num()+"���� ���� �ƽ��ϴ�.");
								System.out.print(seat[row][col].getSeat_num()+"���� ��й�ȣ�� �Է����ּ��� >>");
								int pin = MenuViewer.sc.nextInt();
								seat[row][col].setPassword(pin);
							}else{
								System.out.println("already booked");
								System.out.print("�ٽ� ");
							}
						}
					}

				}
				break;

			case INIT_MENU.SEARCH:
				System.out.println("�¼���ȸǥ �Դϴ�.");
				for(int row=0; row<seat.length; row++){
					for(int col=0; col<seat[row].length; col++){
						System.out.print(seat[row][col].getSeat_num());
						System.out.print(seat[row][col].getBook()+"\t");
					}
					System.out.println("");
				}
				break;


			case INIT_MENU.CANCEL:
				System.out.println("����� �¼���ȣ�� �����ϼ���");
				int cancle_num = MenuViewer.sc.nextInt();
				if(cancle_num<0 || cancle_num>18)
					System.out.print("�ٽ� ");

				for(int row=0; row<seat.length; row++){
					for(int col=0; col<seat[row].length; col++){
						if(seat[row][col].getSeat_num().equals(String.valueOf(cancle_num))){
							if(seat[row][col].getBook()=="(O)"){
								System.out.print(seat[row][col].getSeat_num()+"���� ��й�ȣ�� �Է����ּ��� >>");
								int pin = MenuViewer.sc.nextInt();

								if(seat[row][col].getPassword()==pin){
									seat[row][col].setBook("(x)");
									System.out.println(seat[row][col].getSeat_num()+"���� ������� �ƽ��ϴ�.");
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
							int random_money = r.nextInt(200000)+100000; //r.nextInt(100) = 0~99���� +100 100~299
							seat[row][col].setMoney(random_money);
							random_total_money += seat[row][col].getMoney();
						}
					}
				}
				System.out.println("Total coast is "+ ((random_total_money/1000)*1000));
				break;

			case INIT_MENU.EXIT:
				System.out.println("�����մϴ�");
				return;


			}//switch
		}//while
	}//main
}//Class

