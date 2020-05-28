package com.lambda.web.music;

import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Data
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="music")
@Lazy
public class Music {
    public Long getMusicNo() {
        return musicNo;
    }

    public void setMusicNo(Long musicNo) {
        this.musicNo = musicNo;
    }

    public String getSqe() {
        return sqe;
    }

    public void setSqe(String sqe) {
        this.sqe = sqe;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Music(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicNo;
    @Column(length = 10, nullable =false)
    private String sqe;
    @Column(length = 50, nullable =false)
    private String title;
    @Column(length = 50, nullable =false)
    private String artists;
    @Column(length = 200, nullable =false)
    private String thumbnail;


    @Builder
    public Music(String seq,String title, String artists, String thumbnail){
        this.sqe = seq;
        this.title = title;
        this.artists = artists;
        this.thumbnail = thumbnail;
    }
}
