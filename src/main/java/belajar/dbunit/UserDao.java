package belajar.dbunit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UserDao {
	private Connection connection;
	private PreparedStatement psInsert;
	
	public UserDao(Connection connection) throws Exception {
		this.connection = connection;
		psInsert = this.connection
		.prepareStatement("insert into m_user (name) values (?)");
		
	}

	public void insert(User u) throws Exception {
		psInsert.setString(1, u.getName());
		psInsert.executeUpdate();
	}
	
	public User findById(Integer id){
		return null;
	}
	
	public List<User> findUserByName(String name){
		return null;
	}
}
