package com.arifrizkihidayat.moviecatalogue.data.source.remote.response.tvshowsresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import lombok.Setter;

public class SeasonResponse {

    @SerializedName("air_date")
    @Expose
    @Getter @Setter
    private String airDate;
    @SerializedName("episode_count")
    @Expose
    @Getter @Setter
    private Integer episodeCount;
    @SerializedName("id")
    @Expose
    @Getter @Setter
    private Integer id;
    @SerializedName("name")
    @Expose
    @Getter @Setter
    private String name;
    @SerializedName("overview")
    @Expose
    @Getter @Setter
    private String overview;
    @SerializedName("poster_path")
    @Expose
    @Getter @Setter
    private Object posterPath;
    @SerializedName("season_number")
    @Expose
    @Getter @Setter
    private Integer seasonNumber;

    public SeasonResponse() {
    }

    @NotNull
    @Override
    public String toString() {
        return "SeasonResponse{" +
                "airDate='" + airDate + '\'' +
                ", episodeCount=" + episodeCount +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", posterPath=" + posterPath +
                ", seasonNumber=" + seasonNumber +
                '}';
    }
}
