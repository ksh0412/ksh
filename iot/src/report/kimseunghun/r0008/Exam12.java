package report.kimseunghun.r0008;

import report.kimseunghun.r0007.Exam11;

public class Exam12 extends Exam11 {
	
	Exam12(int a, int b){
		this.a=a;
		this.b=b;
	}
	
	public static void main(String[] args) {
		Exam12 e12 = new Exam12(1, 2);
		e12.getPlus();
		e12.printResult();
  
		e12 = new Exam12(2, 2);
		e12.getMinus();
		e12.printResult();

		e12 = new Exam12(3, 4);
		e12.getMultiple();
		e12.printResult();

		e12 = new Exam12(4, 2);
		e12.getDivision();
		e12.printResult();
	}
}
