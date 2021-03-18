package project_shoppingmall.dao;

import java.sql.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import project_shoppingmall.dao.impl.SellDaoImpl;
import project_shoppingmall.dto.Product;
import project_shoppingmall.dto.Sell;
import project_shoppingmall.dto.User_Info;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SellDaoTest {
	private static SellDao dao = SellDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test03SelectSellByAll() {
		System.out.println("test03SelectSellByAll");
		List<Sell> sellList = dao.selectSellByAll();
		Assert.assertNotNull(sellList);

		for (Sell s : sellList) {
			System.out.println(s);
		}
	}

	@Test
	public void test05SelectSellByUser_No() {
		System.out.println("test05SelectSellByUser_No");

		List<Sell> sellList = dao.selectSellByUser_No(new User_Info("12003", "김지원"));
		Assert.assertNotNull(sellList);

		sellList.stream().forEach(System.out::println);
	}

	@Test
	public void test06SelectSellAloneByUser_No() {
		System.out.println("test06selectSellAloneByUser_No");
		Sell selSell = new Sell(new User_Info("12003","김지원"));
		Sell searchSell = dao.selectSellAloneByUser_No(selSell);
		
		Assert.assertNotNull(searchSell);
		System.out.println(searchSell);
		
	}

	@Test
	public void test01InsertSell() {
		System.out.println("test01InsertSell");
		java.sql.Date day = Date.valueOf("2021-03-14");
		Sell newSell = new Sell(17,day,new User_Info("12003","김지원"), new Product("PA","책상"), 1, 0);
		int res = dao.insertSell(newSell);
		Assert.assertEquals(1, res);
		
		System.out.println(newSell);
	}

	@Test
	public void test02UpdateSell() {
		System.out.println("test02UpdateSell");
		java.sql.Date day = Date.valueOf("2021-03-14");
		Sell newSell = new Sell(17,day,new User_Info("12003","김지원"), new Product("PA","책상"), 5, 0);
		int res = dao.updateSell(newSell);
		Assert.assertEquals(1, res);
		
		System.out.println(newSell);
	}

	@Test
	public void test04DeleteSell() {
		System.out.println("test04DeleteSell");
		int res = dao.deleteSell(17);
		Assert.assertEquals(1, res);
		dao.selectSellByAll().stream().forEach(System.out::println);
		
	}

}
