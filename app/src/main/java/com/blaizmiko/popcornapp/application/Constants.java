package com.blaizmiko.popcornapp.application;

public class Constants {

    public interface Api {
        String BasePealUrl = "https://api.themoviedb.org/3/";
        String BaseProfileImageUrl = "https://image.tmdb.org/t/p/w185";
        String BaseNowMovieImageUrl = "https://image.tmdb.org/t/p/w780";
        String BasePopularMovieImageUrl = "https://image.tmdb.org/t/p/w185";
        String ApiKey = "92e0a05bf5b6e05f60a73954b743558f";
        String Language = "en_US";

        //TestValues
        String NowMovieDefaultRegion = "US";
        int FirstPage = 1;
    }

    public interface NetworkingConfig {
        int TIMEOUT = 20;
    }
}
