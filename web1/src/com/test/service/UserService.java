package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.common.DBConn2;

public class UserService {
	public String checkPwd(String pwd1, String pwd2) {
		if (pwd1.equals(pwd2)) {
			return "로그인성공";
		}
		return "비밀번호 틀림";
	}

	public String loginUser(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn2.getCon();
			String sql = "select userpwd from user_info where userid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("userid"));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String userpwd = rs.getString("userpwd");
				return checkPwd(userpwd, hm.get("userpwd"));
			}
		} catch (Exception e) {
		}
		return "그런 아이디 없다";
	}

	public boolean insertUser(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn2.getCon();
			String sql = "insert into user_info(userid, userpwd, username,age,address,hp1,hp2,hp3)";
			sql += "values(?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("userid"));
			ps.setString(2, hm.get("userpwd"));
			ps.setString(3, hm.get("username"));
			ps.setString(4, hm.get("age"));
			ps.setString(5, hm.get("address"));
			ps.setString(6, hm.get("hp1"));
			ps.setString(7, hm.get("hp2"));
			ps.setString(8, hm.get("hp3"));
			int result = ps.executeUpdate();
			if (result == 1) {
				con.commit();
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean deleteUser(String usernum) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConn2.getCon();
			String sql = "delete from user_info";
			sql += " where usernum=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, usernum);
			int result = ps.executeUpdate();
			if (result == 1) {
				con.commit();
				return true;
			}
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean updateUser(String user_num) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConn2.getCon();
			String sql = "update user_info";
			sql += " set age=30 where num=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, user_num);

			int result = ps.executeUpdate();
			if (result == 1) {
				con.commit();
				return true;
			}
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public List<Map> selectUser(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn2.getCon();
			String sql = "select usernum,userid,userpwd,username,age,address,hp1,hp2,hp3 from user_info";
			if (hm.get("username") != null) {
				sql += " where username like ?";
			}

			ps = con.prepareStatement(sql);
			if (hm.get("username") != null) {
				ps.setString(1, hm.get("username"));
			}
			ResultSet rs = ps.executeQuery();
			List userList = new ArrayList();
			while (rs.next()) {
				HashMap hm1 = new HashMap();
				hm1.put("usernum", rs.getString("usernum"));
				hm1.put("userid", rs.getString("userid"));
				hm1.put("userpwd", rs.getString("userpwd"));
				hm1.put("username", rs.getString("username"));
				hm1.put("age", rs.getString("age"));
				hm1.put("address", rs.getString("address"));
				hm1.put("hp1", rs.getString("hp1"));
				hm1.put("hp2", rs.getString("hp2"));
				hm1.put("hp3", rs.getString("hp3"));
				userList.add(hm1);
			}
			return userList;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}