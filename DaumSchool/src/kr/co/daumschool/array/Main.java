package kr.co.daumschool.array;
import java.util.Scanner;

/**
 * 
 * @author 김현진
 * @date 2015. 6. 25. 오전 1:35:22
 */
public class Main {
	public static void main(String[] args) {

		Member_info[] member = new Member_info[3];
		Scanner sc = new Scanner(System.in);
		System.out.println(member.length);
		
		while(true){
			System.out.println("1. 입력");
			System.out.println("2. 조회");
			System.out.println("3. 삭제");

			int choice = sc.nextInt();

			switch(choice){
			case 1:
				for(int i=0; i<member.length; i++){
					Member_info t = new Member_info();

					System.out.print("아이디 :");
					t.setId(sc.next());

					System.out.print("이름 :");
					t.setName(sc.next());
					member[i]=t;
				}
				break;

			case 2:
				for(int i=0; i<member.length; i++)
					System.out.println(member[i]);
				break;

            case 3:
                System.out.println("삭제할 배열");
                int num=sc.nextInt();
                
                member[num-1] = null;
                
                for(int i=0; i<member.length; i++){
                    if(i==num-1){
                        for(int j=i;j<member.length-1;j++){
                         member[j] = member[j+1];
                        }
                        break;
                    }
                }
                
                member[member.length-1]=null;
                
             
            break;
            }
	
		}


	}
}


