package report.kimseunghun.r0013;

public class User {
	private InterfaceExam ie;

	User(String operator) {
		if (operator.equals("+")) {
			ie = new Plus();
		} else if (operator.equals("-")) {
			ie = new Minus();

		} else if (operator.equals("*")) {
			ie = new Multiple();
		} else if (operator.equals("/")) {
			ie = new Division();
		} else {
			System.out.println("넘마 연산자 잘못입력했어 임마!!");
		}
	}

	public InterfaceExam getInterfaceExam() {
		return ie;
	}

	public static void main(String[] args) {
		User u = new User("+");
		InterfaceExam ie2 = u.getInterfaceExam();
		ie2.setString("아아아");
		int result = ie2.cal(3, 4);
		System.out.println(result);

		u = new User("-");
		ie2 = u.getInterfaceExam();
		result = ie2.cal(3, 4);
		System.out.println(result);

		u = new User("*");
		ie2 = u.getInterfaceExam();
		result = ie2.cal(3, 4);
		System.out.println(result);

		u = new User("/");
		ie2 = u.getInterfaceExam();
		result = ie2.cal(3, 4);
		System.out.println(result);
	}

	// public static void main(String[] args) {
	// InterfaceExam ie = new Exam();
	// InterfaceExam ie2 = new Test();
	//
	// String str = ie.getString();
	// System.out.println(str);
	// String str2 = ie2.getString();
	// System.out.println(str2);
	//
	// InterfaceExam2 ie3 = new Test();
	// int a = ie3.getInt();
	// System.out.println(a);
	// ie3.setInt(a);
	// }
}