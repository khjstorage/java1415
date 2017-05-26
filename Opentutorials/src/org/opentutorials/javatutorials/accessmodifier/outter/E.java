package org.opentutorials.javatutorials.accessmodifier.outter;
import org.opentutorials.javatutorials.accessmodifier.inner.B;

public class E {
	B b = new B();
	
	void a(){
		b._public();
	}
	/*void b(){
		b._private();
	}
	void c(){
		b._protected();
	}
	void d(){
		b._default();
	}*/
}

