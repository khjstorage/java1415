package org.opentutorials.javatutorials.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class B{
	void run() throws FileNotFoundException, IOException{
		BufferedReader bReader = null;
		String input = null;

		bReader = new BufferedReader(new FileReader("out.txt"));
		input = bReader.readLine();

		System.out.println(input); 
	}

}

class C{
	void run() throws FileNotFoundException, IOException{
		B b = new B();
		b.run();
	}

}

public class ThrowExceptionDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		C c = new C();
		try {
			c.run();
		} catch (FileNotFoundException e) {
			System.out.println("out.txt 파일이 필요합니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}   
}