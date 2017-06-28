package report.kimseunghun.r0007;

import report.kimseunghun.r0008.Exam12;

public class Exam11 {	
	// a와 b값을 초기화하는 Exam11생성자를 만들어주세요.
	// a와 b값을 더하기, 빼기,나누기,곱하기 하는 함수를 각각 4개 작성해주시고
	// 해당연산결과는 printResult()라는 함수를 호출했을때 나오게 프로그램을 작성해주시면됩니다.
	// 호출은 Exam12라는 클래스를 만들어서 그안에서 해주시기 바랍니다.
	protected int a;
	protected int b;
	int result;
	
	public Exam11(){}

	public Exam11(int a, int b) {
		this.a = a;
		this.b = b;
	}

	protected int getPlus() {
		result = a + b;
		return result;
	}
	

	protected int getMinus() {
		result = a - b;
		return result;
	}

	protected int getMultiple() {
		result = a * b;
		return result;
	}

	protected int getDivision() {
		result = a / b;
		return result;
	}

	public void printResult() {
		System.out.println(result);
	}
}