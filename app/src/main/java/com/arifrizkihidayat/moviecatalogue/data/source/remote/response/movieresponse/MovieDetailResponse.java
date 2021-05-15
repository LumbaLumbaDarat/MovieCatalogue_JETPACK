package com.arifrizkihidayat.moviecatalogue.data.source.remote.response.movieresponse;

import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.GenresResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.ProductionCompaniesResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.ProductionCountriesResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.SpokenLanguageResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class MovieDetailResponse {

    @SerializedName("adult")
    @Expose
    @Getter @Setter
    private Boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    @Getter @Setter
    private String backdropPath;
    @SerializedName("belongs_to_collection")
    @Expose
    @Getter @Setter
    private Object belongsToCollection;
    @SerializedName("budget")
    @Expose
    @Getter @Setter
    private Integer budget;
    @SerializedName("genres")
    @Expose
    @Getter @Setter
    private ArrayList<GenresResponse> genresResponseArrayList = new ArrayList<>();
    @SerializedName("homepage")
    @Expose
    @Getter @Setter
    private String homepage;
    @SerializedName("id")
    @Expose
    @Getter @Setter
    private Integer id;
    @SerializedName("imdb_id")
    @Expose
    @Getter @Setter
    private String imdbId;
    @SerializedName("original_language")
    @Expose
    @Getter @Setter
    private String originalLanguage;
    @SerializedName("original_title")
    @Expose
    @Getter @Setter
    private String originalTitle;
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
    @SerializedName("production_companies")
    @Expose
    @Getter @Setter
    private ArrayList<ProductionCompaniesResponse> productionCompaniesResponseArrayList = new ArrayList<>();
    @SerializedName("production_countries")
    @Expose
    @Getter @Setter
    private ArrayList<ProductionCountriesResponse> productionCountriesResponseArrayList = new ArrayList<>();
    @SerializedName("release_date")
    @Expose
    @Getter @Setter
    private String releaseDate;
    @SerializedName("revenue")
    @Expose
    @Getter @Setter
    private Integer revenue;
    @SerializedName("runtime")
    @Expose
    @Getter @Setter
    private Integer runtime;
    @SerializedName("spoken_languages")
    @Expose
    @Getter @Setter
    private ArrayList<SpokenLanguageResponse> spokenLanguageResponseArrayList = new ArrayList<>();
    @SerializedName("status")
    @Expose
    @Getter @Setter
    private String status;
    @SerializedName("tagline")
    @Expose
    @Getter @Setter
    private String tagline;
    @SerializedName("title")
    @Expose
    @Getter @Setter
    private String title;
    @SerializedName("video")
    @Expose
    @Getter @Setter
    private Boolean video;
    @SerializedName("vote_average")
    @Expose
    @Getter @Setter
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    @Getter @Setter
    private Integer voteCount;

    public MovieDetailResponse() {
    }

    @NotNull
    @Override
    public String toString() {
        return "MovieDetailResponse{" +
                "adult=" + adult +
                ", backdropPath='" + backdropPath + '\'' +
                ", belongsToCollection=" + belongsToCollection +
                ", budget=" + budget +
                ", genresResponseArrayList=" + genresResponseArrayList +
                ", homepage='" + homepage + '\'' +
                ", id=" + id +
                ", imdbId='" + imdbId + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", posterPath='" + posterPath + '\'' +
                ", productionCompaniesResponseArrayList=" + productionCompaniesResponseArrayList +
                ", productionCountriesResponseArrayList=" + productionCountriesResponseArrayList +
                ", releaseDate='" + releaseDate + '\'' +
                ", revenue=" + revenue +
                ", runtime=" + runtime +
                ", spokenLanguageResponseArrayList=" + spokenLanguageResponseArrayList +
                ", status='" + status + '\'' +
                ", tagline='" + tagline + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                '}';
    }
}
