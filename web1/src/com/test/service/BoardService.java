package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import com.test.common.DBConn2;

public class BoardService {
	public boolean insertBoard(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn2.getCon();
			String sql = "insert into board(title,content,writer)";
			sql += "values(?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("title"));
			ps.setString(2, hm.get("content"));
			ps.setString(3, hm.get("writer"));
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
		return false;
	}
	
	public boolean deleteUser(String writer) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConn2.getCon();
			String sql = "delete from board";
			sql += " where writer=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, writer);
			int result = ps.executeUpdate();
			if(result==1){
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
		return false;
	}
	
	public boolean updateUser(String writer) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConn2.getCon();
			String sql = "update board";
			sql += " set content=30 where writer=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, writer);
			
			int result = ps.executeUpdate();
			if(result==1){
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
		return false;
	}
	
	public boolean selectUser(String num) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn2.getCon();
			String sql = "select * from board";
			sql += " where num = ?";

			ps = con.prepareStatement(sql);
			ps.setString(1, num);
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
}
