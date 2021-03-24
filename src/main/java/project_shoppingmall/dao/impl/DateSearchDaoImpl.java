package project_shoppingmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_shoppingmall.dao.DateSearchDao;
import project_shoppingmall.dto.DateSearch;
import project_shoppingmall.dto.Product;
import project_shoppingmall.dto.Sell;
import project_shoppingmall.dto.User_Info;
import project_shoppingmall.util.JdbcConn;

public class DateSearchDaoImpl implements DateSearchDao {
	private static final DateSearchDaoImpl instance = new DateSearchDaoImpl();
	
	public static DateSearchDaoImpl getInstance() {
		return instance;
	};
	
	
	public DateSearchDaoImpl() {}

	@Override
	public List<DateSearch> selectDateSearchByAll() {
		String sql = "select 날짜, 회원번호, 회원명, 휴대전화, 제품코드, 주문수량, 판매액 from vw_date_search";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<DateSearch> list = new ArrayList<>();
				do {
					list.add(getDateSearch(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	private DateSearch getDateSearch(ResultSet rs) throws SQLException {
		Sell sell_date = new Sell(rs.getDate("날짜"));
		User_Info user_no = new User_Info(rs.getString("회원번호"));
		User_Info user_name = new User_Info(rs.getString("회원명"));
		User_Info user_phone = new User_Info(rs.getString("휴대전화"));
		Product p_code = new Product(rs.getString("제품코드"));
		Sell sellqty = new Sell(rs.getInt("주문수량"));
		Sell orderat = new Sell(rs.getInt("판매액"));
		
	
		
		return new DateSearch(sell_date,user_no,user_name,user_phone,p_code,sellqty,orderat);
	}


	

}
