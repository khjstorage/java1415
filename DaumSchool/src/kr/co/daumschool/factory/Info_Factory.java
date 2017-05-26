package kr.co.daumschool.factory;

class Info_Factory {

	String item_serial_num;
	String item;
	int item_amount;
	int itme_price;

	public Info_Factory(){

	}

	public Info_Factory(String num, String goods, int price, int amount){
		this.item_serial_num = num;
		this.item = goods;
		this.itme_price = price;
		this.item_amount = amount;
	}	

	public String getItem_serial_num() {
		return item_serial_num;
	}

	public void setItem_serial_num(String item_serial_num) {
		this.item_serial_num = item_serial_num;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getItme_price() {
		return itme_price;
	}

	public void setItme_price(int itme_price) {
		this.itme_price = itme_price;
	}

	public int getItem_amount() {
		return item_amount;
	}

	public void setItem_amount(int item_amount) {
		this.item_amount = item_amount;
	}

	public void show_factory(){
		System.out.println("�Ϸù�ȣ: "+getItem_serial_num());
		System.out.println("�����̸�: "+getItem());
		System.out.println("���Ǽ���: "+getItem_amount());
		System.out.println("���ǰ���: "+getItme_price());
	}

	@Override
	public String toString() {
		return "Info_Factory [�Ϸù�ȣ=" + item_serial_num + ", �����̸�="
				+ item + ", ���Ǽ���=" + item_amount + ", ���ǰ���="
				+ itme_price + "]";
	}





}
