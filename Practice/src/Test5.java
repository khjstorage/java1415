

import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ û���� ��� program");
		System.out.println("���»�뷮(Kw/h)�� �Է��ϰ� Enter>");
		int electronic = sc.nextInt();

		int basic_fee;
		int usage_fee = 0;
		
		if(electronic<=100){
			basic_fee=390;
			usage_fee=(int) (usage_fee*57.9);
		}else if((100<electronic)&&(electronic<=200)){
			basic_fee=870;
			electronic -= 100;
			usage_fee=(int) ((100*57.9)+(electronic*120.2));
		}else if((200<electronic)&&(electronic<=300)){
			basic_fee=1530;
			electronic -= 200;
			usage_fee=(int) ((100*57.9)+(100*120.2)+(electronic*179.4));
		}else if((300<electronic)&&(electronic<=400)){
			basic_fee=3680;
			electronic -= 300;
			usage_fee=(int) ((100*57.9)+(100*120.2)+(100*179.4)+(electronic*267.8));
		}else if((400<electronic)&&(electronic<=500)){
			basic_fee=6970;
			electronic -= 400;
			usage_fee=(int) ((100*57.9)+(100*120.2)+(100*179.4)+(100*267.8)+(electronic*398.7));
		}else{
			basic_fee=12350;
			electronic -= 500;
			usage_fee=(int) ((100*57.9)+(100*120.2)+(100*179.4)+(100*267.8)+(100*398.7)+(electronic*677.3));

		}
		
		System.out.println("�⺻���:"+basic_fee+"��");
		System.out.println("�����:"+usage_fee+"��");
		
		int num1=(int) (basic_fee+usage_fee);
		System.out.println("���¿��:"+num1+"��");

		int num2=(int) (num1*0.037);
		System.out.println("���±��:"+num2+"��");

		int num3=(int) (num1*0.1);
		System.out.println("�ΰ���ġ:"+num3+"��");

		int num4=num1+num2+num3;
		System.out.println("û�����:"+(int)(num4*0.1)*10+"��");

	}

}
