package net.projecteuler;
/*È¸¹®¼ö*/
import java.util.Scanner;

public class Lagest_palindrome_product {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int tmp = number;
		
		int result = 0;
		
			
		for(; tmp!=0;){
			result = result*10 + tmp%10;
			tmp /= 10;
		}
		
		
		System.out.println(result);
		
		boolean bo = (number==result) ? true:false;
		System.out.println(bo);
	}

}
