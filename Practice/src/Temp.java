import java.util.Random;


public class Temp {
	public static void main(String args[]){
		Random r = new Random();
		int tierTemp = r.nextInt(3)+1;
		System.out.println(tierTemp);
	}
}
