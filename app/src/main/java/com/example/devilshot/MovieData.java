package com.example.devilshot;

public class MovieData {
// mainTest.movies.add(new MovieData(ele.select(".thumb img").attr("src"),
// ele.select(".tit span").text(), ele.select(".tit a").text(),
// ele.select(".info_star .num").text(), category, showTimes))

    String imgUrl;
    String old;
    String tittle;
    String stars;
    String category;
    String showTimes;

    public MovieData(String imgUrl, String old, String tittle, String stars, String category, String showTimes) {
        this.imgUrl = imgUrl;
        this.old = old;
        this.tittle = tittle;
        this.stars = stars;
        this.category = category;
        this.showTimes = showTimes;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getOld() {
        return old;
    }
    public void setOld(String old) {
        this.old = old;
    }
    public String getTittle() {
        return tittle;
    }
    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
    public String getstars() {
        return stars;
    }
    public void setstars(String stars) {
        this.stars = stars;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getShowTimes() {
        return showTimes;
    }
    public void setShowTimes(String showTimes) {
        this.showTimes = showTimes;
    }

    @Override
    public String toString() {
        return  this.imgUrl+" "+this.old +" "+ this.tittle+ " "+ this.stars+ " "+this.category+" "+ this.showTimes;
    }

}