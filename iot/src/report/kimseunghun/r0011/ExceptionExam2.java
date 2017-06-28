package report.kimseunghun.r0011;

import java.util.Scanner;

public class ExceptionExam2 {
	int[] arrNum = new int[10];

	// 10개의 방을 가지고 있는 int형 배열변수 arrNum을
	// ExceptionExam2의 멤버변수로 선언해주세요.
	// for문을 돌며 Scanner 클래스의 nextLine()함수를 사용하여 아무런 값이나 입력해주세요.
	// 단 for문을 돌며 문자값이 입력됬을때 에러메세지를 나오게해주세요.
	public static void main(String[] args) {
		ExceptionExam2 ee = new ExceptionExam2();
		for (int i = 0; i < ee.arrNum.length; i++) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.print((i+1)+"번째 입력: ");
				String str = scan.nextLine();
				ee.arrNum[i] = Integer.parseInt(str);
				System.out.println(ee.arrNum[i]);
			} catch (Exception e) {
				System.out.println("error");
				i--;
			}
		}
	}
}