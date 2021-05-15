package com.arifrizkihidayat.moviecatalogue.data.source.remote.response.tvshowsresponse;

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

public class TvShowsDetailResponse {

    @SerializedName("backdrop_path")
    @Expose
    @Getter @Setter
    private String backdropPath;
    @SerializedName("created_by")
    @Expose
    @Getter @Setter
    private ArrayList<CreatedByResponse> createdByResponseArrayList = new ArrayList<>();
    @SerializedName("episode_run_time")
    @Expose
    @Getter @Setter
    private ArrayList<Integer> episodeRunTime = new ArrayList<>();
    @SerializedName("first_air_date")
    @Expose
    @Getter @Setter
    private String firstAirDate;
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
    @SerializedName("in_production")
    @Expose
    @Getter @Setter
    private Boolean inProduction;
    @SerializedName("languages")
    @Expose
    @Getter @Setter
    private ArrayList<String> languages = new ArrayList<>();
    @SerializedName("last_air_date")
    @Expose
    @Getter @Setter
    private String lastAirDate;
    @SerializedName("last_episode_to_air")
    @Expose
    @Getter @Setter
    private LastEpisodeToAirResponse lastEpisodeToAir;
    @SerializedName("name")
    @Expose
    @Getter @Setter
    private String name;
    @SerializedName("next_episode_to_air")
    @Expose
    @Getter @Setter
    private Object nextEpisodeToAir;
    @SerializedName("networks")
    @Expose
    @Getter @Setter
    private ArrayList<NetworkResponse> networkResponseArrayList = new ArrayList<>();
    @SerializedName("number_of_episodes")
    @Expose
    @Getter @Setter
    private Integer numberOfEpisodes;
    @SerializedName("number_of_seasons")
    @Expose
    @Getter @Setter
    private Integer numberOfSeasons;
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
    @SerializedName("production_companies")
    @Expose
    @Getter @Setter
    private ArrayList<ProductionCompaniesResponse> productionCompaniesResponseArrayList = new ArrayList<>();
    @SerializedName("production_countries")
    @Expose
    @Getter @Setter
    private ArrayList<ProductionCountriesResponse> productionCountriesResponseArrayList = new ArrayList<>();
    @SerializedName("seasons")
    @Expose
    @Getter @Setter
    private ArrayList<SeasonResponse> seasonResponseArrayList = new ArrayList<>();
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
    @SerializedName("type")
    @Expose
    @Getter @Setter
    private String type;
    @SerializedName("vote_average")
    @Expose
    @Getter @Setter
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    @Getter @Setter
    private Integer voteCount;

    public TvShowsDetailResponse() {
    }

    @NotNull
    @Override
    public String toString() {
        return "TvShowsDetailResponse{" +
                "backdropPath='" + backdropPath + '\'' +
                ", createdByResponseArrayList=" + createdByResponseArrayList +
                ", episodeRunTime=" + episodeRunTime +
                ", firstAirDate='" + firstAirDate + '\'' +
                ", genresResponseArrayList=" + genresResponseArrayList +
                ", homepage='" + homepage + '\'' +
                ", id=" + id +
                ", inProduction=" + inProduction +
                ", languages=" + languages +
                ", lastAirDate='" + lastAirDate + '\'' +
                ", lastEpisodeToAir=" + lastEpisodeToAir +
                ", name='" + name + '\'' +
                ", nextEpisodeToAir=" + nextEpisodeToAir +
                ", networkResponseArrayList=" + networkResponseArrayList +
                ", numberOfEpisodes=" + numberOfEpisodes +
                ", numberOfSeasons=" + numberOfSeasons +
                ", originCountry=" + originCountry +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", originalName='" + originalName + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", posterPath='" + posterPath + '\'' +
                ", productionCompaniesResponseArrayList=" + productionCompaniesResponseArrayList +
                ", productionCountriesResponseArrayList=" + productionCountriesResponseArrayList +
                ", seasonResponseArrayList=" + seasonResponseArrayList +
                ", spokenLanguageResponseArrayList=" + spokenLanguageResponseArrayList +
                ", status='" + status + '\'' +
                ", tagline='" + tagline + '\'' +
                ", type='" + type + '\'' +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                '}';
    }
}
