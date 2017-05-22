package pl.karol.littleshelter.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class User {

	@Id
	private String id;
	
	private String name;
	
	private String lastname;
	
	private String email;
	
	private String password;
	
	@Setter(value = AccessLevel.NONE)
	private Set<GoodData> goodData = new HashSet<>();
	
	public User() {
		
	}
	
	public User(String name, String lastname, String email, String password) {
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
	
	public User addSomeGoodData(GoodData goodData) {
		this.goodData.add(goodData);
		return this;
	}

}
