package com.arifrizkihidayat.moviecatalogue.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieAndDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.room.MovieCatalogueDao;

import java.util.List;

public class MovieCatalogueLocalDataSource {

    private static MovieCatalogueLocalDataSource INSTANCE;
    private final MovieCatalogueDao movieCatalogueDao;

    public MovieCatalogueLocalDataSource(MovieCatalogueDao movieCatalogueDao) {
        this.movieCatalogueDao = movieCatalogueDao;
    }

    public static MovieCatalogueLocalDataSource getInstance(MovieCatalogueDao movieCatalogueDao) {
        if (INSTANCE == null)
            INSTANCE = new MovieCatalogueLocalDataSource(movieCatalogueDao);

        return INSTANCE;
    }

    public DataSource.Factory<Integer, MovieEntity> getMoviesCatalogues(String movieType) {
        return movieCatalogueDao.getMoviesCatalogues(movieType);
    }

    public DataSource.Factory<Integer, MovieEntity> getFavoriteMoviesCatalogues(String movieType) {
        return movieCatalogueDao.getFavoriteMoviesCatalogues(movieType, true);
    }

    public LiveData<MovieAndDetailEntity> getMovieDetailCatalogues(int movieId) {
        return movieCatalogueDao.getMoviesAndDetailCatalogues(movieId);
    }

    public void insertMovies(List<MovieEntity> movies) {
        movieCatalogueDao.insertMovies(movies);
    }

    public void insertMovieDetail(MovieDetailEntity movieDetailEntity) {
        movieCatalogueDao.insertMovieDetail(movieDetailEntity);
    }

    public void setFavoriteMovie(int movieId, boolean isFavorite) {
        movieCatalogueDao.setFavoriteMovie(movieId, isFavorite);
    }
}
