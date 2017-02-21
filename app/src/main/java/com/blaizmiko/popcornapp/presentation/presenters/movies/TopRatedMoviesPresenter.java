package com.blaizmiko.popcornapp.presentation.presenters.movies;

import com.arellomobile.mvp.InjectViewState;
import com.blaizmiko.popcornapp.application.BaseApplication;
import com.blaizmiko.popcornapp.application.Constants;
import com.blaizmiko.popcornapp.common.api.PealApi;
import com.blaizmiko.popcornapp.presentation.presenters.base.BaseMvpPresenter;
import com.blaizmiko.popcornapp.presentation.views.movies.TopRatedMoviesView;
import com.blaizmiko.popcornapp.ui.adapters.TileAdapter;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class TopRatedMoviesPresenter extends BaseMvpPresenter<TopRatedMoviesView> {
    @Inject
    PealApi mPealApi;
    public TopRatedMoviesPresenter() {
        BaseApplication.getComponent().inject(this);
    }

    public void loadTopRatedMoviesList() {
        getViewState().showProgress();

        final Subscription topRatedMoviesSubscription = mPealApi
                .getTopRatedMovies(Constants.Api.ApiKey, Constants.Api.Language, Constants.Api.FirstPage, Constants.Api.NowMovieDefaultRegion)
                .flatMap(topRatedMovies -> Observable.from(topRatedMovies.getMovies()))
                .filter(briefMovie -> briefMovie != null)
                .map(briefMovie -> new TileAdapter.Item(briefMovie.getPosterPath(), briefMovie.getTitle(), briefMovie.getVoteAverage()))
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(moviesList -> {
                    getViewState().setTopRatedMoviesList(moviesList);
                }, error -> {
                    getViewState().hideProgress();
                    getViewState().showError();
                });

        unSubscribeOnDestroy(topRatedMoviesSubscription);
    }
}
