package kr.co.daumschool.factory;

public class Thread_stack extends Thread {
	Control cr;

	public Thread_stack(Control cr){
		this.cr = cr;
	}

	@Override
	public void run() {
			cr.stack_item();
		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

