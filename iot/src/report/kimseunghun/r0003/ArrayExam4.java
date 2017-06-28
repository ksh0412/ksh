package report.kimseunghun.r0003;

public class ArrayExam4 {
	public static void main(String[] args) {
		int[] a = new int[10];

		for (int i = 10; i >= 1; i--) {
			a[10 - i] = (i) * 2;
		}
		for (int i = 0; i <= 9; i++) {
			System.out.println(a[i]);
		}
	}
}