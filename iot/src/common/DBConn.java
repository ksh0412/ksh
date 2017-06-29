package common;

public class DBConn {
	static int a=1;

	int getInt() throws Exception {
		int a = Integer.parseInt("str");
		return a;
	}

	public static void main(String[] args) {
		DBConn dbc = new DBConn();
		try {
			int a = dbc.getInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
