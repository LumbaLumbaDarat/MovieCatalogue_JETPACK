package com.arifrizkihidayat.moviecatalogue.ui;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.arifrizkihidayat.moviecatalogue.data.MovieCatalogueRepository;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieAndDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;
import com.arifrizkihidayat.moviecatalogue.ui.viewmodel.MovieDetailViewModel;
import com.arifrizkihidayat.moviecatalogue.utils.DummyData;
import com.arifrizkihidayat.moviecatalogue.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieDetailViewModelTest {

    private MovieDetailViewModel movieDetailViewModel;

    private final MovieEntity movieEntityDummy = DummyData.dummyMovies().get(0);
    private final int movieId = movieEntityDummy.getMovieId();

    private final MovieEntity tvShowEntityDummy = DummyData.dummyTvShows().get(0);
    private final int tvShowId = tvShowEntityDummy.getMovieId();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieCatalogueRepository movieCatalogueRepository;

    @Mock
    private Observer<Resource<MovieAndDetailEntity>> observer;

    @Before
    public void setUp() {
        movieDetailViewModel = new MovieDetailViewModel(movieCatalogueRepository);
    }

    @Test
    public void getDetailMovie() {
        movieDetailViewModel.getMovieDetail(movieId);

        Resource<MovieAndDetailEntity> dummyDetailMovie = Resource.success(DummyData.dummyDetailMovie(movieEntityDummy));
        MutableLiveData<Resource<MovieAndDetailEntity>> resourceMutableLiveData = new MutableLiveData<>();
        resourceMutableLiveData.setValue(dummyDetailMovie);

        when(movieCatalogueRepository.getMovieDetailCatalogue(movieId)).thenReturn(resourceMutableLiveData);
        verify(movieCatalogueRepository).getMovieDetailCatalogue(movieId);

        movieDetailViewModel.getMovieDetail(movieId).observeForever(observer);
        verify(observer).onChanged(dummyDetailMovie);
    }

    @Test
    public void getDetailTvShow() {
        movieDetailViewModel.getTvShowDetail(tvShowId);

        Resource<MovieAndDetailEntity> dummyDetailTvShow = Resource.success(DummyData.dummyDetailMovie(tvShowEntityDummy));
        MutableLiveData<Resource<MovieAndDetailEntity>> resourceMutableLiveData = new MutableLiveData<>();
        resourceMutableLiveData.setValue(dummyDetailTvShow);

        when(movieCatalogueRepository.getTvShowDetailCatalogue(tvShowId)).thenReturn(resourceMutableLiveData);
        verify(movieCatalogueRepository).getTvShowDetailCatalogue(tvShowId);

        movieDetailViewModel.getTvShowDetail(tvShowId).observeForever(observer);
        verify(observer).onChanged(dummyDetailTvShow);
    }
}
