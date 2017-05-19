package pl.karol.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pl.karol.entity.User;
import pl.karol.repository.UserRepository;

@Component
public class DatabaseDataLoader implements CommandLineRunner{
	
	private UserRepository userRepository;
	
	@Autowired
	public DatabaseDataLoader(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.save(new User("Joe Biden", "aaa", "bbb", "ccc"));
        this.userRepository.save(new User("Joe Biden", "aaa", "bbb", "ccc"));
        this.userRepository.save(new User("Joe Biden", "aaa", "bbb", "ccc"));
        this.userRepository.save(new User("Joe Biden", "aaa", "bbb", "ccc"));
	}

}
