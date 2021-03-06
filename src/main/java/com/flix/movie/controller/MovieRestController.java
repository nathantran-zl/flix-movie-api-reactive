package com.flix.movie.controller;

import com.flix.movie.model.Movie;
import com.flix.movie.service.MovieService;
import com.flix.movie.dto.request.MovieRequest;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * Created by sromero on 2/20/17.
 */
@RestController
public class MovieRestController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/movies")
    public Flux<Movie> list() {

        return movieService.list();
    }

    @GetMapping(value = "/moviesByRating")
    public Flux<ResponseEntity<Movie>> findByRating(
            @RequestParam(value = "rating", required = false) final String rating) {

        return movieService.findByRating(rating)
                .map(m -> new ResponseEntity<>(m, HttpStatus.OK));

    }

    @GetMapping("/movies/{movieId}")
    public Mono<ResponseEntity<Movie>> read(
            @PathVariable("movieId") final String movieId) {

        return movieService.read(movieId)
                .map(m -> new ResponseEntity<>(m, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/movies/{movieId}")
    public Mono<ResponseEntity<Movie>> delete(
            @PathVariable("movieId") final String movieId) {

        return movieService.delete(movieId)
                .map(m -> new ResponseEntity<>(m, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/movies/{movieId}")
    public Mono<ResponseEntity<Movie>> update(
            @PathVariable("movieId") final String movieId,
            @RequestBody final MovieRequest movieRequest) {

        return movieService.update(movieId, movieRequest)
                .map(m -> new ResponseEntity<>(m, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/movies")
    public Mono<ResponseEntity<Movie>> create(
            @RequestBody final Mono<MovieRequest> movieRequest) {

        return movieService.create(movieRequest)
                .map(m -> new ResponseEntity<>(m, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Movie> getProductEvents() {
        return Flux.interval(Duration.ofSeconds(1))
            .map(val ->
                new Movie("movie1", "1", "movie1")
            );
    }

}
