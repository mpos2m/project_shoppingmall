package project_shoppingmall.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import project_shoppingmall.dao.impl.User_InfoDaoImpl;
import project_shoppingmall.dto.Grade;
import project_shoppingmall.dto.User_Info;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class User_InfoDaoTest {
	private static User_InfoDao dao = User_InfoDaoImpl.getInstance();
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test03SelectUser_InfoByAll() {
		System.out.println("test03SelectUser_InfoByAll");
		List<User_Info> user_infoList = dao.selectUser_InfoByAll();
		Assert.assertNotNull(user_infoList);
		
		for(User_Info ui : user_infoList) {
			System.out.println(ui);
		}
		
	}

	@Test
	public void test05SelectUser_InfoByUser_Id() {
		System.out.println("test03SelectUser_InfoByAll");
		User_Info user_info = new User_Info("test1");
		User_Info searchUser_Info = dao.selectUser_InfoByUser_Id(user_info);
		Assert.assertNotNull(searchUser_Info);
		System.out.println(searchUser_Info);
	}

	@Test
	public void test01InsertUser_Info() {
		System.out.println("test01InsertUser_Info");
		User_Info newUser_Info = new User_Info("10000", "test", "12345", "테스트", "20001230", "010-1234-5678", "대한민국", "여자", "출신 고등학교는?", "테스트",0, new Grade("브론즈"));
		int res = dao.insertUser_Info(newUser_Info);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectUser_InfoByUser_Id(newUser_Info));
	}

	@Test
	public void test02UpdateUser_Info() {
		System.out.println("test02UpdateUser_Info");
		User_Info newUser_Info = new User_Info("10000", "test", "1234", "테스트", "20001230", "010-1234-5678", "대한민국", "여자", "출신 고등학교는?", "테스트",0, new Grade("브론즈"));
		int res = dao.updateUser_Info(newUser_Info);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectUser_InfoByUser_Id(newUser_Info));
		
	}

	@Test
	public void test04DeleteUser_Info() {
		System.out.println("test04DeleteUser_Info");
		int res = dao.deleteUser_Info("test");
		Assert.assertEquals(1, res);
		dao.selectUser_InfoByAll().stream().forEach(System.out::println);
		
	}

}
