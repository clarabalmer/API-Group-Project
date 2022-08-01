package co.grandcircus.MovieSearch;

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
	@RequestMapping("/confirm")
	public String addFavorite(@RequestParam int movieId, Model model) {
		MovieModel movieModel = new MovieModel(movieId); 
		repo.save(movieModel);
		Optional<MovieModel> optionalMovieModel = repo.findByApiId(movieId);
		MovieModel retrievedMovieModel = optionalMovieModel.get();
		//movieModel.getId()
		model.addAttribute("movie", movieService.getMovieById(retrievedMovieModel.getApiId()));
		return "confirm";
	}
	@RequestMapping("/favorites")
	public String showFavorites() {
		return "favorites";
	}
	
	
}
