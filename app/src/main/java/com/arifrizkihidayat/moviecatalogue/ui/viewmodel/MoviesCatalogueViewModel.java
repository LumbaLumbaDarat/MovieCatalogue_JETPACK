package com.arifrizkihidayat.moviecatalogue.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.arifrizkihidayat.moviecatalogue.data.MovieCatalogueRepository;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;
import com.arifrizkihidayat.moviecatalogue.vo.Resource;

import java.util.List;

public class MoviesCatalogueViewModel extends ViewModel {

    private final MovieCatalogueRepository movieCatalogueRepository;

    public MoviesCatalogueViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    public LiveData<Resource<List<MovieEntity>>> getMoviesCatalogue() {
        return movieCatalogueRepository.getMoviesCatalogue();
    }

    public LiveData<Resource<List<MovieEntity>>> getTvShowsCatalogue() {
        return movieCatalogueRepository.getTvShowsCatalogue();
    }
}
