package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAO {
	public List<HashMap> doSelect(String sql) {
		List<HashMap> userlist = new ArrayList<HashMap>();
		try {
			Connection con = DBConn2.getCon();
			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			System.out.println(rsmd.getColumnName(1));
			System.out.println(rsmd.getColumnCount());
			while (rs.next()) {
				HashMap hm = new HashMap();
				int colCount=rsmd.getColumnCount();
				for(int i=1;i<=colCount;i++){
					String colName=rsmd.getColumnName(i); //i번째에 있는 칼럼 이름을 읽음
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

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		String sql = "select num, id, pwd, name, age from user order by name desc";
		List<HashMap> userList = ud.doSelect(sql);
		System.out.println("유저 리스트->" + userList);
		sql = "select num, id, pwd, name, age from user_info";
		userList = ud.doSelect(sql);
		System.out.println("유저 인포리스트->" + userList);
	}
}
