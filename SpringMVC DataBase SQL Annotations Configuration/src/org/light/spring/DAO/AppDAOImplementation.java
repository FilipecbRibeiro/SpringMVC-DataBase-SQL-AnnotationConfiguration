package org.light.spring.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.light.spring.model.User;

public class AppDAOImplementation implements AppDAO {
	
	private DataSource dataSource;

	public AppDAOImplementation(DataSource dataSource) {//we need to inject our dataSource as a constructor Parameter!!!!
		
		this.dataSource = dataSource;
	}
	

	@Override
	public List<User> listUsers() {
		String SQL = "Select * from users"; // our table name
		List<User> listUsers = new ArrayList<User>() ;
		Connection connection=null; 
		ResultSet resultSet;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(SQL);
			resultSet = ps.executeQuery();
			
			while(resultSet.next()){
				User temporary = new User(resultSet.getInt("user_id"),resultSet.getString("name"),resultSet.getString("email"));
				listUsers.add(temporary);
			}
			resultSet.close();
			ps.close();
			//Always a good practicing to always close those statements before the return statement else 
			// the controller wont reach them !
			return listUsers;
		} catch (SQLException e) {
			e.printStackTrace();
			return null; //if any error occur!!!
		}finally{
			if(connection!= null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}


	@Override
	public void addUser(User user) {
		String SQL = "INSERT INTO users (name,email) VALUES (?,?)";
		Connection connection = null;
		
		try {
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.execute();
			
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection!= null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}



	
	
	
}
