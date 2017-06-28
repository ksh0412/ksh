package report.kimseunghun.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTypeExam6 {
	public static void main(String[] args) {
		ArrayList<HashMap> alList = new ArrayList<HashMap>();
		DataTypeExam5 dte5 = new DataTypeExam5();
		for (int i = 0; i < 10; i++) {
			HashMap hm = dte5.getHashMap();
			alList.add(hm);
		}
		for (HashMap hm1 : alList) {
			System.out.print(hm1.get("클래스") + ", ");
			System.out.print(hm1.get("이름") + ", ");
			System.out.print(hm1.get("나이") + ", ");
			System.out.println(hm1.get("성별"));
		}
	}
}