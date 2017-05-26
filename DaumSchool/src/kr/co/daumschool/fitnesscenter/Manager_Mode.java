package kr.co.daumschool.fitnesscenter;

/* ●관리자모드(로그인) ▶▶
 * 트레이닝계획서수정
 * ●회원관리 (전체회원보기,회원검색 및 상세정보,회원정보수정,회원삭제)
 * ●암호변경
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Manager_Mode extends Training_Program{

	Info_Manager coach = new Info_Manager("admin","0000");
	static List<Training_Program> tp = new ArrayList<Training_Program>();


	//step1. 관리자모드에 접근하기 위해 로그인
	public void admin_login(){
		System.out.println("관리자 아이디 : " +coach.getAdmin());
		System.out.print("관리자 비밀번호 : ");
		String tmpPin = Menu.sc.next();
		if(tmpPin.equals(coach.getPin())){
			System.out.println("▶로그인에 성공하였습니다.\n");
			admin_rc();
		}else{
			System.out.println("▶로그인실패\n");
			return;
		}
	}

	//트레이닝계획서 수정
	@Override
	public void week_plan() {
		Training_Program tmp = new Training_Program();

		System.out.print("월요일 plan :");
		tmp.setMon(Menu.sc.next());

		System.out.print("화요일 plan :");
		tmp.setTue(Menu.sc.next());

		System.out.print("수요일 plan :");
		tmp.setWed(Menu.sc.next());

		System.out.print("목요일 plan :");
		tmp.setThu(Menu.sc.next());

		System.out.print("금요일 plan :");
		tmp.setFri(Menu.sc.next());
		tp.add(tmp);

	}

	//트레이닝계획서 목록
	public static void show_all_plan(){
		Iterator<Training_Program> itr = tp.iterator();
		while(itr.hasNext()){
			num++;
			System.out.println(itr.next());
		}
	}
	
	//트레이닝계획서 가져오기
	public static void select_tp(){
		System.out.print("몇번째 plan을 선택하시겠습니까?");
		 tp.get(Menu.sc.nextInt()+1);
	}
	


	//관리자모드 암호변경
	public Info_Manager admin_change_pin(){
		System.out.println("\n관리자 비밀번호 변경");
		System.out.print("기존 비밀번호 : ");
		String tmpPin = Menu.sc.next();
		if(tmpPin.equals(coach.getPin())){
			System.out.print("변경할 비밀번호 : ");
			String pin = Menu.sc.next();
			coach.setPin(pin);
			System.out.println("비밀번호가 "+pin+"(으)로변경 되었습니다.");
			System.out.println("다시 로그인 해주세요.\n");
		}else{
			System.out.println("비밀번호가 틀립니다. \n");
		}
		return coach;
	}

	//관리자모드 리모콘
	public void admin_rc() {
		int choice;
		while((choice=Menu.admin_Menu())!=4){
			switch(choice){
			case 1:	//트레이닝계획서수정
				week_plan();
				break;
			case 2:	//회원관리▶▶
				Member_run.manage_member_rc();
				break;
			case 3:	//암호변경
				admin_change_pin();
				return;
			case 4:
				return;
			default:
				System.out.println("※Please check of 1 to 4 times");
			}
		}
	}








}