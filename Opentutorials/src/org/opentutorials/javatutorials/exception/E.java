package org.opentutorials.javatutorials.exception;

import java.io.IOException;

class E{
    void throwArithmeticException(){
        throw new ArithmeticException();
    }
    
    //unchecked ����� extends RuntimeException
    
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
    //checked ����� extends Exception
    
    /*ArithmeticException�� �θ� �߿� RuntimeException�� �ִ�. 
    �ݸ鿡 IOException�� Exception�� �ڽ������� RuntimeException�� �ڽ��� �ƴϴ�.
    �̷� ������ IOException�� checked�̰� ArithmeticException�� unchekced�̴�. (Error�� unchecked�̴�)*/

    
}