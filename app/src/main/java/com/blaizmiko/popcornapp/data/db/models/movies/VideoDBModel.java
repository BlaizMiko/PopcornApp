package com.blaizmiko.popcornapp.data.db.models.movies;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
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
    private long idModel;
    @Index
    @SerializedName("id")
    private String serverId;
    @SerializedName("iso_639_1")
    private String region;
    @SerializedName("iso_3166_1")
    private String language;
    @SerializedName("key")
    private String key;
    @SerializedName("name")
    private String name;
    @SerializedName("site")
    private String site;
    @SerializedName("size")
    private int size;
    @SerializedName("type")
    private String type;
    /** Used to resolve relations */
    @Internal
    @Generated(1307364262)
    transient BoxStore __boxStore;

    @Generated(1854501014)
    @Internal
    /** This constructor was generated by ObjectBox and may change any time. */
    public VideoDBModel(long detailedMovieDBModelId, long idModel, String serverId,
            String region, String language, String key, String name, String site,
            int size, String type) {
        this.detailedMovieDBModelId = detailedMovieDBModelId;
        this.idModel = idModel;
        this.serverId = serverId;
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

    public void setDetailedMovieDBModelId(long detailedMovieDBModelId) {
        this.detailedMovieDBModelId = detailedMovieDBModelId;
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
    public String getServerId() {
        return serverId;
    }
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }
    public long getDetailedMovieDBModelId() {
        return detailedMovieDBModelId;
    }

    public long getIdModel() {
        return idModel;
    }

    public void setIdModel(long idModel) {
        this.idModel = idModel;
    }

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

}
