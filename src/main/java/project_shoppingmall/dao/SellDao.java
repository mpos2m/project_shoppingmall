package project_shoppingmall.dao;

import java.util.List;

import project_shoppingmall.dto.Sell;
import project_shoppingmall.dto.User_Info;

public interface SellDao {
	List<Sell> selectSellByAll();
	List<Sell> selectSellByUser_No(User_Info user_info);
	Sell selectSellAloneByUser_No(Sell sell);
	
	int insertSell(Sell sell);
	int updateSell(Sell sell);
	int deleteSell(int sell);
	
	///////////////////////////////////////
	

}
