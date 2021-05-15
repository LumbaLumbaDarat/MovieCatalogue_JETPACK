package com.arifrizkihidayat.moviecatalogue.data.source.remote.response.tvshowsresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class TvShowsInListResponse {

    @SerializedName("backdrop_path")
    @Expose
    @Getter @Setter
    private String backdropPath;
    @SerializedName("first_air_date")
    @Expose
    @Getter @Setter
    private String firstAirDate;
    @SerializedName("genre_ids")
    @Expose
    @Getter @Setter
    private ArrayList<Integer> genreIds = new ArrayList<>();
    @SerializedName("id")
    @Expose
    @Getter @Setter
    private Integer id;
    @SerializedName("name")
    @Expose
    @Getter @Setter
    private String name;
    @SerializedName("origin_country")
    @Expose
    @Getter @Setter
    private ArrayList<String> originCountry = new ArrayList<>();
    @SerializedName("original_language")
    @Expose
    @Getter @Setter
    private String originalLanguage;
    @SerializedName("original_name")
    @Expose
    @Getter @Setter
    private String originalName;
    @SerializedName("overview")
    @Expose
    @Getter @Setter
    private String overview;
    @SerializedName("popularity")
    @Expose
    @Getter @Setter
    private Double popularity;
    @SerializedName("poster_path")
    @Expose
    @Getter @Setter
    private String posterPath;
    @SerializedName("vote_average")
    @Expose
    @Getter @Setter
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    @Getter @Setter
    private Integer voteCount;

    public TvShowsInListResponse() {
    }

    @NotNull
    @Override
    public String toString() {
        return "TvShowsInListResponse{" +
                "backdropPath='" + backdropPath + '\'' +
                ", firstAirDate='" + firstAirDate + '\'' +
                ", genreIds=" + genreIds +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", originCountry=" + originCountry +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", originalName='" + originalName + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", posterPath='" + posterPath + '\'' +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                '}';
    }
}
