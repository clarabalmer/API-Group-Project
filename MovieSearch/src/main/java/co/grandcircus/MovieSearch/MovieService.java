package co.grandcircus.MovieSearch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {
	private RestTemplate restTemplate = new RestTemplate();
	@Value("${key}")
	private String key;
	
	public MovieResponse getSearchResults(String search) {
		String url = "https://api.themoviedb.org/3/search/movie?api_key={0}&query={1}";
		MovieResponse response = restTemplate.getForObject(url,  MovieResponse.class, key, search);
		return response;
	}
	
	public Movie getMovieById(int id) {
		String url = "https://api.themoviedb.org/3/movie/{0}?api_key={1}";
		String idString = String.valueOf(id);
		Movie response = restTemplate.getForObject(url, Movie.class, idString, key);
		return response;
	}


	

	
}
