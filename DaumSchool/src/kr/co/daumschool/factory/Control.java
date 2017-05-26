package kr.co.daumschool.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Control extends Ver_01 {

	static Random r = new Random();
	static List<Info_Buyer> buyer = new ArrayList<Info_Buyer>();
	static List<Info_Factory> factory = new ArrayList<Info_Factory>();

	public static int MAX_ITEM = 30;
	public static char num_shop = 96;
	public Control(){
		factory.add(new Info_Factory("no1","축구공",2000,30)); //0
		factory.add(new Info_Factory("no2","야구공",1500,30)); //1
		factory.add(new Info_Factory("no3","농구공",2000,30)); //2
		factory.add(new Info_Factory("no4","배구공",2500,30)); //3
		buyer.add(new Info_Buyer("김현진","a"));
		buyer.add(new Info_Buyer("이상훈","b"));
		buyer.add(new Info_Buyer("박은숙","c"));
	}
	//1.물건구매 -> 물건 30개 채우기
	public synchronized void select_item(){
		num_shop++;
		System.out.println("\n"+num_shop+"손님 item 구매중");
		int what = r.nextInt(4); //(0,1,2,3)

		if(what==0){				//축구공
			soccer();
		}else if(what==1){			//축구,야구공
			soccer();
			base();
		}else if(what==2){			//축구,야구,농구공
			soccer();
			base();
			basket();
		}else{						//축구,야구,농구,배구공
			soccer();
			base();
			basket();
			volley();
		}

	}

	public synchronized  void soccer(){
		int soccer = r.nextInt(factory.get(0).item_amount);
		Info_Buyer tmp = new Info_Buyer();
		tmp.setBuyer_amount(soccer);
		System.out.println("축구공 "+soccer+"개 구입 했습니다.");
		
		if(soccer==MAX_ITEM){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

		Info_Factory temp = new Info_Factory();
		int minus = factory.get(0).item_amount-soccer;
			
		temp.setItem_serial_num(factory.get(0).item_serial_num);
		temp.setItem(factory.get(0).item);
		temp.setItem_amount(minus);
		temp.setItme_price(factory.get(0).itme_price);
		factory.set(0, temp);

		
		
	}

	public synchronized void base(){
		int base = r.nextInt(factory.get(1).item_amount);
		Info_Buyer tmp = new Info_Buyer();
		tmp.setBuyer_amount(base);
		System.out.println("야구공 "+base+"개 구입 했습니다.");

		if(base==MAX_ITEM){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

		Info_Factory temp = new Info_Factory();
		int minus = factory.get(1).item_amount-base;
		
		temp.setItem_serial_num(factory.get(1).item_serial_num);
		temp.setItem(factory.get(1).item);
		temp.setItem_amount(minus);
		temp.setItme_price(factory.get(1).itme_price);
		factory.set(1, temp);
	}

	public synchronized void basket(){
		int basket = r.nextInt(factory.get(2).item_amount);
		Info_Buyer tmp = new Info_Buyer();
		tmp.setBuyer_amount(basket);
		System.out.println("농구공 "+basket+"개 구입 했습니다.");


		if(basket==MAX_ITEM){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

		Info_Factory temp = new Info_Factory();
		int minus = factory.get(2).item_amount-basket;
		
		temp.setItem_serial_num(factory.get(2).item_serial_num);
		temp.setItem(factory.get(2).item);
		temp.setItem_amount(minus);
		temp.setItme_price(factory.get(2).itme_price);
		factory.set(2, temp);

	}

	public synchronized void volley(){
		int volley = r.nextInt(factory.get(3).item_amount);
		Info_Buyer tmp = new Info_Buyer();
		tmp.setBuyer_amount(volley);
		System.out.println("배구공 "+volley+"개 구입 했습니다.");


		if(volley==MAX_ITEM){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

		Info_Factory temp = new Info_Factory();
		int minus = factory.get(3).item_amount-volley;
		
		temp.setItem_serial_num(factory.get(3).item_serial_num);
		temp.setItem(factory.get(3).item);
		temp.setItem_amount(minus);
		temp.setItme_price(factory.get(3).itme_price);
		factory.set(3, temp);

	}

	public synchronized  void stack_item(){
		for(int i=0; i<=3; i++){
			
			Info_Factory temp = new Info_Factory();
			
			temp.setItem_serial_num(factory.get(i).item_serial_num);
			temp.setItem(factory.get(i).item);
			temp.setItem_amount(MAX_ITEM);
			temp.setItme_price(factory.get(i).itme_price);
			factory.set(i, temp);	

			if(temp.getItem_amount()==MAX_ITEM){
				notify();
			}
		}
		System.out.println("창고에 물건을 가득 채웠다.");	
	}

	//2.조회
	public void search_buyer_Info(){
		System.out.println("구매자 정보 검색을 시작합니다..");
		System.out.print("구매자아이디:  ");
		String buyer_id = Menu.sc.next();
		Info_Buyer info = search(buyer_id);
		if(info == null){
			System.out.println("존재하지 않는 구매자입니다.\n");
		}else{
			info.show_buyer();
			System.out.println("데이터 검색이 완료되었습니다. \n");
		}
	}
	public static Info_Buyer search(String buyer_id){
		Iterator<Info_Buyer> itr = buyer.iterator();
		while(itr.hasNext()){
			Info_Buyer tmpInfo = itr.next();
			if(buyer_id.compareTo(tmpInfo.getBuyer_id())==0){
				return tmpInfo;
			}
		}
		return null;
	}
	//3.재고
	public static void inventory(){
		Iterator<Info_Factory> itr = factory.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	//4.인기템
	public void best_sell(){

	}




}


