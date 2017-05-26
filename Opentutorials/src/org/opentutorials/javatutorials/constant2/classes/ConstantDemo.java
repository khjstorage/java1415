package org.opentutorials.javatutorials.constant2.classes;
 
class Fruit{
    public static final Fruit APPLE  = new Fruit();
    public static final Fruit PEACH  = new Fruit();
    public static final Fruit BANANA = new Fruit();
}
class Company{
    public static final Company GOOGLE = new Company();
    public static final Company APPLE = new Company();
    public static final Company ORACLE = new Company();
}
 
public class ConstantDemo {
     
    public static void main(String[] args) {
        Fruit type = Fruit.APPLE;
        /*switch(type){							//switch문의 타입에는 들어갈수 있는게 제한적
            case Fruit.APPLE:
                System.out.println(57+" kcal");
                break;
            case Fruit.PEACH:
                System.out.println(34+" kcal");
                break;
            case Fruit.BANANA:
                System.out.println(93+" kcal");
                break;
        }*/
        /*if(Fruit.APPLE == Company.APPLE){
            System.out.println("과일 애플과 회사 애플이 같다.");
        }*/
    }
}