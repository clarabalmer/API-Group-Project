package co.grandcircus.MovieSearch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieResponse {
	private int page;
	private Movie[] results;
	@JsonProperty("total_pages")
	private int totalPages;
	@JsonProperty("total_results")
	private int totalResults;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Movie[] getResults() {
		return results;
	}
	public void setResults(Movie[] results) {
		this.results = results;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	
}
