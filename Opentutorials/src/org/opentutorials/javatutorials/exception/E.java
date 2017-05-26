package org.opentutorials.javatutorials.exception;

import java.io.IOException;

class E{
    void throwArithmeticException(){
        throw new ArithmeticException();
    }
    
    //unchecked 상속은 extends RuntimeException
    
    void throwIOException1(){
    	try {
			throw new IOException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    void throwIOException2() throws IOException{
    	throw new IOException();
    }
    //checked 상속은 extends Exception
    
    /*ArithmeticException의 부모 중에 RuntimeException이 있다. 
    반면에 IOException은 Exception의 자식이지만 RuntimeException의 자식은 아니다.
    이런 이유로 IOException은 checked이고 ArithmeticException은 unchekced이다. (Error도 unchecked이다)*/

    
}