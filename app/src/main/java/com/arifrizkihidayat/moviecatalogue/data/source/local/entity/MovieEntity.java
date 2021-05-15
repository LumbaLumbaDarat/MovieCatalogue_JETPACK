package com.arifrizkihidayat.moviecatalogue.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Entity(tableName = "moviesCatalogues")
public class MovieEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    @Getter @Setter
    private int movieId;

    @ColumnInfo(name = "movieType")
    @Getter @Setter
    private String movieType;

    @ColumnInfo(name = "movieTitle")
    @Getter @Setter
    private String movieTitle;

    @ColumnInfo(name = "movieOverview")
    @Getter @Setter
    private String movieOverview;

    @ColumnInfo(name = "movieUserScore")
    @Getter @Setter
    private double movieUserScore;

    @ColumnInfo(name = "moviePoster")
    @Getter @Setter
    private String moviePoster;

    public MovieEntity() {
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "movieId=" + movieId +
                ", movieType='" + movieType + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieOverview='" + movieOverview + '\'' +
                ", movieUserScore=" + movieUserScore +
                ", moviePoster='" + moviePoster + '\'' +
                '}';
    }
}
