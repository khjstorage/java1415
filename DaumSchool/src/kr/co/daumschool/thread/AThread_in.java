package kr.co.daumschool.thread;

public class AThread_in extends Thread {
	InOut io;
	
	public AThread_in(InOut io){
		this.io = io;
	}

	@Override
	public void run() {
		for(int i=1; i<100; i++){
			io.inA();
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}