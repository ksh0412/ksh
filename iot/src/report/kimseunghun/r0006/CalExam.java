package report.kimseunghun.r0006;

import java.util.Scanner;

public class CalExam {
	// 반복문을 사용하여 Scanner클래스를 이용해
	// 총 10명의 핵생의 점수를 받아주세요.
	// 10명의 학생의 총점과 평균을 구해주세요.
	Scanner scan = new Scanner(System.in);

	public int[] point() {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++) {
			System.out.print("학생" + (i + 1) + "의 점수를 입력해주세요:");
			String str = scan.nextLine();
			a[i] = Integer.parseInt(str);
		}
		return a;
	}

	int pointPlus(int[] a) {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += a[i];
		}
		System.out.println("총합:" + sum);
		return sum;
	}

	void division(double sum) {
		System.out.println("평균:" + sum / 10);

	}

	void printPoint(int[] a) {
		int temp;
		int i;
		for (i = 0; i < 10; i++) {
			for (int j = i + 1; j < 10; j++) {
				if (a[i] < a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			System.out.println("학생" + (i + 1) + "의 점수:" + a[i]);
		}
	}
	int getIndexArray(int[] a, int num){
		for(int i=0;i<a.length;i++){
			if(a[i]==num){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		CalExam ce = new CalExam();
		int[] a = ce.point();
		ce.printPoint(a);
		double sum = ce.pointPlus(a);
		ce.division(sum);
	}

}
