package kr.co.daumschool.fitnesscenter;

/*
 * ȸ��Ŭ����
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
		System.out.println("�̸� :"+name);
		System.out.println("�ּ� :"+address);
		System.out.println("����ó :"+office);
		System.out.println("��ǥ :"+goal);
		System.out.println("�� � Ƚ�� :"+numberOfwork);
		System.out.println("� �ð� :"+timeOfwork);
		
	}


	@Override
	public String toString() {
		return "Info_Member [name=" + name + ", address=" + address
				+ ", office=" + office + ", goal=" + goal + ", numberOfwork="
				+ numberOfwork + ", timeOfwork=" + timeOfwork + "]";
	}


}