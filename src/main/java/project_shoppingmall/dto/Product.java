package project_shoppingmall.dto;

public class Product {
	private String p_code;
	private String p_name;
	private int p_price;
	private int p_stock;

	public Product() {

	}

	public Product(String p_code, String p_name) {
		this.p_code = p_code;
		this.p_name = p_name;
	}

	public Product(String p_name) {
		this.p_name = p_name;
	}

	public Product(String p_code, String p_name, int p_price, int p_stock) {
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_stock = p_stock;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_stock() {
		return p_stock;
	}

	public void setP_stock(int p_stock) {
		this.p_stock = p_stock;
	}

	@Override
	public String toString() {
		return "상품코드 = " + p_code + ", 상품이름 = " + p_name + ", 상품가격 = " + p_price + ", 재고 = " + p_stock;
	}
	
}
