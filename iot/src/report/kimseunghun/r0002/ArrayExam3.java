package report.kimseunghun.r0002;

public class ArrayExam3 {
	public int[] getArrayVar(int initNum, int maxNum) {
		int[] a = new int[maxNum - initNum];
		for (int i = initNum - initNum; i < maxNum - initNum; i++) {
			a[i] = i;
		}
		return a;
	}

	public void printArrayVar(int[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			System.out.println("a의" + i + "번째 방의 값= " + a[i]);
		}
	}

	public static void main(String[] args) {
		ArrayExam3 ae3 = new ArrayExam3();
		int[] a = ae3.getArrayVar(5, 10);
		ae3.printArrayVar(a);

	}
}