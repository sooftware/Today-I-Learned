package dept1;

import java.util.Scanner;

public class DeptManager {
	public static void main(String[] args) {
		DatabaseEx de;
		try {
			de = new DatabaseEx();
			main_while(de);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/* 메인에서 도는 와일문 따로 배치 */
	public static void main_while(DatabaseEx de){
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		while (true) {
			System.out.println("## 1. 부서등록");
			System.out.println("## 2. 부서수정");
			System.out.println("## 3. 부서삭제");
			System.out.println("## 4. 부서모두조회");
			System.out.println("## 5. 종료");
			do {
				choice = sc.nextInt();
			} while (choice < 1 || choice > 5);

			switch (choice) {
			case 1:
				de.insert();
				break;
			case 2:
				de.update();
				break;
			case 3:
				de.delete();
				break;
			case 4:
				de.display();
				break;
			case 5:
				return;
				default :
					break;
			}
		}
	}
}
