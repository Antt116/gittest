package student_registeration.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student_registeration.models.Login;
import student_registeration.models.User;

public class UserRepository {
	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	
	//insert
		public int add(User user) {
			int result=0;
			String sql="INSERT INTO user(user_id,user_name,password,confirmPassword,userRole, email) VALUES (?,?,?,?,?,?)";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, user.getUser_id());
				ps.setString(2, user.getUser_name());
				ps.setString(3, user.getPassword());
				ps.setString(4, user.getConfirmPassword());
				ps.setString(5, user.getUserRole());
				ps.setString(6, user.getEmail());
				
				result=ps.executeUpdate();
			}catch(SQLException e) {
				result=0;
				System.out.println("User insert err: "+e);
			}
			return result;
		}
		
		//update
		public int edit(User user) {
			int result=0;
			String sql="UPDATE user SET user_name=?, password=?, confirmPassword=?, userRole=? , email=? WHERE user_id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, user.getUser_name());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getConfirmPassword());
				ps.setString(4, user.getUserRole());
				ps.setString(5, user.getEmail());
				ps.setString(6, user.getUser_id());
				
				result=ps.executeUpdate();
			}catch(SQLException e) {
				result=0;
				System.out.println("User edit err: "+e);
			}
			return result;
		}
		
		//delete
			public int delete(String id) {
				int result=0;
				String sql="DELETE FROM user WHERE user_id=?";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, id);
					result=ps.executeUpdate();
					
				}catch(SQLException e) {
					result=0;
					System.out.println("User delete err: "+e);
				}
				return result;
			}
			
			//getAll
			public List<User>getAll(){
				List<User> users=new ArrayList<>();
				String sql="SELECT * FROM user";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						User user=new User();
						user.setUser_id(rs.getString("user_id"));
						user.setUser_name(rs.getString("user_name"));
						user.setPassword(rs.getString("password"));
						user.setConfirmPassword(rs.getString("confirmPassword"));
						user.setUserRole(rs.getString("userRole"));
						user.setEmail(rs.getString("email"));
						users.add(user);
					}
					
				}catch(SQLException e) {
					System.out.println("User selec err: "+e);
				}
				return users;
			}
			
			//getByCode == getOne
			public User getById(String id) {
				User user=null;//initially null
				String sql="SELECT * FROM user WHERE user_id=?";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, id);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						user=new User();
						user.setUser_id(rs.getString("user_id"));
						user.setUser_name(rs.getString("user_name"));
						user.setPassword(rs.getString("password"));
						user.setConfirmPassword(rs.getString("confirmPassword"));
						user.setUserRole(rs.getString("userRole"));
						user.setEmail(rs.getString("email"));
					}
					
				}catch(SQLException e) {
					System.out.println("author getByCode err: "+e);
				}
				return user;
			}
			
			
			//GetNameByBookCode
			public User getByLogin(Login login) {
				User user=new User();
				
				String sql="SELECT * FROM user where user_name=? and password=?";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, login.getName());
					ps.setString(2, login.getPassword());
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						user.setUser_id(rs.getString("user_id"));
						user.setUser_name(rs.getString("user_name"));
						user.setPassword(rs.getString("password"));
						user.setConfirmPassword(rs.getString("confirmPassword"));
						user.setUserRole(rs.getString("userRole"));
						user.setEmail(rs.getString("email"));
					}
					
				}catch(SQLException e) {
					System.out.println("User getByLogin err: "+e);
				}
				return user;
			}
}
