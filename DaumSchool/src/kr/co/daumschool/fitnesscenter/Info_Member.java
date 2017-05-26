package kr.co.daumschool.fitnesscenter;

/*
 * 회원클래스
 */

class Info_Member {


	private String name;
	private String address;
	String office;
	private String goal;
	private String numberOfwork;
	private String timeOfwork;


	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getNumberOfwork() {
		return numberOfwork;
	}

	public void setNumberOfwork(String numberOfwork) {
		this.numberOfwork = numberOfwork;
	}

	public String getTimeOfwork() {
		return timeOfwork;
	}

	public void setTimeOfwork(String timeOfwork) {
		this.timeOfwork = timeOfwork;
	}


	public void show_Member_Info() {
		System.out.println("이름 :"+name);
		System.out.println("주소 :"+address);
		System.out.println("연락처 :"+office);
		System.out.println("목표 :"+goal);
		System.out.println("주 운동 횟수 :"+numberOfwork);
		System.out.println("운동 시간 :"+timeOfwork);
		
	}


	@Override
	public String toString() {
		return "Info_Member [name=" + name + ", address=" + address
				+ ", office=" + office + ", goal=" + goal + ", numberOfwork="
				+ numberOfwork + ", timeOfwork=" + timeOfwork + "]";
	}


}