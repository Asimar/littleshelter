package pl.karol.littleshelter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.karol.littleshelter.entity.User;
import pl.karol.littleshelter.repository.UserRepository;
import pl.karol.littleshelter.tool.ValidationUtil;

@Service
public class UserService implements UserDetailsService {

	private UserRepository userRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(ValidationUtil.cleanDataForNoSQL(email))
							 .orElseThrow(() -> new UsernameNotFoundException(
								"User identified by email: ".concat(email).concat(" not foud")));
	}

	public Boolean register(User user) {
		if (!userRepository.findByEmail(user.getEmail()).isPresent()) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return true;
		}
		
		return false;
	}
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	public Optional<User> findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void deleteUser(String id) {
		this.findUserById(id).ifPresent(user -> userRepository.delete(user));
	}
	
	private Optional<User> findUserById(String id) {
		return userRepository.findById(id);
	}

}
