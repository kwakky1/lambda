package com.lambda.web.movie;

import com.lambda.web.mappers.MovieMapper;
import com.lambda.web.proxy.Box;
import com.lambda.web.proxy.Pager;
import com.lambda.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
@RequestMapping("/movie")
public class MovieController extends Proxy {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;
    @Autowired MovieRepository movieRepository;
    @GetMapping("/{searchWord}/{pageNumber}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                         @PathVariable("searchWord") String searchWord){
        if(searchWord.equals("null")){
            pxy.print("검색어가 없음");
            pager.setSearchWord("");
        } else {
            pxy.print("검색어가: "+searchWord);
            pager.setSearchWord(searchWord);
        }
        pxy.print("넘어온 검색어"+searchWord+'\n');
        pxy.print("넘어온 페이지 번호 "+pageNumber);
        pager.setPageNow(pxy.interger(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.paging();
        Function<Pager, List<MovieDTO>> f = movieMapper::selectMovies;
        List<MovieDTO> list = f.apply(pager);
        pxy.print("**************\n");
        for(MovieDTO m : list){
            pxy.print(m.toString());
        }
        box.clear();
        box.put("list",list);
        box.put("pager",pager);
        return box.get();
    }
    @GetMapping("/{searchWord}")
    public MovieDTO detail(@PathVariable String searchWord){
        return movieMapper.selectMovie(searchWord);
    }
}
