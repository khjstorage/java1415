

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�籸�� �̿��� ��� program");

		System.out.println("���۽ð� �Է�(�ð�, ��):");
		int startTime = sc.nextInt(); 
		int startMinute = sc.nextInt();
		System.out.println("����ð� �Է�(�ð�, ��):");
		int endTime = sc.nextInt();
		int endMinute = sc.nextInt();
		System.out.println("10�д� �̿� �ݾ�(��):");
		int won = sc.nextInt();
		
		int s_Time = (startTime*60)+startMinute;
		int e_Time = (endTime*60)+endMinute;
		int time = s_Time - e_Time;
		int hour = time/60;
		int min = time%60;
		
		System.out.println("��ü���ð�:"+hour+"�ð�"+min+"��"+"("+time+"��"+")");
		
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

		System.out.println("��ü ��� �ݾ�:"+time2+"*"+won+"��+"+"�ΰ���"+"("+(int)add+"��)"+"="+(int)charge+"��");
	
		charge = ((int)charge / 100)*100;
		System.out.println("������ �ݾ�:"+(int)charge+"��");
	}

}
