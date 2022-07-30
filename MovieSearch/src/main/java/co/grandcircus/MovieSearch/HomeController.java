package co.grandcircus.MovieSearch;

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
		
		model.addAttribute("movie", movieService.getMovieById(movieId));
		return "confirm";
	}
	@RequestMapping("/favorites")
	public String showFavorites() {
		return "favorites";
	}
}
