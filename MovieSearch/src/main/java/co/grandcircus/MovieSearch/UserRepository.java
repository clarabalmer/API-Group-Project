package co.grandcircus.MovieSearch;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;

public interface UserRepository extends MongoRepository<UserModel, String> {
	List<UserModel> findAll();
	Optional<UserModel> findByUsername(String username);
	UserModel save(UserModel entity);
	void deleteByUsername(String username);
	@Update("{ '$push' : { 'favorites' : ?1 } } ")
	void findAndPushFavoriteByUsername(String username, MovieModel movieModel);
	@Update("{ '$pull' : { 'favorites' : ?1 } }")
	void findAndPullFavoriteByUsername(String username, MovieModel movieModel);
	@Update("{ '$push' : { 'toWatch' : ?1 } }")
	void findAndPushToWatchByUsername(String username, MovieModel movieModel);
	@Update("{ '$pull' : { 'toWatch' : ?1 } }")
	void findAndPullToWatchByUsername(String username, MovieModel movieModel);
}
