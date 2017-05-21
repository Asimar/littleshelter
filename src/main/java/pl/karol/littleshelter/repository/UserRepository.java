package pl.karol.littleshelter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.karol.littleshelter.entity.User;

public interface UserRepository extends MongoRepository<User, Long>{
	
	public User findByName(String name);
	
	public User findByEmail(String email);

}
