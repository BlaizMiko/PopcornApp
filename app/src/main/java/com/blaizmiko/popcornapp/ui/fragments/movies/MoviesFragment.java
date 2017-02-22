package com.blaizmiko.popcornapp.ui.fragments.movies;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.blaizmiko.popcornapp.R;
import com.blaizmiko.popcornapp.presentation.presenters.CustomOnScrollListener;
import com.blaizmiko.popcornapp.presentation.presenters.Loader;
import com.blaizmiko.popcornapp.presentation.presenters.movies.NowMoviesPresenter;
import com.blaizmiko.popcornapp.presentation.presenters.movies.PopularMoviesPresenter;
import com.blaizmiko.popcornapp.presentation.presenters.movies.TopMoviesPresenter;
import com.blaizmiko.popcornapp.presentation.presenters.movies.UpcomingMoviesPresenter;
import com.blaizmiko.popcornapp.presentation.views.movies.NowMoviesView;
import com.blaizmiko.popcornapp.presentation.views.movies.PopularMoviesView;
import com.blaizmiko.popcornapp.presentation.views.movies.TopMoviesView;
import com.blaizmiko.popcornapp.presentation.views.movies.UpcomingMoviesView;
import com.blaizmiko.popcornapp.ui.adapters.TileAdapter;
import com.blaizmiko.popcornapp.ui.fragments.base.BaseMvpFragment;

import java.util.List;

import butterknife.BindView;

public class MoviesFragment extends BaseMvpFragment implements CustomOnScrollListener.CustomScrollListener, NowMoviesView, PopularMoviesView, TopMoviesView, UpcomingMoviesView {

    public static MoviesFragment newInstance() {
        return new MoviesFragment();
    }

    @InjectPresenter
    NowMoviesPresenter mNowMoviesPresenter;
    @InjectPresenter
    PopularMoviesPresenter mPopularMoviesPresenter;
    @InjectPresenter
    TopMoviesPresenter mTopRatedMoviesPresenter;
    @InjectPresenter
    UpcomingMoviesPresenter mUpcomingMoviesPresenter;

    private TileAdapter mNowPlayingMoviesAdapter, mPopularMoviesAdapter, mTopMoviesAdapter, mUpcomingMoviesAdapter;

    //Bind views
    @BindView(R.id.fragment_movies_now_playing_recycler_view)
    protected RecyclerView mNowMoviesRecyclerView;
    @BindView(R.id.fragment_movies_top_movies_recycler_view)
    protected RecyclerView mTopRatedMoviesRecyclerView;
    @BindView(R.id.fragment_movies_popular_movies_recycler_view)
    protected RecyclerView mPopularMoviesRecyclerView;
    @BindView(R.id.fragment_movies_progress_bar)
    protected ProgressBar mProgressBar;
    @BindView(R.id.fragment_movies_upcoming_movies_recycler_view)
    protected RecyclerView mUpcomingMoviesRecyclerView;

    //Life cycle
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    //Init methods
    @Override
    protected void bindViews() {
        initAdapters();

        mNowMoviesPresenter.loadNowMoviesList();
        mPopularMoviesPresenter.loadPopularMoviesList();
        mTopRatedMoviesPresenter.loadTopRatedMoviesList();
        mUpcomingMoviesPresenter.loadUpcomingMoviesList();
    }

    private void initAdapters(){
        final Context context = getActivity().getApplicationContext();

        mNowPlayingMoviesAdapter = initAdapter(context, mNowMoviesRecyclerView, LinearLayoutManager.HORIZONTAL, TileAdapter.TileType.HORIZONTAL_TILE, mNowMoviesPresenter);
        mPopularMoviesAdapter = initAdapter(context, mPopularMoviesRecyclerView, LinearLayoutManager.HORIZONTAL, TileAdapter.TileType.VERTICAL_TILE, mPopularMoviesPresenter);
        mTopMoviesAdapter = initAdapter(context, mTopRatedMoviesRecyclerView, LinearLayoutManager.HORIZONTAL, TileAdapter.TileType.VERTICAL_TILE, mTopRatedMoviesPresenter);
        mUpcomingMoviesAdapter = initAdapter(context, mUpcomingMoviesRecyclerView, LinearLayoutManager.HORIZONTAL, TileAdapter.TileType.VERTICAL_TILE, mUpcomingMoviesPresenter);
    }

    private TileAdapter initAdapter(final Context context, final RecyclerView recyclerView, final int layoutManagerType, final TileAdapter.TileType tileType, Loader presenter) {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, layoutManagerType, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        final TileAdapter adapter = new TileAdapter(context, tileType);
        recyclerView.setAdapter(adapter);
        CustomOnScrollListener customOnScrollListener = new CustomOnScrollListener(this);
        recyclerView.addOnScrollListener(customOnScrollListener);
        return adapter;
    }

    //Movies View
    @Override
    public void showProgress() {
        if(mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        if(mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError() {

    }

    @Override
    public void setNowMoviesList(final List<TileAdapter.Item> nowMoviesCells) {
        mNowPlayingMoviesAdapter.add(nowMoviesCells);
    }

    @Override
    public void setPopularMoviesList(final List<TileAdapter.Item> popularMoviesCells) {
        mPopularMoviesAdapter.add(popularMoviesCells);
    }

    @Override
    public void setTopMoviesList(final List<TileAdapter.Item> topMovies) {
        mTopMoviesAdapter.add(topMovies);
    }

    @Override
    public void setUpcomingMoviesList(final List<TileAdapter.Item> upcomingMoviesCells) {
        mUpcomingMoviesAdapter.add(upcomingMoviesCells);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        final int visibleItemCount = layoutManager.getChildCount();
        final int totalItemCount = layoutManager.getItemCount();
        final int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

        if (visibleItemCount + pastVisibleItems == totalItemCount) {
            switch(recyclerView.getId()) {
                case R.id.fragment_movies_now_playing_recycler_view:
                    //code
                    break;
                case R.id.fragment_movies_popular_movies_recycler_view:
                    //code
                    break;
                case R.id.fragment_movies_top_movies_recycler_view:
                    //code
                    break;
                case R.id.fragment_movies_upcoming_movies_recycler_view:
                    //code
                    break;
            }
        }
    }
}
