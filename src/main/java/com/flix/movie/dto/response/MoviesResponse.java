package com.flix.movie.dto.response;

import com.flix.movie.model.Movie;

import java.util.List;

/**
 * Created by sromero on 2/20/17.
 */
public class MoviesResponse {

    private Long count;
    private List<Movie> data;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<Movie> getData() {
        return data;
    }

    public void setData(List<Movie> data) {
        this.data = data;
    }
}
