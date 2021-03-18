package project_shoppingmall.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import project_shoppingmall.dao.impl.CartDaoImpl;
import project_shoppingmall.dto.Cart;
import project_shoppingmall.dto.Product;
import project_shoppingmall.dto.User_Info;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CartDaoTest {
	private static CartDao dao = CartDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test03SelectCartByAll() {
		System.out.println("test03SelectSellByAll");
		List<Cart> cartList = dao.selectCartByAll();
		Assert.assertNotNull(cartList);
		
		for(Cart c : cartList) {
			System.out.println(c);
		}
	}

	@Test
	public void test05SelectCartByUser_No() {
		System.out.println("test05SelectCartByUser_No");
		List<Cart> sellList = dao.selectCartByUser_No(new User_Info("12001","홍길동"));
		Assert.assertNotNull(sellList);
		sellList.stream().forEach(System.out::println);
	}

	@Test
	public void test01InsertCart() {
		System.out.println("test01InsertCart");
		Cart newCart = new Cart(7, new User_Info("12004","문희원"), new Product("PC","세탁기"), 10);
		int res = dao.insertCart(newCart);
		Assert.assertEquals(1, res);
		System.out.println(newCart);
	}

	@Test
	public void test02UpdateCart() {
		System.out.println("test02UpdateCart");
		Cart newCart = new Cart(7, new User_Info("12004","문희원"), new Product("PC","세탁기"),5);
		int res = dao.updateCart(newCart);
		Assert.assertNotNull(newCart);
		System.out.println(newCart);
	}

	@Test
	public void test04DeleteCart() {
		System.out.println("test04DeleteCart");
		int res = dao.deleteCart(7);
		Assert.assertEquals(1, res);
		dao.selectCartByAll().stream().forEach(System.out::println);
	}

}
