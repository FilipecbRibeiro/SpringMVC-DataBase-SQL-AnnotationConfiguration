package org.light.spring.DAO;

import java.util.List;

import org.light.spring.model.User;

public interface AppDAO {
	
	public List<User> listUsers();
	public void addUser (User user);
}
