package com.arifrizkihidayat.moviecatalogue.data;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieAndDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;
import com.arifrizkihidayat.moviecatalogue.vo.Resource;

import java.util.List;

public interface MovieCatalogueDataSource {
    LiveData<Resource<PagedList<MovieEntity>>> getMoviesCatalogue();
    LiveData<Resource<PagedList<MovieEntity>>> getTvShowsCatalogue();

    LiveData<PagedList<MovieEntity>> getFavoriteMoviesCatalogue();
    LiveData<PagedList<MovieEntity>> getFavoriteTvShowsCatalogue();

    LiveData<Resource<MovieAndDetailEntity>> getMovieDetailCatalogue(int movieId);
    LiveData<Resource<MovieAndDetailEntity>> getTvShowDetailCatalogue(int movieId);

    void setFavoriteMovie(int movieId, boolean isFavorite);
}
