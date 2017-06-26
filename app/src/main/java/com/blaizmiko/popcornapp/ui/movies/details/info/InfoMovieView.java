package com.blaizmiko.popcornapp.ui.movies.details.info;

import com.arellomobile.mvp.MvpView;
import com.blaizmiko.popcornapp.data.db.models.movies.DetailedMovieDBModel;
import com.blaizmiko.popcornapp.ui.all.adapters.TileAdapter;

import java.util.List;

public interface InfoMovieView extends MvpView{
    void showFormattedReleaseDate(String releaseDate);
    void showFormattedRuntime(String runtime);
    void showFormattedBudget(String budget);
    void showFormattedRevenue(String revenue);
    void updateMovieExtras(DetailedMovieDBModel movie);

    void finishLoad();
    void showError();
    void startLoad();
}
