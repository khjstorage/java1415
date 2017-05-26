package asia.ojc.defaultmethods;

interface Ojc {
	//default method
	default void javaStudy() {
		System.out.println("오라클자바커뮤니티 자바8 공부1");
	}
}

interface OjcEdu {
	//default method
	default void javaStudy() {
		System.out.println("오라클자바커뮤니티 자바8 공부2");
	}
}

class Programmer implements Ojc, OjcEdu {
	public void  javaStudy() {
		System.out.println("오라클자바커뮤니티 자바8 공부3");
		Ojc.super.javaStudy();  //
		OjcEdu.super.javaStudy();  //
	}
}

public class DefaultMethods2 {
	public static void main(String[] args) {
		Programmer p = new Programmer();
		p.javaStudy();		
	}
}