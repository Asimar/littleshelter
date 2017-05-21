package pl.karol.littleshelter.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {

	@Id
	private String id;
	
	private String name;
	
	private String lastname;
	
	private String email;
	
	private String password;
	
	public User() {
		
	}
	
	public User(String name, String lastname, String email, String password) {
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

}
