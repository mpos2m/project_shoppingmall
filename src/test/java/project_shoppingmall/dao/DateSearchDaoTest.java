package project_shoppingmall.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import project_shoppingmall.dao.impl.DateSearchDaoImpl;
import project_shoppingmall.dto.DateSearch;

public class DateSearchDaoTest {
	private static DateSearchDao dao = DateSearchDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testSelectDateSearchByAll() {
		System.out.println("testSelectDateSearchByAll");
		List<DateSearch> DateSearchList = dao.selectDateSearchByAll();
		Assert.assertNotNull(DateSearchList);
		
		for(DateSearch ds : DateSearchList) {
			System.out.println(ds);
		}
	}

}
