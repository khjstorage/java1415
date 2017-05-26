package org.opentutorials.javatutorials.constant2.interfacees;

 
public class ConstantDemo {
	interface Fruit{
	    int APPLE=1, PEACH=2, BANANA=3;
	}
	
	interface COMPANY{
	    int GOOGLE=1, APPLE=2, ORACLE=3;
	}
     
    public static void main(String[] args) {
        int type = Fruit.APPLE;					//COMPANY.GOOGLE == 57kcal
        switch(type){
            case Fruit.APPLE:
                System.out.println(57+" kcal");
                break;
            case Fruit.PEACH:
                System.out.println(34+" kcal");
                break;
            case Fruit.BANANA:
                System.out.println(93+" kcal");
                break;
        }
    }
}