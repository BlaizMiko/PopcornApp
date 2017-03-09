package com.blaizmiko.popcornapp.ui.movies;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.blaizmiko.popcornapp.R;
import com.blaizmiko.popcornapp.application.Constants;
import com.blaizmiko.popcornapp.ui.ActivityNavigator;
import com.blaizmiko.ui.listeners.RecyclerViewLoadMore;
import com.blaizmiko.popcornapp.ui.all.adapters.TileAdapter;
import com.blaizmiko.popcornapp.ui.all.fragments.BaseMvpFragment;

import java.util.List;

import butterknife.BindView;

public class MoviesFragment extends BaseMvpFragment implements TileAdapter.MovieOnClickListener, RecyclerViewLoadMore.OnLoadMoreListener, LoadProgressView, NowMoviesView, PopularMoviesView, TopMoviesView, UpcomingMoviesView {

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
    @InjectPresenter
    LoadProgressPresenter mLoadProgressPresenter;

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

    private void initAdapters() {
        final Context context = getActivity().getApplicationContext();

        mNowPlayingMoviesAdapter = initAdapter(context, mNowMoviesRecyclerView, LinearLayoutManager.HORIZONTAL, TileAdapter.TileType.HORIZONTAL_TILE);
        mPopularMoviesAdapter = initAdapter(context, mPopularMoviesRecyclerView, LinearLayoutManager.HORIZONTAL, TileAdapter.TileType.VERTICAL_TILE);
        mTopMoviesAdapter = initAdapter(context, mTopRatedMoviesRecyclerView, LinearLayoutManager.HORIZONTAL, TileAdapter.TileType.VERTICAL_TILE);
        mUpcomingMoviesAdapter = initAdapter(context, mUpcomingMoviesRecyclerView, LinearLayoutManager.HORIZONTAL, TileAdapter.TileType.VERTICAL_TILE);
    }

    private TileAdapter initAdapter(final Context context, final RecyclerView recyclerView, final int layoutManagerType, final TileAdapter.TileType tileType) {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, layoutManagerType, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnScrollListener(new RecyclerViewLoadMore(this, linearLayoutManager));

        final TileAdapter adapter = new TileAdapter(context, tileType);
        recyclerView.setAdapter(adapter);
        adapter.setItemClickListener(this);
        return adapter;
    }

    //Movies presenters
    @Override
    public void showError() {
        Toast.makeText(getActivity().getApplicationContext(), "Sorry, an error occurred while establish server connection", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finishLoad() {
        mLoadProgressPresenter.hideProgress();
    }

    @Override
    public void startLoad() {
        mLoadProgressPresenter.showProgress();
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

    //LoadProgress presenter
    public void showProgress() {
        if (mProgressBar.getVisibility() != View.VISIBLE) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        if (mProgressBar.getVisibility() != View.GONE) {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    //Listeners
    @Override
    public void onLoadMore(final RecyclerView recyclerView, final int nextPage) {
        switch (recyclerView.getId()) {
            case R.id.fragment_movies_now_playing_recycler_view:
                mNowMoviesPresenter.loadNowMoviesList();
                break;
            case R.id.fragment_movies_popular_movies_recycler_view:
                mPopularMoviesPresenter.loadPopularMoviesList();
                break;
            case R.id.fragment_movies_top_movies_recycler_view:
                mTopRatedMoviesPresenter.loadTopRatedMoviesList();
                break;
            case R.id.fragment_movies_upcoming_movies_recycler_view:
                mUpcomingMoviesPresenter.loadUpcomingMoviesList();
                break;
        }
    }

    @Override
    public void onClick(View view, int pos, TileAdapter adapter) {
        final int movieId = adapter.getItemByPosition(pos).getId();

        final Bundle movieIdBundle = new Bundle();
        movieIdBundle.putInt(Constants.Bundles.ID, movieId);
        ActivityNavigator.startMovieDetailsActivity(getActivity(), movieId);
    }
}