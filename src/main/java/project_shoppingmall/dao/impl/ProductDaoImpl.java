package project_shoppingmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_shoppingmall.dao.ProductDao;
import project_shoppingmall.dto.Product;
import project_shoppingmall.util.JdbcConn;

public class ProductDaoImpl implements ProductDao {
	private static final ProductDaoImpl instance = new ProductDaoImpl();
	
	public static ProductDaoImpl getInstace() {
		return instance;
	}
	
	public ProductDaoImpl() {}

	@Override
	public List<Product> selectProductByAll() {
		String sql = "select p_code, p_name, p_price, p_stock from product";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Product> list = new ArrayList<>();
				do {
					list.add(getProduct(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	private Product getProduct(ResultSet rs) throws SQLException {
		String p_code = rs.getString("p_code");
		String p_name = rs.getString("p_name");
		int p_price = rs.getInt("p_price");
		int p_stock = rs.getInt("p_stock");
		return new Product(p_code, p_name, p_price, p_stock);
	}

	@Override
	public Product selectProductByName(Product product) {
		String sql = "select p_code, p_name, p_price, p_stock from product where p_name =?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, product.getP_name());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getProduct(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertProduct(Product product) {
		String sql = "insert into product values (?, ?, ?, ?)";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, product.getP_code());
			pstmt.setString(2, product.getP_name());
			pstmt.setInt(3, product.getP_price());
			pstmt.setInt(4, product.getP_stock());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateProduct(Product product) {
		String sql = "update product set p_stock = ? where p_name = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, product.getP_stock());
			pstmt.setString(2, product.getP_name());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteProduct(String product) {
		String sql = "delete from product where p_name = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, product);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
