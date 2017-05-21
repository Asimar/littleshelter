package pl.karol.littleshelter.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pl.karol.littleshelter.entity.User;
import pl.karol.littleshelter.repository.UserRepository;

@Component
public class DatabaseDataLoader implements CommandLineRunner{
	
	private UserRepository userRepository;
	
	@Autowired
	public DatabaseDataLoader(UserRepository userRepository) {
		this.userRepository = userRepository;
	}	

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		this.userRepository.save(new User("Joe Biden", "aaa", "bbb", "ccc"));
        this.userRepository.save(new User("Joe Biden", "aaa", "bbb", "ccc"));
        this.userRepository.save(new User("Joe Biden", "aaa", "bbb", "ccc"));
        this.userRepository.save(new User("Joe Biden", "aaa", "bbb", "ccc"));
	}

}
