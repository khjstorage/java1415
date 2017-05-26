package kr.co.daumschool.library;

class Info_Book {
	String book_name;
	String book_code;
	int book_volume;

	public int getBook_volume() {
		return book_volume;
	}

	public int setBook_volume(int book_volume) {
		return this.book_volume = book_volume;
	}

	public Info_Book(){

	}

	public Info_Book(String book_name, String book_code, int book_volume){
		this.book_name = book_name;
		this.book_code = book_code;
		this.book_volume = book_volume;
	}


	public void show_Book_Info(){
		System.out.println("book_name: " + book_name);
		System.out.println("book_code: " + book_code);
		System.out.println("book_volume: " + book_volume);
	}

	public int hashCode() {
		return book_code.hashCode();
	}

	public boolean equals(Object obj) {
		Info_Book tmp = (Info_Book) obj;
		if (book_code.compareTo(tmp.book_code) == 0)
			return true;
		else
			return false;
	}

	public String toString(){
		return "도서이름 : "+book_name + "\t도서코드 : "+book_code + "\t책  수량 : " + book_volume+ "권";
	}
}