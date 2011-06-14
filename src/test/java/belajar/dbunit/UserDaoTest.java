package belajar.dbunit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserDaoTest {
	private static Connection connection;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost/belajar";
		String username = "root";
		String password = "admin";
		connection = DriverManager.getConnection(url, username, password);
	}

	@Test
	public void testInsert() throws Exception {
		UserDao userDao = new UserDao(connection);
		
		User u = new User();
		u.setName("Endy Muhardin");
		
		userDao.insert(u);
		
		String sql = "select * from m_user";
		ResultSet rs = connection.createStatement().executeQuery(sql);
		
		assertTrue("harusnya tabel m_user ada isinya", rs.next());
		
		// periksa isinya
		String name = rs.getString("name");
		assertNotNull("Kolom nama harusnya terisi", name);
		assertEquals("Endy Muhardin", name);
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserByName() {
		fail("Not yet implemented");
	}

}
