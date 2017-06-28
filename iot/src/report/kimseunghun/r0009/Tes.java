package report.kimseunghun.r0009;

import java.util.Scanner;

public class Tes {
	public int aa(int[] arr,int num){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==num){
				return i+1;
			}
		}
		return -1;
	}

	public static void main(String[] args){
		int[] a= new int[5];
		int[] a1 = new int[5];
		int sum=0;
		for(int i=0;i<a.length;i++){
			Scanner scan = new Scanner(System.in);
			System.out.print("학생"+(i+1)+"의 점수는> ");
			String str= scan.nextLine();
			a[i]=Integer.parseInt(str);
			a1[i]=Integer.parseInt(str);
			sum+=a[i];
		}
		System.out.println("총합"+sum);
		System.out.println("평균"+sum/a.length);
		
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]>a[j] && j<a.length){
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		Tes t = new Tes();
		for(int i=0;i<a.length;i++){
		System.out.print((5-i)+"등의 점수는"+ a[i]);
		System.out.println(", "+ t.aa(a1, a[i])+"번째 입력" );
	}
}
}