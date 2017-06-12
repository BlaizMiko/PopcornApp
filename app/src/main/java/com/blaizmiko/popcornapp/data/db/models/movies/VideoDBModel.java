package com.blaizmiko.popcornapp.data.db.models.movies;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Relation;
import io.objectbox.annotation.Generated;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.BoxStore;
import io.objectbox.relation.ToOne;

@Entity
public class VideoDBModel {
    private long detailedMovieDBModelId;
    @Relation()
    private DetailedMovieDBModel detailedMovieDBModel;
    @Id(assignable = true)
    private long id;
    private String region;
    private String language;
    private String key;
    private String name;
    private String site;
    private int size;
    private String type;
    /** Used to resolve relations */
    @Internal
    @Generated(1307364262)
    transient BoxStore __boxStore;
    @Generated(1339626802)
    @Internal
    /** This constructor was generated by ObjectBox and may change any time. */
    public VideoDBModel(long detailedMovieDBModelId, long id, String region,
            String language, String key, String name, String site, int size,
            String type) {
        this.detailedMovieDBModelId = detailedMovieDBModelId;
        this.id = id;
        this.region = region;
        this.language = language;
        this.key = key;
        this.name = name;
        this.site = site;
        this.size = size;
        this.type = type;
    }
    @Generated(1540980780)
    public VideoDBModel() {
    }
    @Internal
    @Generated(2117117426)
    transient ToOne<DetailedMovieDBModel> detailedMovieDBModelToOne = new ToOne<>(
            this, VideoDBModel_.detailedMovieDBModel);
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
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSite() {
        return site;
    }
    public void setSite(String site) {
        this.site = site;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
