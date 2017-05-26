package kr.co.daumschool.thread;

import java.util.Random;

public class InOut {
	Random r = new Random();
	public static int MAX_HALL = 5;				//홀
	public static int MAX_TICKET =2;			//매표소
	public static int MAX_SNACK =1;				//매점
	public static int MAX_LOUNGE =3;			//휴게소
	public static int MAX_A= 10;				//A상영관
	public static int MAX_B= 10;				//B상영관
	public static int MAX_C= 10;				//C상영관
	
	int hallNum, ticketNum, snackNum, loungeNum, aNum, bNum, cNum = 0;	
	
	//극장(홀)
	public synchronized void inHall(){
		System.out.println("손님이 극장(홀)에 들어옴");
		hallNum++;
		System.out.println("현재 극장(홀)인원은 "+hallNum+"명입니다.\n");
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
		System.out.println("극장(홀)에서 매표소이동");
		hallNum--;
		inTicket();	//매표소이동~
		System.out.println("현재 극장(홀)인원은 "+hallNum+"명입니다.\n");
	}
	
	//매표소
	public synchronized void inTicket(){
		System.out.println("손님이 매표소 들어옴");
		ticketNum++;
		System.out.println("현재 매표소에 있는 손님은 "+ticketNum+"명입니다.");
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
		System.out.println("손님이 티켓구매후 매표소 나감");
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
		System.out.println("현재 매표소 손님은 "+ticketNum+"명입니다.");
	}
	
	//매점
	public synchronized void inSnack(){
		System.out.println("손님이 매점 들어옴");
		snackNum++;
		System.out.println("현재 매점이용 고객은 "+snackNum+"명입니다.");
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
		System.out.println("손님이 매점에서 나감");
		snackNum--;
		int rNum = r.nextInt(5)+1;
		if(rNum==1){		
			inA();
		}else if(rNum==2){
			inB();
		}else{
			inC();
		}
		System.out.println("현재 매점에있는 손서은 "+snackNum+"명입니다.");
	}
	
	//휴게소
	public synchronized void inLounge(){
		System.out.println("손님이 휴게실 들어옴");
		loungeNum++;
		System.out.println("현재 휴게실이용 고객은 "+loungeNum+"명입니다.");
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
		System.out.println("손님이 휴게실에서 나감");
		loungeNum--;
		int rNum = r.nextInt(5)+1;
		if(rNum==1){		
			inA();
		}else if(rNum==2){
			inB();
		}else{
			inC();
		}
		System.out.println("현재 휴게실에있는 손님은 "+loungeNum+"명입니다.");
	}
	
	//A상영관
	public synchronized void inA(){
		System.out.println("손님이 (A)상영관 들어옴");
		aNum++;
		System.out.println("현재 (A)상영관 고객은 "+aNum+"명입니다.");
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
		System.out.println("손님이 (A)상영관에서 나감");
		aNum--;
		System.out.println("현재 (A)상영관에있는 손님은 "+aNum+"명입니다.");
	}
	
	//B상영관
	public synchronized void inB(){
		System.out.println("손님이 (B)상영관 들어옴");
		bNum++;
		System.out.println("현재 (B)상영관 고객은 "+bNum+"명입니다.");
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
		System.out.println("손님이 (B)상영관에서 나감");
		bNum--;
		System.out.println("현재 (B)상영관에있는 손님은 "+bNum+"명입니다.");
	}
	
	//C상영관
	public synchronized void inC(){
		System.out.println("손님이 (C)상영관 들어옴");
		cNum++;
		System.out.println("현재 (C)상영관 고객은 "+cNum+"명입니다.");
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
		System.out.println("손님이 (C)상영관에서 나감");
		cNum--;
		System.out.println("현재 (C)상영관에있는 손님은 "+cNum+"명입니다.");
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

	
	

