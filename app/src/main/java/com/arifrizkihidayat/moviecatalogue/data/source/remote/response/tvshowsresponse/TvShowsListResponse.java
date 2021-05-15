package com.arifrizkihidayat.moviecatalogue.data.source.remote.response.tvshowsresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class TvShowsListResponse {

    @SerializedName("page")
    @Expose
    @Getter @Setter
    private Integer page;
    @SerializedName("results")
    @Expose
    @Getter @Setter
    private ArrayList<TvShowsInListResponse> tvShowsInListResponseArrayList = new ArrayList<>();
    @SerializedName("total_pages")
    @Expose
    @Getter @Setter
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    @Getter @Setter
    private Integer totalResults;

    public TvShowsListResponse() {
    }

    @NotNull
    @Override
    public String toString() {
        return "TvShowsListResponse{" +
                "page=" + page +
                ", tvShowsInListResponseArrayList=" + tvShowsInListResponseArrayList +
                ", totalPages=" + totalPages +
                ", totalResults=" + totalResults +
                '}';
    }
}
