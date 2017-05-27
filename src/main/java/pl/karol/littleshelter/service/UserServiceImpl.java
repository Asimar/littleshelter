package pl.karol.littleshelter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.karol.littleshelter.entity.User;
import pl.karol.littleshelter.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);

	}

	@Override
	public Optional<User> findUserById(String id) {
		return userRepository.findById(id);
	}
	
	@Override
	public Optional<User> findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

}
