package com.edu.chapter5.test1;

public class StudentScore implements Comparable<StudentScore>{
	protected String name;
	protected String studentNo;
	protected int korJumsu;
	protected int engJumsu;
	protected int matJumsu;
	protected int aveJumsu;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public int getKorJumsu() {
		return korJumsu;
	}

	public void setKorJumsu(int korJumsu) {
		this.korJumsu = korJumsu;
	}

	public int getEngJumsu() {
		return engJumsu;
	}

	public void setEngJumsu(int engJumsu) {
		this.engJumsu = engJumsu;
	}

	public int getMatJumsu() {
		return matJumsu;
	}

	public void setMatJumsu(int matJumsu) {
		this.matJumsu = matJumsu;
	}

	public int getAveJumsu() {
		return aveJumsu;
	}

	public int setAveJumsu(int aveJumsu) {
		return this.aveJumsu = aveJumsu;
	}

	public int average(){
		return setAveJumsu((korJumsu+engJumsu+matJumsu)/3);
	}

	public void display(){
		System.out.println("이름. "+name);
		System.out.println("학번. "+studentNo);
		System.out.println("평균점수. "+aveJumsu);

	}

	@Override
	public int compareTo(StudentScore o) {
		if(this.aveJumsu < o.aveJumsu){
			return 1;
		}else if(this.aveJumsu > o.aveJumsu){
			return -1;
		}else {
			return 0;
		}
	}
	/*
	내림차순 정렬						오름차순 정렬 
	this 가 other 보다 작으면 양수		this 가 other 보다 작으면 음수
	this 가 other 보다 크면 음수			this 가 other 보다 크면 양수
	this 가 other 와 같다면 0			this 가 other 와 같다면 0
	*/

//	@Override
//	public int compareTo(StudentScore o) {
//		return this.aveJumsu - o.aveJumsu; //자기자신이 기준이 되면 오름차순 정렬
//		return o.aveJumsu - this.aveJumsu; //비교대상이 기준이 되면 내림차순 정렬
//	}
}


