package com.arifrizkihidayat.moviecatalogue.data.source.local.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieAndDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;

import java.util.List;

@Dao
public interface MovieCatalogueDao {

    @Transaction
    @Query("SELECT * FROM moviesCatalogues WHERE movieType = :movieType")
    LiveData<List<MovieEntity>> getMoviesCatalogues(String movieType);

    @Transaction
    @Query("SELECT * FROM moviesCatalogues WHERE movieId = :movieId")
    LiveData<MovieAndDetailEntity> getMoviesAndDetailCatalogues(int movieId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovies(List<MovieEntity> movies);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovieDetail(MovieDetailEntity movieDetailEntity);

    @Transaction
    @Query("UPDATE moviesDetailCatalogues SET isFavorite = :isFavorite WHERE movieId = :movieId")
    void setFavoriteMovie(int movieId, boolean isFavorite);
}
