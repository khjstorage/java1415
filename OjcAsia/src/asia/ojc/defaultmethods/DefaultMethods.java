package asia.ojc.defaultmethods;

/*
 * 자바8 부터는 인테페이스에 BODY를 가지는(구현된) 메소드를 사용할 수 있는데
 * 자바8 default methods 라고 한다.
 * 어떤 클래스가 인터페이스를 구현하여 생성되었을때(이러한 클래스가 여러개 있다고 하자.)
 * 인터페이스에 어떤 추상 메소드를 하나 추가했다고 하면 이를 구현한 모든 클래스를 수정해야 하는 번거러움이 있다.
 * (인터페이스와 이를 구현한 클래스는 너무 강하게 커플링 되어 있다.)
 * 이 경우 default method를 이용한다면 좋을 것이다.
 */

interface OracleJavaCommunity2 {
	//default method
	 default void javaStudy() {
		System.out.println("오라클자바커뮤니티 자바8 공부");
	}

	public void springStudy();
}

class OracleJavaCommunityEdu implements OracleJavaCommunity2 {
	public void springStudy() {
		System.out.println("오라클자바커뮤니티 스프링4 공부");
	}
	
	//javaStudy 메소드 구현x
}

public class DefaultMethods {
	public static void main(String[] args) {
		OracleJavaCommunityEdu ojc = new OracleJavaCommunityEdu();

		ojc.javaStudy();    //인터페이스에서 만든 default method
		ojc.springStudy();
	}
}