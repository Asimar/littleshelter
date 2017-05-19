package pl.karol.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	
	public User() {
		
	}
	
	public User(String name, String surname, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String password;

}
