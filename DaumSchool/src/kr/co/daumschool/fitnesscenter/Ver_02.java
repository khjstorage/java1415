package kr.co.daumschool.fitnesscenter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/*
 * �ʱ�ȭ��
 */
public class Ver_02 {
	
	static List<Info_Member> person = new ArrayList<Info_Member>();

		
	public static void main(String[] args){
		Manager_Mode m = new Manager_Mode();
		Member_Mode n = new Member_Mode();
		
		int choice;

		while((choice=Menu.main_Menu())!=4){
			switch(choice){
			case 1:
				m.admin_login();	//������ �α��΢���
				break;
			case 2:
				n.member_login();	//��� ��墺��
				break;
			case 3:				//ȸ������
				n.join();
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("��Please check of 1 to 3 times");
			}
		}
	}
	
}