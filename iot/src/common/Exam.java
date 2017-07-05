package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Exam {
	public List<String> getUserIDLists(String name) {
		List<String> userlist = new ArrayList<String>();
		try {
			Connection con = DBConn2.getCon();
			String sql = "select id,pwd,name,age,class_num from user";
			if (!name.equals("")) {
				sql += " where name =?";// 띄어쓰기
			}
			PreparedStatement prestmt = con.prepareStatement(sql);
			if (!name.equals("")) {
				prestmt.setString(1, name);
			}
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()) {
				userlist.add(
						rs.getString("id") + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4)+ "," + rs.getString(5));
			}
			DBConn2.closeCon();
			return userlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertUser() {
		try {
			Scanner scan = new Scanner(System.in);
			HashMap<String, String> hm = new HashMap<String, String>();
			System.out.println("id를 입력하세요> ");
			hm.put("id", scan.nextLine());
			System.out.println("pwd를 입력하세요> ");
			hm.put("pwd", scan.nextLine());
			System.out.println("이름을 입력하세요> ");
			hm.put("name", scan.nextLine());
			System.out.println("나이를 입력하세요> ");
			hm.put("age", scan.nextLine());
			System.out.println("클래스를 입력하세요> ");
			hm.put("class_num", scan.nextLine());
			Connection con = DBConn2.getCon();
			String sql = "insert into user(id,pwd,name,age,class_num)values(?,?,?,?,?)";
			PreparedStatement prestmt = con.prepareStatement(sql);
			prestmt.setString(1, hm.get("id"));
			prestmt.setString(2, hm.get("pwd"));
			prestmt.setString(3, hm.get("name"));
			prestmt.setString(4, hm.get("age"));
			prestmt.setString(5, hm.get("class_num"));
			int result = prestmt.executeUpdate();
			DBConn2.closeCon();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUser() {
		try {
			Connection con = DBConn2.getCon();
			String sql = "update user set id='red' where num='8'";
			PreparedStatement prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate();
			DBConn2.closeCon();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser() {
		try {
			Connection con = DBConn2.getCon();
			Scanner scan = new Scanner(System.in);
			String sql = "delete from user where num='" + scan.nextLine() + "'";
			PreparedStatement prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate();
			DBConn2.closeCon();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		Exam e = new Exam();
		e.insertUser();
		List<String> userList = e.getUserIDLists("");
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
		}
	}
	// DBConn dbc = new DBConn();
	// dbc.a = 3;
	// System.out.println(dbc.a);
	// System.out.println(DBConn.a);
	// DBConn.a = 4;
	// System.out.println(dbc.a);
	// dbc=new DBConn();
	// System.out.println(dbc.a);
	// http://central.maven.org/maven2/com/google/guava/guava/16.0.1/guava-16.0.1.jar
}
