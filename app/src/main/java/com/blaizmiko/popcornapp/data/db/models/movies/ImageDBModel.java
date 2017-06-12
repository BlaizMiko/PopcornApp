package com.blaizmiko.popcornapp.data.db.models.movies;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Generated;
import io.objectbox.annotation.Relation;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.BoxStore;
import io.objectbox.relation.ToOne;

@Entity
public class ImageDBModel {
    @Relation()
    private DetailedMovieDBModel detailedMovieDBModel;
    private long detailedMovieDBModelId;
    @Id(assignable = true)
    private long id;
    private double aspectRatio;
    private String filePath;
    private double height;
    private String language;
    private double voteAverage;
    private int voteCount;
    private int width;
    /** Used to resolve relations */
    @Internal
    @Generated(1307364262)
    transient BoxStore __boxStore;
    @Generated(1309412093)
    @Internal
    /** This constructor was generated by ObjectBox and may change any time. */
    public ImageDBModel(long detailedMovieDBModelId, long id, double aspectRatio,
            String filePath, double height, String language, double voteAverage,
            int voteCount, int width) {
        this.detailedMovieDBModelId = detailedMovieDBModelId;
        this.id = id;
        this.aspectRatio = aspectRatio;
        this.filePath = filePath;
        this.height = height;
        this.language = language;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.width = width;
    }
    @Generated(13788059)
    public ImageDBModel() {
    }
    @Internal
    @Generated(1722896605)
    transient ToOne<DetailedMovieDBModel> detailedMovieDBModelToOne = new ToOne<>(
            this, ImageDBModel_.detailedMovieDBModel);
    /** To-one relationship, resolved on first access. */
    @Generated(1730563088)
    public DetailedMovieDBModel getDetailedMovieDBModel() {
        detailedMovieDBModel = detailedMovieDBModelToOne
                .getTarget(this.detailedMovieDBModelId);
        return detailedMovieDBModel;
    }
    /** Set the to-one relation including its ID property. */
    @Generated(924616133)
    public void setDetailedMovieDBModel(DetailedMovieDBModel detailedMovieDBModel) {
        detailedMovieDBModelToOne.setTarget(detailedMovieDBModel);
        this.detailedMovieDBModel = detailedMovieDBModel;
    }
    public long getDetailedMovieDBModelId() {
        return detailedMovieDBModelId;
    }
    public void setDetailedMovieDBModelId(long detailedMovieDBModelId) {
        this.detailedMovieDBModelId = detailedMovieDBModelId;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getAspectRatio() {
        return aspectRatio;
    }
    public void setAspectRatio(double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public double getVoteAverage() {
        return voteAverage;
    }
    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }
    public int getVoteCount() {
        return voteCount;
    }
    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
}
