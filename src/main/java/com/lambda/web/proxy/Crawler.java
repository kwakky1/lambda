package com.lambda.web.proxy;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component("crawler") @Lazy
public class Crawler extends Proxy {
    @Autowired Inventory<HashMap<String,String>> inventory;
    @Autowired Box<String> box;
    public ArrayList<HashMap<String,String>> bugsMusic(){
        inventory.clear();
        try{
            String url ="https://music.bugs.co.kr/chart";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36\"")
                    .execute();
            Document d = homepage.parse();
            Elements title = d.select("p.title");
            Elements artist = d.select("p.artist");
            Elements thumbnail = d.select("a.thumbnail");
            HashMap<String,String> map = null;
            for(int i=0;i<title.size();i++){
                map = new HashMap<>();
                map.put("seq",string(i+1));
                map.put("title",title.get(i).text());
                map.put("artists",artist.get(i).text());
                map.put("thumbnail",thumbnail.get(i).select("img").attr("src"));
                inventory.add(map);
            }
        }catch (Exception e){
            print("에러발생");
        }
        print("************************크롤링 결과*****************************");
        inventory.get().forEach(System.out::println);
        return inventory.get();
    }
}
