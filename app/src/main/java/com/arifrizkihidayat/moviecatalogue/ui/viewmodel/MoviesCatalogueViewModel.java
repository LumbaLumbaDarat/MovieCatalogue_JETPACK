package com.arifrizkihidayat.moviecatalogue.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.arifrizkihidayat.moviecatalogue.data.MovieCatalogueRepository;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;
import com.arifrizkihidayat.moviecatalogue.vo.Resource;

import java.util.List;

public class MoviesCatalogueViewModel extends ViewModel {

    private final MovieCatalogueRepository movieCatalogueRepository;

    public MoviesCatalogueViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    public LiveData<Resource<PagedList<MovieEntity>>> getMoviesCatalogue() {
        return movieCatalogueRepository.getMoviesCatalogue();
    }

    public LiveData<PagedList<MovieEntity>> getFavoriteMoviesCatalogue() {
        return movieCatalogueRepository.getFavoriteMoviesCatalogue();
    }

    public LiveData<Resource<PagedList<MovieEntity>>> getTvShowsCatalogue() {
        return movieCatalogueRepository.getTvShowsCatalogue();
    }

    public LiveData<PagedList<MovieEntity>> getFavoriteTvShowsCatalogue() {
        return movieCatalogueRepository.getFavoriteTvShowsCatalogue();
    }
}
