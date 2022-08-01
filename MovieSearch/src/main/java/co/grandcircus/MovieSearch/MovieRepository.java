package co.grandcircus.MovieSearch;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<MovieModel, String> {
	
	List<MovieModel> findAll();
	
	void deleteById(String id);
	
	MovieModel save(MovieModel entity );
	
	Optional<MovieModel> findByApiId(int apiId);
	
}
