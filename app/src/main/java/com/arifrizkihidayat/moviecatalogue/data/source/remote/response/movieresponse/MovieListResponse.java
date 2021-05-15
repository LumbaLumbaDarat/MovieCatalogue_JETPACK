package com.arifrizkihidayat.moviecatalogue.data.source.remote.response.movieresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class MovieListResponse {

    @SerializedName("page")
    @Expose
    @Getter @Setter
    private Integer page;
    @SerializedName("results")
    @Expose
    @Getter @Setter
    private ArrayList<MovieInListResponse> movieInListResponseList = new ArrayList<>();
    @SerializedName("total_pages")
    @Expose
    @Getter @Setter
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    @Getter @Setter
    private Integer totalResults;

    public MovieListResponse() {
    }

    @NotNull
    @Override
    public String toString() {
        return "MovieListResponse{" +
                "page=" + page +
                ", movieInListResponseList=" + movieInListResponseList +
                ", totalPages=" + totalPages +
                ", totalResults=" + totalResults +
                '}';
    }
}
