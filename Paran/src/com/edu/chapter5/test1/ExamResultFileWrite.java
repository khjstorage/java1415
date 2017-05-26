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
			/*���ڿ��� �Է��� ���� �Է� ��Ʈ���� �ֻ��� Ŭ������ Reader�� �ƴ�, 
			�̸� ����ϴ� ���� ��Ʈ�� �� �ϳ��� BufferedReader�� ���� ��Ʈ������ �����ؾ��Ѵ�.
			�̴� ���ڿ� ��� ��Ʈ���� �ֻ��� Ŭ������ Writer���� �����ϴ� �ſʹ� ��� �ȴ�.
			BufferedReader Ŭ������ readLine() �޼ҵ尡 ����
			Writer Ŭ������ write() �޼ҵ� ���� 
			������ ���ڿ��� �Է��� ���۸��� ������ ���� ���� ���̰� ũ�� ������ �ݵ�� ���۸� �϶�� �ǹ̷� �޾Ƶ帮��
			�׷��� ��±����� ���۸��� ������ ���� ���� ���̰� ū ���� �ν� �ϰ� ��� ���� ���� ��Ʈ���� ��������*/

			stuList = new ArrayList<StudentScore>();

			String str;
			while (true) {
				str = in.readLine();
				if (str == null) {
					break;
				}
				/*���ڿ��� �б� ���ؼ� readLine �޼ҵ带 ȣ���ϰ� �ִ�. �׷��� ���⼭ ���ϴ� ���ڿ� �����ʹ� ������ �������� ������.
				�� ���ڿ� �����͸� �д� �ٴ� ���� ������ �����ϱ� ������ �����͸� �ѹ��� �д´ٴ� ������ �ؼ��� ���� �ִ�.
				�׸��� readLine �޼ҵ�� �� �̻� �о� ���� ���ڿ��� �������� ������ null�� ��ȯ�Ѵ�.*/

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
					System.out.println("array[0]�������� 1,2�� �ƴմϴ�.");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("��ũ�� ���� ���Ͽ� �׼��� �Ͽ����ϴ�.");
		} catch (IOException e) {
			System.out.println("����� ������ �߻��߽��ϴ�.");
		} finally {
			try {
				in.close();
				/*�׻� ���� ���ƾ� �� ���� �ٷ� close �޼ҵ��� ȣ���̴�. 
				������� �Ϸ�Ǹ� ������ ��Ʈ���� �Ҹ��� ���ؼ� �ݵ�� close�޼ҵ带 ȣ���� ����*/
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
			/*���ڿ��� ������ ���� ��� ��Ʈ���� �����ϰ� �ִ�. ���ڿ� �����ε� ������ ������ ����������, ���� �����ε� ������ �����̰����ϴ�.*/

			for(StudentScore stu : getStuList()){ 
				if(stu instanceof ForeignStudentScore){
					ForeignStudentScore fss = (ForeignStudentScore)stu;
					/*for ���� ȣ��ɶ�, �Ű������� StudentScoreŬ���� �Ǵ� �� �ڽ� Ŭ����(ForeignStudentScore,DomesticStudentScore)�� �ν��Ͻ���
					�Ѱܹް����� �޼��� ���� ���� ��Ȯ�� � �ν��Ͻ����� �� �� ����. 
					�׷��� instanceof�����ڸ� �̿��ؼ� ���������� ����Ű�� �ִ� �ν��Ͻ� Ÿ���� üũ�ؾ��Ѵ�.
					instanceof�� �̿��� �������� true�� ����ٴ� ���� �������� �˻��� Ÿ������ �� ��ȯ�� �����ϴٴ� ���� ���Ѵ�.*/
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
				/*newLine�� BufferedWriter�� ���ǵ� �޼ҵ�ν� ���������� ���� ����� �����Ѵ�. �̸޼ҵ尡 ȣ�� �Ǵ� ������ �ϳ��� ���������� ����
				�� �޼ҵ尡 ���ǵ� ������ ���ϻ󿡼� ������ ǥ���ϴ� ����� �ü������ �ٸ��� �����̴�. ������ ���ڿ��� �Ϻη� \n�� ���Եȴٰ� �ؼ�
				���Ͽ��� ������ �̷����� �����ƴϴ�.*/
			}
		} catch (FileNotFoundException e) {
			System.out.println("������ ������ �� �����ϴ�.");
		} catch (IOException e) {
			System.out.println("����� ������ �߻��߽��ϴ�.");
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
		exResultObj.readScore(); //���ڿ� �Է�
		Collections.sort(exResultObj.getStuList()); //����
		exResultObj.writeScore(); //���ڿ� ���

		for (StudentScore eachStuObj : exResultObj.getStuList()) {
			eachStuObj.display();
			System.out.println("");
		}
	}
}
