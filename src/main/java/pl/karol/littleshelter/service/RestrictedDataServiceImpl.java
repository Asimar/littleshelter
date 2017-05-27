package pl.karol.littleshelter.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.karol.littleshelter.entity.RestrictedData;
import pl.karol.littleshelter.entity.User;
import pl.karol.littleshelter.repository.UserRepository;

@Service
public class RestrictedDataServiceImpl implements RestrictedDataService {

	private UserRepository userRepository;

	@Autowired
	public RestrictedDataServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Set<RestrictedData> addRestrictedData(User user, RestrictedData data) {
		user.getRestrictedData().add(data);
		return userRepository.save(user).getRestrictedData();
	}

	@Override
	public Set<RestrictedData> updateRestrictedData(User user, RestrictedData data) {
		user.getRestrictedData().stream().map(item -> item.getId().equals(data.getId()) ? data : item).collect(Collectors.toSet());
		return userRepository.save(user).getRestrictedData();
	}

	@Override
	public Set<RestrictedData> removeRestrictedData(User user, RestrictedData data) {
		user.getRestrictedData().removeIf(item -> item.equals(data));
		return userRepository.save(user).getRestrictedData();
	}

}
