package kr.co.daumschool.fitnesscenter;

/*
 * ȸ������(�ϼ�)
 *  ��-��üȸ������
 *  ��-ȸ���˻� �� ������
 *  ��-ȸ����������
 *  ��-ȸ������
 *  ��-������
 */	 

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class Member_run extends Ver_02{
	
	static int i=0;
	
	//��üȸ������
	public static void show_all_member(){
		Iterator<Info_Member> itr = person.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

	//ȸ�� �˻� �� ������
	public static void search_Member_Info(){
		System.out.println("ȸ������ �˻��� �����մϴ�..");
		System.out.print("����ó:  ");
		String office = Menu.sc.next();
		Info_Member info = search(office);
		if(info == null){
			System.out.println("�������� �ʴ� ȸ���Դϴ�.\n");
		}else{
			info.show_Member_Info();
			System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�. \n");
		}
	}
	//ȸ�� �˻� ���ͷ�
	public static Info_Member search(String office){
		Iterator<Info_Member> itr = person.iterator();
		while(itr.hasNext()){
			Info_Member tmpInfo = itr.next();
			if(office.compareTo(tmpInfo.getOffice())==0){
				return tmpInfo;
			}
		}
		return null;
	}

	//ȸ������ ����
	public static Info_Member input_change_member(){
		i = 0;
		System.out.print("������ ȸ���� ����ó �Է� : ");
		String office = Menu.sc.next();

		Info_Member info = search(office);
		Iterator<Info_Member> itr = person.iterator();
		while(itr.hasNext()){
			Info_Member tmpInfo = itr.next();
			if(office.compareTo(tmpInfo.office)==0){
				Info_Member tmp = new Info_Member();
				tmp.setName(tmpInfo.getName());
				
				System.out.print("(����) �ּ� �Է� :");
				tmp.setAddress(Menu.sc.next());
				System.out.print("(����) ����ó �Է� :");
				tmp.setOffice(Menu.sc.next());
				System.out.print("(����) ��ǥ �Է� :");
				tmp.setGoal((Menu.sc.next()));
				System.out.print("(����) �� � ȸ�� �Է� :");
				tmp.setNumberOfwork((Menu.sc.next()));
				System.out.print("(����) ��ð� �Է�: ");
				tmp.setTimeOfwork((Menu.sc.next()));
				System.out.println("�����Ͱ� �����Ǿ����ϴ�. (after).");
				tmp.show_Member_Info();
				return person.set(i, tmp);
			}
			i++;
		}
		System.out.println("�������� �ʴ� ȸ���Դϴ�.");
		return info;
	}

	//ȸ������
	public static void delete_Data(){
		System.out.println("ȸ�������� ������ ���մϴ�..");
		System.out.print("����ó: ");
		String office = Menu.sc.next();

		Iterator<Info_Member> itr = person.iterator();
		while(itr.hasNext()){
			Info_Member tmpInfo = itr.next();
			if(office.compareTo(tmpInfo.office)==0){
				itr.remove();
				System.out.println("ȸ�������Ͱ� ���� �Ϸ�Ǿ����ϴ�. \n");
				return;
			}
		}
		System.out.println("�������� �ʴ� ȸ���Դϴ�.\n");
	}


	public static void manage_member_rc(){
		int choice;
		while((choice=Menu.member_Run_Menu())!=5){
			switch(choice){
			case 1:
				show_all_member();		//��üȸ������
				break;
			case 2:
				search_Member_Info(); 	//ȸ���˻� �� ������
				break;
			case 3:	
				input_change_member();	//ȸ����������
				break;
			case 4:
				delete_Data();
				break;					//ȸ������
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("��Please check of 1 to 5 times");
			}
		}
	}

}
