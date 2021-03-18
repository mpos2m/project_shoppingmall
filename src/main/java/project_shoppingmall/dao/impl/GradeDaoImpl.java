package project_shoppingmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_shoppingmall.dao.GradeDao;
import project_shoppingmall.dto.Grade;
import project_shoppingmall.util.JdbcConn;

public class GradeDaoImpl implements GradeDao {
	private static final GradeDaoImpl instance = new GradeDaoImpl();
	
	public static GradeDaoImpl getInstance() {
		return instance;
	}
	
	public GradeDaoImpl() {}
	
	@Override
	public List<Grade> selectGradeByAll() {
		String sql = "select grade , totalp from grade order by totalp asc";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Grade> list = new ArrayList<>();
				do {
					list.add(getGrade(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Grade getGrade(ResultSet rs) throws SQLException {
		String grade = rs.getString("grade");
		int totalp = rs.getInt("totalp");
		return new Grade(grade, totalp);
	}

	@Override
	public Grade selectGradeByGrade(Grade grade) {
		String sql = "select grade, totalp from grade where grade = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, grade.getGrade());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getGrade(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertGrade(Grade grade) {
		String sql = "insert into grade values(?, ?)";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, grade.getGrade());
			pstmt.setInt(2, grade.getTotalp());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateGrade(Grade grade) {
		String sql = "update grade set totalp = ? where grade = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, grade.getTotalp());
			pstmt.setString(2, grade.getGrade());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteGrade(String grade) {
		String sql = "delete from grade where grade =?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, grade);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
