package com.blaizmiko.popcornapp.ui.movies.details.info;

import android.support.annotation.NonNull;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.blaizmiko.popcornapp.application.BaseApplication;
import com.blaizmiko.popcornapp.application.Constants;
import com.blaizmiko.popcornapp.common.network.api.MovieDbApi;
import com.blaizmiko.popcornapp.common.utils.FormatUtil;
import com.blaizmiko.popcornapp.data.db.Database;
import com.blaizmiko.popcornapp.data.db.models.movies.DetailedMovieDBModel;
import com.blaizmiko.popcornapp.ui.all.presentation.BaseMvpPresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class InfoMoviePresenter extends BaseMvpPresenter<InfoMovieView> {
    @Inject
    MovieDbApi movieDbApi;
    @Inject
    Database database;

    InfoMoviePresenter() {
        BaseApplication.getComponent().inject(this);
    }

    public void loadMovieInfo(final long movieId) {
        getViewState().startLoad();
        final Subscription creditsMovieSubscription = movieDbApi.getMovieInfo(movieId, Constants.MovieDbApi.IncludeImageLanguage, Constants.MovieDbApi.InfoDetailsMovieAppendToResponse)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(info -> {
                    Log.d("detailed_movie", ""+info);
                    updateDescription(info);
                    getViewState().updateMovieExtras(info);
                    database.putDetailedMovie(info);

                    //Log.d("checking", ""+info.getPosters().size());
                }, error -> {
                    Log.d("errorInfo", ""+error.getMessage());
                    error.printStackTrace();
                    getViewState().showError();
                    getViewState().finishLoad();
                }, () -> getViewState().finishLoad());

        unSubscribeOnDestroy(creditsMovieSubscription);


    }


    private void updateDescription(final DetailedMovieDBModel movieModel) {
        final String formattedReleaseDate = formatReleaseDate(movieModel.getReleaseDate());
        getViewState().showFormattedReleaseDate(formattedReleaseDate);
        final String formattedRuntime = formatRuntime(movieModel.getRuntime());
        getViewState().showFormattedRuntime(formattedRuntime);
        final String formattedBudget = formatBudget(movieModel.getBudget());
        getViewState().showFormattedBudget(formattedBudget);
        final String formattedRevenue = formatRevenue(movieModel.getRevenue());
        getViewState().showFormattedRevenue(formattedRevenue);
    }

    private String formatReleaseDate(@NonNull final String releaseDate) {
        return FormatUtil.parseDateToMaterialFormat(releaseDate, FormatUtil.ResultMaterialDateType.FULL);
    }

    private String formatRuntime(final int runtime) {
        return FormatUtil.parseTimeToMaterialFormat(runtime);
    }

    private String formatBudget(final int money) {
        return FormatUtil.parseMoneyToMaterialFormat(money);
    }

    private String formatRevenue(final int money) {
        return FormatUtil.parseMoneyToMaterialFormat(money);
    }
}