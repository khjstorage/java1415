package kr.co.daumschool.fitnesscenter;

/*
 * 회원관리(완성)
 *  ●-전체회원보기
 *  ●-회원검색 및 상세정보
 *  ●-회원정보수정
 *  ●-회원삭제
 *  ●-나가기
 */	 

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class Member_run extends Ver_02{
	
	static int i=0;
	
	//전체회원보기
	public static void show_all_member(){
		Iterator<Info_Member> itr = person.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

	//회원 검색 및 상세정보
	public static void search_Member_Info(){
		System.out.println("회원정보 검색을 시작합니다..");
		System.out.print("연락처:  ");
		String office = Menu.sc.next();
		Info_Member info = search(office);
		if(info == null){
			System.out.println("존재하지 않는 회원입니다.\n");
		}else{
			info.show_Member_Info();
			System.out.println("데이터 검색이 완료되었습니다. \n");
		}
	}
	//회원 검색 리터럴
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

	//회원정보 수정
	public static Info_Member input_change_member(){
		i = 0;
		System.out.print("수정할 회원의 연락처 입력 : ");
		String office = Menu.sc.next();

		Info_Member info = search(office);
		Iterator<Info_Member> itr = person.iterator();
		while(itr.hasNext()){
			Info_Member tmpInfo = itr.next();
			if(office.compareTo(tmpInfo.office)==0){
				Info_Member tmp = new Info_Member();
				tmp.setName(tmpInfo.getName());
				
				System.out.print("(수정) 주소 입력 :");
				tmp.setAddress(Menu.sc.next());
				System.out.print("(수정) 연락처 입력 :");
				tmp.setOffice(Menu.sc.next());
				System.out.print("(수정) 목표 입력 :");
				tmp.setGoal((Menu.sc.next()));
				System.out.print("(수정) 주 운동 회수 입력 :");
				tmp.setNumberOfwork((Menu.sc.next()));
				System.out.print("(수정) 운동시간 입력: ");
				tmp.setTimeOfwork((Menu.sc.next()));
				System.out.println("데이터가 수정되었습니다. (after).");
				tmp.show_Member_Info();
				return person.set(i, tmp);
			}
			i++;
		}
		System.out.println("존재하지 않는 회원입니다.");
		return info;
	}

	//회원삭제
	public static void delete_Data(){
		System.out.println("회원데이터 삭제를 작합니다..");
		System.out.print("연락처: ");
		String office = Menu.sc.next();

		Iterator<Info_Member> itr = person.iterator();
		while(itr.hasNext()){
			Info_Member tmpInfo = itr.next();
			if(office.compareTo(tmpInfo.office)==0){
				itr.remove();
				System.out.println("회원데이터가 삭제 완료되었습니다. \n");
				return;
			}
		}
		System.out.println("존재하지 않는 회원입니다.\n");
	}


	public static void manage_member_rc(){
		int choice;
		while((choice=Menu.member_Run_Menu())!=5){
			switch(choice){
			case 1:
				show_all_member();		//전체회원보기
				break;
			case 2:
				search_Member_Info(); 	//회원검색 및 상세정보
				break;
			case 3:	
				input_change_member();	//회원정보수정
				break;
			case 4:
				delete_Data();
				break;					//회원삭제
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("※Please check of 1 to 5 times");
			}
		}
	}

}
