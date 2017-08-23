package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DBConn2;
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;

public class VendorServiceImpl implements VendorService {
	
	public List<Vendor> selectVendorList(Vendor pVendor){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBConn2.getCon();

			String sql="select * from vendor_info";
			if(pVendor.getViName()!=null){
				sql += " where viname like ?";
			}
			ps = con.prepareStatement(sql);
			if(pVendor.getViName()!=null){
				ps.setString(1, "%" + pVendor.getViName() + "%");
			}
			rs = ps.executeQuery();
			
			List<Vendor> vendorList=new ArrayList<Vendor>();
			while(rs.next()){
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("videsc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viphone"));
				vendorList.add(vendor);
			}
			return vendorList;
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
	public Vendor selectVendor(Vendor pVendor) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBConn2.getCon();

			String sql = "select * from vendor_info"
					+ " where vinum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pVendor.getViNum());
			System.out.println(pVendor.getViNum());
			rs = ps.executeQuery();

			while (rs.next()) {
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("videsc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viphone"));
				return vendor;
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
		return null;
	}
	
	public Goods selectGoods(Goods pGoods) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBConn2.getCon();

			String sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname from goods_info gi, vendor_info vi"
					+ " where gi.vinum=vi.vinum and gi.ginum=?";
										
			Page page = pGoods.getPage();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pGoods.getGiNum());
			
			rs = ps.executeQuery();
				while (rs.next()) {
				Goods goods = new Goods();
				goods.setGiNum(rs.getInt("ginum"));
				goods.setGiName(rs.getString("giname"));
				goods.setGiDesc(rs.getString("gidesc"));
				goods.setViNum(rs.getInt("vinum"));
				goods.setViName(rs.getString("viname"));
				return goods;
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
		return null;
	}
	
	public int insertVendor(Vendor pVendor) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBConn2.getCon();

			String sql = "insert into vendor_info(viname,videsc,viaddress,viphone,vicredat,vicretim)"
					+ " values(?,?,?,?,DATE_FORMAT(NOW(),'%Y%m%d'),DATE_FORMAT(NOW(),'%H%i%s'))";
										
			ps = con.prepareStatement(sql);
			ps.setString(1, pVendor.getViName());
			ps.setString(2, pVendor.getViDesc());
			ps.setString(3, pVendor.getViAddress());
			ps.setString(4, pVendor.getViPhone());
			int result = ps.executeUpdate();
			con.commit();
			return result;
				
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
	
	public int deleteVendor(Vendor pVendor) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBConn2.getCon();

			String sql = "delete from vendor_info where vinum=?";
										
			ps = con.prepareStatement(sql);
			ps.setInt(1, pVendor.getViNum());
			int result = ps.executeUpdate();
			con.commit();
			return result;
				
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
	
	public int updateVendor(Vendor pVendor) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBConn2.getCon();

			String sql = "update vendor_info set viname=?, videsc=?, viaddress=?, viphone=? where vinum=?";
										
			ps = con.prepareStatement(sql);
			ps.setString(1, pVendor.getViName());
			ps.setString(2, pVendor.getViDesc());
			ps.setString(3, pVendor.getViAddress());
			ps.setString(4, pVendor.getViPhone());
			ps.setInt(5, pVendor.getViNum());
			int result = ps.executeUpdate();
			con.commit();
			return result;
				
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
	
	public int getTotalCount(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try{
			String sql = "select count(1)"
					+ " from goods_info as gi, vendor_info as vi"
					+ " where gi.vinum = vi.vinum";
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			if(pGoods.getViNum()!=0 && pGoods.getGiName()==null){
				ps.setInt(1, pGoods.getViNum());
			}else if(pGoods.getGiName()!=null && pGoods.getViNum()==0){
				ps.setString(2, pGoods.getGiName());
			}else if(pGoods.getGiName()!=null && pGoods.getViNum()!=0){
				ps.setInt(1, pGoods.getViNum());
				ps.setString(2, pGoods.getGiName());
			}
			ResultSet rs = ps.executeQuery();
			List<Goods> goodsList = new ArrayList<Goods>();
			while(rs.next()){
				return rs.getInt(1);
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				DBConn2.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int writeNumber(){
		Connection con = null;
		PreparedStatement ps = null;
		try{
			String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'iot' AND   TABLE_NAME   = 'vendor_info'";
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				DBConn2.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return 0;
	}
}