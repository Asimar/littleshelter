package pl.karol.littleshelter.service;

import java.util.List;
import java.util.Optional;

import pl.karol.littleshelter.entity.User;

public interface UserService {
	
	List<User> getUsers();
	
	Boolean register(User user);
	
	Optional<User> findUserById(String id);
	
	Optional<User> findUserByEmail(String email);
	
	void deleteUser(User user);

}
