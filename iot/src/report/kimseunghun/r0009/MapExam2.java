package report.kimseunghun.r0009;

import java.util.HashMap;

public class MapExam2 {

	HashMap<String,Integer> hm;

	MapExam2() {
		hm = new HashMap<String,Integer>();
	}

	public static void main(String[] args) {
		MapExam2 me = new MapExam2();
		me.hm.put("1", 1);
	}
}