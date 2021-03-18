package project_shoppingmall.dto;

public class Cart {
	private int cart_no;
	private User_Info user_no;
	private Product p_code;
	private int cartqty;
	
	public Cart() {
		
	}

	public Cart(User_Info user_no) {
		this.user_no = user_no;
	}

	public Cart(int cart_no, User_Info user_no, Product p_code, int cartqty) {
		this.cart_no = cart_no;
		this.user_no = user_no;
		this.p_code = p_code;
		this.cartqty = cartqty;
	}

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
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

	public int getCartqty() {
		return cartqty;
	}

	public void setCartqty(int cartqty) {
		this.cartqty = cartqty;
	}

	@Override
	public String toString() {
		return "장바구니 번호 = " + cart_no + ", 회원번호 = " + user_no + ", 상품코드 = " + p_code + ", 구매수량 = " + cartqty;
	}
	
	
}
