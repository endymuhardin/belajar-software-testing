package belajar.dbunit;

import java.util.List;

import javax.sql.DataSource;

public class UserDao {
	private DataSource dataSource;

	public UserDao(DataSource dataSource) {
		this.dataSource = dataSource;
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
