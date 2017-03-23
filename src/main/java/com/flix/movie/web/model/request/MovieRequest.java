package com.flix.movie.web.model.request;

import java.math.BigInteger;

/**
 * Created by sromero on 2/20/17.
 */
public class MovieRequest {

    private String title;
    private String rating;
    private String description;

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
