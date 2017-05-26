package org.opentutorials.javatutorials.accessmodifier;

class A {
	public String y(){
		return "public void y()";
	}
	private String z(){
		return "public void z()";
	}
	public String x(){
		return z(); 
		//z() 같은 A클래스여서 접근제어자 private가 있어도 사용 가능
	}
}
public class AccessDemo1 {

	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.y());
		// 아래 코드는 오류가 발생한다.
		//System.out.println(a.z());
		System.out.println(a.x());
	}

}
