package report.kimseunghun.r0010;

import java.util.HashMap;


public class MapExam extends HashMap {

	
	public String put(String key){
		if(!containsKey(key)){
			put(key,"test");
			return "잘들어 갔어요";
		}
		return "이미 있어 임마";
	}
	public static void main(String[] args){
		MapExam me = new MapExam();
		me.put("A군",50);
		me.put("B군", 60);
		System.out.println(me);
	}
}
