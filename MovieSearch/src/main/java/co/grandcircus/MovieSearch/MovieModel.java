package co.grandcircus.MovieSearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MovieModel {
	private int apiId;
	private double rating;
	
	@Id 
	private String id;

	public MovieModel(int apiId, double rating) {
		this.apiId = apiId;
		this.rating = rating;
		
	
	}
	
	public MovieModel() {
		
	}

	
	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
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
