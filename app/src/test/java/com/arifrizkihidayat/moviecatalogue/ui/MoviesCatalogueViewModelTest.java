package com.arifrizkihidayat.moviecatalogue.ui;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.arifrizkihidayat.moviecatalogue.data.MovieCatalogueRepository;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;
import com.arifrizkihidayat.moviecatalogue.ui.viewmodel.MoviesCatalogueViewModel;
import com.arifrizkihidayat.moviecatalogue.utils.DummyData;
import com.arifrizkihidayat.moviecatalogue.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MoviesCatalogueViewModelTest {

    private MoviesCatalogueViewModel moviesCatalogueViewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieCatalogueRepository movieCatalogueRepository;

    @Mock
    private Observer<Resource<List<MovieEntity>>> observer;

    @Before
    public void setUp() {
        moviesCatalogueViewModel = new MoviesCatalogueViewModel(movieCatalogueRepository);
    }

    @Test
    public void getMovies() {
        Resource<List<MovieEntity>> dummyMovies = Resource.success(DummyData.dummyMovies());
        MutableLiveData<Resource<List<MovieEntity>>> resourceMutableLiveData = new MutableLiveData<>();
        resourceMutableLiveData.setValue(dummyMovies);

        when(movieCatalogueRepository.getMoviesCatalogue()).thenReturn(resourceMutableLiveData);
        List<MovieEntity> movieEntityList = moviesCatalogueViewModel.getMoviesCatalogue().getValue().data;
        verify(movieCatalogueRepository).getMoviesCatalogue();
        assertNotNull(movieEntityList);
        assertEquals(5, movieEntityList.size());

        moviesCatalogueViewModel.getMoviesCatalogue().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }

    @Test
    public void getTvShows() {
        Resource<List<MovieEntity>> dummyTvShows = Resource.success(DummyData.dummyTvShows());
        MutableLiveData<Resource<List<MovieEntity>>> resourceMutableLiveData = new MutableLiveData<>();
        resourceMutableLiveData.setValue(dummyTvShows);

        when(movieCatalogueRepository.getTvShowsCatalogue()).thenReturn(resourceMutableLiveData);
        List<MovieEntity> movieEntityList = moviesCatalogueViewModel.getTvShowsCatalogue().getValue().data;
        verify(movieCatalogueRepository).getTvShowsCatalogue();
        assertNotNull(movieEntityList);
        assertEquals(5, movieEntityList.size());

        moviesCatalogueViewModel.getTvShowsCatalogue().observeForever(observer);
        verify(observer).onChanged(dummyTvShows);
    }
}
