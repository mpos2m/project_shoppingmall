package project_shoppingmall.dao;

import java.util.List;

import project_shoppingmall.dto.Cart;
import project_shoppingmall.dto.User_Info;

public interface CartDao {
	List<Cart> selectCartByAll();
	List<Cart> selectCartByUser_No(User_Info user_info);
	
	int insertCart(Cart cart);
	int updateCart(Cart cart);
	int deleteCart(int Cart);
	
}
