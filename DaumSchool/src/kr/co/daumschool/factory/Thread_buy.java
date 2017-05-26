package kr.co.daumschool.factory;

public class Thread_buy extends Thread{
	Control cr;
	public Thread_buy(Control cr){
		this.cr = cr;
	}

	@Override
	public void run() {
		for(int i=0; i<3; i++){
			cr.select_item();
		}
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}