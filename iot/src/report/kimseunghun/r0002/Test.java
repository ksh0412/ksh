package report.kimseunghun.r0002;

public class Test {

	public void printMultipleTable(int initNum, int maxNum) {
		System.out.println("시작값" + initNum + "," + "끝값" + maxNum);
		for (int i = initNum; i <= maxNum; i++) {
			int a = 1;
			for (a = initNum; a <= (maxNum - 1); a++) {
				System.out.print(i + "X" + a + "=" + (i * a) + " ");
			}
			System.out.println(i + "X" + a + "=" + (i * a));
		}
	}

	public static void main(String[] args) {
		Test t1 = new Test();
		t1.printMultipleTable(2, 6);

	}
}
