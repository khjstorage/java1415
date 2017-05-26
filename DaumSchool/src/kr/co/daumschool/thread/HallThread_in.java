package kr.co.daumschool.thread;

public class HallThread_in extends Thread {
	InOut io;
	
	public HallThread_in(InOut io){
		this.io = io;
	}
	
	@Override
	public void run() {
		for(int i=1; i<10; i++){
			io.inHall();
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
