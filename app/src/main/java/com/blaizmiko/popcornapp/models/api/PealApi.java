package com.blaizmiko.popcornapp.models.api;

import com.blaizmiko.popcornapp.models.Movie.NowPlayingMovies;
import com.blaizmiko.popcornapp.models.Movie.PopularMovies;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PealApi {

    @GET("/movie/popular")
    Observable<PopularMovies> getPopularMovies(@Query("api_key") String api_key,
                                                 @Query("language") String language,
                                                 @Query("page") int page,
                                                 @Query("region") String region);

    @GET("/movie/now_playing")
    Observable<NowPlayingMovies> getNowPlayingMovies(@Query("api_key") String api_key,
                                                       @Query("language") String language,
                                                       @Query("page") int page,
                                                       @Query("region") String region);

}