package report.kimseunghun.r0008;

public class Son extends Father {
	//아빠클래스에서 값을 str1,str2를 scanner클래스의 nextLine()함수를 사용하여 값을 입력받아주세요.
	//숫자값을 입력받아 정수로 변환해 주시고
	//첫번째값은 반복문의 초기값 두번째값은 반복문의 맥스값
	//반복문만큼 i의 값을 출력하는 함수를 아빠클래스에 선언해주시고
	//아들클래스에서 호출하여 겺과값을 나타내주세요.

	Son() {
		System.out.println("아들 기본생성자 호출!!");
	}

	Son(int a) {
		System.out.println("오버로딩 개념으로 추가된 아들 생성자 호출!!");
	}

	public static void main(String[] args) {
		Son s = new Son(1);
		//s.point();
	}
}