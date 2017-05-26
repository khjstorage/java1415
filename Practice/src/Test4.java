

import java.util.Scanner;

public class Test4 {

	public static int tax(int cc){
		int tax=0;
		if(cc<=800){
			tax = 104;
		}else if(cc<=1000){
			tax = 130;
		}else if(cc<=1600){
			tax = 182;
		}else if(cc<=2000){
			tax = 260;
		}else if(cc<=2500){
			tax = 286;
		}else{
			tax = 286;
		}
		return tax;
	}

	public static double discount(int year){
		double discount=1;

		if(year<3){
			discount = 1;
		}else if(year<12){
			discount = (discount -((year-2)*0.05));
		}else{
			discount = 0.5;
		}
		return discount;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�¿��� ���� ��� program");

		System.out.println("�¿����� ��ⷮ(cc)�� �Է��ϰ� Enter>");
		int cc=sc.nextInt();
		System.out.println("�� ������ �������� �Է��ϰ� Enter>");
		int year=sc.nextInt();

		double duty = cc * tax(cc) * discount(year);
		System.out.println("��ⷮ:"+cc+" cc");
		System.out.println("������:"+year+" ��");
		System.out.println("�����Ѿ�:"+(int)duty+" ��"); 
	}
}
