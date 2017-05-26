package kr.co.daumschool.fitnesscenter;

/* �ܰ����ڸ��(�α���) ����
 * Ʈ���̴װ�ȹ������
 * ��ȸ������ (��üȸ������,ȸ���˻� �� ������,ȸ����������,ȸ������)
 * �ܾ�ȣ����
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Manager_Mode extends Training_Program{

	Info_Manager coach = new Info_Manager("admin","0000");
	static List<Training_Program> tp = new ArrayList<Training_Program>();


	//step1. �����ڸ�忡 �����ϱ� ���� �α���
	public void admin_login(){
		System.out.println("������ ���̵� : " +coach.getAdmin());
		System.out.print("������ ��й�ȣ : ");
		String tmpPin = Menu.sc.next();
		if(tmpPin.equals(coach.getPin())){
			System.out.println("���α��ο� �����Ͽ����ϴ�.\n");
			admin_rc();
		}else{
			System.out.println("���α��ν���\n");
			return;
		}
	}

	//Ʈ���̴װ�ȹ�� ����
	@Override
	public void week_plan() {
		Training_Program tmp = new Training_Program();

		System.out.print("������ plan :");
		tmp.setMon(Menu.sc.next());

		System.out.print("ȭ���� plan :");
		tmp.setTue(Menu.sc.next());

		System.out.print("������ plan :");
		tmp.setWed(Menu.sc.next());

		System.out.print("����� plan :");
		tmp.setThu(Menu.sc.next());

		System.out.print("�ݿ��� plan :");
		tmp.setFri(Menu.sc.next());
		tp.add(tmp);

	}

	//Ʈ���̴װ�ȹ�� ���
	public static void show_all_plan(){
		Iterator<Training_Program> itr = tp.iterator();
		while(itr.hasNext()){
			num++;
			System.out.println(itr.next());
		}
	}
	
	//Ʈ���̴װ�ȹ�� ��������
	public static void select_tp(){
		System.out.print("���° plan�� �����Ͻðڽ��ϱ�?");
		 tp.get(Menu.sc.nextInt()+1);
	}
	


	//�����ڸ�� ��ȣ����
	public Info_Manager admin_change_pin(){
		System.out.println("\n������ ��й�ȣ ����");
		System.out.print("���� ��й�ȣ : ");
		String tmpPin = Menu.sc.next();
		if(tmpPin.equals(coach.getPin())){
			System.out.print("������ ��й�ȣ : ");
			String pin = Menu.sc.next();
			coach.setPin(pin);
			System.out.println("��й�ȣ�� "+pin+"(��)�κ��� �Ǿ����ϴ�.");
			System.out.println("�ٽ� �α��� ���ּ���.\n");
		}else{
			System.out.println("��й�ȣ�� Ʋ���ϴ�. \n");
		}
		return coach;
	}

	//�����ڸ�� ������
	public void admin_rc() {
		int choice;
		while((choice=Menu.admin_Menu())!=4){
			switch(choice){
			case 1:	//Ʈ���̴װ�ȹ������
				week_plan();
				break;
			case 2:	//ȸ����������
				Member_run.manage_member_rc();
				break;
			case 3:	//��ȣ����
				admin_change_pin();
				return;
			case 4:
				return;
			default:
				System.out.println("��Please check of 1 to 4 times");
			}
		}
	}








}