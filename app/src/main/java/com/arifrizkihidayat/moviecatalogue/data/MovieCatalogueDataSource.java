package com.arifrizkihidayat.moviecatalogue.data;

import androidx.lifecycle.LiveData;

import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieAndDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;
import com.arifrizkihidayat.moviecatalogue.vo.Resource;

import java.util.List;

public interface MovieCatalogueDataSource {
    LiveData<Resource<List<MovieEntity>>> getMoviesCatalogue();
    LiveData<Resource<MovieAndDetailEntity>> getMovieDetailCatalogue(int movieId);
    LiveData<Resource<List<MovieEntity>>> getTvShowsCatalogue();
    LiveData<Resource<MovieAndDetailEntity>> getTvShowDetailCatalogue(int movieId);
}