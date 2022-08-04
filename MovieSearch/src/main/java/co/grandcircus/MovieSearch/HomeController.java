package co.grandcircus.MovieSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@Autowired
	private MovieService movieService;
	@Autowired
	private MovieRepository repo;
	
	@RequestMapping("/")
	public String showIndex() {
		return "home";
	}
	@PostMapping("/search")
	public String searchysearch(@RequestParam String search, Model model) {
		search = search.replace(' ', '+');
		model.addAttribute("movieArray", movieService.getSearchResults(search).getResults());
		return "results";
	}
	@PostMapping("/confirmDelete")
	public String deleteFavorite(@RequestParam int movieId, Model model) {
		repo.deleteByApiId(movieId);
		Movie movie = movieService.getMovieById(movieId);
		model.addAttribute("movie", movie);
		return "confirmDelete";
	}
	@PostMapping("/confirm")
	public String addFavorite(@RequestParam int movieId, @RequestParam double rating, Model model) {
		Optional<MovieModel> checkMovieModel = repo.findByApiId(movieId);
		if(checkMovieModel.isPresent()) {
			String message = "Movie already in favorites!";
			model.addAttribute("message", message);
			model.addAttribute("movie", movieService.getMovieById(movieId));
		}else {
			MovieModel movieModel = new MovieModel(movieId, rating); 
			repo.save(movieModel);
			Optional<MovieModel> optionalMovieModel = repo.findByApiId(movieId);
			MovieModel retrievedMovieModel = optionalMovieModel.get();
			model.addAttribute("movie", movieService.getMovieById(retrievedMovieModel.getApiId()));
			model.addAttribute("rating", rating);
		}
		return "confirm";
	}
	@RequestMapping("/favorites")
	public String showFavorites(Model model) {
		List<Movie> favMovies = new ArrayList<>();
		List<MovieModel> favList = repo.findAll();
		for(int i = 0; i < favList.size(); i++) {
			favMovies.add(movieService.getMovieById(favList.get(i).getApiId()));
		}
		model.addAttribute("favMovieList",favMovies);
		model.addAttribute("favList", favList);
		return "favorites";
	}
	
}
