package pl.karol.littleshelter.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import pl.karol.littleshelter.entity.RestrictedData;
import pl.karol.littleshelter.entity.User;
import pl.karol.littleshelter.repository.UserRepository;

@Component
public class DatabaseDataLoader implements CommandLineRunner {

	private UserRepository userRepository;
	
	private BCryptPasswordEncoder passwordEncoder;
	

	@Autowired
	public DatabaseDataLoader(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		this.userRepository.save(new User("karol","nowosad", "nk", "781", this.passwordEncoder.encode("admin"), true).addRestrictedData(new RestrictedData("abc123", "ultra restricted data")));
     
	}

}
