package belajar.dbunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserDaoTest {
	private static Connection connection;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Inisialisasi koneksi database");
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost/belajar";
		String username = "root";
		String password = "admin";
		connection = DriverManager.getConnection(url, username, password);
	}
	
	@Before
	public void resetDatabase() throws Exception {
		System.out.println("Reset isi tabel database");
		
		DataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet ds = loader.load("/users.xml");
		
		DatabaseOperation.CLEAN_INSERT
		.execute(new DatabaseConnection(connection), ds);
	}
	
	@AfterClass
	public static void disconnectDatabase() throws Exception {
		System.out.println("Disconnect dari database");
		connection.close();
	}

	@Test
	public void testInsert() throws Exception {
		UserDao userDao = new UserDao(connection);
		
		User u = new User();
		u.setName("Endy Muhardin");
		
		userDao.insert(u);
		
		ResultSet rs = connection.createStatement().executeQuery("select count(*) from m_user");
		assertTrue(rs.next());
		assertEquals(3, rs.getInt(1));
		rs.close();
		
		String sql = "select * from m_user where name = 'Endy Muhardin'";
		rs = connection.createStatement().executeQuery(sql);
		
		assertTrue("harusnya tabel m_user ada isinya", rs.next());
		
		// periksa isinya
		String name = rs.getString("name");
		assertNotNull("Kolom nama harusnya terisi", name);
		assertEquals("Endy Muhardin", name);
		
		rs.close();
	}

	@Test
	public void testFindById() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserByName() throws Exception {
		UserDao userDao = new UserDao(connection);
		List<User> hasil = userDao.findUserByName("a");
		assertTrue("harusnya ada 2 user di tabel", hasil.size() == 2);
	}

}
