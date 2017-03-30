package com.blaizmiko.popcornapp.injection;
import com.blaizmiko.popcornapp.injection.modules.ApplicationModule;
import com.blaizmiko.popcornapp.injection.modules.ApiModule;
import com.blaizmiko.popcornapp.injection.modules.NetworkModule;
import com.blaizmiko.popcornapp.ui.actors.PopularActorsPresenter;
import com.blaizmiko.popcornapp.ui.movies.details.cast.CastMoviePresenter;
import com.blaizmiko.popcornapp.ui.movies.reviews.ReviewPresenter;
import com.blaizmiko.popcornapp.ui.tvshows.details.cast.CastTvShowPresenter;
import com.blaizmiko.popcornapp.ui.movies.details.info.InfoMoviePresenter;
import com.blaizmiko.popcornapp.ui.tvshows.details.info.InfoTvShowPresenter;
import com.blaizmiko.popcornapp.ui.all.presentation.rating.RatingPresenter;
import com.blaizmiko.popcornapp.ui.movies.nowplaying.NowPlayingMoviesPresenter;
import com.blaizmiko.popcornapp.ui.movies.popular.PopularMoviesPresenter;
import com.blaizmiko.popcornapp.ui.movies.top.TopMoviesPresenter;
import com.blaizmiko.popcornapp.ui.movies.upcoming.UpcomingMoviesPresenter;
import com.blaizmiko.popcornapp.ui.movies.details.review.ReviewsPresenter;
import com.blaizmiko.popcornapp.ui.tvshows.episodes.SeasonTvShowPresenter;
import com.blaizmiko.popcornapp.ui.tvshows.nowplaying.NowPlayingTvShowsPresenter;
import com.blaizmiko.popcornapp.ui.tvshows.popular.PopularTvShowsPresenter;
import com.blaizmiko.popcornapp.ui.tvshows.top.TopTvShowsPresenter;
import com.blaizmiko.popcornapp.ui.tvshows.upcoming.UpcomingTvShowsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class, NetworkModule.class})
public interface ApplicationComponent {

    //Movies
    void inject(PopularActorsPresenter actorsListPresenter);
    void inject(NowPlayingMoviesPresenter moviesListPresenter);
    void inject(PopularMoviesPresenter popularMoviesPresenter);
    void inject(TopMoviesPresenter topRatedMoviesPresenter);
    void inject(UpcomingMoviesPresenter upcomingMoviesPresenter);
    void inject(RatingPresenter ratingPresenter);

    //Movie details
    void inject(ReviewsPresenter reviewsPresenter);
    void inject(InfoTvShowPresenter tvShowPresenter);
    void inject(InfoMoviePresenter infoMoviePresenter);
    void inject(CastMoviePresenter castMoviePresenter);

    //Movie reviews
    void inject(ReviewPresenter reviewPresenter);

    //Tv Shows
    void inject(PopularTvShowsPresenter popularTvShowsPresenter);
    void inject(TopTvShowsPresenter topTvShowsPresenter);
    void inject(NowPlayingTvShowsPresenter nowPlayingTVShowsPresenter);
    void inject(UpcomingTvShowsPresenter upcomingTvShowsPresenter);

    //Tv Shows details
    void inject(CastTvShowPresenter castTvShowPresenter);

    //Tv Shows episodes
    void inject(SeasonTvShowPresenter seasonTvShowPresenter);

}
