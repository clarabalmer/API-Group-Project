package co.grandcircus.MovieSearch;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class UserModel {
	@Id
	private String id;
	private String username;
	private ArrayList<MovieModel> favorites;
	private ArrayList<MovieModel> toWatch;
	
	public UserModel(String username) {
		this.username = username;
		favorites = new ArrayList<>();
		toWatch = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<MovieModel> getFavorites() {
		return favorites;
	}

	public void setFavorites(ArrayList<MovieModel> favorites) {
		this.favorites = favorites;
	}

	public ArrayList<MovieModel> getToWatch() {
		return toWatch;
	}

	public void setToWatch(ArrayList<MovieModel> toWatch) {
		this.toWatch = toWatch;
	}
}
