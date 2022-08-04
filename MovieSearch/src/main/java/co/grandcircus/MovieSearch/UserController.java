package co.grandcircus.MovieSearch;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	@Autowired
	private MovieService movieService;
	@Autowired
	private UserRepository repo;
	
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	@RequestMapping("/userhome")
	public String showHomepage(@RequestParam String username, Model model) {
		model.addAttribute("username", username);
		return "userhome";
	}
	@PostMapping("/login")
	public String userLogin(@RequestParam String username, Model model) {
		Optional<UserModel> optUser = repo.findByUsername(username);
		String message = "";
		if (optUser.isPresent()) {
			message = "Welcome back, " + username + "!";
		} else {
			message = "Welcome for the first time, " + username + "!";
			repo.save(new UserModel(username));
		}
		model.addAttribute("username", username);
		model.addAttribute("message", message);
		return "userhome";
	}
	@PostMapping("/mySearch")
	public String userSearch(@RequestParam String username, @RequestParam String search, Model model) {
		search = search.replace(' ', '+');
		model.addAttribute("username", username);
		model.addAttribute("movieArray", movieService.getSearchResults(search).getResults());
		return "userresults";
	}
	@PostMapping("/addMyFavorites")
	public String addMyFavorites(@RequestParam String username, @RequestParam int movieId, Model model) {
		repo.findAndPushFavoriteByUsername(username, new MovieModel(movieId, -1));
		model.addAttribute("username", username);
		Optional<UserModel> optUser = repo.findByUsername(username);
		UserModel user = optUser.get();
		ArrayList<MovieModel> faveModels = user.getFavorites();
		ArrayList<Movie> favorites = new ArrayList<>();
		for (int i = 0; i < faveModels.size(); i++) {
			favorites.add(movieService.getMovieById(faveModels.get(i).getApiId()));
		}
		model.addAttribute("favorites", favorites);
		return "userfavorites";
	}
	@PostMapping("/addToWatch")
	public String addToWatch(@RequestParam String username, @RequestParam int movieId, Model model) {
		repo.findAndPushToWatchByUsername(username, new MovieModel(movieId, -1));
		model.addAttribute("username", username);
		Optional<UserModel> optUser = repo.findByUsername(username);
		UserModel user = optUser.get();
		ArrayList<MovieModel> watchModels = user.getToWatch();
		ArrayList<Movie> toWatch = new ArrayList<>();
		for (int i = 0; i < watchModels.size(); i++) {
			toWatch.add(movieService.getMovieById(watchModels.get(i).getApiId()));
		}
		model.addAttribute("toWatch", toWatch);
		return "towatch";
	}
	@RequestMapping("/myFavorites")
	public String showMyFavorites(@RequestParam String username, Model model) {
		model.addAttribute("username", username);
		Optional<UserModel> optUser = repo.findByUsername(username);
		UserModel user = optUser.get();
		ArrayList<MovieModel> faveModels = user.getFavorites();
		ArrayList<Movie> favorites = new ArrayList<>();
		for (int i = 0; i < faveModels.size(); i++) {
			favorites.add(movieService.getMovieById(faveModels.get(i).getApiId()));
		}
		model.addAttribute("favorites", favorites);
		return "userfavorites";
	}
	@PostMapping("/userDeleteFavorite")
	public String userDeleteFave(@RequestParam int movieId, @RequestParam String username, Model model) {
		repo.findAndPullFavoriteByUsername(username, new MovieModel(movieId, -1));
		String message = "We deleted that movie for you, " + username + " .";
		model.addAttribute("message", message);
		model.addAttribute("username", username);
		return "userhome";
	}
	@PostMapping("/userDeleteToWatch")
	public String userDeleteWatch(@RequestParam int movieId, @RequestParam String username, Model model) {
		repo.findAndPullToWatchByUsername(username, new MovieModel(movieId, -1));
		String message = "We deleted that movie for you, " + username + " .";
		model.addAttribute("message", message);
		model.addAttribute("username", username);
		return "userhome";
	}
	@RequestMapping("/myToWatch")
	public String showMyToWatch(@RequestParam String username, Model model) {
		model.addAttribute("username", username);
		Optional<UserModel> optUser = repo.findByUsername(username);
		UserModel user = optUser.get();
		ArrayList<MovieModel> watchModels = user.getToWatch();
		ArrayList<Movie> toWatch = new ArrayList<>();
		for (int i = 0; i < watchModels.size(); i++) {
			toWatch.add(movieService.getMovieById(watchModels.get(i).getApiId()));
		}
		model.addAttribute("toWatch", toWatch);
		return "towatch";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "home";
	}
}
