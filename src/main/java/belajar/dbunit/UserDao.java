package belajar.dbunit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	private Connection connection;
	private PreparedStatement psInsert;
	private PreparedStatement psFindByName;
	
	public UserDao(Connection connection) throws Exception {
		this.connection = connection;
		psInsert = this.connection
		.prepareStatement("insert into m_user (name) values (?)");
		psFindByName = this.connection
		.prepareStatement("select * from m_user where name like ?");
		
	}

	public void insert(User u) throws Exception {
		psInsert.setString(1, u.getName());
		psInsert.executeUpdate();
	}
	
	public User findById(Integer id){
		return null;
	}
	
	public List<User> findUserByName(String name) throws Exception {
		psFindByName.setString(1, "%"+name+"%");
		ResultSet rs = psFindByName.executeQuery();
		
		List<User> hasil = new ArrayList<User>();
		while(rs.next()){
			hasil.add(rs2User(rs));
		}
		
		return hasil;
	}
	
	private User rs2User(ResultSet rs) throws Exception {
		User u = new User();
		u.setId(rs.getInt("id"));
		u.setName(rs.getString("name"));
		return u;
	}
}
