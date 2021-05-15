package com.arifrizkihidayat.moviecatalogue.data.source.remote.response.movieresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class MovieInListResponse {

    @SerializedName("adult")
    @Expose
    @Getter @Setter
    private Boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    @Getter @Setter
    private String backdropPath;
    @SerializedName("genre_ids")
    @Expose
    @Getter @Setter
    private ArrayList<Integer> genreIds = new ArrayList<>();
    @SerializedName("id")
    @Expose
    @Getter @Setter
    private Integer id;
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
    @SerializedName("release_date")
    @Expose
    @Getter @Setter
    private String releaseDate;
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

    public MovieInListResponse() {
    }

    @NotNull
    @Override
    public String toString() {
        return "MovieInListResponse{" +
                "adult=" + adult +
                ", backdropPath='" + backdropPath + '\'' +
                ", genreIds=" + genreIds +
                ", id=" + id +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", posterPath='" + posterPath + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                '}';
    }
}
