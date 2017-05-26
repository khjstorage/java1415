package kr.co.daumschool.library;

class Info_Rental extends Info_Member {
	
	String book_code;
	
	public Info_Rental(){
		
	}
	
	public Info_Rental(String id, String name, String phoneNumber, String pin, String book_code) {
		super(id, name, phoneNumber, pin);
		this.book_code = book_code;
	}	

	public void show_Member_Info(){
		super.show_Member_Info();
		System.out.println("book_code: " + book_code);
	}
	
	public String toString(){
		return "대여자아이디: "+id +"\t도서코드: "+book_code;
	}
	
}