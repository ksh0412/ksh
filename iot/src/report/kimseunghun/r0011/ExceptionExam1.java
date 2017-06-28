package report.kimseunghun.r0011;

import java.util.Scanner;

public class ExceptionExam1 {
	// ExceptionExam1의 멤버변수로 int num1, num2를 선언해주세요.
	// 멤버변수 num1과 num2값을 계산하여 int값을 리턴하는
	// plus(),minus(),multiple(),division()함수를 4개 선언하여 이름에 맞게 연산하여 리턴해주세요.
	// Scanner 클래서의 nextLine()함수를 사용하여 num1의 값과 num2값을 대입해주세요.
	// 숫자값을 입력하지 않았을때는 Exception에서 "숫자를 입력해야지!!!"라는 문자열이 나와야 합니다.
	// 정상적으로 숫자 값을 입력했다면
	// 위에 선언한 4개의 함수를 호출하여 값을 받아 출력하는 예제를 작성해주시기 바랍니다.

	int num1;
	int num2;
	int result;
	final int NUM_NUM3;
	
	ExceptionExam1(){
		NUM_NUM3=1;
	}

	int plus() {
		result = num1 + num2;
		return result;
	}

	int minus() {
		result = num1 - num2;
		return result;
	}

	int multiple() {
		result = num1 * num2;
		return result;
	}

	int division() {
		result = num1 / num2;
		return result;
	}

	public static void main(String[] args) {
		ExceptionExam1 ee = new ExceptionExam1();
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("숫자를 입력하세요> ");
			ee.num1 = Integer.parseInt(scan.nextLine());
			System.out.print("숫자를 입력하세요> ");
			ee.num2 = Integer.parseInt(scan.nextLine());
			System.out.println(ee.plus());
			System.out.println(ee.minus());
			System.out.println(ee.multiple());
			System.out.println(ee.division());

		} catch (Exception e) {
			System.out.println("숫자를 입력해야지!!!");
		} finally {
			System.out.println("숫자를 입력하지않아도 난 실행");
		}
	}
}