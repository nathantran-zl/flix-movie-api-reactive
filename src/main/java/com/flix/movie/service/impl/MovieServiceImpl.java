package com.flix.movie.service.impl;

import com.flix.movie.entity.Movie;
import com.flix.movie.repository.MovieRepository;
import com.flix.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Created by sromero on 2/20/17.
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Flux<Movie> findAllMovies(){
        return movieRepository.findAll();
    }

    @Override
    public Flux<Movie> findByRating(final String rating){
        return movieRepository.findByRating(rating);
    }
}
