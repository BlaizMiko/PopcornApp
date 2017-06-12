package com.blaizmiko.popcornapp.data.db.models.movies;

import com.blaizmiko.popcornapp.data.models.cinema.BaseCinemaModel;
import com.blaizmiko.popcornapp.ui.all.adapters.TileAdapter;
import java.util.ArrayList;
import java.util.List;
import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Relation;
import io.objectbox.annotation.Generated;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.BoxStore;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

@Entity
public class DetailedMovieDBModel {
    @Relation()
    private MoviesResponseDBModel moviesResponseDBModel;
    private long moviesResponseDBModelId;
    @Id(assignable = true)
    private long id;
    private String posterPath;
    private String title;
    private double voteAverage;
    private String backdropPath;
    private String overview;
    private String releaseDate;
    private int budget;
    private String imdbId;
    private int revenue;
    private int runtime;
    @Backlink
    List<GenreDBModel> genres = new ToMany<>(this, DetailedMovieDBModel_.genres);
    @Backlink
    List<ImageDBModel> posters = new ToMany<>(this, DetailedMovieDBModel_.posters);
    @Backlink
    List<ImageDBModel> backdrops = new ToMany<>(this, DetailedMovieDBModel_.backdrops);
    @Backlink
    List<VideoDBModel> videos = new ToMany<>(this, DetailedMovieDBModel_.videos);
    /** Used to resolve relations */
    @Internal
    @Generated(1307364262)
    transient BoxStore __boxStore;
    @Internal
    @Generated(1722143452)
    transient ToOne<MoviesResponseDBModel> moviesResponseDBModelToOne = new ToOne<>(this,
            DetailedMovieDBModel_.moviesResponseDBModel);

    public DetailedMovieDBModel(BaseCinemaModel baseCinemaModel) {
        this.title = baseCinemaModel.getTitle();
        this.backdropPath = baseCinemaModel.getBackdropPath();
        this.id = baseCinemaModel.getId();
        this.posterPath = baseCinemaModel.getPosterPath();
        this.voteAverage = baseCinemaModel.getVoteAverage();
    }

    public DetailedMovieDBModel(final TileAdapter.Item item) {
        this.title = item.getTitle();
        this.backdropPath = item.getBackdropUrl();
        this.id = item.getId();
        this.posterPath = item.getPosterUrl();
        this.voteAverage = item.getRating();
    }

    @Generated(903066836)
    @Internal
    /** This constructor was generated by ObjectBox and may change any time. */
    public DetailedMovieDBModel(long moviesResponseDBModelId, long id, String posterPath, String title,
            double voteAverage, String backdropPath, String overview, String releaseDate, int budget,
            String imdbId, int revenue, int runtime) {
        this.moviesResponseDBModelId = moviesResponseDBModelId;
        this.id = id;
        this.posterPath = posterPath;
        this.title = title;
        this.voteAverage = voteAverage;
        this.backdropPath = backdropPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.budget = budget;
        this.imdbId = imdbId;
        this.revenue = revenue;
        this.runtime = runtime;
    }

    @Generated(60458136)
    public DetailedMovieDBModel() {
    }

    public static List<DetailedMovieDBModel> fromTileAdapterItem(final List<TileAdapter.Item> items) {
        final List<DetailedMovieDBModel> resultList = new ArrayList<>(items.size());
        for (TileAdapter.Item item : items) {
            resultList.add(new DetailedMovieDBModel(item));
        }
        return resultList;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(2069896203)
    public MoviesResponseDBModel getMoviesResponseDBModel() {
        moviesResponseDBModel = moviesResponseDBModelToOne.getTarget(this.moviesResponseDBModelId);
        return moviesResponseDBModel;
    }

    /** Set the to-one relation including its ID property. */
    @Generated(961395787)
    public void setMoviesResponseDBModel(MoviesResponseDBModel moviesResponseDBModel) {
        moviesResponseDBModelToOne.setTarget(moviesResponseDBModel);
        this.moviesResponseDBModel = moviesResponseDBModel;
    }

    public long getMoviesResponseDBModelId() {
        return moviesResponseDBModelId;
    }

    public void setMoviesResponseDBModelId(long moviesResponseDBModelId) {
        this.moviesResponseDBModelId = moviesResponseDBModelId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    } 
}

