package kr.co.daumschool.fitnesscenter;

/*
 * 사용자모드
 *  ●-회원가입
 *  -출석체크
 *  -헬스클럽정보보기
 *  ●-이전메뉴
 */	 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Member_Mode extends Ver_02{

	//회원가입
	public void join(){
		Info_Member t = new Info_Member();
		System.out.print("이름 : ");
		String name = Menu.sc.next();
		t.setName(name);
		System.out.print("주소 : ");
		String address = Menu.sc.next();
		t.setAddress(address);
		System.out.print("연락처 : ");
		String office = Menu.sc.next();
		t.setOffice(office);
		System.out.print("목표 : ");
		String goal = Menu.sc.next();
		t.setGoal(goal);
		System.out.print("주 운동 회수 : ");
		String numberOfwork = Menu.sc.next();
		t.setNumberOfwork(numberOfwork);
		System.out.print("운동 시간 : ");
		String timeOfwork = Menu.sc.next();
		t.setTimeOfwork(timeOfwork);

		if(isSearch(t.getOffice())){
			System.out.println("중복된 회원가입입니다. (연락처 중복)");
		}else{
			person.add(t);
			System.out.println("회원가입 완료되었습니다.");
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
		System.out.print("이름 : ");
		id = Menu.sc.next();
		System.out.print("연락처 :");
		pin = Menu.sc.next();

		Iterator<Info_Member> itr = person.iterator();
		while(itr.hasNext()){
			Info_Member tmpInfo = itr.next();
			if(id.compareTo(tmpInfo.getName())==0 && pin.compareTo(tmpInfo.getOffice())==0){
				System.out.println("회원모드접속에 성공하였습니다.");
				state_id = id;
				state_pin = pin;
				member_rc();
			}else{
				System.out.println("로그인실패");
			}
		}
	}
	
	public void member_logout(){
		if(state_id.equals(id) && state_pin.equals(pin)){
			System.out.println("로그아웃 성공");
			state_id = "";
			state_pin = "";
			return;
		}else{
			System.out.println("로그아웃 실패");
			return;
		}
	}
	
	
	
	public void member_rc() {
		int choice;
		while((choice=Menu.member_Menu())!=4){
			switch(choice){
			case 1:			//트레이닝계획서 선택
				Manager_Mode.select_tp();
				break;
			case 2:			//헬스클럽정보보기
				Manager_Mode.show_all_plan();
				break;
			case 3:			//로그아웃
				System.out.println(id + pin + state_id + state_pin);
				member_logout();
				break;
			case 4:
				System.out.println("처음화면으로");
				return;
			default:
				System.out.println("※Please check of 1 to 4 times");
			}
		}
	}

}
