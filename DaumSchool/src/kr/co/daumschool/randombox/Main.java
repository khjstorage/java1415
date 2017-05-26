package kr.co.daumschool.randombox;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author ������
 * @date 2015. 6. 27. ���� 12:49:37
 */

class MenuViewer{
	public static Scanner sc = new Scanner(System.in);
	public static Random r = new Random();
}



class Main {
	public static void main(String[] args) {

		RandomBox_info[] box = new RandomBox_info[10];

		//�ʱ�ȭ
		int digit = 0;
		for(int i=0; i<box.length; i++){
			RandomBox_info t = new RandomBox_info();

			//�迭�� 1~10���� ��ȣ����
			t.setNumber(++digit);
			System.out.print(t.getNumber()+"\t");

			//�迭�� 0~999���� ��������
			int random_value = MenuViewer.r.nextInt(1000);
			t.setValue(random_value);
			System.out.print(t.getValue()+"\t");

			//�迭�� �̸� ����
			t.setName((char) (Math.random()*26+'A'));
			System.out.println(t.getName());

			t.setState(true);

			box[i] = t;
		}
		System.out.println();


		//����������
		String win = "����� �̰���ϴ�.";
		String draw = "�����ϴ�.";
		String lose = "����� �����ϴ�";
		System.out.println("�ָ԰������� ������. \n(1=�ָ�, 2=����, 3=��)");
		int user_ggb = MenuViewer.sc.nextInt();

		if(user_ggb>0 && user_ggb<4){
			int com_ggb = MenuViewer.r.nextInt(3)+1;
			int winner = user_ggb - com_ggb; //0:���º� & 2,-1:�� & -2,1:�� 
			switch(winner){

			//���º�
			case 0: 
				System.out.println(draw);
				return; 


				//user�� ����������    
			case 2:
			case -1: 
				System.out.println(win);
				System.out.println("��� �ڽ��� �����ϰڽ��ϱ�? (1�� or 2��)");
				int choice = MenuViewer.sc.nextInt();
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(choice==1){
					for(int loop=0; loop<box.length; loop++){
						System.out.println("���° �ڽ��� �������ڽ��ϱ�? (1~10��)");
						int box_num = MenuViewer.sc.nextInt();

						for(int i=0; i<box.length; i++){
							if(box[i].getNumber()==box_num){
								if(box[i].isState()==true){
									box[i].setState(false);
									int user_select_box_num = box[i].getValue();
									System.out.println("����� �ڽ����ڴ� "+box_num+"�Դϴ�.");
								}
							}
						}

						int com_random_choice =  MenuViewer.r.nextInt(2)+1;
						if(com_random_choice==1){
							int com_num = MenuViewer.r.nextInt(10)+1;
							for(int i=0; i<box.length; i++){
								if(com_num!=box_num){
									if(box[i].getNumber()==com_num){
										if(box[i].isState()==true){
											box[i].setState(false);
											int com_select_box_num = box[i].getValue();
											System.out.println("��ǻ���� �ڽ����ڴ� "+com_num+"�Դϴ�.");
										}
									}
								}
							}	
						}else{
							int com_num_1 = MenuViewer.r.nextInt(10)+1;
							int com_num_2 = com_num_1+1;
							for(int i=0; i<box.length; i++){
								if(box[i].getNumber()==com_num_1){
									if(box[i].isState()==true){
										box[i].setState(false);
										int com_select_box_num = box[i].getValue();
										System.out.println("��ǻ���� �ڽ����ڴ� "+com_num_1+"�Դϴ�.");
									}
								}
							}
							for(int i=0; i<box.length; i++ ){
								if(box[i].getNumber()==com_num_2){
									if(box[i].isState()==true){
										box[i].setState(false);
										int com_select_box_num= box[i].getValue();
										System.out.println("��ǻ���� �ڽ����ڴ� "+com_num_2+"�Դϴ�.");
									}
								}
							}

						}
					}

					///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				}else if(choice==2){
					System.out.println("how number box? (box of two)");
					int box_num_1 = MenuViewer.sc.nextInt();
					int box_num_2 = box_num_1+1;
					for(int i=0; i<box.length; i++){
						if(box[i].getNumber()==box_num_1){
							if(box[i].isState()==true){
								box[i].setState(false);
								int user_select_box_num = box[i].getValue();
								System.out.print("����� �ڽ����ڴ� "+box_num_1);
							}
						}
					}
					for(int i=0; i<box.length; i++ ){
						if(box[i].getNumber()==box_num_2){
							if(box[i].isState()==true){
								box[i].setState(false);
								int user_select_box_num= box[i].getValue();
								System.out.println(","+box_num_2+"�Դϴ�.");
							}
						}
					}

					int com_random_choice =  MenuViewer.r.nextInt(2)+1;
					if(com_random_choice==1){
						int com_num = MenuViewer.r.nextInt(10)+1;
						for(int i=0; i<box.length; i++){
							if(com_num!=box_num_1 && com_num!=box_num_2){
								if(box[i].getNumber()==com_num){
									if(box[i].isState()==true){
										box[i].setState(false);
										int com_select_box_num = box[i].getValue();
										System.out.println("��ǻ���� �ڽ����ڴ� "+com_num+"�Դϴ�.");
									}
								}
							}
						}	
					}else{
						int com_num_1 = MenuViewer.r.nextInt(10)+1;
						int com_num_2 = com_num_1+1;
						for(int i=0; i<box.length; i++){
							if(box[i].getNumber()==com_num_1){
								if(box[i].isState()==true){
									box[i].setState(false);
									int com_select_box_num = box[i].getValue();
									System.out.print("��ǻ���� �ڽ����ڴ� "+com_num_1);
								}
							}
						}
						for(int i=0; i<box.length; i++ ){
							if(box[i].getNumber()==com_num_2){
								if(box[i].isState()==true){
									box[i].setState(false);
									int com_select_box_num= box[i].getValue();
									System.out.println(","+com_num_2+"�Դϴ�");
								}
							}
						}

					}
					///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				}else{
					System.out.println("box select number 1 or 2");
				}
				break;











				//com ��������
			case -2: 
			case 1 : 
				System.out.println(lose); 
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				int com_random_choice =  MenuViewer.r.nextInt(2)+1;
				if(com_random_choice==1){
					int com_num = MenuViewer.r.nextInt(10)+1;
					for(int i=0; i<box.length; i++){
						if(box[i].getNumber()==com_num){
							if(box[i].isState()==true){
								box[i].setState(false);
								int com_select_box_num = box[i].getValue();
								System.out.println("��ǻ���� �ڽ����ڴ� "+com_num+"�Դϴ�.");
							}
						}
					}

					System.out.println("��� �ڽ��� �����ϰڽ��ϱ�? (1�� or 2��)");
					choice = MenuViewer.sc.nextInt();
					if(choice==1){
						System.out.println("���° �ڽ��� �������ڽ��ϱ�? (1~10��)");
						int box_num = MenuViewer.sc.nextInt();

						for(int i=0; i<box.length; i++){
							if(box[i].getNumber()==box_num){
								if(box[i].isState()==true){
									box[i].setState(false);
									int user_select_box_num = box[i].getValue();
									System.out.println("����� �ڽ����ڴ� "+box_num+"�Դϴ�.");
								}
							}
						}
					}else if(choice==2){
						System.out.println("how number box? (box of two)");
						int box_num_1 = MenuViewer.sc.nextInt();
						int box_num_2 = box_num_1+1;
						for(int i=0; i<box.length; i++){
							if(box[i].getNumber()==box_num_1){
								if(box[i].isState()==true){
									box[i].setState(false);
									int user_select_box_num = box[i].getValue();
									System.out.print("����� �ڽ����ڴ� "+box_num_1);
								}
							}
						}
						for(int i=0; i<box.length; i++ ){
							if(box[i].getNumber()==box_num_2){
								if(box[i].isState()==true){
									box[i].setState(false);
									int user_select_box_num= box[i].getValue();
									System.out.println(","+box_num_2+"�Դϴ�.");
								}
							}
						}
					}else{
						System.out.println("box select number 1 or 2");
					}
					///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				}else{
					int com_num_1 = MenuViewer.r.nextInt(10)+1;
					int com_num_2 = com_num_1+1;
					for(int i=0; i<box.length; i++){
						if(box[i].getNumber()==com_num_1){
							if(box[i].isState()==true){
								box[i].setState(false);
								int com_select_box_num = box[i].getValue();
								System.out.print("��ǻ���� �ڽ����ڴ� "+com_num_1);
							}
						}
					}
					for(int i=0; i<box.length; i++ ){
						if(box[i].getNumber()==com_num_2){
							if(box[i].isState()==true){
								box[i].setState(false);
								int com_select_box_num= box[i].getValue();
								System.out.println(","+com_num_1+"�Դϴ�.");
							}
						}
					}

					System.out.println("��� �ڽ��� �����ϰڽ��ϱ�? (1�� or 2��)");
					choice = MenuViewer.sc.nextInt();
					if(choice==1){
						System.out.println("���° �ڽ��� �������ڽ��ϱ�? (1~10��)");
						int box_num = MenuViewer.sc.nextInt();

						for(int i=0; i<box.length; i++){
							if(box[i].getNumber()==box_num){
								if(box[i].isState()==true){
									box[i].setState(false);
									int user_select_box_num = box[i].getValue();
									System.out.println("����� �ڽ����ڴ� "+user_select_box_num+"�Դϴ�.");
								}
							}
						}
					}else if(choice==2){
						System.out.println("how number box? (box of two)");
						int box_num_1 = MenuViewer.sc.nextInt();
						int box_num_2 = box_num_1+1;
						for(int i=0; i<box.length; i++){
							if(box[i].getNumber()==box_num_1){
								if(box[i].isState()==true){
									box[i].setState(false);
									int user_select_box_num = box[i].getValue();
									System.out.print("����� �ڽ����ڴ� "+user_select_box_num);
								}
							}
						}
						for(int i=0; i<box.length; i++ ){
							if(box[i].getNumber()==box_num_2){
								if(box[i].isState()==true){
									box[i].setState(false);
									int user_select_box_num= box[i].getValue();
									System.out.println(","+user_select_box_num+"�Դϴ�.");
								}
							}
						}
					}

				}
				break; 
			}
		}else{
			System.out.println("�ָ�, ����, ���� �ϳ��� ������.");
		}
	}
}


