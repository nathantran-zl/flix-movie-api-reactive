package com.flix.movie.repository;

import com.flix.movie.entity.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Created by sromero on 2/20/17.
 */
@Repository
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {

    Flux<Movie> findByRating(String rating);
}
