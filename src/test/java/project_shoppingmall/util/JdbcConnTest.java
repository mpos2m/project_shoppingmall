package project_shoppingmall.util;

import java.sql.Connection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JdbcConnTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetConnection() {
		System.out.printf("%s()%n", "testGetConnection");
		Connection con = JdbcConn.getConnection();
		System.out.println("con : " + con);
		Assert.assertNotNull(con);
	}

}
