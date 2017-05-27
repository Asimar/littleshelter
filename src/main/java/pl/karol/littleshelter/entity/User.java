package pl.karol.littleshelter.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
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
	private Set<RestrictedData> restrictedData = new HashSet<>();
	
	public User() {
		
	}
	
	public User(String name, String lastname, String email, String password) {
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
	
	public User addRestrictedData(RestrictedData restrictedData) {
		this.restrictedData.add(restrictedData);
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User: {");
		builder.append("\n name: ");
		builder.append(this.name);
		builder.append("\n lastname: ");
		builder.append(this.lastname);
		builder.append("\n email: ");
		builder.append(this.email);
		builder.append("\n}");
		return builder.toString();
	}

}
