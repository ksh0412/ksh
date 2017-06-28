package report.kimseunghun.r0003;

public class ArrayExam5 {
	public static void main(String[] args) {
		// int[] a = new int[10];
		// for (int i = 0; i <= 9; i++) {
		// a[i] = 10 - i;
		// System.out.println(a[i]);

		int[] a = new int[6];
		int random = (int) (Math.random() * 45) + 1;

		for (int i = 0; i < a.length; i++) {
			random = (int) (Math.random() * 45) + 1;
			a[i] = random;
			for (int j = i; j >= 0; j--) {
				if (a[i] == a[j] && i != j) {
					i--;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println((i + 1) + "번째 로또번호:" + a[i]);
		}
		// int[] a=new int[6];
		// for(int i=0;i<6;i++){
		// int random=(int)(Math.random()*45)+1;
		// a[i]=random;
		// System.out.println((i+1)+"번째 로또번호는:"+a[i]);
		// for(int j=i+1;j>0;j--){
		// if(a[j]==a[i]){
		// a[i]=random=(int)Math.random()*45+1;
		// }
		// }
		// }
	}
}