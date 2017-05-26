

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
		System.out.println("비만도 측정 program");

		System.out.print("신장(cm)를 입력하고 Enter>");
		float cm = sc.nextFloat();
		System.out.print("체중(kg)을 입력하고 Enter>");
		float kg = sc.nextFloat();
		
		System.out.println("\n판정결과");
		System.out.println("\n표준체중(kg) : "+standradWeight(cm));
		System.out.println("신체질량지수 : "+bmi(kg));
			
		if(bmi(kg)<20){
			System.out.println("지수에 대한 비만 판정 : 저체중");
		}else if(bmi(kg)<=24){
			System.out.println("지수에 대한 비만 판정 : 정상 체중");
		}else if(bmi(kg)<=30){
			System.out.println("지수에 대한 비만 판정 : 과체중");
		}else{
			System.out.println("지수에 대한 비만 판정 : 병적 비만");
		}
		
		float obesity = ((kg-standradWeight(cm))/standradWeight(cm))*100;
		System.out.println("비만도(%) : "+ obesity);
		
		if(obesity<10){
			System.out.println("비만도에 대한 판정 : 정상 체중");
		}else if(obesity<=19){
			System.out.println("비만도에 대한 판정 : 과체중");
		}else{
			System.out.println("비만도에 대한 판정 : 비만");
		}
	}

	
	

}
