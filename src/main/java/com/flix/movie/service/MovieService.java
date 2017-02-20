package com.flix.movie.service;

import com.flix.movie.entity.Movie;
import reactor.core.publisher.Flux;

/**
 * Created by sromero on 2/20/17.
 */
public interface MovieService {
    Flux<Movie> findAllMovies();

    Flux<Movie> findByRating(String rating);
}
