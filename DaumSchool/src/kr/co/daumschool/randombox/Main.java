package kr.co.daumschool.randombox;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author 김현진
 * @date 2015. 6. 27. 오전 12:49:37
 */

class MenuViewer{
	public static Scanner sc = new Scanner(System.in);
	public static Random r = new Random();
}



class Main {
	public static void main(String[] args) {

		RandomBox_info[] box = new RandomBox_info[10];

		//초기화
		int digit = 0;
		for(int i=0; i<box.length; i++){
			RandomBox_info t = new RandomBox_info();

			//배열에 1~10숫자 번호지정
			t.setNumber(++digit);
			System.out.print(t.getNumber()+"\t");

			//배열에 0~999숫자 랜덤지정
			int random_value = MenuViewer.r.nextInt(1000);
			t.setValue(random_value);
			System.out.print(t.getValue()+"\t");

			//배열에 이름 지정
			t.setName((char) (Math.random()*26+'A'));
			System.out.println(t.getName());

			t.setState(true);

			box[i] = t;
		}
		System.out.println();


		//가위바위보
		String win = "당신이 이겼습니다.";
		String draw = "비겼습니다.";
		String lose = "당신이 졌습니다";
		System.out.println("주먹가위보를 내세요. \n(1=주먹, 2=가위, 3=보)");
		int user_ggb = MenuViewer.sc.nextInt();

		if(user_ggb>0 && user_ggb<4){
			int com_ggb = MenuViewer.r.nextInt(3)+1;
			int winner = user_ggb - com_ggb; //0:무승부 & 2,-1:승 & -2,1:패 
			switch(winner){

			//무승부
			case 0: 
				System.out.println(draw);
				return; 


				//user가 먼저시작함    
			case 2:
			case -1: 
				System.out.println(win);
				System.out.println("몇개의 박스를 선택하겠습니까? (1개 or 2개)");
				int choice = MenuViewer.sc.nextInt();
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(choice==1){
					for(int loop=0; loop<box.length; loop++){
						System.out.println("몇번째 박스를 가져오겠습니까? (1~10번)");
						int box_num = MenuViewer.sc.nextInt();

						for(int i=0; i<box.length; i++){
							if(box[i].getNumber()==box_num){
								if(box[i].isState()==true){
									box[i].setState(false);
									int user_select_box_num = box[i].getValue();
									System.out.println("당신의 박스숫자는 "+box_num+"입니다.");
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
											System.out.println("컴퓨터의 박스숫자는 "+com_num+"입니다.");
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
										System.out.println("컴퓨터의 박스숫자는 "+com_num_1+"입니다.");
									}
								}
							}
							for(int i=0; i<box.length; i++ ){
								if(box[i].getNumber()==com_num_2){
									if(box[i].isState()==true){
										box[i].setState(false);
										int com_select_box_num= box[i].getValue();
										System.out.println("컴퓨터의 박스숫자는 "+com_num_2+"입니다.");
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
								System.out.print("당신의 박스숫자는 "+box_num_1);
							}
						}
					}
					for(int i=0; i<box.length; i++ ){
						if(box[i].getNumber()==box_num_2){
							if(box[i].isState()==true){
								box[i].setState(false);
								int user_select_box_num= box[i].getValue();
								System.out.println(","+box_num_2+"입니다.");
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
										System.out.println("컴퓨터의 박스숫자는 "+com_num+"입니다.");
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
									System.out.print("컴퓨터의 박스숫자는 "+com_num_1);
								}
							}
						}
						for(int i=0; i<box.length; i++ ){
							if(box[i].getNumber()==com_num_2){
								if(box[i].isState()==true){
									box[i].setState(false);
									int com_select_box_num= box[i].getValue();
									System.out.println(","+com_num_2+"입니다");
								}
							}
						}

					}
					///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				}else{
					System.out.println("box select number 1 or 2");
				}
				break;











				//com 먼저시작
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
								System.out.println("컴퓨터의 박스숫자는 "+com_num+"입니다.");
							}
						}
					}

					System.out.println("몇개의 박스를 선택하겠습니까? (1개 or 2개)");
					choice = MenuViewer.sc.nextInt();
					if(choice==1){
						System.out.println("몇번째 박스를 가져오겠습니까? (1~10번)");
						int box_num = MenuViewer.sc.nextInt();

						for(int i=0; i<box.length; i++){
							if(box[i].getNumber()==box_num){
								if(box[i].isState()==true){
									box[i].setState(false);
									int user_select_box_num = box[i].getValue();
									System.out.println("당신의 박스숫자는 "+box_num+"입니다.");
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
									System.out.print("당신의 박스숫자는 "+box_num_1);
								}
							}
						}
						for(int i=0; i<box.length; i++ ){
							if(box[i].getNumber()==box_num_2){
								if(box[i].isState()==true){
									box[i].setState(false);
									int user_select_box_num= box[i].getValue();
									System.out.println(","+box_num_2+"입니다.");
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
								System.out.print("컴퓨터의 박스숫자는 "+com_num_1);
							}
						}
					}
					for(int i=0; i<box.length; i++ ){
						if(box[i].getNumber()==com_num_2){
							if(box[i].isState()==true){
								box[i].setState(false);
								int com_select_box_num= box[i].getValue();
								System.out.println(","+com_num_1+"입니다.");
							}
						}
					}

					System.out.println("몇개의 박스를 선택하겠습니까? (1개 or 2개)");
					choice = MenuViewer.sc.nextInt();
					if(choice==1){
						System.out.println("몇번째 박스를 가져오겠습니까? (1~10번)");
						int box_num = MenuViewer.sc.nextInt();

						for(int i=0; i<box.length; i++){
							if(box[i].getNumber()==box_num){
								if(box[i].isState()==true){
									box[i].setState(false);
									int user_select_box_num = box[i].getValue();
									System.out.println("당신의 박스숫자는 "+user_select_box_num+"입니다.");
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
									System.out.print("당신의 박스숫자는 "+user_select_box_num);
								}
							}
						}
						for(int i=0; i<box.length; i++ ){
							if(box[i].getNumber()==box_num_2){
								if(box[i].isState()==true){
									box[i].setState(false);
									int user_select_box_num= box[i].getValue();
									System.out.println(","+user_select_box_num+"입니다.");
								}
							}
						}
					}

				}
				break; 
			}
		}else{
			System.out.println("주먹, 가위, 보중 하나만 내세요.");
		}
	}
}


