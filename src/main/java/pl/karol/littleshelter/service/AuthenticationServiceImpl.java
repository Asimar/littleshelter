package pl.karol.littleshelter.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import pl.karol.littleshelter.entity.User;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private UserServiceImpl userService;
	
	public AuthenticationServiceImpl(UserServiceImpl userService) {
		this.userService = userService;
	}

	@Override
	public boolean authenticate(String email, String password) {
		Optional<User> user = userService.findUserByEmail(email);
		boolean authenticated;
		if(user.isPresent()) {
			authenticated = password.equals(user.get().getPassword());
		} else {
			authenticated = false;
		}
		return authenticated;
	}

	@Override
	public boolean register(User user) {
		userService.addUser(user);
		return false;
	}

}
