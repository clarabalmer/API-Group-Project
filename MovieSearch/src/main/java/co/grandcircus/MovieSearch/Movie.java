package co.grandcircus.MovieSearch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
	@JsonProperty("genre_ids")
	private int[] genreId;
	private int id;
	@JsonProperty("original_language")
	private String language;
	private String overview;
	@JsonProperty("poster_path")
	private String posterPath;
	@JsonProperty("release_date")
	private String releaseDate;
	private String title;
	
	
	
	public int[] getGenreId() {
		return genreId;
	}
	public void setGenreId(int[] genreId) {
		this.genreId = genreId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getPosterPath() {
		return posterPath;
	}
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
