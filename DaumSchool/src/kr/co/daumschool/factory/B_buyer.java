package kr.co.daumschool.factory;


public class B_buyer extends Thread{
	Control cr;
	
	public B_buyer(Control cr) {
		this.cr=cr;
	}
	
	@Override
	public void run() {
		cr.select_item();
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}

