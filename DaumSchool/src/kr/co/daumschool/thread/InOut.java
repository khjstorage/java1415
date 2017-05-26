package kr.co.daumschool.thread;

import java.util.Random;

public class InOut {
	Random r = new Random();
	public static int MAX_HALL = 5;				//Ȧ
	public static int MAX_TICKET =2;			//��ǥ��
	public static int MAX_SNACK =1;				//����
	public static int MAX_LOUNGE =3;			//�ްԼ�
	public static int MAX_A= 10;				//A�󿵰�
	public static int MAX_B= 10;				//B�󿵰�
	public static int MAX_C= 10;				//C�󿵰�
	
	int hallNum, ticketNum, snackNum, loungeNum, aNum, bNum, cNum = 0;	
	
	//����(Ȧ)
	public synchronized void inHall(){
		System.out.println("�մ��� ����(Ȧ)�� ����");
		hallNum++;
		System.out.println("���� ����(Ȧ)�ο��� "+hallNum+"���Դϴ�.\n");
		if(hallNum==MAX_HALL){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public synchronized void outHall(){
		if(hallNum < 1){
			notify();
			return;
		}
		System.out.println("����(Ȧ)���� ��ǥ���̵�");
		hallNum--;
		inTicket();	//��ǥ���̵�~
		System.out.println("���� ����(Ȧ)�ο��� "+hallNum+"���Դϴ�.\n");
	}
	
	//��ǥ��
	public synchronized void inTicket(){
		System.out.println("�մ��� ��ǥ�� ����");
		ticketNum++;
		System.out.println("���� ��ǥ�ҿ� �ִ� �մ��� "+ticketNum+"���Դϴ�.");
		if(ticketNum==MAX_TICKET){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public synchronized void outTicket(){
		if(ticketNum < 1){
			notify();
			return;
		}
		System.out.println("�մ��� Ƽ�ϱ����� ��ǥ�� ����");
		ticketNum--;
		int rNum = r.nextInt(5)+1;
		if(rNum==1){		
			inSnack();
		}else if(rNum==2){
			inLounge();
		}else if(rNum==3){
			inA();
		}else if(rNum==4){
			inB();
		}else{
			inC();
		}
		System.out.println("���� ��ǥ�� �մ��� "+ticketNum+"���Դϴ�.");
	}
	
	//����
	public synchronized void inSnack(){
		System.out.println("�մ��� ���� ����");
		snackNum++;
		System.out.println("���� �����̿� ���� "+snackNum+"���Դϴ�.");
		if(snackNum==MAX_SNACK){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public synchronized void outSnack(){
		if(ticketNum < 1){
			notify();
			return;
		}
		System.out.println("�մ��� �������� ����");
		snackNum--;
		int rNum = r.nextInt(5)+1;
		if(rNum==1){		
			inA();
		}else if(rNum==2){
			inB();
		}else{
			inC();
		}
		System.out.println("���� �������ִ� �ռ��� "+snackNum+"���Դϴ�.");
	}
	
	//�ްԼ�
	public synchronized void inLounge(){
		System.out.println("�մ��� �ްԽ� ����");
		loungeNum++;
		System.out.println("���� �ްԽ��̿� ���� "+loungeNum+"���Դϴ�.");
		if(loungeNum==MAX_LOUNGE){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public synchronized void outLounge(){
		if(loungeNum < 1){
			notify();
			return;
		}
		System.out.println("�մ��� �ްԽǿ��� ����");
		loungeNum--;
		int rNum = r.nextInt(5)+1;
		if(rNum==1){		
			inA();
		}else if(rNum==2){
			inB();
		}else{
			inC();
		}
		System.out.println("���� �ްԽǿ��ִ� �մ��� "+loungeNum+"���Դϴ�.");
	}
	
	//A�󿵰�
	public synchronized void inA(){
		System.out.println("�մ��� (A)�󿵰� ����");
		aNum++;
		System.out.println("���� (A)�󿵰� ���� "+aNum+"���Դϴ�.");
		if(aNum==MAX_A){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public synchronized void outA(){
		if(aNum < 1){
			notify();
			return;
		}
		System.out.println("�մ��� (A)�󿵰����� ����");
		aNum--;
		System.out.println("���� (A)�󿵰����ִ� �մ��� "+aNum+"���Դϴ�.");
	}
	
	//B�󿵰�
	public synchronized void inB(){
		System.out.println("�մ��� (B)�󿵰� ����");
		bNum++;
		System.out.println("���� (B)�󿵰� ���� "+bNum+"���Դϴ�.");
		if(bNum==MAX_B){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public synchronized void outB(){
		if(bNum < 1){
			notify();
			return;
		}
		System.out.println("�մ��� (B)�󿵰����� ����");
		bNum--;
		System.out.println("���� (B)�󿵰����ִ� �մ��� "+bNum+"���Դϴ�.");
	}
	
	//C�󿵰�
	public synchronized void inC(){
		System.out.println("�մ��� (C)�󿵰� ����");
		cNum++;
		System.out.println("���� (C)�󿵰� ���� "+cNum+"���Դϴ�.");
		if(cNum==MAX_C){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public synchronized void outC(){
		if(cNum < 1){
			notify();
			return;
		}
		System.out.println("�մ��� (C)�󿵰����� ����");
		cNum--;
		System.out.println("���� (C)�󿵰����ִ� �մ��� "+cNum+"���Դϴ�.");
	}
	
	
	
	public static void main(String[] args) {
		InOut io = new InOut();
		
		HallThread_in hi = new HallThread_in(io);
		HallThread_out oi = new HallThread_out(io);
		TicketThread_in ti = new TicketThread_in(io);
		TicketThread_out to = new TicketThread_out(io);
		
		hi.start();
		oi.start();
		ti.start();
		to.start();
	}

}

	
	

