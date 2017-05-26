package org.opentutorials.javatutorials.abstractclass.example1;

abstract class A{
	public abstract int b();
	//본체가 있는 메소드는 abstract 키워드를 가질 수 없다.
	/*public abstract int c(){
		System.out.println("Hello");
	}*/
	//추상 클래스 내에는 추상 메소드가 아닌 메소드가 존재 할 수 있다. 
	public void d(){
		System.out.println("world");
	}
}

class B extends A{

	@Override
	public int b() {
		//구현
		return 0;
	}

}
/*클래스B는 A클래스를 상속하고 있다. b메소드를 오버라이딩 하지않았다.
그래서 abstract b 상태 그대로 상속된다. 즉 B클래스는 상속으로 인해서
abstract 메소드를 멤버로 포함한 꼴이 된다.*/


public class AbstractDemo {

	public static void main  (String[] args) {
		//A obj = new A();
		B obj = new B();
		System.out.println(obj.b());
	}

}
