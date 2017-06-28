package report.kimseunghun.r0004;

import java.util.Scanner;

public class CalPoint {
	Scanner scan = new Scanner(System.in);

	public int[] getInput() {
		int[] a = new int[6];
		for (int i = 0; i <a.length; i++) {
			System.out.print("학생" + (i+1) + "의 점수를 입력하세요>");
			String input = scan.nextLine();
			a[i] = Integer.parseInt(input);
		}
		return a;
	}

	public void printPoint(int[] a) {
		for (int i = 0; i <= 5; i++) {
			for (int j = i + 1; j <= 5; j++) {
				if (a[i] > a[j]) {
					int temp = 0;
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			System.out.println((6 - i) + "등의 점수 : " + a[i]);
		}
	}

	public int pointPlus(int[] a) {
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += a[i];
		}
		System.out.println("학생들의 총점: " + sum);
		return sum;
	}

	public double pointAverage(int[] a, double sum) {
		double avr = 0;
		avr = sum / 6;
		System.out.println("학생들의 평균: " + avr);
		return avr;
	}

	public static void main(String[] args) {
		CalPoint cal = new CalPoint();
		int[] a = cal.getInput();
		cal.printPoint(a);
		int sum = cal.pointPlus(a);
		cal.pointAverage(a, sum);
	}

}
