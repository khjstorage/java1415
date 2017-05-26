package kr.co.daumschool.factory;

/*
 * �ʱ�ȭ��
 * 1.���� o
 * 2.��ȸ o
 * 3.��� o
 * 4.�α�ǰ��
 * 5.����
 */
public class Ver_01{
	public static void main(String[] args) {

		Control cr = new Control();
		Thread_buy buy = new Thread_buy(cr);
		Thread_stack stack = new Thread_stack(cr);
		A_buyer ab = new A_buyer(cr);
		B_buyer bb = new B_buyer(cr);
		C_buyer cb = new C_buyer(cr);
		
		boolean st = true;
		int choice;

		while((choice=Menu.main_Menu())!=5){
			switch(choice){
			case 1:
				ab.start();
				bb.start();
				cb.start();
				stack.start();
				try{
					ab.join();
					bb.join();
					cb.join();
					stack.join();
				}catch(Exception e){

				}
				break;
			case 2:
				cr.search_buyer_Info();
				break;
			case 3:
				cr.inventory();
				break;
			case 4:
				break;
			case 5:
				return;
			default:
				System.out.println("choice num of 1~5");
			}

		}

	}

}