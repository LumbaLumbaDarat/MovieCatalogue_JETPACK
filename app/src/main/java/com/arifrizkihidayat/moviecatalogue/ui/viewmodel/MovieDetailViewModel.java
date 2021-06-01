package com.arifrizkihidayat.moviecatalogue.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.arifrizkihidayat.moviecatalogue.data.MovieCatalogueRepository;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieAndDetailEntity;
import com.arifrizkihidayat.moviecatalogue.vo.Resource;

public class MovieDetailViewModel extends ViewModel {

    private final MovieCatalogueRepository movieCatalogueRepository;

    public MovieDetailViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    public LiveData<Resource<MovieAndDetailEntity>> getMovieDetail(int movieId) {
        return movieCatalogueRepository.getMovieDetailCatalogue(movieId);
    }

    public LiveData<Resource<MovieAndDetailEntity>> getTvShowDetail(int movieId) {
        return movieCatalogueRepository.getTvShowDetailCatalogue(movieId);
    }

    public void setFavoriteMovie(int movieId, boolean isFavorite) {
        movieCatalogueRepository.setFavoriteMovie(movieId, isFavorite);
    }
}
