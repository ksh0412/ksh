package report.kimseunghun.r0003;

public class ArrayExam6 {
	public int[] getArrVar(int length, int initNum, int maxNum) {
		int[] a = new int[length];
		for (int i = initNum; i <= maxNum; i++) {
			a[i] = (i + 1) * 2;
		}
		return a;
	}

	public void printArrVar(int[] a) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(a[i - 1]);
		}
	}

	public static void main(String[] args) {
		ArrayExam6 ae = new ArrayExam6();
		int[] a = ae.getArrVar(10, 0, 9);
		ae.printArrVar(a);
	}
}
	/*int[] a = new int[10];

	public void Array(int b, int c) {
		for (int i = b; i <= c; i++) {
			a[10 - i] = i * 2;
		}
	}

	public void Array2(int b, int c) {
		for (int i = b; i <= c; i++) {
			System.out.println(a[i - 1]);
		}
	}

	public static void main(String[] args) {
		ArrayExam6 ar = new ArrayExam6();
		ar.Array(1, 10);
		ar.Array2(1, 10);
	}*/

