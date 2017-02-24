package com.blaizmiko.popcornapp.presentation.views.movies;

import com.arellomobile.mvp.MvpView;
import com.blaizmiko.popcornapp.ui.adapters.TileAdapter;

import java.util.List;

public interface UpcomingMoviesView extends MvpView{
    void showError();
    void finishLoad();
    void startLoad();
    void setUpcomingMoviesList(List<TileAdapter.Item> topRatedMovies);
}