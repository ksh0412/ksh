package report.kimseunghun.r0006;

public class NewExam {
	public static void main(String[] args) {
		String str1 = "a"; //주소값저장
		String str2 = "a"; //주소값저장
		System.out.println(str1 == str2); //같은 주소값
		str1 = new String("b"); //new로 주소값 초기화 후 저장
		str2 = new String("b"); //new로 새로운 주소값 초기화 후 저장
		System.out.println(str1 == str2); //다른 주소값
	}
}