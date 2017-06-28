package report.kimseunghun.r0012;

import java.util.Scanner;

public class FunctionExam {
	Scanner scan = new Scanner(System.in);
	int[] arrNum = new int[5];
	int i=1;

	int getNumberFromString() {
		try {
			System.out.println(i+"번째 숫자를 넣어주세요");
			i++;
			return Integer.parseInt(scan.nextLine());
		} catch (Exception e) {
			System.out.println("누가 문자 넣으래!!");
			i--;
			return getNumberFromString();
		}
	}

//	public static void main(String[] args) {
//		FunctionExam ee3 = new FunctionExam();
//		for (int i = 0; i < ee3.arrNum.length; i++) {
//			ee3.arrNum[i] = ee3.getNumberFromString();
//		}
//	}
}