package kr.co.daumschool.fitnesscenter;

/*
 * ����ڸ��
 *  ��-ȸ������
 *  -�⼮üũ
 *  -�ｺŬ����������
 *  ��-�����޴�
 */	 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Member_Mode extends Ver_02{

	//ȸ������
	public void join(){
		Info_Member t = new Info_Member();
		System.out.print("�̸� : ");
		String name = Menu.sc.next();
		t.setName(name);
		System.out.print("�ּ� : ");
		String address = Menu.sc.next();
		t.setAddress(address);
		System.out.print("����ó : ");
		String office = Menu.sc.next();
		t.setOffice(office);
		System.out.print("��ǥ : ");
		String goal = Menu.sc.next();
		t.setGoal(goal);
		System.out.print("�� � ȸ�� : ");
		String numberOfwork = Menu.sc.next();
		t.setNumberOfwork(numberOfwork);
		System.out.print("� �ð� : ");
		String timeOfwork = Menu.sc.next();
		t.setTimeOfwork(timeOfwork);

		if(isSearch(t.getOffice())){
			System.out.println("�ߺ��� ȸ�������Դϴ�. (����ó �ߺ�)");
		}else{
			person.add(t);
			System.out.println("ȸ������ �Ϸ�Ǿ����ϴ�.");
		}
	}
	public boolean isSearch(String office){
		Iterator<Info_Member> itr = person.iterator();
		while(itr.hasNext()){
			Info_Member tmpInfo = itr.next();
			if(office.compareTo(tmpInfo.getOffice())==0){
				return true;
			}
		}
		return false;
	}


	
	String id;
	String pin;
	
	String state_id;
	String state_pin;
	
	public void member_login(){
		System.out.print("�̸� : ");
		id = Menu.sc.next();
		System.out.print("����ó :");
		pin = Menu.sc.next();

		Iterator<Info_Member> itr = person.iterator();
		while(itr.hasNext()){
			Info_Member tmpInfo = itr.next();
			if(id.compareTo(tmpInfo.getName())==0 && pin.compareTo(tmpInfo.getOffice())==0){
				System.out.println("ȸ��������ӿ� �����Ͽ����ϴ�.");
				state_id = id;
				state_pin = pin;
				member_rc();
			}else{
				System.out.println("�α��ν���");
			}
		}
	}
	
	public void member_logout(){
		if(state_id.equals(id) && state_pin.equals(pin)){
			System.out.println("�α׾ƿ� ����");
			state_id = "";
			state_pin = "";
			return;
		}else{
			System.out.println("�α׾ƿ� ����");
			return;
		}
	}
	
	
	
	public void member_rc() {
		int choice;
		while((choice=Menu.member_Menu())!=4){
			switch(choice){
			case 1:			//Ʈ���̴װ�ȹ�� ����
				Manager_Mode.select_tp();
				break;
			case 2:			//�ｺŬ����������
				Manager_Mode.show_all_plan();
				break;
			case 3:			//�α׾ƿ�
				System.out.println(id + pin + state_id + state_pin);
				member_logout();
				break;
			case 4:
				System.out.println("ó��ȭ������");
				return;
			default:
				System.out.println("��Please check of 1 to 4 times");
			}
		}
	}

}
