package co.grandcircus.MovieSearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MovieModel {
	
	
	
	private int apiId;
	
	@Id 
	private String id;

	public MovieModel(int apiId) {
		this.apiId = apiId;
		
	
	}
	
	public MovieModel() {
		
	}

	public int getApiId() {
		return apiId;
	}

	public void setApiId(int apiId) {
		this.apiId = apiId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
