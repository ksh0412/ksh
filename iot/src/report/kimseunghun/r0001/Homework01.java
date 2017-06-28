package report.kimseunghun.r0001;

public class Homework01 {
	int a = 0;
	int b = 0;
	int c = 0;
	int cnt = 0;

	public void printLoop() {
		for (int i = a; i <= b; i++) {
			cnt++;
			if (cnt % c == 0) {
				System.out.println(i);
			} else {
				System.out.print(i+",");
			}
		}
	}

	public void printLoopReverse() {
		for (int i = a; i >= b; i--) {
			cnt++;
			if (cnt % c == 0) {
				System.out.println(i);
			} else {
				System.out.print(i+",");
			}
		}
	}

	public static void main(String[] args) {
		Homework01 t2 = new Homework01();
		t2.a = 3;
		t2.b = 15;
		t2.c = 3;
		t2.printLoop();

		t2.a = 5;
		t2.b = 1;
		t2.printLoopReverse();
	}
}