package com.blaizmiko.popcornapp.models.movies;

import com.google.gson.annotations.SerializedName;

public class ProductionCompany {
    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}