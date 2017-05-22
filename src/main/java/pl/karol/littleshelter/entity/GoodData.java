package pl.karol.littleshelter.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class GoodData<T> {
	
	@Id
	private String id;
	
	private T content;
	
	private String description;
	
	private Date date = new Date();
	
	public GoodData() {
		
	}
	
	public GoodData(T content, String description) {
		this.content = content;
		this.description = description;
	}
	

}
