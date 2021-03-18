package project_shoppingmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_shoppingmall.dao.AdminDao;
import project_shoppingmall.dto.Admin;
import project_shoppingmall.util.JdbcConn;

public class AdminDaoImpl implements AdminDao {
	private static final AdminDaoImpl instance = new AdminDaoImpl();
	
	public static AdminDaoImpl getInstance() {
		return instance;
	}
	
	public AdminDaoImpl() {}


	@Override
	public List<Admin> selectAdminByAll() {
		 String sql ="select ad_id, ad_pass, ad_name from admin";
		 try(Connection con = JdbcConn.getConnection();
				 PreparedStatement pstmt = con.prepareStatement(sql);
				 ResultSet rs = pstmt.executeQuery()){
			 if(rs.next()) {
				 List<Admin> list = new ArrayList<>();
				 do {
					 list.add(getAdmin(rs));
				 }while(rs.next());
				 return list;
			 }
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Admin getAdmin(ResultSet rs) throws SQLException {
		String ad_id = rs.getString("ad_id");
		String ad_pass = rs.getString("ad_pass");
		String ad_name = rs.getString("ad_name");
		return new Admin(ad_id, ad_pass,ad_name);
	}

	@Override
	public Admin selectAdminById(Admin admin) {
		String sql = "select ad_id, ad_pass, ad_name from admin where ad_id = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, admin.getAd_id());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getAdmin(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertAdmin(Admin admin) {
		String sql = "insert into admin values(?, ?, ?)";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, admin.getAd_id());
			pstmt.setString(2, admin.getAd_pass());
			pstmt.setString(3, admin.getAd_name());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateAdmin(Admin admin) {
		String sql = "update admin set ad_pass = ? where ad_id =?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, admin.getAd_pass());
			pstmt.setString(2, admin.getAd_id());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAdmin(String admin) {
		String sql = "delete from admin where ad_id = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, admin);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
