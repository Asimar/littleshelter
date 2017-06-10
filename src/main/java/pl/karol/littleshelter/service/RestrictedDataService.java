package pl.karol.littleshelter.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.karol.littleshelter.entity.RestrictedData;
import pl.karol.littleshelter.entity.User;
import pl.karol.littleshelter.repository.UserRepository;

@Service
public class RestrictedDataService {

	private UserRepository userRepository;

	@Autowired
	public RestrictedDataService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	public Set<RestrictedData> addRestrictedData(User user, RestrictedData data) {
		user.getRestrictedData().add(data);
		return userRepository.save(user).getRestrictedData();
	}

	
	public void removeRestrictedData(User user, RestrictedData data) {
		user = userRepository.findById(user.getId()).get();
		user.getRestrictedData().removeIf(item -> item.equals(data));
		userRepository.save(user);
	}

}
