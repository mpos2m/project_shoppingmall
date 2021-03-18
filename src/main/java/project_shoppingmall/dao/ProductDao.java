package project_shoppingmall.dao;

import java.util.List;

import project_shoppingmall.dto.Product;

public interface ProductDao {
	List<Product> selectProductByAll();
	Product selectProductByName(Product product);
	
	int insertProduct(Product product);
	int updateProduct(Product product);
	int deleteProduct(String product);
	
}
