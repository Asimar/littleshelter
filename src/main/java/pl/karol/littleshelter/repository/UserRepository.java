package pl.karol.littleshelter.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import pl.karol.littleshelter.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	public Optional<User> findByEmail(String email);

}
