package org.opentutorials.javatutorials.accessmodifier.outter;
import org.opentutorials.javatutorials.accessmodifier.inner.B;

public class D extends B {
	void a(){
		_public();
	}

	/*void b(){
		_private();
	}*/
	
	void c(){
		_protected();
	}
	
	/*void d(){
		_default();
	}*/
}
