package com.flix.movie.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by sromero on 2/20/17.
 */
@Document
public class Movie {

    @Id
    private String id;
    private String title;
    private String rating;
    private String description;

    public Movie(String title, String rating, String description) {
        this.title = title;
        this.rating = rating;
        this.description = description;
    }

    public Movie() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
