package report.kimseunghun.r0010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapExam2 extends HashMap<String,Integer> {
	// HashMap을 상속받아주세요.
	// 키타입은 String, 벨류타입은 Integer로 선언해주세요.
	// 키는 아무거나 넣으셔도 되지만 벨류는 반드시 숫자만 입력하셔야 합니다.
	// 총 10개의 키값을 생성해주세요.
	// toString()함수를 오버라이딩 하여서
	// 해당 해쉬맵이 가지고 있는 전체 숫자를 더한값을 출력해주세요.

	public String toString() {
		String result = "";
		List<String> keyList = new ArrayList<String>(keySet());
		for (int i = 0; i < keyList.size(); i++) {
			String key = keyList.get(i);
			int sum=0;
			
		}
		
		return result;
	}

	public static void main(String[] args) {

	}
}
