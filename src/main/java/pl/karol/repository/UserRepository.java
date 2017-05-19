package pl.karol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.karol.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
