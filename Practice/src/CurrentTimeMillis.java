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


		System.out.println("���۽ð� : "+ endTime);
		System.out.println("����ð� : "+ startTime);
		System.out.println("����ð� : "+ (endTime - startTime) + " ms");
	}

}
