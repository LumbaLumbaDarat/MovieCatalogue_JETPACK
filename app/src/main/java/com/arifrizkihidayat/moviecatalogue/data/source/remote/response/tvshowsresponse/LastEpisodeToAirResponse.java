package com.arifrizkihidayat.moviecatalogue.data.source.remote.response.tvshowsresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import lombok.Setter;

public class LastEpisodeToAirResponse {

    @SerializedName("air_date")
    @Expose
    @Getter @Setter
    private String airDate;
    @SerializedName("episode_number")
    @Expose
    @Getter @Setter
    private Integer episodeNumber;
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
    @SerializedName("production_code")
    @Expose
    @Getter @Setter
    private String productionCode;
    @SerializedName("season_number")
    @Expose
    @Getter @Setter
    private Integer seasonNumber;
    @SerializedName("still_path")
    @Expose
    @Getter @Setter
    private Object stillPath;
    @SerializedName("vote_average")
    @Expose
    @Getter @Setter
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    @Getter @Setter
    private Integer voteCount;

    public LastEpisodeToAirResponse() {
    }

    @NotNull
    @Override
    public String toString() {
        return "LastEpisodeToAirResponse{" +
                "airDate='" + airDate + '\'' +
                ", episodeNumber=" + episodeNumber +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", productionCode='" + productionCode + '\'' +
                ", seasonNumber=" + seasonNumber +
                ", stillPath=" + stillPath +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                '}';
    }
}
