package report.kimseunghun.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTypeExam4 {
	public static void main(String[] args){
		ArrayList<HashMap> arrList = new ArrayList<HashMap>();
		HashMap hm= new HashMap();
		hm.put("클래스","A");
		hm.put("이름", "홍길동");
		hm.put("나이", 20);
		hm.put("성별", "남자");
		arrList.add(hm);

		HashMap hm2= new HashMap();
		hm2.put("클래스","B");
		hm2.put("이름", "길정이");
		hm2.put("나이", 25);
		hm2.put("성별", "남자");
		arrList.add(hm2);

		HashMap hm3= new HashMap();
		hm3.put("클래스","C");
		hm3.put("이름", "홍길동");
		hm3.put("나이", 22);
		hm3.put("성별", "여자");
		arrList.add(hm3);
		
		HashMap hm4= new HashMap();
		hm4.put("클래스","D");
		hm4.put("이름", "동동이");
		hm4.put("나이", " "+5);
		hm4.put("성별", "여자");
		arrList.add(hm4);
		
		for(int i=0;i<arrList.size();i++){
		HashMap resultMap = arrList.get(i);
		System.out.print(resultMap.get("클래스")+", ");
		System.out.print(resultMap.get("이름")+", ");
		System.out.print(resultMap.get("나이")+",");
		System.out.println(resultMap.get("성별"));
	}
}
}
