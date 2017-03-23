package com.flix.movie.service;

import com.flix.movie.entity.Movie;
import com.flix.movie.web.model.request.MovieRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by sromero on 2/20/17.
 */
public interface MovieService {
    Flux<Movie> list();

    Flux<Movie> findByRating(String rating);

    Mono<Movie> update(String id, MovieRequest movieRequest);

    Mono<Movie> create(Mono<MovieRequest> movieRequest);

    Mono<Movie> read(String id);

    Mono<Movie> delete(String id);
}
