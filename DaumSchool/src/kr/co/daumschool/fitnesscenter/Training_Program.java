package kr.co.daumschool.fitnesscenter;


public class Training_Program{

	private String mon;
	private String tue;
	private String wed;
	private String thu;
	private String fri;
	static int num = 0;
	
	public String getMon() {
		return mon;
	}

	public void setMon(String mon) {
		this.mon = mon;
	}

	public String getTue() {
		return tue;
	}

	public void setTue(String tue) {
		this.tue = tue;
	}

	
	public String getWed() {
		return wed;
	}

	public void setWed(String wed) {
		this.wed = wed;
	}

	public String getThu() {
		return thu;
	}

	public void setThu(String thu) {
		this.thu = thu;
	}

	public String getFri() {
		return fri;
	}

	public void setFri(String fri) {
		this.fri = fri;
	}

	public void week_plan(){
		
	};
	
	@Override
	public String toString() {
		return num+".Training_Program [mon=" + mon + ", tue=" + tue + ", wed=" + wed
				+ ", thu=" + thu + ", fri=" + fri + "]";
	}
	
}

