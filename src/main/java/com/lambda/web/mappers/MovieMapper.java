package com.lambda.web.mappers;

import com.lambda.web.movie.Movie;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieMapper {
    public void updateMovie();
    public void deleteMovie();
    public Movie selectMovies(Movie movie);
    public Movie selectMovie(Movie movie);
    public int count();
}
