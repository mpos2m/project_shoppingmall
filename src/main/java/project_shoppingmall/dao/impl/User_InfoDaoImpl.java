package project_shoppingmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_shoppingmall.dao.User_InfoDao;
import project_shoppingmall.dto.Grade;
import project_shoppingmall.dto.User_Info;
import project_shoppingmall.util.JdbcConn;

public class User_InfoDaoImpl implements User_InfoDao {
	private static final User_InfoDaoImpl instance = new User_InfoDaoImpl();
	
	public static User_InfoDaoImpl getInstance() {
		return instance;
	}
	
	public User_InfoDaoImpl() {}
	
	@Override
	public List<User_Info> selectUser_InfoByAll() {
		String sql = "select user_no, user_id, user_pass, user_name, user_birth, user_phone,\r\n" + 
				"	user_address,user_sex,upass_find, upass_answer, user_totalp, grade\r\n" + 
				"	from user_info ";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<User_Info> list = new ArrayList<>();
				do {
					list.add(getUser_Info(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private User_Info getUser_Info(ResultSet rs) throws SQLException {
		String user_no = rs.getString("user_no");
		String user_id = rs.getString("user_id");
		String user_pass = rs.getString("user_pass");
		String user_name = rs.getString("user_name");
		String user_birth = rs.getString("user_birth");
		String user_phone = rs.getString("user_phone");
		String user_address = rs.getString("user_address");
		String user_sex = rs.getString("user_sex");
		String upass_find = rs.getString("upass_find");
		String upass_answer = rs.getString("upass_answer");
		int user_totalp = rs.getInt("user_totalp");
		Grade grade = null;
		try {
			grade = new Grade(rs.getString("grade"));
		}catch(SQLException e) {}
	
		return new User_Info(user_no, user_id, user_pass, user_name, user_birth, user_phone
				, user_address, user_sex, upass_find, upass_answer, user_totalp, grade);
	}

	@Override
	public User_Info selectUser_InfoByUser_Id(User_Info user_info) {
		String sql = "select user_no, user_id, user_pass, user_name, user_birth, user_phone,\r\n" + 
				"	user_address,user_sex,upass_find, upass_answer, user_totalp, grade\r\n" + 
				"	from user_info where user_id = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, user_info.getUser_id());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getUser_Info(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertUser_Info(User_Info user_info) {
		String sql = "insert into user_info values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, user_info.getUser_no());
			pstmt.setString(2, user_info.getUser_id());
			pstmt.setString(3, user_info.getUser_pass());
			pstmt.setString(4, user_info.getUser_name());
			pstmt.setString(5, user_info.getUser_birth());
			pstmt.setString(6, user_info.getUser_phone());
			pstmt.setString(7, user_info.getUser_address());
			pstmt.setString(8, user_info.getUser_sex());
			pstmt.setString(9, user_info.getUpass_find());
			pstmt.setString(10, user_info.getUpass_answer());
			pstmt.setInt(11, user_info.getUser_totalp());
			pstmt.setString(12, user_info.getGrade().getGrade());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUser_Info(User_Info user_info) {
		String sql = "update user_info set user_pass = ? where user_id = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, user_info.getUser_pass());
			pstmt.setString(2, user_info.getUser_id());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUser_Info(String user_info) {
		String sql = "delete from user_info where user_id = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, user_info);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
