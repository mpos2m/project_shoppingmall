package project_shoppingmall.service;

import java.util.List;

import project_shoppingmall.dao.DateSearchDao;
import project_shoppingmall.dao.impl.DateSearchDaoImpl;
import project_shoppingmall.dto.DateSearch;

public class DateSearchService {
	private DateSearchDao dao = DateSearchDaoImpl.getInstance();
	
	public List<DateSearch> showDateSearch(){
		return dao.selectDateSearchByAll();
	}
	
}
