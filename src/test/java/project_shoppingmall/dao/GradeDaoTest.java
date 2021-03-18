package project_shoppingmall.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import project_shoppingmall.dao.impl.GradeDaoImpl;
import project_shoppingmall.dto.Grade;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GradeDaoTest {
	private static GradeDao dao = GradeDaoImpl.getInstance();
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test03SelectGradeByAll() {
		System.out.println("test03SelectGradeByAll");
		List<Grade> gradeList = dao.selectGradeByAll();
		Assert.assertNotNull(gradeList);
		
		for(Grade g : gradeList) {
			System.out.println(g);
		}
	}

	@Test
	public void test05SelectGradeByGrade() {
		System.out.println("test05SelectGradeByGrade");
		Grade grade = new Grade("실버");
		Grade searchGrade = dao.selectGradeByGrade(grade);
		Assert.assertNotNull(searchGrade);
		System.out.println(searchGrade);
	}

	@Test
	public void test01InsertGrade() {
		System.out.println("test01InsertGrade");
		Grade newGrade = new Grade("VVIP", 5000000);
		int res = dao.insertGrade(newGrade);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectGradeByGrade(newGrade));
	}

	@Test
	public void test02UpdateGrade() {
		System.out.println("test02UpdateGrade");
		Grade newGrade = new Grade("플레티넘", 1000000);
		int res = dao.updateGrade(newGrade);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectGradeByGrade(newGrade));
	}

	@Test
	public void test04DeleteGrade() {
		System.out.println("test04DeleteGrade");
		int res = dao.deleteGrade("VVIP");
		Assert.assertEquals(1, res);
		dao.selectGradeByAll().stream().forEach(System.out::println);
	}

}
