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
	@PostMapping("/confirm")
	public String showConfirmation(@RequestParam String action, @RequestParam int movieId, @RequestParam double rating, Model model) {
		switch (action) {
			case "add":
				Optional<MovieModel> checkMovieModel = repo.findByApiId(movieId);
				
				if(checkMovieModel.isPresent()) {
					String message = "That movie is already in the public favorites list";
					model.addAttribute("message", message);
					model.addAttribute("movie", movieService.getMovieById(movieId));
				}else {
					
					MovieModel movieModel = new MovieModel(movieId, rating); 
					repo.save(movieModel);
					Optional<MovieModel> optionalMovieModel = repo.findByApiId(movieId);
					MovieModel retrievedMovieModel = optionalMovieModel.get();
					Movie movie = movieService.getMovieById(retrievedMovieModel.getApiId());
					String message = movie.getTitle() + " successfully added to public favorites";
					model.addAttribute("message", message);
					model.addAttribute("movie", movie);
					model.addAttribute("rating", rating);
				}
				break;
			case "delete":
				repo.deleteByApiId(movieId);
				Movie movie = movieService.getMovieById(movieId);
				model.addAttribute("movie", movie);
				String message = movie.getTitle() + " was deleted from the public favorites list";
				model.addAttribute("message", message);
				break;
			default:
				break;
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
	
	@PostMapping("/overview")
	public String showOverview(@RequestParam int id, Model model) {
		model.addAttribute("movie", movieService.getMovieById(id));
		return "overview";
	}
	
}
