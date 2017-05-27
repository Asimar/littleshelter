package pl.karol.littleshelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.karol.littleshelter.entity.User;
import pl.karol.littleshelter.repository.UserRepository;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public User findUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
