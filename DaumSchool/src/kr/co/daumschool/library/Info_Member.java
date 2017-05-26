package kr.co.daumschool.library;

class Info_Member {
	String id;
	String name;
	String phoneNumber;
	String pin;
	
	public Info_Member(){
		
	}
		
	public Info_Member(String id, String name, String phoneNumber, String pin){
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.pin = pin;
	}
	

	public void show_Member_Info(){
		System.out.println("아이디 : " + id);
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}

	
	public int hashCode() {
		return phoneNumber.hashCode();
	}
	
	public boolean equals(Object obj) {
		Info_Member tmp = (Info_Member) obj;
		if (phoneNumber.compareTo(tmp.phoneNumber) == 0)
			return true;
		else
			return false;
	}
	
	public String toString(){
		return "아이디: "+id + "\t이름: "+name + "\t전화번호: " + phoneNumber;
	}
	
	
}