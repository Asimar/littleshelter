package pl.karol.littleshelter.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.karol.littleshelter.tool.LoggingUtil;

@Data
@EqualsAndHashCode
public class RestrictedData {
	
	@Id
	private String id;
	
	private String data;
	
	private String description;
	
	private Date insertDate = new Date();
	
	private Date updateDate;
	
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
		builder.append("\n insertDate: ");
		builder.append(this.insertDate);
		builder.append("\n updateDate: ");
		builder.append(this.updateDate);
		builder.append("\n}");
		return builder.toString();
		
	}
	

}
