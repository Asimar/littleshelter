package pl.karol.littleshelter.service;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
