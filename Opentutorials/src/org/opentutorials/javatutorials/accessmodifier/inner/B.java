package org.opentutorials.javatutorials.accessmodifier.inner;

public class B {
	public void _public(){
		System.out.println("public void _public()");
	}
	private void _private(){
		System.out.println("public void _private()");
	}//같은 패키지에서만
	protected void  _protected(){
		System.out.println("public void _protected()");
	}//protected 다른패키지 여도 <상속관계>이면 접근허용
	void _default(){
		System.out.println("public void x()");
	}//default 같은패키지 이면서 상속이여야함

	void a(){
		_public();
	}
	void b(){
		_private();
	}
	void c(){
		_protected();
	}
	void d(){
		_default();
	}

}
