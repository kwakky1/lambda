package com.lambda.web.proxy;


import com.lambda.web.music.Music;
import com.lambda.web.music.MusicRepository;
import com.lambda.web.soccer.Player;
import com.lambda.web.soccer.PlayerDTO;
import com.lambda.web.soccer.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("uploader")@Lazy
public class FileUploader extends Proxy {

    @Autowired Inventory<String> inventory;
    @Autowired PlayerRepository playerRepository;
    @Autowired
    MusicRepository musicRepository;

    List<String> temp = new ArrayList<>();
    public void upload(){
        inventory.clear();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\bit2\\IdeaProjects\\lambda\\src\\main\\resources\\static\\files\\player.csv")));
            String player = "";
            while ((player = reader.readLine())!= null){
                inventory.add(player);
            }
        }catch (Exception e){
            print("파일리딩 실패");
            e.printStackTrace();}
        print("-----------------------------------------------\n");
        print(inventory.get().get(0).toString());

        String [] arr = inventory.get().get(0).split(",");
        Player p = new Player();
        p.setPlayerId(arr[0]);
        p.setPlayerName(arr[1]);
        p.setePlayerName(arr[3]);
        p.setNickname(arr[4]);
        p.setJoinYyyy(arr[5]);
        p.setPosition(arr[6]);
        p.setBackNo(arr[7]);
        p.setNation(arr[8]);
        p.setBirthDate(arr[9]);
        p.setSolar(arr[10]);
        p.setHeight(arr[11]);
        p.setWeight(arr[12]);
        print("-----------------------------------------------\n");
        print(p.toString());
        playerRepository.save(p);
    }
}
