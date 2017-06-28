package report.kimseunghun.r0006;

public class Exam2 {
	
	String print(){
		for(int i=0;i<10;i++){
			if(i==4){
				System.out.println( "ㅇㅇ");
			}else if(i!=4){
				System.out.println("ㄴㄴ");
			}
		}
		return "aa";
	}
	public static void main(String[]args){
		for(int i=0;i<10;i++){
			if(i==4){
				System.out.println("ㅇㅇ");
			}
		}
	}

}
