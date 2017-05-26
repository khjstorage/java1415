package kr.co.daumschool.thread;

public class TicketThread_in extends Thread {
	InOut io;

	public TicketThread_in(InOut io){
		this.io = io;
	}
	
	@Override
	public void run() {
		for(int i=1; i<10; i++){
			io.outHall();
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
