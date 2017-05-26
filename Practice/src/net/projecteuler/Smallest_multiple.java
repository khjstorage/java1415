package net.projecteuler;


/* 12(2*2*3),18(2*3*3)

   GCM 최대공약수 = 6  (2*3)
   최대공약수를 구하는 방법은, 우선 소인수(素因數)로 분해하여 공통의 수를 택하여 곱해주면 된다

   LCM 최소공배수 = 36 (2*3*2*3) 
   최소공배수를 구할 때는 우선 소인수(素因數)로 분해하여 각 수 중에서 적어도 어느 한 곳에라도 있는 약수를 모두 찾아서 곱해주면 된다

   두 자연수 A, B에 대하여 A*B = GCM*LCM 성립한다.

   참고1 : 4byte 정수형을 사용할 경우 overflow가 발생할 수 있다. (연산 순서에 주의!)
   참고2 : Java 라이브러리 중 BigInteger를 사용하면 최대공약수를 구하는 method가 잘 정의되어있다.
   참고3 : 유클리드 호제법 (Euclidean algorithm)은 최대공약수를 구하는 방법


 */

public class Smallest_multiple {

	public static void main(String[] args) {
		
		int result = 0;
		int min = 2;
		int max = 20;

		// 그냥 계속 순차대로 나누어 떨어지는지 비교하는 방법
		boolean is = false;
		while(!is) {
			result++;
			is = true;
			for(int i=min; i<=max; i++) {
				if(result % i != 0) {
					is = false;
					break;
				}
			}
		}


		System.out.println("최소공배수 : "+result);

	}
 
}
