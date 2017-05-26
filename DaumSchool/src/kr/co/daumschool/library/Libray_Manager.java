package kr.co.daumschool.library;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Libray_Manager {

	static HashSet<Info_Member> info = new HashSet<Info_Member>();
	static List<Info_Book> book_info = new ArrayList<Info_Book>();

	static int i = 0;
	static int book_volume = 5;
	static String id = null;
	static String pin = null;

	String mal_6 = "\n1. 도서전체목록, 2. 도서등록, 3. 도서수정, 4. 도서삭제, 5. 도서조회, 6.처음화면으로 \n└선택:";
	String mal_5 = "\n1. 도서전체목록, 2. 도서대출, 3. 도서반납, 4. 처음화면으로 \n└선택:";


	//1.회원가입
	public void input_Member_Info(){
		System.out.println("회원 데이터 입력을 시작합니다..");
		Info_Member information = null;
		information = read_member_info();

		boolean isAdd = info.add(information); 
		if(isAdd == true)
			System.out.println("회원 데이터 입력이 완료되었습니다. \n");
		else
			System.out.println("이미 저장된 회원 데이터입니다. \n");
	}
	private Info_Member read_member_info(){
		System.out.print("아이디: ");
		String id = Menu.sc.next();
		System.out.print("이름: ");
		String name = Menu.sc.next();
		System.out.print("전화번호: ");
		String phoneNumber = Menu.sc.next();
		System.out.print("비밀번호: ");
		String pin = Menu.sc.next();
		return new Info_Member(id, name ,phoneNumber, pin);
	}
	//2.회원탈퇴
	public void quit_Data(){
		System.out.println("데이터 삭제를 시작합니다..");
		System.out.print("전화번호: ");
		String phoneNumber = Menu.sc.next();

		Iterator<Info_Member> itr = info.iterator();
		while(itr.hasNext()){
			Info_Member tmpInfo = itr.next();
			if(phoneNumber.compareTo(tmpInfo.phoneNumber)==0){
				itr.remove();
				System.out.println("데이터 삭제가 완료되었습니다. \n");
				return;
			}
		}
		System.out.println("존재하지 않는 회원입니다.\n");
	}
	//3.회원검색
	public void search_Member_Info(){
		System.out.println("데이터 검색을 시작합니다..");
		System.out.print("전화번호:  ");
		String phoneNumber = Menu.sc.next();
		Info_Member info = search(phoneNumber);
		if(info == null){
			System.out.println("존재하지 않는 회원입니다.\n");
		}else{
			info.show_Member_Info();
			System.out.println("데이터 검색이 완료되었습니다. \n");
		}
	}
	//반복자 (매개변수로 전화번호)
	public Info_Member search(String phoneNumber){
		Iterator<Info_Member> itr = info.iterator();
		while(itr.hasNext()){
			Info_Member tmpInfo = itr.next();
			if(phoneNumber.compareTo(tmpInfo.phoneNumber)==0){
				return tmpInfo;
			}
		}
		return null;
	}
	//회원전체목록
	public void show_all_member(){
		Iterator<Info_Member> itr = info.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}


	//4.로그인
	public void login() throws MenuChoiceException{
		System.out.print("아이디 : ");
		id = Menu.sc.next();
		System.out.print("비밀번호 :");
		pin = Menu.sc.next();

		Iterator<Info_Member> itr = info.iterator();
		while(itr.hasNext()){
			Info_Member tmpInfo = itr.next();
			if(id.compareTo(tmpInfo.id)==0 && pin.compareTo(tmpInfo.pin)==0){
				System.out.println("로그인에 성공하였습니다.");
				rantal_return();
			}else{
				System.out.println("로그인실패");
			}
		}
	}
	
	Info_Rental rt = new Info_Rental();

	//5-1 도서대여
	public void rantal_b(){
		System.out.print("대여할 도서코드를 입력하세요..");
		String rtb_code = Menu.sc.next();
		Info_Book info = book_search(rtb_code);
		if(info == null){
			System.out.println("존재하지 않는 도서입니다.");
		}else{
			rt.id = id;
			rt.book_code = rtb_code;
			vloume_minus(rtb_code);
		}
	}
	//5-2 도서반납
	public void return_b(){
		System.out.print("반납할 도서코드를 입력하세요..");
		String rtb_code = Menu.sc.next();
		Info_Book info = book_search(rtb_code);
		if(info == null){
			System.out.println("존재하지 않는 도서입니다.");
		}else{
			rt.id = id;
			rt.book_code = rtb_code;
			vloume_plus(rtb_code);
		}
	}
	
	//반복자 (매개변수는 도서코드)
	public Info_Book book_search(String book_code){
		Iterator<Info_Book> itr = book_info.iterator();
		while(itr.hasNext()){
			Info_Book tmpInfo = itr.next();
			if(book_code.compareTo(tmpInfo.book_code)==0){
				return tmpInfo;
			}
		}
		return null;
	}
	//반복자 (매개변수는 수량)
	public int vloume_minus(String book_code){
		Iterator<Info_Book> itr = book_info.iterator();
		while(itr.hasNext()){
			Info_Book tmpInfo = itr.next();
			tmpInfo.setBook_volume(--book_volume);
			return tmpInfo.getBook_volume();
		}
		return 0;
	}

	public int vloume_plus(String book_code){
		Iterator<Info_Book> itr = book_info.iterator();
		while(itr.hasNext()){
			Info_Book tmpInfo = itr.next();
			tmpInfo.setBook_volume(++book_volume);
			return tmpInfo.getBook_volume();
		}
		return 0;
	}
	


	//도서전체목록
	public  void show_all_book(){
		Iterator<Info_Book> itr = book_info.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}


	//6-1 도서등록
	private Info_Book read_book_info(){
		System.out.print("도서이름 : ");
		String book_name = Menu.sc.next();
		System.out.print("도서코드 : ");
		String book_code = Menu.sc.next();
		int real_volume = book_volume;
		System.out.print("책  수량 : "+real_volume+"권");
		System.out.println();
		return new Info_Book(book_name, book_code ,real_volume);
	}
	public void input_Book_Info(){
		System.out.println("도서 데이터 입력을 시작합니다..");
		Info_Book information = null;
		information = read_book_info();

		boolean isAdd = book_info.add(information); 
		if(isAdd == true)
			System.out.println("도서 데이터 입력이 완료되었습니다. ");
		else
			System.out.println("이미 저장된 도서 데이터입니다. ");
	}
	//6-2 도서수정
	public Info_Book modify_book(){
		System.out.println("도서 수정을 시작합니다..");
		System.out.print("수정할 도서코드 : ");
		String book_code = Menu.sc.next();

		Info_Book info = book_search(book_code);
		Iterator<Info_Book> itr = book_info.iterator();
		while(itr.hasNext()){
			Info_Book tmpInfo = itr.next();
			if(book_code.compareTo(tmpInfo.book_code)==0){
				Info_Book tmp = new Info_Book();
				System.out.print("수정할 도서이름: ");
				tmp.book_name = Menu.sc.next();
				tmp.book_code = tmpInfo.book_code;
				System.out.print("수정할 수량: ");
				tmp.book_volume = Menu.sc.nextInt();
				System.out.println("데이터가 수정되었습니다. (after).");
				tmp.show_Book_Info();
				return tmp;
			}
			i++;
		}
		System.out.println("존재하지 않는 도서입니다.");
		return info;
	}
	public void input_Book_Modify(){
		Info_Book modify = modify_book();
		book_info.set(i, modify); 
	}
	//6-3 도서삭제
	public void quit_Book_Data(){
		System.out.println("도서 데이터 삭제를 시작합니다..");
		System.out.print("도서코드: ");
		String book_code = Menu.sc.next();

		Iterator<Info_Book> itr = book_info.iterator();
		while(itr.hasNext()){
			Info_Book tmpInfo = itr.next();
			if(book_code.compareTo(tmpInfo.book_code)==0){
				itr.remove();
				System.out.println("데이터 삭제가 완료되었습니다. ");
				return;
			}
		}
		System.out.println("존재하지 않는 회원입니다.");
	}
	//6-4 도서조회
	public void search_Book_Info(){
		System.out.println("도서 데이터 검색을 시작합니다..");
		System.out.print("도서코드:  ");
		String book_code = Menu.sc.next();
		Info_Book info = book_search(book_code);
		if(info == null){
			System.out.println("존재하지 않는 도서입니다.");
		}else{
			info.show_Book_Info();
			System.out.println("데이터 검색이 완료되었습니다. ");
		}
	}


	//  도서등록 & 수정 & 삭제 & 조회 리모콘
	public void book_related() throws MenuChoiceException {
		System.out.print(mal_6);
		int choice; 

		while(true){
			try{
				choice = Menu.sc.nextInt();
				if(choice < BOOK_RELATED.LIST || choice > BOOK_RELATED.EXIT)
					throw new MenuChoiceException(choice);

				switch(choice){
				case BOOK_RELATED.LIST:
					show_all_book();			
					System.out.print(mal_6);
					break;
				case BOOK_RELATED.REGISTER:
					input_Book_Info();
					System.out.print(mal_6);
					break;
				case BOOK_RELATED.MODIFY:
					input_Book_Modify();
					System.out.print(mal_6);
					break;
				case BOOK_RELATED.DELETE:
					quit_Book_Data();
					System.out.print(mal_6);
					break;
				case BOOK_RELATED.INQUIRY:
					search_Book_Info();
					System.out.print(mal_6);
					break;
				case BOOK_RELATED.EXIT:
					System.out.println();
					return;
				}
			}catch(MenuChoiceException e){
				e.showWrongChoice();
				System.out.println(mal_6);	
			}
		}
	}
	//  도서대출 & 도서반납 리모콘
	public void rantal_return() throws MenuChoiceException {
		System.out.print(mal_5);
		int choice;

		while(true){
			try{
				choice = Menu.sc.nextInt();
				if(choice < RANTAL_RETURN.LIST || choice > RANTAL_RETURN.EXIT)
					throw new MenuChoiceException(choice);
				switch(choice){
				case RANTAL_RETURN.LIST:
					show_all_book();
					System.out.print(mal_5);
					break;
				case RANTAL_RETURN.RANTAl:
					rantal_b();
					System.out.print(mal_5);
					break;
				case RANTAL_RETURN.RETURN:
					return_b();
					System.out.print(mal_5);
					break;
				case RANTAL_RETURN.EXIT:
					return;
				}
			}catch(MenuChoiceException e){
				e.showWrongChoice();
				System.out.println(mal_5);	
			}
		}
	}

}











/*
 * hasNext 다음에 반복할 요소가 있는지 확인후 boolean값 리턴
 * next 다음요소에 대한 값 반환
 * remove 해당요소 지워줌
 * compareTo 값이 같으면 0을 반환
 */

/*
 *  private LibrayBookManager(){}
 *	static LibrayBookManager inst = null;
 *	public static LibrayBookManager createManagerInst() {
 *	if (inst == null)
 *		inst = new LibrayBookManager();
 *	return inst;
 */


