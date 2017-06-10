package pl.karol.littleshelter.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.karol.littleshelter.entity.RestrictedData;
import pl.karol.littleshelter.entity.User;
import pl.karol.littleshelter.repository.UserRepository;
import pl.karol.littleshelter.tool.EncryptionUtil;

@Service
public class RestrictedDataService {

	private UserRepository userRepository;

	@Autowired
	public RestrictedDataService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	public Set<RestrictedData> addRestrictedData(User user, RestrictedData data) {
		data.setData(EncryptionUtil.encryptData(data.getData()));
		user.getRestrictedData().add(data);
		return userRepository.save(user).getRestrictedData();
	}
	
	public Set<RestrictedData> getRestrictedData(User user) {
		user = userRepository.findById(user.getId()).get();
		for(RestrictedData restrictedData : user.getRestrictedData()) {
			restrictedData.setData(EncryptionUtil.decryptData(restrictedData.getData()));
		}
		return user.getRestrictedData();
	}

	
	public void removeRestrictedData(User user, RestrictedData data) {
		user = userRepository.findById(user.getId()).get();
		data.setData(EncryptionUtil.encryptData(data.getData()));
		user.getRestrictedData().removeIf(item -> item.equals(data));
		userRepository.save(user);
	}

}
