package net.projecteuler;
/*짝수 피보나치 합*/
public class Even_Fibonacci_number {

	private static int fibo(int num){

		int a=1, b=2, c=3, hap=2;

		while(c<=num){
			c = a+b;
			a = b;
			b = c;

			if(c%2 == 0) hap += c;
		}
		return hap;

	}

	public static void main(String[] args) {

		System.out.println(fibo(4000000));
	}
}
