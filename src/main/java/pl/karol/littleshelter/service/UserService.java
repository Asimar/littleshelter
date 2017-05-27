package pl.karol.littleshelter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.karol.littleshelter.entity.User;

@Service
public interface UserService {
	
	List<User> getUsers();
	
	void addUser();
	
	User findUser(String id);
	
	User deleteUser(String id);

}
