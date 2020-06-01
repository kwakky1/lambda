package com.lambda.web.movie;

import com.lambda.web.mappers.MovieMapper;
import com.lambda.web.proxy.Box;
import com.lambda.web.proxy.IFunction;
import com.lambda.web.proxy.Pager;
import com.lambda.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
@RequestMapping("/movie")
public class MovieController extends Proxy {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;
    @GetMapping("/list/{pageNumber}/{searchWord}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                         @PathVariable("searchWord") String searchWord){
        if(searchWord.equals("")){
            pxy.print("검색어 없음");
        } else {
            pxy.print("검색어가"+searchWord);
        }
        pager.setPageNow(pxy.interger(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        IFunction<Pager, List<MovieDTO>> f = movieMapper::selectMovies;
        List<MovieDTO> l = f.apply(pager);
        pxy.print("**************\n");
        for(MovieDTO m : l) {
            pxy.print(m.toString());
        }
        box.clear();
        box.put("list",l);
        box.put("searchWord",searchWord);
        box.put("count",l.size());
        return box.get();
    }

}
