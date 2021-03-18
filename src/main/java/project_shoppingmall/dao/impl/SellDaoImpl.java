package project_shoppingmall.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_shoppingmall.dao.SellDao;
import project_shoppingmall.dto.Product;
import project_shoppingmall.dto.Sell;
import project_shoppingmall.dto.User_Info;
import project_shoppingmall.util.JdbcConn;

public class SellDaoImpl implements SellDao {
	private static final SellDaoImpl instance = new SellDaoImpl();
	
	public static SellDaoImpl getInstance() {
		return instance;
	}
	public SellDaoImpl() {}
	
	@Override
	public List<Sell> selectSellByAll() {
		String sql = "select sell_no, sell_date, user_no, p_code, sellqty, orderat from sell";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Sell> list = new ArrayList<>();
				do {
					list.add(getSell(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Sell getSell(ResultSet rs) throws SQLException {
		int sell_no = rs.getInt("sell_no");
		Date sell_date = rs.getDate("sell_date");
		User_Info user_no = new User_Info(rs.getString("user_no"));
		Product p_code = new Product(rs.getString("p_code"));
		int sellqty = rs.getInt("sellqty");
		int orderat = rs.getInt("orderat");
		
		try {
			user_no.setUser_no(rs.getString("user_no"));
		}catch(SQLException e) {}
		try {
			p_code.setP_code(rs.getString("p_code"));
		}catch(SQLException e) {}
		
		return new Sell(sell_no, sell_date, user_no, p_code, sellqty, orderat);
	}
	
	@Override
	public List<Sell> selectSellByUser_No(User_Info user_info) {
		String sql = "select sell_no, sell_date, ui.user_no ,p_code,sellqty, orderat from sell s\r\n" + 
				"	join user_info ui on s.user_no = ui.user_no where ui.user_no = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, user_info.getUser_no());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					List<Sell> list = new ArrayList<>();
					do {
						list.add(getSell(rs));
					}while(rs.next());
					return list;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Sell selectSellAloneByUser_No(Sell sell) {
		String sql = "select sell_no, sell_date, ui.user_no ,p_code,sellqty, orderat from sell s\r\n" + 
				"	join user_info ui on s.user_no = ui.user_no where ui.user_no = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, sell.getUser_no().getUser_no());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getSell(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertSell(Sell sell) {
		String sql = "insert into sell values (?, ?, ?, ?, ?, ?)";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, sell.getSell_no());
			pstmt.setDate(2, sell.getSell_date());
			pstmt.setString(3, sell.getUser_no().getUser_no());
			pstmt.setString(4, sell.getP_code().getP_code());
			pstmt.setInt(5, sell.getSellqty());
			pstmt.setInt(6, sell.getOrderat());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateSell(Sell sell) {
		String sql = "update sell set sell_no = ?, sell_date = ?, user_no = ?,\r\n" + 
				"	p_code = ?, sellqty =? ,orderat =? where sell_no =?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, sell.getSell_no());
			pstmt.setDate(2, sell.getSell_date());
			pstmt.setString(3, sell.getUser_no().getUser_no());
			pstmt.setString(4, sell.getP_code().getP_code());
			pstmt.setInt(5, sell.getSellqty());
			pstmt.setInt(6, sell.getOrderat());
			pstmt.setInt(7, sell.getSell_no());
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteSell(int sell) {
		String sql = "delete from sell where sell_no = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, sell);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
