package com.lambda.web.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.HashMap;


@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
public class ProxyController {
    @Autowired Crawler crawler;
//    @PostMapping("/벅스 뮤직")
//    public ArrayList<HashMap<String ,String>> crawler(){
//        return crawler.bugsMusic();
//    }
    @Autowired Box<Object> box;
    @Autowired Proxy pxy;
    @PostMapping("/crawler")
    public HashMap<String,Object> bugsMusic(@RequestBody String searchWord){
        pxy.print("넘어온 키워드"+searchWord);
        box.clear();
        ArrayList<HashMap<String,String>> list = crawler.bugsMusic();
        box.put("list",list);
        pxy.print("조회한 수 :"+list.size());
        box.put("count",list.size());
        return box.get();
    }
}

