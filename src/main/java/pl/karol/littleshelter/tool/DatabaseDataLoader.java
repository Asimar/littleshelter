package pl.karol.littleshelter.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pl.karol.littleshelter.entity.GoodData;
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
		
		User user1 = new User("Joe Biden", "aaa", "bbb", "ccc");
		user1.addSomeGoodData(new GoodData<Integer>(45, "bbb"));
		User user2 = new User("Joe Biden", "aaa", "bbb", "ccc");
		user1.addSomeGoodData(new GoodData<Integer>(45, "bbb"));
		User user3 = new User("Joe Biden", "aaa", "bbb", "ccc");
		user3.addSomeGoodData(new GoodData<Integer>(45, "bbb"));
		this.userRepository.save(user1);
        this.userRepository.save(user2);
        this.userRepository.save(user3);
	}

}
