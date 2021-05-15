package com.arifrizkihidayat.moviecatalogue.data.source.local.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import lombok.Getter;
import lombok.Setter;

public class MovieAndDetailEntity {
    @Embedded
    @Getter @Setter
    public MovieEntity movieEntity;

    @Relation(
            parentColumn = "movieId",
            entityColumn = "movieId"
    )
    @Getter @Setter
    public MovieDetailEntity movieDetailEntity;

    public MovieAndDetailEntity() {
    }

    @Override
    public String toString() {
        return "MovieAndDetailEntity{" +
                "movieEntity=" + movieEntity +
                ", movieDetailEntity=" + movieDetailEntity +
                '}';
    }
}
