package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.DBConn2;

public class TestDAO {

	public boolean insertTest() throws Exception {
		try {
			Connection con = DBConn2.getCon();
			String sql = "insert in Test(title,content,writer,reg_date)";
			sql+=" values(?,?,?,now())";
			PreparedStatement prestmt = con.prepareStatement(sql);
			prestmt.setString(1, "게시물3");
			prestmt.setString(2, "내용3");
			prestmt.setString(3, "3");
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

	public List<HashMap> selectTest() {
		List<HashMap> userlist = new ArrayList<HashMap>();
		try {
			Connection con = DBConn2.getCon();
			String sql = "select ci.*,ui.id,ui.name from user_info as ui, test as ci";
			sql +=" where ui.num=ci.writer;";
			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			while (rs.next()) {
				HashMap hm = new HashMap();
				int colCount = rsmd.getColumnCount();
				for(int i=1;i<=colCount;i++){
					String colName=rsmd.getColumnName(i);
					hm.put(colName, rs.getString(colName));
				}
				userlist.add(hm);
			}
			DBConn2.closeCon();
			return userlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateTest() throws Exception {
		try {
			Connection con = DBConn2.getCon();
			String sql = "update Test set ";
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

	public boolean deleteTest() throws Exception {
		try {
			Connection con = DBConn2.getCon();
			String sql = "delete from test where num=4 ";
			PreparedStatement prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate();
			DBConn2.closeCon();
			if (result == 1) {
				return true;
			}else{
				System.out.println("XX");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
}
	public static void main(String[] args) throws Exception{
		TestDAO td=new TestDAO();
//		System.out.println(td.selectTest());
//		Date d=new Date();
//		System.out.print(d);
		td.deleteTest();
		List<HashMap> list= td.selectTest();
		for(HashMap m:list){
			System.out.println(m);
		}
	}
}
