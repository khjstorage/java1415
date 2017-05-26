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

	String mal_6 = "\n1. ������ü���, 2. �������, 3. ��������, 4. ��������, 5. ������ȸ, 6.ó��ȭ������ \n������:";
	String mal_5 = "\n1. ������ü���, 2. ��������, 3. �����ݳ�, 4. ó��ȭ������ \n������:";


	//1.ȸ������
	public void input_Member_Info(){
		System.out.println("ȸ�� ������ �Է��� �����մϴ�..");
		Info_Member information = null;
		information = read_member_info();

		boolean isAdd = info.add(information); 
		if(isAdd == true)
			System.out.println("ȸ�� ������ �Է��� �Ϸ�Ǿ����ϴ�. \n");
		else
			System.out.println("�̹� ����� ȸ�� �������Դϴ�. \n");
	}
	private Info_Member read_member_info(){
		System.out.print("���̵�: ");
		String id = Menu.sc.next();
		System.out.print("�̸�: ");
		String name = Menu.sc.next();
		System.out.print("��ȭ��ȣ: ");
		String phoneNumber = Menu.sc.next();
		System.out.print("��й�ȣ: ");
		String pin = Menu.sc.next();
		return new Info_Member(id, name ,phoneNumber, pin);
	}
	//2.ȸ��Ż��
	public void quit_Data(){
		System.out.println("������ ������ �����մϴ�..");
		System.out.print("��ȭ��ȣ: ");
		String phoneNumber = Menu.sc.next();

		Iterator<Info_Member> itr = info.iterator();
		while(itr.hasNext()){
			Info_Member tmpInfo = itr.next();
			if(phoneNumber.compareTo(tmpInfo.phoneNumber)==0){
				itr.remove();
				System.out.println("������ ������ �Ϸ�Ǿ����ϴ�. \n");
				return;
			}
		}
		System.out.println("�������� �ʴ� ȸ���Դϴ�.\n");
	}
	//3.ȸ���˻�
	public void search_Member_Info(){
		System.out.println("������ �˻��� �����մϴ�..");
		System.out.print("��ȭ��ȣ:  ");
		String phoneNumber = Menu.sc.next();
		Info_Member info = search(phoneNumber);
		if(info == null){
			System.out.println("�������� �ʴ� ȸ���Դϴ�.\n");
		}else{
			info.show_Member_Info();
			System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�. \n");
		}
	}
	//�ݺ��� (�Ű������� ��ȭ��ȣ)
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
	//ȸ����ü���
	public void show_all_member(){
		Iterator<Info_Member> itr = info.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}


	//4.�α���
	public void login() throws MenuChoiceException{
		System.out.print("���̵� : ");
		id = Menu.sc.next();
		System.out.print("��й�ȣ :");
		pin = Menu.sc.next();

		Iterator<Info_Member> itr = info.iterator();
		while(itr.hasNext()){
			Info_Member tmpInfo = itr.next();
			if(id.compareTo(tmpInfo.id)==0 && pin.compareTo(tmpInfo.pin)==0){
				System.out.println("�α��ο� �����Ͽ����ϴ�.");
				rantal_return();
			}else{
				System.out.println("�α��ν���");
			}
		}
	}
	
	Info_Rental rt = new Info_Rental();

	//5-1 �����뿩
	public void rantal_b(){
		System.out.print("�뿩�� �����ڵ带 �Է��ϼ���..");
		String rtb_code = Menu.sc.next();
		Info_Book info = book_search(rtb_code);
		if(info == null){
			System.out.println("�������� �ʴ� �����Դϴ�.");
		}else{
			rt.id = id;
			rt.book_code = rtb_code;
			vloume_minus(rtb_code);
		}
	}
	//5-2 �����ݳ�
	public void return_b(){
		System.out.print("�ݳ��� �����ڵ带 �Է��ϼ���..");
		String rtb_code = Menu.sc.next();
		Info_Book info = book_search(rtb_code);
		if(info == null){
			System.out.println("�������� �ʴ� �����Դϴ�.");
		}else{
			rt.id = id;
			rt.book_code = rtb_code;
			vloume_plus(rtb_code);
		}
	}
	
	//�ݺ��� (�Ű������� �����ڵ�)
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
	//�ݺ��� (�Ű������� ����)
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
	


	//������ü���
	public  void show_all_book(){
		Iterator<Info_Book> itr = book_info.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}


	//6-1 �������
	private Info_Book read_book_info(){
		System.out.print("�����̸� : ");
		String book_name = Menu.sc.next();
		System.out.print("�����ڵ� : ");
		String book_code = Menu.sc.next();
		int real_volume = book_volume;
		System.out.print("å  ���� : "+real_volume+"��");
		System.out.println();
		return new Info_Book(book_name, book_code ,real_volume);
	}
	public void input_Book_Info(){
		System.out.println("���� ������ �Է��� �����մϴ�..");
		Info_Book information = null;
		information = read_book_info();

		boolean isAdd = book_info.add(information); 
		if(isAdd == true)
			System.out.println("���� ������ �Է��� �Ϸ�Ǿ����ϴ�. ");
		else
			System.out.println("�̹� ����� ���� �������Դϴ�. ");
	}
	//6-2 ��������
	public Info_Book modify_book(){
		System.out.println("���� ������ �����մϴ�..");
		System.out.print("������ �����ڵ� : ");
		String book_code = Menu.sc.next();

		Info_Book info = book_search(book_code);
		Iterator<Info_Book> itr = book_info.iterator();
		while(itr.hasNext()){
			Info_Book tmpInfo = itr.next();
			if(book_code.compareTo(tmpInfo.book_code)==0){
				Info_Book tmp = new Info_Book();
				System.out.print("������ �����̸�: ");
				tmp.book_name = Menu.sc.next();
				tmp.book_code = tmpInfo.book_code;
				System.out.print("������ ����: ");
				tmp.book_volume = Menu.sc.nextInt();
				System.out.println("�����Ͱ� �����Ǿ����ϴ�. (after).");
				tmp.show_Book_Info();
				return tmp;
			}
			i++;
		}
		System.out.println("�������� �ʴ� �����Դϴ�.");
		return info;
	}
	public void input_Book_Modify(){
		Info_Book modify = modify_book();
		book_info.set(i, modify); 
	}
	//6-3 ��������
	public void quit_Book_Data(){
		System.out.println("���� ������ ������ �����մϴ�..");
		System.out.print("�����ڵ�: ");
		String book_code = Menu.sc.next();

		Iterator<Info_Book> itr = book_info.iterator();
		while(itr.hasNext()){
			Info_Book tmpInfo = itr.next();
			if(book_code.compareTo(tmpInfo.book_code)==0){
				itr.remove();
				System.out.println("������ ������ �Ϸ�Ǿ����ϴ�. ");
				return;
			}
		}
		System.out.println("�������� �ʴ� ȸ���Դϴ�.");
	}
	//6-4 ������ȸ
	public void search_Book_Info(){
		System.out.println("���� ������ �˻��� �����մϴ�..");
		System.out.print("�����ڵ�:  ");
		String book_code = Menu.sc.next();
		Info_Book info = book_search(book_code);
		if(info == null){
			System.out.println("�������� �ʴ� �����Դϴ�.");
		}else{
			info.show_Book_Info();
			System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�. ");
		}
	}


	//  ������� & ���� & ���� & ��ȸ ������
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
	//  �������� & �����ݳ� ������
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
 * hasNext ������ �ݺ��� ��Ұ� �ִ��� Ȯ���� boolean�� ����
 * next ������ҿ� ���� �� ��ȯ
 * remove �ش��� ������
 * compareTo ���� ������ 0�� ��ȯ
 */

/*
 *  private LibrayBookManager(){}
 *	static LibrayBookManager inst = null;
 *	public static LibrayBookManager createManagerInst() {
 *	if (inst == null)
 *		inst = new LibrayBookManager();
 *	return inst;
 */


