package pl.karol.littleshelter.service;

import pl.karol.littleshelter.entity.User;

public interface AuthenticationService {
	
	boolean authenticate(String email, String password);
	
	boolean register(User user);

}
