

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("당구장 이용요금 계산 program");

		System.out.println("시작시간 입력(시간, 분):");
		int startTime = sc.nextInt(); 
		int startMinute = sc.nextInt();
		System.out.println("종료시간 입력(시간, 분):");
		int endTime = sc.nextInt();
		int endMinute = sc.nextInt();
		System.out.println("10분당 이용 금액(원):");
		int won = sc.nextInt();
		
		int s_Time = (startTime*60)+startMinute;
		int e_Time = (endTime*60)+endMinute;
		int time = s_Time - e_Time;
		int hour = time/60;
		int min = time%60;
		
		System.out.println("전체사용시간:"+hour+"시간"+min+"분"+"("+time+"분"+")");
		
		double time2, add, charge;
		if(time%10 >=5){
			time2 = (time/10+0.5);
			add = (time2*won)/10;
		}else{
			time2 =(time/10);
			add = (time2*won)/10;
		}
		
		charge=(time2*won)+add;
		add=((int)add/10)*10;
		charge=((int)charge/10)*10;

		System.out.println("전체 사용 금액:"+time2+"*"+won+"원+"+"부가세"+"("+(int)add+"원)"+"="+(int)charge+"원");
	
		charge = ((int)charge / 100)*100;
		System.out.println("지불할 금액:"+(int)charge+"원");
	}

}
