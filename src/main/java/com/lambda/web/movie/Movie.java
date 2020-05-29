package com.lambda.web.movie;



import javax.persistence.*;

@Entity(name ="movie")

public class Movie {
    public Long getMovieSeq() {
        return movieSeq;
    }

    public void setMovieSeq(Long movieSeq) {
        this.movieSeq = movieSeq;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRankDate() {
        return rankDate;
    }

    public void setRankDate(String rankDate) {
        this.rankDate = rankDate;
    }

    public Movie() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieSeq;
    @Column(length = 4)
    private String rank;
    @Column(length = 100)
    private String title;
    @Column(length = 10)
    private String rankDate;

}
