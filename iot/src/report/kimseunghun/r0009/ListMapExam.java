package report.kimseunghun.r0009;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ListMapExam {
	// 스트링,인티져로 구성된 HashMap 변수를 선언해주세요
	// HashMap변수명은 pointHm이라고 해주세요
	// pointHm에 학생의 이름키값과 점수 벨류값을 10개 넣어주세요
	// 학생이름은 A군,B군,C군...으로 입력해주세요.
	// 해당 pointHm을 ArrayList에 추가해주세요.
	// 반복문을 사용하여 ArrayList에 추가된 pointHm을 출력해주세요.

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> pointHm = new HashMap<String, Integer>();
		ArrayList arr = new ArrayList();
		for (int i = 0; i < 10; i++) {
			char cr = 65;
			int sum = cr + i;
			char cr1 = (char) sum;
			System.out.print("점수를 입력해주세요> ");
			int num= Integer.parseInt(scan.nextLine());
			pointHm.put(cr1 + "군", num);
		}
		arr.add(pointHm);
		System.out.println(arr);
	}
}
