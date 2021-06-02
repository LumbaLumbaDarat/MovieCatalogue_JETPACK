package com.arifrizkihidayat.moviecatalogue.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity(tableName = "moviesDetailCatalogues")
public class MovieDetailEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieDetailId")
    @Getter @Setter
    private int movieDetailId;

    @ColumnInfo(name = "movieId")
    @Getter @Setter
    private int movieId;

    @ColumnInfo(name = "movieGenres")
    @Getter @Setter
    private String movieGenres;

    @ColumnInfo(name = "movieOverview")
    @Getter @Setter
    private String movieOverview;

    @ColumnInfo(name = "movieReleaseStatus")
    @Getter @Setter
    private String movieReleaseStatus;

    @ColumnInfo(name = "movieReleaseDate")
    @Getter @Setter
    private String movieReleaseDate;

    @ColumnInfo(name = "movieRunTime")
    @Getter @Setter
    private int movieRunTime;

    @ColumnInfo(name = "movieHomePage")
    @Getter @Setter
    private String movieHomePage;

    @ColumnInfo(name = "movieUserScore")
    @Getter @Setter
    private double movieUserScore;

    @ColumnInfo(name = "moviePoster")
    @Getter @Setter
    private String moviePoster;

    public MovieDetailEntity() {
    }

    @NotNull
    @Override
    public String toString() {
        return "MovieDetailEntity{" +
                "movieDetailId=" + movieDetailId +
                ", movieId=" + movieId +
                ", movieGenres='" + movieGenres + '\'' +
                ", movieOverview='" + movieOverview + '\'' +
                ", movieReleaseStatus='" + movieReleaseStatus + '\'' +
                ", movieReleaseDate='" + movieReleaseDate + '\'' +
                ", movieRunTime=" + movieRunTime +
                ", movieHomePage='" + movieHomePage + '\'' +
                ", movieUserScore=" + movieUserScore +
                ", moviePoster='" + moviePoster + '\'' +
                '}';
    }
}
