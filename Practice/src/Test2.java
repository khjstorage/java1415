

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("고속도로 통행료 계산 program");
		int[][] money ={
				{0,1700,4300,7700,13500,22900},
				{1700,0,3500,6900,13300,22700},
				{4300,3500,0,4300,10700,20100},
				{7700,6900,4300,0,8400,17800},
				{13500,13300,10700,8400,0,9400},
				{22900,22700,20100,17800,9400,0}
		};
		
		System.out.println("\n각 도시별 번호");
		System.out.println("서울(0) 수원(1) 천안(2) \n대전(3) 대구(4) 부산(5)");


		while(true){
			System.out.println("출발지 도시번호 입력하고 Enter>");
			int start = sc.nextInt();
			System.out.println("도착지 도시번호 입력하고 Enter>");
			int end = sc.nextInt();
			System.out.println(money[start][end]);
		}
	}
}
