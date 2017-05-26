package kr.co.daumschool.thread;

public class AThread_out extends Thread {
	InOut io;

	public AThread_out(InOut io){
		this.io = io;
	}
	
	@Override
	public void run() {
		for(int i=1; i<100; i++){
			io.outA();
			try{
				Thread.sleep(1500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}




