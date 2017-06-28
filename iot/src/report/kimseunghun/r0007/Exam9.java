package report.kimseunghun.r0007;

import java.util.Scanner;

public class Exam9 {

	private int a;
	private int b;
	private int result;
	Scanner scan = new Scanner(System.in);
	
	
	/*Exam9(){
		System.out.print("초기값을 입력해주세요>");
		this.a=Integer.parseInt(scan.nextLine());
		System.out.print("맥스값을 입력해주세요>");
		this.b=Integer.parseInt(scan.nextLine());
	}*/
	public int getA(){
		System.out.print("초기값을 입력해주세요> ");
		this.a=Integer.parseInt(scan.nextLine());
		return this.a;
	}
	public int getB(){
		System.out.print("맥스값을 입력해주세요> ");
		this.b=Integer.parseInt(scan.nextLine());
		return this.b;
	}

	public int doLoop(){
	for(int i=a;i<=b;i++){
		this.result +=i;
	}
	return this.result;
}
	public void print(){
			System.out.println(this.result);
		}
	}