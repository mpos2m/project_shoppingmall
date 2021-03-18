package project_shoppingmall.dto;

import java.sql.Date;

public class Sell {
	private int sell_no;
	private Date sell_date;
	private User_Info user_no;
	private Product p_code;
	private int sellqty;
	private int orderat;
	
	public Sell() {

	}
	
	public Sell(int orderat) {
		this.orderat = orderat;
	}

	public Sell(Date sell_date) {
		this.sell_date = sell_date;
	}

	public Sell(int sellqty,int orderat) {
		this.sellqty = sellqty;
		this.orderat = orderat;
	}

	public Sell(User_Info user_no) {
		this.user_no = user_no;
	}

	public Sell(int sell_no, Date sell_date, User_Info user_no, Product p_code, int sellqty, int orderat) {
		this.sell_no = sell_no;
		this.sell_date = sell_date;
		this.user_no = user_no;
		this.p_code = p_code;
		this.sellqty = sellqty;
		this.orderat = orderat;
	}

	public int getSell_no() {
		return sell_no;
	}

	public void setSell_no(int sell_no) {
		this.sell_no = sell_no;
	}

	public Date getSell_date() {
		return sell_date;
	}

	public void setSell_date(Date sell_date) {
		this.sell_date = sell_date;
	}

	public User_Info getUser_no() {
		return user_no;
	}

	public void setUser_no(User_Info user_no) {
		this.user_no = user_no;
	}

	public Product getP_code() {
		return p_code;
	}

	public void setP_code(Product p_code) {
		this.p_code = p_code;
	}

	public int getSellqty() {
		return sellqty;
	}

	public void setSellqty(int sellqty) {
		this.sellqty = sellqty;
	}

	public int getOrderat() {
		return orderat;
	}

	public void setOrderat(int orderat) {
		this.orderat = orderat;
	}

	@Override
	public String toString() {
		return "판매번호 = " + sell_no + ", 구매일자 = " + sell_date + ", 회원번호 = " + user_no + ", 제품코드 = " + p_code
				+ ", 판매수량 = " + sellqty + ", 주문금액 = " + orderat;
	}
	
	
}
