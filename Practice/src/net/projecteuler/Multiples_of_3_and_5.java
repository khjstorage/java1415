package net.projecteuler;
public class Multiples_of_3_and_5 {

	public static void main(String[] args) {

		int hap = 0;

		for(int i=0; i<1000; i++){
			if((i%3==0) || (i%5==0)){hap+=i;}

		}
		System.out.println(hap);

	}

}
