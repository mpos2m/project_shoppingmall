package project_shoppingmall.dto;

public class DateSearch {
	private Sell sell_date;
	private User_Info user_no;
	private User_Info user_name;
	private User_Info user_phone;
	private Product p_code;
	private Sell sellqty;
	private Sell orderat;
	
	public DateSearch() {
		
	}

	public DateSearch(Sell sell_date) {
		this.sell_date = sell_date;
	}
	
	
	public DateSearch(User_Info user_no) {
		this.user_no = user_no;
	}

	public DateSearch(User_Info user_no, User_Info user_name) {
		this.user_no = user_no;
		this.user_name = user_name;
	}

	public DateSearch(Sell sell_date, User_Info user_no, User_Info user_name, User_Info user_phone, Product p_code,
			Sell sellqty, Sell orderat) {
		this.sell_date = sell_date;
		this.user_no = user_no;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.p_code = p_code;
		this.sellqty = sellqty;
		this.orderat = orderat;
	}

	public Sell getSell_date() {
		return sell_date;
	}

	public void setSell_date(Sell sell_date) {
		this.sell_date = sell_date;
	}

	public User_Info getUser_no() {
		return user_no;
	}

	public void setUser_no(User_Info user_no) {
		this.user_no = user_no;
	}

	public User_Info getUser_name() {
		return user_name;
	}

	public void setUser_name(User_Info user_name) {
		this.user_name = user_name;
	}

	public User_Info getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(User_Info user_phone) {
		this.user_phone = user_phone;
	}

	public Product getP_code() {
		return p_code;
	}

	public void setP_code(Product p_code) {
		this.p_code = p_code;
	}

	public Sell getSellqty() {
		return sellqty;
	}

	public void setSellqty(Sell sellqty) {
		this.sellqty = sellqty;
	}

	public Sell getOrderat() {
		return orderat;
	}

	public void setOrderat(Sell orderat) {
		this.orderat = orderat;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s %s %s %s %s", sell_date, user_no, user_name, user_phone, p_code, sellqty, orderat);
	}
	
}
