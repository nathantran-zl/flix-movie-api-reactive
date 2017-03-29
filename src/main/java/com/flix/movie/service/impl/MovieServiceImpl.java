package com.flix.movie.service.impl;

import com.flix.movie.entity.Movie;
import com.flix.movie.repository.MovieRepository;
import com.flix.movie.service.MovieService;
import com.flix.movie.web.model.request.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by sromero on 2/20/17.
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Flux<Movie> list(){
        return movieRepository.findAll();
    }


    @Override
    public Flux<Movie> findByRating(final String rating){
        return movieRepository.findByRating(rating);
    }

    @Override
    public Mono<Movie> update(String id, MovieRequest movieRequest) {

       return movieRepository.findOne(id).map(existingMovie -> {

           if(movieRequest.getDescription() != null){
               existingMovie.setDescription(movieRequest.getDescription());
           }
           if(movieRequest.getRating() != null){
               existingMovie.setRating(movieRequest.getRating());
           }
           if(movieRequest.getTitle() != null) {
               existingMovie.setTitle(movieRequest.getTitle());
           }

           return existingMovie;

       }).then(movieRepository::save);
    }

    @Override
    public Mono<Movie> create(Mono<MovieRequest> movieRequest) {

        return movieRequest.map(newMovie -> {

            Movie movie = new Movie();

            if(newMovie.getDescription() != null){
                movie.setDescription(newMovie.getDescription());
            }
            if(newMovie.getRating() != null){
                movie.setRating(newMovie.getRating());
            }
            if(newMovie.getTitle() != null) {
                movie.setTitle(newMovie.getTitle());
            }

            return movie;

        }).then(movieRepository::save);
    }

    @Override
    public Mono<Movie> read(String id) {
        return movieRepository.findOne(id);
    }

    @Override
    public Mono<Movie> delete(String id) {
        Mono<Movie> movie = movieRepository.findOne(id);
        movie.then(m -> movieRepository.delete(id));
        return movie;
    }
}
