package org.opentutorials.javatutorials.overloading.example1;

public class OverloadingDemo2 extends OverloadingDemo{

	void A (String arg1, String arg2){
		System.out.println("sub class : void A (String arg1, String arg2)");
	}
	//부모 클래스에서는 정의되어 있지 않기 때문에 메소드 overloading
	
	void A (){
		System.out.println("sub class : void A ()");
	}
	//부모 클래스에는 이미 매개변수가 없는 메소드 A가 존재 한다. overriding
	
	public static void main(String[] args) {
		OverloadingDemo2 od = new OverloadingDemo2();
		od.A();
		od.A(1);
		od.A("coding everybody");
		od.A("coding everybody", "coding everybody");
	}

}
