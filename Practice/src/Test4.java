

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
		System.out.println("승용차 세금 계산 program");

		System.out.println("승용차의 배기량(cc)을 입력하고 Enter>");
		int cc=sc.nextInt();
		System.out.println("차 구입후 경과년수를 입력하고 Enter>");
		int year=sc.nextInt();

		double duty = cc * tax(cc) * discount(year);
		System.out.println("배기량:"+cc+" cc");
		System.out.println("경과년수:"+year+" 년");
		System.out.println("세금총액:"+(int)duty+" 원"); 
	}
}
