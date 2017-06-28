package report.kimseunghun.r0006;

public class Son extends Father{
	int a;
	
	/*int getAget(){ //오버라이딩
		age =25;
		return age;
	}*/

	public static void main(String[] args) {
		Son s = new Son();
		s.a = 3;
		//System.out.println(s.address);
		System.out.println(s.getAge());
		Father f = new Father();
		System.out.println(s.getAdress());
		s.setName("ㅇㅇㅇ");
		System.out.println(s.getName());
	}
}
