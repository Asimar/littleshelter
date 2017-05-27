package pl.karol.littleshelter.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import pl.karol.littleshelter.entity.RestrictedData;
import pl.karol.littleshelter.entity.User;
import pl.karol.littleshelter.repository.UserRepository;

public class RestrictedDataServiceImpl implements RestrictedDataService {

	private UserRepository userRepository;

	@Autowired
	public RestrictedDataServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Set<RestrictedData> findRestrictedData(User user) {
		return user.getRestrictedData();
	}

	@Override
	public Set<RestrictedData> addRestrictedData(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<RestrictedData> updateRestrictedData(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<RestrictedData> removeRestrictedData(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
