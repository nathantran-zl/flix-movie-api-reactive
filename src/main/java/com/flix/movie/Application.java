package com.flix.movie;

import com.flix.movie.model.Movie;
import com.flix.movie.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(MovieRepository repository) {
		return args -> {
			Flux.just(
					new Movie("movie1", "1", "movie1"),
					new Movie("movie2", "1", "movie2"),
					new Movie("movie3", "5", "movie3"),
					new Movie("movie4", "1", "movie4"),
					new Movie("movie5", "3", "movie5"),
					new Movie("movie6", "1", "movie6"),
					new Movie("movie7", "2", "movie7"),
					new Movie("movie8", "3", "movie8"),
					new Movie("movie9", "1", "movie9"),
					new Movie("movie10", "2", "movie10"),
					new Movie("movie11", "1", "movie11"),
					new Movie("movie12", "3", "movie12"),
					new Movie("movie13", "1", "movie13"),
					new Movie("movie14", "4", "movie14"),
					new Movie("movie15", "1", "movie15"),
					new Movie("movie16", "4", "movie16")
			).flatMap(repository::save)
					.thenMany(repository.findAll())
					.subscribe(System.out::println);

		};
	}
}
