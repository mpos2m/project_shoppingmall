package project_shoppingmall.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import project_shoppingmall.dao.impl.AdminDaoImpl;
import project_shoppingmall.dto.Admin;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminDaoTest {
	private static AdminDao dao = AdminDaoImpl.getInstance();	

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test03SelectAdminByAll() {
		System.out.println("test03SelectAdminByAll");
		List<Admin> adminList = dao.selectAdminByAll();
		Assert.assertNotNull(adminList);
		
		for(Admin a : adminList) {
			System.out.println(a);
		}
	}

	@Test
	public void test05SelectAdminById() {
		System.out.println("test05SelectAdminById");
		Admin admin = new Admin("admin");
		Admin searchAdmin = dao.selectAdminById(admin);
		Assert.assertNotNull(searchAdmin);
		System.out.println(searchAdmin);
	}

	@Test
	public void test01InsertAdmin() {
		System.out.println("test01InsertAdmin");
		Admin newAdmin = new Admin("test","1234","테스트");
		int res = dao.insertAdmin(newAdmin);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectAdminById(newAdmin));
	}

	@Test
	public void test02UpdateAdmin() {
		System.out.println("test02UpdateAdmin");
		Admin newAdmin = new Admin("test","12345","테스트");
		int res = dao.updateAdmin(newAdmin);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectAdminById(newAdmin));
	}

	@Test
	public void test04DeleteAdmin() {
		System.out.println("test04DeleteAdmin");
		int res = dao.deleteAdmin("test");
		Assert.assertEquals(1, res);
		dao.selectAdminByAll().stream().forEach(System.out::println);
	}

}
