package project_shoppingmall.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import project_shoppingmall.dao.impl.ProductDaoImpl;
import project_shoppingmall.dto.Product;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest {
	private static ProductDao dao = ProductDaoImpl.getInstace();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test03SelectProductByAll() {
		System.out.println("test03SelectProductByAll");
		List<Product> productList = dao.selectProductByAll();
		Assert.assertNotNull(productList);
		
		for(Product p : productList) {
			System.out.println(p);
		}
	}

	@Test
	public void test05SelectProductByName() {
		System.out.println("test05SelectProductByName");
		Product product = new Product("자전거");
		Product searchProduct = dao.selectProductByName(product);
		Assert.assertNotNull(searchProduct);
		System.out.println(searchProduct);
	}

	@Test
	public void test01InsertProduct() {
		System.out.println("test01InsertProduct");
		Product newproduct = new Product("AA","테스트", 10000,100);
		int res = dao.insertProduct(newproduct);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectProductByName(newproduct));
	}

	@Test
	public void test02UpdateProduct() {
		System.out.println("test02UpdateProduct");
		Product newProduct = new Product("AA","테스트",10000,150);
		int res = dao.updateProduct(newProduct);
		Assert.assertEquals(1, res);
		System.out.println(newProduct);
	}

	@Test
	public void test04DeleteProduct() {
		System.out.println("test04DeleteProduct");
		int res = dao.deleteProduct("테스트");
		Assert.assertEquals(1, res);
		dao.selectProductByAll().stream().forEach(System.out::println);
	}

}
