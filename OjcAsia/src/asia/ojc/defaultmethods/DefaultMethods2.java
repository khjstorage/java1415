package asia.ojc.defaultmethods;

interface Ojc {
	//default method
	default void javaStudy() {
		System.out.println("����Ŭ�ڹ�Ŀ�´�Ƽ �ڹ�8 ����1");
	}
}

interface OjcEdu {
	//default method
	default void javaStudy() {
		System.out.println("����Ŭ�ڹ�Ŀ�´�Ƽ �ڹ�8 ����2");
	}
}

class Programmer implements Ojc, OjcEdu {
	public void  javaStudy() {
		System.out.println("����Ŭ�ڹ�Ŀ�´�Ƽ �ڹ�8 ����3");
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