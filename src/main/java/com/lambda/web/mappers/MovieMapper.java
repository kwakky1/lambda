package com.lambda.web.mappers;

import com.lambda.web.movie.Movie;
import com.lambda.web.movie.MovieDTO;
import com.lambda.web.proxy.Pager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieMapper {
    public void insertMovie(MovieDTO movieDTO);
    public void updateMovie(MovieDTO movieDTO);
    public void deleteMovie(MovieDTO movieDTO);
    public List<MovieDTO> selectMovies(Pager pager);
    public MovieDTO selectMovie(String movieSeq);
    public int count();
}
