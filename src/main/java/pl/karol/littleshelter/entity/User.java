package pl.karol.littleshelter.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import pl.karol.littleshelter.annotation.Email;
import pl.karol.littleshelter.annotation.Password;
import pl.karol.littleshelter.annotation.PhoneNumber;
import pl.karol.littleshelter.object.enumeration.Role;
import pl.karol.littleshelter.tool.LoggingUtil;

@Data
public class User implements UserDetails {

	private static final long serialVersionUID = 2345365434L;

	@Id
	private String id;

	@Size(min = 3, max = 25)
	private String name;

	@Size(min = 2, max = 50)
	private String lastname;

	@Email
	@Size(min = 5, max = 50)
	private String email;

	@PhoneNumber
	private String phoneNumber;

	@Password
	private String password;

	private Boolean active;

	@Setter(value = AccessLevel.NONE)
	private Set<RestrictedData> restrictedData = new HashSet<>();

	@Setter(value = AccessLevel.NONE)
	private List<GrantedAuthority> roles;

	public User() {
		this.active = true;
		this.roles = AuthorityUtils.createAuthorityList(Role.USER.value);
	}

	public User(String name, String lastname, String email, String phoneNumber, String password, Boolean admin) {
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.active = true;
		if (admin) {
			this.roles = AuthorityUtils.createAuthorityList(Role.ADMIN.value);
		} else {
			this.roles = AuthorityUtils.createAuthorityList(Role.USER.value);
		}
	}

	public User addRestrictedData(RestrictedData restrictedData) {
		this.restrictedData.add(restrictedData);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nUser: {");
		builder.append("\n name: ");
		builder.append(this.name);
		builder.append("\n lastname: ");
		builder.append(this.lastname);
		builder.append("\n email: ");
		builder.append(this.email);
		builder.append("\n phoneNumber: ");
		builder.append(this.phoneNumber);
		builder.append("\n password: ");
		builder.append(LoggingUtil.hideData(this.phoneNumber));
		builder.append("\n}");
		return builder.toString();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isEnabled() {
		return this.active;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.active;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.active;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.active;
	}

}
