package com.lambda.web.proxy;

import com.lambda.web.movie.Movie;
import com.lambda.web.movie.MovieRepository;
import com.lambda.web.music.Music;
import com.lambda.web.music.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.HashMap;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
public class ProxyController{
    @Autowired Box<Object> box;
    @Autowired Crawler crawler;
    @Autowired Proxy pxy;
    @Autowired FileUploader upload;
    @Autowired MusicRepository musicRepository;
    @Autowired MovieRepository movieRepository;

    @GetMapping("/bugsMusic/{searchWord}")
    public HashMap<String,Object> bugsmusic(@RequestBody String searchWord){
        pxy.print("넘어온 키워드: "+searchWord);
        box.clear();
        if(musicRepository.count() == 0) crawler.bugsMusic();
        List<Music> list = musicRepository.findAll();
        box.put("list",list);
        box.put("search",searchWord);
        box.put("count",list.size());
        return box.get();
    }
    @GetMapping("/soccer/{searchWord}")
    public HashMap<String ,Object> soccer(@PathVariable String searchWord){
        pxy.print("넘어온 키워드"+searchWord);
        upload.upload();
        return null;
    }
    @GetMapping("/movie/{searchWord}")
    public HashMap<String ,Object> movie(@PathVariable String searchWord){
        pxy.print("넘어온 키워드"+searchWord);
        if(movieRepository.count()==0){crawler.movie();}
        List<Movie> list = movieRepository.findAll();
        box.put("list",list);
        box.put("count",list.size());
        box.put("search",searchWord);
        return box.get();
    }
}

