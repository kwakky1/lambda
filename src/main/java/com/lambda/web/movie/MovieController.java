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
    @Autowired MovieRepository movieRepository;
    @GetMapping("/{searchWord}/{pageNumber}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                         @PathVariable("searchWord") String searchWord){
        pxy.print("넘어온 페이지 번호 "+pageNumber);
        pager.setPageNow(pxy.interger(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.paging();
        IFunction<Pager, List<MovieDTO>> f = movieMapper::selectMovies;
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
}
