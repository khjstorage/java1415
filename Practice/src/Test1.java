

import java.util.Scanner;

public class Test1 {
	public static float standradWeight(float cm){
		float sw = (float) ((cm-100)*0.9);
		return sw;
	}

	public static float bmi(float kg){
		float bmi = (float) (kg/Math.pow(1.72, 2));
		return bmi;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�񸸵� ���� program");

		System.out.print("����(cm)�� �Է��ϰ� Enter>");
		float cm = sc.nextFloat();
		System.out.print("ü��(kg)�� �Է��ϰ� Enter>");
		float kg = sc.nextFloat();
		
		System.out.println("\n�������");
		System.out.println("\nǥ��ü��(kg) : "+standradWeight(cm));
		System.out.println("��ü�������� : "+bmi(kg));
			
		if(bmi(kg)<20){
			System.out.println("������ ���� �� ���� : ��ü��");
		}else if(bmi(kg)<=24){
			System.out.println("������ ���� �� ���� : ���� ü��");
		}else if(bmi(kg)<=30){
			System.out.println("������ ���� �� ���� : ��ü��");
		}else{
			System.out.println("������ ���� �� ���� : ���� ��");
		}
		
		float obesity = ((kg-standradWeight(cm))/standradWeight(cm))*100;
		System.out.println("�񸸵�(%) : "+ obesity);
		
		if(obesity<10){
			System.out.println("�񸸵��� ���� ���� : ���� ü��");
		}else if(obesity<=19){
			System.out.println("�񸸵��� ���� ���� : ��ü��");
		}else{
			System.out.println("�񸸵��� ���� ���� : ��");
		}
	}

	
	

}
