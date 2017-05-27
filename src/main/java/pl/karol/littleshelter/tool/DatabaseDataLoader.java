package pl.karol.littleshelter.tool;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pl.karol.littleshelter.entity.RestrictedData;
import pl.karol.littleshelter.entity.User;
import pl.karol.littleshelter.repository.UserRepository;

@Component
public class DatabaseDataLoader implements CommandLineRunner {

	private UserRepository userRepository;
	

	@Autowired
	public DatabaseDataLoader(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		this.userRepository.save(new User("a", "a", "a", "a").addRestrictedData(new RestrictedData("asdafdf", "password for system account")));
        this.userRepository.save(new User("b", "b", "b", "b").addRestrictedData(new RestrictedData("a", "pass")));
        this.userRepository.save(new User("c", "c", "c", "c").addRestrictedData(new RestrictedData("a", "pass")));
        
        Optional<User> user = this.userRepository.findByEmail("a");
        user.ifPresent(u -> u.addRestrictedData(new RestrictedData("dsafdsafd", "password for facebook")));
        user.ifPresent(u -> u.addRestrictedData(new RestrictedData("habababa", "password for email")));
        user.ifPresent(u -> u.addRestrictedData(new RestrictedData("1234", "credit card pin")));
        user.ifPresent(u -> u.addRestrictedData(new RestrictedData("111 222 333", "number to lover")));
        
        this.userRepository.save(user.get());
	}

}
