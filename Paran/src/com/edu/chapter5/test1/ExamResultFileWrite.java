package com.edu.chapter5.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ExamResultFileWrite {
	public ExamResultFileWrite() {}

	private List<StudentScore> stuList = null;
	public List<StudentScore> getStuList() {
		return stuList;
	}
	public void setStuList(List<StudentScore> stuList) {
		this.stuList = stuList;
	}

	public void readScore() {
		BufferedReader in = null;

		try {
			in = new BufferedReader(new FileReader("fileTest/students_score.txt"));
			/*문자열의 입력은 문자 입력 스트림의 최상위 클래스인 Reader가 아닌, 
			이를 상속하는 필터 스트림 중 하나인 BufferedReader를 필터 스트림으로 연결해야한다.
			이는 문자열 출력 스트림의 최상위 클래스인 Writer에서 제공하는 거와는 상반 된다.
			BufferedReader 클래스에 readLine() 메소드가 존재
			Writer 클래스에 write() 메소드 존재 
			이유는 문자열의 입력은 버퍼링의 유무에 따른 성능 차이가 크기 때문에 반드시 버퍼링 하라는 의미로 받아드리자
			그러나 출력까지도 버퍼링의 유무에 따른 성능 차이가 큰 것을 인식 하고 모두 버퍼 필터 스트림을 연결하자*/

			stuList = new ArrayList<StudentScore>();

			String str;
			while (true) {
				str = in.readLine();
				if (str == null) {
					break;
				}
				/*문자열을 읽기 위해서 readLine 메소드를 호출하고 있다. 그런데 여기서 말하는 문자열 데이터는 개행을 기준으로 나뉜다.
				즉 문자열 데이터를 읽는 다는 뜻은 개행이 등장하기 전까지 데이터를 한번에 읽는다는 뜻으로 해석할 수도 있다.
				그리고 readLine 메소드는 더 이상 읽어 들일 문자열이 존재하지 않으면 null을 반환한다.*/

				StringTokenizer st = new StringTokenizer(str, "|");
				String[] tokenArray = new String[st.countTokens()];

				int i = 0;
				while (st.hasMoreElements()) {
					tokenArray[i++] = st.nextToken();
				}

				if (tokenArray[0].equals("1")) {
					StudentScore domesticStuObj = new DomesticStudentScore();
					domesticStuObj.setName(tokenArray[1]);
					domesticStuObj.setStudentNo(tokenArray[2]);
					domesticStuObj.setKorJumsu(Integer.parseInt(tokenArray[3]));
					domesticStuObj.setEngJumsu(Integer.parseInt(tokenArray[4]));
					domesticStuObj.setMatJumsu(Integer.parseInt(tokenArray[5]));
					domesticStuObj.average();
					((DomesticStudentScore) domesticStuObj).setResidentNo(tokenArray[6]);
					stuList.add(domesticStuObj);
				} else if (tokenArray[0].equals("2")) {
					StudentScore foreignStuObj = new ForeignStudentScore();
					foreignStuObj.setName(tokenArray[1]);
					foreignStuObj.setStudentNo(tokenArray[2]);
					foreignStuObj.setKorJumsu(Integer.parseInt(tokenArray[3]));
					foreignStuObj.setEngJumsu(Integer.parseInt(tokenArray[4]));
					foreignStuObj.setMatJumsu(Integer.parseInt(tokenArray[5]));
					foreignStuObj.average();
					((ForeignStudentScore) foreignStuObj).setNationality(tokenArray[6]);
					stuList.add(foreignStuObj);
				} else {
					System.out.println("array[0]번지값이 1,2가 아닙니다.");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("디스크에 없는 파일에 액세스 하였습니다.");
		} catch (IOException e) {
			System.out.println("입출력 오류가 발생했습니다.");
		} finally {
			try {
				in.close();
				/*항상 잊지 말아야 할 것이 바로 close 메소드의 호출이다. 
				입출력이 완료되면 생성한 스트림의 소멸을 위해서 반드시 close메소드를 호출해 주자*/
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void writeScore() {
		BufferedWriter out = null;
		String rLine = null;

		try {
			out = new BufferedWriter(new FileWriter("filetest/result_score.txt"));
			/*문자열을 저장을 위한 출력 스트림을 형성하고 있다. 문자열 단위로도 데이터 저장이 가능하지만, 문자 단위로도 데이터 저장이가능하다.*/

			for(StudentScore stu : getStuList()){ 
				if(stu instanceof ForeignStudentScore){
					ForeignStudentScore fss = (ForeignStudentScore)stu;
					/*for 문이 호출될때, 매개변수로 StudentScore클래스 또는 그 자식 클래스(ForeignStudentScore,DomesticStudentScore)의 인스턴스를
					넘겨받겠지만 메서드 내에 서는 정확히 어떤 인스턴스인지 알 수 없다. 
					그래서 instanceof연산자를 이용해서 참조변수가 가르키고 있는 인스턴스 타입을 체크해야한다.
					instanceof를 이용한 연산결과로 true를 얻었다는 것은 참조변수 검사한 타입으로 형 변환이 가능하다는 것을 뜻한다.*/
					rLine=stu.getName() + "&" + stu.getStudentNo() + "&" + stu.getAveJumsu() + "&" + fss.getNationality();
					out.write(rLine);
					out.newLine();
				}else if(stu instanceof DomesticStudentScore){
					DomesticStudentScore dss = (DomesticStudentScore)stu;
					rLine=stu.getName() + "&" + stu.getStudentNo() + "&" + stu.getAveJumsu() + "&" + dss.getResidentNo();
					out.write(rLine);
					out.newLine();
				}else{
					rLine=stu.getName() + "&" + stu.getStudentNo() + "&" + stu.getAveJumsu();
					out.write(rLine);
					out.newLine();
				}
				/*newLine은 BufferedWriter에 정의된 메소드로써 개행정보의 삽입 기능을 제공한다. 이메소드가 호출 되는 순간에 하나의 개행정보가 삽입
				이 메소드가 정의된 이유는 파일상에서 개행을 표현하는 방식이 운영체제마다 다르기 때문이다. 때문에 문자열의 일부로 \n이 삽입된다고 해서
				파일에서 개행이 이뤄지는 것은아니다.*/
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 생성할 수 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력 오류가 발생했습니다.");
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String args[]) {
		ExamResultFileWrite exResultObj = new ExamResultFileWrite();
		exResultObj.readScore(); //문자열 입력
		Collections.sort(exResultObj.getStuList()); //정렬
		exResultObj.writeScore(); //문자열 출력

		for (StudentScore eachStuObj : exResultObj.getStuList()) {
			eachStuObj.display();
			System.out.println("");
		}
	}
}
