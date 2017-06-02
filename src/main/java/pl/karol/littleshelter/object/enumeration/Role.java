package pl.karol.littleshelter.object.enumeration;

public enum Role {
	
	USER("USER"),ADMIN("ADMIN");
	
	public String value;
	
	private Role(String value) {
		this.value = value;
	}

}
