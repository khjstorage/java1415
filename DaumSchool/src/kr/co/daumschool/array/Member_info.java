package kr.co.daumschool.array;
public class Member_info {
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return "ȸ��ID : "+id+"\nȸ���̸� : "+name;
	}
}
