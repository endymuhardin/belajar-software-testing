package belajar.dbunit;

import java.sql.Connection;
import java.util.List;

public class UserDao {
	private Connection connection;

	public UserDao(Connection connection) {
		this.connection = connection;
	}

	public void insert(User u){
		
	}
	
	public User findById(Integer id){
		return null;
	}
	
	public List<User> findUserByName(String name){
		return null;
	}
}
