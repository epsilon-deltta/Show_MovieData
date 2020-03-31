package com.example.devilshot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scracher {
    ArrayList<MovieData> movies = new ArrayList<MovieData>();
    public Scracher(ArrayList<MovieData> movies){
        this.movies=movies;
    }

    public void exec() throws IOException{
        String url = "https://movie.naver.com/movie/running/current.nhn?view=list&tab=normal&order=reserve";
        String imgUrl;
        String old;
        String tittle;
        String stars;
        String category;
        String showTimes;

        Document doc = Jsoup.connect(url).get();
        Elements parents =this.getParentTags(doc);
        for (Element ele : parents) {
            imgUrl    = ele.select(".thumb img").attr("src");
            old       = ele.select(".tit span").text();
            tittle    = ele.select(".tit a").text();
            stars     = ele.select(".info_star .num").text();
            category  = ele.select(".link_txt").first().text();
            showTimes = this.filterShowtimes( ele.select(".info_txt1 dd").first().ownText());
            this.movies.add(new MovieData( imgUrl, old, tittle, stars, category, showTimes) );
        }

//        this.movies.stream()
//                .filter(x->Double.parseDouble(x.stars)>7)
//                .forEach(x->System.out.println(x.tittle));
    }
    public String filterShowtimes(String data) {
        String showTimes = "";
        Pattern pattern = Pattern.compile("\\d*분");
        Matcher matcher = pattern.matcher(data);

        if (matcher.find()) {
            showTimes = matcher.group();
        } else {
            System.out.println("it can't find showTimes string");
        }
        return showTimes;
    }

    public Elements getParentTags(Document doc) {
        Elements parents = doc.select(".lst_detail_t1 li");
        return parents;
    }
}
