package report.kimseunghun.r0008;

import java.util.Scanner;

public class Father {
	int[] a = new int[10];
	Scanner scan;
	String str1, str2;
	int num1,num2;

	Father() {
		//scan = new Scanner(System.in);
		//inputFormScanner1();
		//inputFormScanner2();
		//inputNum();
		System.out.println("아빠 기본생성자 호출!!");
	}
	/*void inputNum(){
		for(int i=0;i<a.length;i++){
			System.out.print((i+1)+"번째 점수를 입력해주세요> ");
			str1 = scan.nextLine();
			a[i]=Integer.parseInt(str1);
			System.out.println(a[i]);
		}
	}
	

	/*void inputFormScanner1() {
		System.out.print("초기값을 입력해주세요> ");
		str1 = scan.nextLine();
		num1=Integer.parseInt(str1);
	}

	void inputFormScanner2() {
		System.out.print("맥스값을 입력해주세요> ");
		str2 = scan.nextLine();
		num2=Integer.parseInt(str2);
	}
	void point(){
		for(int i=num1;i<=num2;i++){
			System.out.println(i);
		}
		}*/
	
	
	Father(int a) {                  
		this();
		System.out.println("오버로딩 개념으로 추가된 아빠 생성자 호출!!");
	}
}
