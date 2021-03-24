package project_shoppingmall.dao;

import java.util.List;

import project_shoppingmall.dto.DateSearch;
import project_shoppingmall.dto.Sell;

public interface DateSearchDao {
	
	List<DateSearch> selectDateSearchByAll();

}
