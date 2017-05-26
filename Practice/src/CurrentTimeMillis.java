/*Returns:the difference, measured in milliseconds, 
between the current time and midnight, January 1, 1970 UTC.See Also:Date*/


public class CurrentTimeMillis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Long startTime = System.currentTimeMillis();

		for(int i=0; i<=100000000; i++){
			;
		}
			
		Long endTime = System.currentTimeMillis();


		System.out.println("시작시간 : "+ endTime);
		System.out.println("종료시간 : "+ startTime);
		System.out.println("수행시간 : "+ (endTime - startTime) + " ms");
	}

}
