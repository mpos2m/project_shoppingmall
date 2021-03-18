package project_shoppingmall.dao;

import java.util.List;

import project_shoppingmall.dto.User_Info;

public interface User_InfoDao {
	List<User_Info> selectUser_InfoByAll();
	User_Info selectUser_InfoByUser_Id(User_Info user_info);
	
	int insertUser_Info(User_Info user_info);
	int updateUser_Info(User_Info user_info);
	int deleteUser_Info(String user_info);
}
