import java.util.Scanner;

abstract class Car {
	String name;
	float mileage;
	int door, wheel;

	Car(String name, float mileage, int door, int wheel){
		this.name = name;
		this.mileage = mileage;
		this.door = door;
		this.wheel = wheel;
	}

	public void showCar(){
		System.out.println("차종은 "+name+"입니다.");
		System.out.println("연비는 "+mileage+"km/ℓ입니다.");
		System.out.println("문 개수는 "+door+"개 입니다.");
		System.out.println("바퀴수는 "+wheel+"개 입니다.");
	}

	public void showBasicCar(){

	}	
}



class SportsCar extends Car{
	int speed;

	public SportsCar(String name, float mileage, int door, int wheel, int speed) {
		super(name, mileage, door, wheel);
		this.speed = speed;
	}

	public void showCar(){
		super.showCar();
		System.out.println("스피드는 "+speed+"km/h입니다.");
	}

	public void showBasicCar(){
		System.out.println("차종 :" +name);
		System.out.println("연비 :" +mileage);
	}
}

class Truck extends Car {
	int baegiryang;

	public Truck(String name, float mileage, int door, int wheel, int cc) {
		super(name, mileage, door, wheel);
		baegiryang = cc;
	}

	public void showCar(){
		super.showCar();
		System.out.println("배기량은 " +baegiryang+"(cc)입니다.");
	}

	public void showBasicCar(){
		System.out.println("차종 :" +name);
		System.out.println("연비 :" +mileage);
	}
}

class TwoWheeler extends Car {
	int price;

	public TwoWheeler(String name, float mileage, int door, int wheel, int price) {
		super(name, mileage, door, wheel);
		this.price = price;
	}

	public void showCar(){
		super.showCar();
		System.out.println("가격은 "+price+"원 입니다.");
	}

	public void showBasicCar(){
		System.out.println("차종 :" +name);
		System.out.println("연비 :" +mileage);
	}	
}


class ControlCar {
	private Car[] myCar;
	private int numOfCar;

	public ControlCar(int num) {
		myCar = new Car[num];
		numOfCar = 0;
	}

	private void addCarInfo(Car caca){
		myCar[numOfCar++]=caca;
	}

	public void addCar(int choice){
		String name;
		float mileage;
		int door, wheel, speed, price, baegiryang;

		Scanner sc = new Scanner(System.in);
		System.out.print("차종 : "); name = sc.nextLine();
		System.out.print("연비(km/ℓ) : "); mileage = sc.nextFloat();
		System.out.print("문개수 : "); door = sc.nextInt();
		System.out.print("바퀴수 : "); wheel = sc.nextInt();

		if(choice == 1){
			System.out.print("스피드(km/h) : "); speed = sc.nextInt();
			addCarInfo(new SportsCar(name, mileage, door, wheel, speed));
		}else if(choice ==2){
			System.out.print("배기량(cc) : "); baegiryang = sc.nextInt();
			addCarInfo(new Truck(name, mileage, door, wheel, baegiryang));
		}else if(choice ==3){
			System.out.print("가격(원) : "); price = sc.nextInt();
			addCarInfo(new TwoWheeler(name, mileage, door, wheel, price));
		}
		System.out.println("\n입력이 완료 되었습니다\n");

	}

	public void showAllCar(){
		for(int i=0; i<numOfCar; i++){
			myCar[i].showCar();
			System.out.println("");
		}
	}

	public void showAllBasicCar(){
		for(int i=0; i<numOfCar; i++){
			myCar[i].showBasicCar();
			System.out.println("");
		}
	}
}


public class CarGarage {
	public static void main(String[] args) {

		ControlCar cr = new ControlCar(6);

		while(true){
			System.out.println("========메뉴선택========");
			System.out.println("1. 스포츠카 정보 등록");
			System.out.println("2. 트럭 정보 등록");
			System.out.println("3. 오토바이 정보 등록");
			System.out.println("4. 전체정보 출력");
			System.out.println("5. 기본정보 출력");
			System.out.println("6. 종료");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch(choice){
			case 1 : case 2: case 3:
				cr.addCar(choice);
				break;
			case 4 : 
				cr.showAllCar();
				break;
			case 5 : 
				cr.showAllBasicCar();
				break;
			case 6 :
				System.out.println("프로그램 종료합니다.");
				break;
			}
			if(choice==6){
				return;
			}
		}
	}
}
