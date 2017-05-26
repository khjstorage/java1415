package com.paran.inst.sample;

import java.io.IOException;

public class ArrayUtilTest{
	public int mTotal = 0 ;
	public static void main(String[] args) throws Exception{
		
		ArrayUtilTest[] obj = new ArrayUtilTest[10];
		obj[0] = new ArrayUtilTest();
		
		if ( obj[0] != null ){
			try {
				obj[0].add();
			} catch (NullPointerException e) {
//				throw e;
				System.out.println("NullPointerException");
			} catch (IOException e) {
//				throw e;0
				System.out.println("IOException");
			}finally{
				System.out.println("finally");				
			}
			
		}

		System.out.println("³¡");
	}
	public void add() throws NullPointerException, IOException{
		throw new NullPointerException();
	}

}
