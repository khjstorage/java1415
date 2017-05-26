package kr.co.daumschool.thread;

public class TicketThread_out  extends Thread {
	InOut io;
	
	public TicketThread_out(InOut io){
		this.io = io;
	}
	
	@Override
	public void run() {
		for(int i=1; i<10; i++){
			io.inTicket();
			try{
				Thread.sleep(1500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
