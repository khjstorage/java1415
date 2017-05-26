package org.opentutorials.javatutorials.accessmodifier.inner;

public class F {

	B b = new B();
	
	void a(){
		b._public();
	}
	
	/*void b(){
		b._private();
	}*/
	
	void c(){
		b._protected();
	}
	
	void d(){
		b._default();
	}

}
