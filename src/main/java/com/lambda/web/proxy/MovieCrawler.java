package com.lambda.web.proxy;

import com.lambda.web.movie.Movie;
import com.lambda.web.movie.MovieRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component("movieCrawler") @Lazy
public class MovieCrawler extends Proxy {
    @Autowired Inventory<Movie> inventory;
    @Autowired MovieRepository movieRepository;
    @Autowired Box<String> box;
    public void movie(){
        inventory.clear();
        try{
            String url ="https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36\"")
                    .execute();
            Document d = homepage.parse();
            Elements movieName = d.select("div.tit3");
            Movie movie = null;
            for(int i=0;i<movieName.size();i++){
                movie = new Movie();
                movie.setMovieName(movieName.get(i).text());
                movieRepository.save(movie);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
