package pl.karol.littleshelter.object.enumeration;

public enum Role {
	
	USER("ROLE_USER"),ADMIN("ROLE_ADMIN");
	
	public String value;
	
	private Role(String value) {
		this.value = value;
	}

}
