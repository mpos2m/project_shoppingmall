package project_shoppingmall.dao;

import java.util.List;

import project_shoppingmall.dto.Admin;

public interface AdminDao {
	List<Admin> selectAdminByAll();
	Admin selectAdminById(Admin admin);
	int insertAdmin(Admin admin);
	int updateAdmin(Admin admin);
	int deleteAdmin(String admin);
}
