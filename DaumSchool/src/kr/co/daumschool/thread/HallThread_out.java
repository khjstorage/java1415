package kr.co.daumschool.thread;

public class HallThread_out extends Thread {
	InOut io;
	
	public HallThread_out(InOut io){
		this.io = io;
	}

	@Override
	public void run() {
		for(int i=1; i<10; i++){
			io.outHall();
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
}
