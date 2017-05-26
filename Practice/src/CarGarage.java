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
		System.out.println("������ "+name+"�Դϴ�.");
		System.out.println("����� "+mileage+"km/���Դϴ�.");
		System.out.println("�� ������ "+door+"�� �Դϴ�.");
		System.out.println("�������� "+wheel+"�� �Դϴ�.");
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
		System.out.println("���ǵ�� "+speed+"km/h�Դϴ�.");
	}

	public void showBasicCar(){
		System.out.println("���� :" +name);
		System.out.println("���� :" +mileage);
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
		System.out.println("��ⷮ�� " +baegiryang+"(cc)�Դϴ�.");
	}

	public void showBasicCar(){
		System.out.println("���� :" +name);
		System.out.println("���� :" +mileage);
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
		System.out.println("������ "+price+"�� �Դϴ�.");
	}

	public void showBasicCar(){
		System.out.println("���� :" +name);
		System.out.println("���� :" +mileage);
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
		System.out.print("���� : "); name = sc.nextLine();
		System.out.print("����(km/��) : "); mileage = sc.nextFloat();
		System.out.print("������ : "); door = sc.nextInt();
		System.out.print("������ : "); wheel = sc.nextInt();

		if(choice == 1){
			System.out.print("���ǵ�(km/h) : "); speed = sc.nextInt();
			addCarInfo(new SportsCar(name, mileage, door, wheel, speed));
		}else if(choice ==2){
			System.out.print("��ⷮ(cc) : "); baegiryang = sc.nextInt();
			addCarInfo(new Truck(name, mileage, door, wheel, baegiryang));
		}else if(choice ==3){
			System.out.print("����(��) : "); price = sc.nextInt();
			addCarInfo(new TwoWheeler(name, mileage, door, wheel, price));
		}
		System.out.println("\n�Է��� �Ϸ� �Ǿ����ϴ�\n");

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
			System.out.println("========�޴�����========");
			System.out.println("1. ������ī ���� ���");
			System.out.println("2. Ʈ�� ���� ���");
			System.out.println("3. ������� ���� ���");
			System.out.println("4. ��ü���� ���");
			System.out.println("5. �⺻���� ���");
			System.out.println("6. ����");

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
				System.out.println("���α׷� �����մϴ�.");
				break;
			}
			if(choice==6){
				return;
			}
		}
	}
}
