package kr.co.daumschool.fitnesscenter;

/*
 * ������ Ŭ����
 */

class Info_Manager {

	private String admin;
	private String pin;
	
	
	public Info_Manager(String admin, String pin){
		this.admin = admin;
		this.pin = pin;
	}
	
	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}




}