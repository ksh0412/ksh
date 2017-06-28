package report.kimseunghun.r0010;

import java.util.HashMap;

public class Exam {

	public static void main(String[] args){
		HashMap<String,String> hm=new HashMap<String,String>();
		hm.put("test", "test");
		System.out.println(hm.containsKey("test"));
	}
}
