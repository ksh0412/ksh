package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.common.DBConn2;
import com.test.dto.TestPage;

public class TestPageService {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<TestPage> selectTestPageList(TestPage pTp) {
		try {
			con = DBConn2.getCon();

			String sql = "select * from testPage";
			sql+= " limit ?,10";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pTp.getStartRow());
			rs = ps.executeQuery();
			List<TestPage> tpList = new ArrayList<TestPage>();
			while (rs.next()) {
				TestPage tp = new TestPage();
				tp.setTnum(rs.getInt("tnum"));
				tp.setTname(rs.getString("tname"));
				tp.setTinfo(rs.getString("tinfo"));
				tp.setThome(rs.getString("thome"));
				tp.setTph(rs.getString("tph"));
				tpList.add(tp);
			}
			System.out.println("getstart="+pTp.getStartRow());
			return tpList;
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
	
	public int countRow(){
		try {
			con = DBConn2.getCon();

			String sql = "select count(1) from testPage";

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
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
		return 0;
	}
}
