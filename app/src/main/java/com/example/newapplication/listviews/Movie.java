package com.example.newapplication.listviews;


/**
 * Movie is a model or DTO (Data transfer object) class, which set and transfer a data from one class
 * to another
 */
public class Movie {
    private String title, releaseDate, imageUrl;

    /**
     * Created constructor of a Movie class to get the required values
     */
    public Movie(String title,String releaseDate, String imageUrl){
        this.title = title;
        this.releaseDate = releaseDate;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
