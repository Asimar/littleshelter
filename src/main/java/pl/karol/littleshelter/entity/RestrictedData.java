package pl.karol.littleshelter.entity;

import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.karol.littleshelter.tool.LoggingUtil;

@Data
@EqualsAndHashCode
public class RestrictedData {
	
	@Size(min = 1, max = 250)
	private String data;
	
	@Size(min = 1, max = 250)
	private String description;
	
	public RestrictedData() {
		
	}
	
	public RestrictedData(String data, String description) {
		this.data = data;
		this.description = description;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nRestricted data: {");
		builder.append("\n data: ");
		builder.append(LoggingUtil.hideData(this.data));
		builder.append("\n description: ");
		builder.append(this.description);
		builder.append("\n}");
		return builder.toString();
		
	}
	

}
