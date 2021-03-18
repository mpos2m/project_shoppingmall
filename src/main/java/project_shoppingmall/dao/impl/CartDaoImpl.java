package project_shoppingmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_shoppingmall.dao.CartDao;
import project_shoppingmall.dto.Cart;
import project_shoppingmall.dto.Product;
import project_shoppingmall.dto.User_Info;
import project_shoppingmall.util.JdbcConn;

public class CartDaoImpl implements CartDao {
	private static final CartDaoImpl instance = new CartDaoImpl();
	
	public static CartDaoImpl getInstance() {
		return instance;
	}
	
	public CartDaoImpl() {}
	
	@Override
	public List<Cart> selectCartByAll() {
		String sql = "select cart_no, user_no, p_code, cartqty from cart";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Cart> list = new ArrayList<>();
				do {
					list.add(getCart(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Cart getCart(ResultSet rs) throws SQLException {
		int cart_no = rs.getInt("cart_no");
		User_Info user_no = new User_Info(rs.getString("user_no"));
		Product p_code = new Product(rs.getString("p_code"));
		int cartqty = rs.getInt("cartqty");
		
		try {
			user_no.setUser_no(rs.getString("user_no"));
		}catch(SQLException e) {}
		try {
			p_code.setP_code(rs.getString("p_code"));
		}catch(SQLException e) {}
		return new Cart(cart_no, user_no, p_code, cartqty);
	}

	@Override
	public List<Cart> selectCartByUser_No(User_Info user_info) {
		String sql = "select cart_no, ui.user_no, p_code, cartqty from cart c join user_info ui on c.user_no = ui.user_no where ui.user_no = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, user_info.getUser_no());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					List<Cart> list = new ArrayList<>();
					do {
						list.add(getCart(rs));
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
	public int insertCart(Cart cart) {
		String sql = "insert into cart values (?, ?,?,?)";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, cart.getCart_no());
			pstmt.setString(2, cart.getUser_no().getUser_no());
			pstmt.setString(3, cart.getP_code().getP_code());
			pstmt.setInt(4, cart.getCartqty());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateCart(Cart cart) {
		String sql = "update cart set cart_no =?, user_no =?, p_code =?, cartqty =? where cart_no = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, cart.getCart_no());
			pstmt.setString(2, cart.getUser_no().getUser_no());
			pstmt.setString(3, cart.getP_code().getP_code());
			pstmt.setInt(4, cart.getCartqty());
			pstmt.setInt(5, cart.getCart_no());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteCart(int Cart) {
		String sql = "delete from cart where cart_no = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, Cart);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
