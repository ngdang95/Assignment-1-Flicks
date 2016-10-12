package com.example.dangfiztssi.flicks.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DangF on 10/11/16.
 */

public class Movie {
    @SerializedName("title")
    private String mTitle;

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("poster_path")
    private String mPoster;

    @SerializedName("backdrop_path")
    private String mBackdrop;

    @SerializedName("release_date")
    private String mReleaseDate;

    @SerializedName("vote_average")
    private float mVoteAverage;

    @SerializedName("id")
    private Integer mId;

    public String getTitle() {
        return mTitle;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getPoster() {
        return mPoster;
    }

    public String getBackdrop() {
        return mBackdrop;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public float getVoteAverage() {
        return mVoteAverage;
    }

    public Integer getId() {
        return mId;
    }

    @Override
    public String toString() {
        return mId + " - " + mTitle + " - " + mVoteAverage;
    }
}
