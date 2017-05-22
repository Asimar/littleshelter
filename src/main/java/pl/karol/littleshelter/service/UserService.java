package pl.karol.littleshelter.service;

import java.util.List;

import pl.karol.littleshelter.entity.User;

public interface UserService {
	
	List<User> getUsers();
	
	void addUser();
	
	User findUser(String id);
	
	User deleteUser(String id);

}
