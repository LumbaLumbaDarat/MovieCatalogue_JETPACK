package com.arifrizkihidayat.moviecatalogue.ui;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.arifrizkihidayat.moviecatalogue.data.MovieCatalogueRepository;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;
import com.arifrizkihidayat.moviecatalogue.ui.viewmodel.MoviesCatalogueViewModel;
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
    private Observer<Resource<PagedList<MovieEntity>>> resourceObserver;

    @Mock
    private Observer<PagedList<MovieEntity>> observer;

    @Mock
    private PagedList<MovieEntity> movieEntityPagedList;

    @Mock
    private PagedList<MovieEntity> favoriteMovieEntityPagedList;

    @Mock
    private PagedList<MovieEntity> tvShowEntityPagedList;

    @Mock
    private PagedList<MovieEntity> favoriteTvShowEntityPagedList;

    @Before
    public void setUp() {
        moviesCatalogueViewModel = new MoviesCatalogueViewModel(movieCatalogueRepository);
    }

    @Test
    public void getMovies() {
        Resource<PagedList<MovieEntity>> dummyMovies = Resource.success(movieEntityPagedList);
        when(dummyMovies.data.size()).thenReturn(5);
        MutableLiveData<Resource<PagedList<MovieEntity>>> resourceMutableLiveData = new MutableLiveData<>();
        resourceMutableLiveData.setValue(dummyMovies);

        when(movieCatalogueRepository.getMoviesCatalogue()).thenReturn(resourceMutableLiveData);
        List<MovieEntity> movieEntityList = moviesCatalogueViewModel.getMoviesCatalogue().getValue().data;
        verify(movieCatalogueRepository).getMoviesCatalogue();
        assertNotNull(movieEntityList);
        assertEquals(5, movieEntityList.size());

        moviesCatalogueViewModel.getMoviesCatalogue().observeForever(resourceObserver);
        verify(resourceObserver).onChanged(dummyMovies);
    }

    @Test
    public void getFavoriteMovies() {
        PagedList<MovieEntity> dummyFavoriteMovies = favoriteMovieEntityPagedList;
        when(dummyFavoriteMovies.size()).thenReturn(2);
        MutableLiveData<PagedList<MovieEntity>> pagedListMutableLiveData = new MutableLiveData<>();
        pagedListMutableLiveData.setValue(dummyFavoriteMovies);

        when(movieCatalogueRepository.getFavoriteMoviesCatalogue()).thenReturn(pagedListMutableLiveData);
        List<MovieEntity> favoriteMovieEntityList = moviesCatalogueViewModel.getFavoriteMoviesCatalogue().getValue();
        verify(movieCatalogueRepository).getFavoriteMoviesCatalogue();
        assertNotNull(favoriteMovieEntityList);
        assertEquals(2, favoriteMovieEntityList.size());

        moviesCatalogueViewModel.getFavoriteMoviesCatalogue().observeForever(observer);
        verify(observer).onChanged(dummyFavoriteMovies);
    }

    @Test
    public void getTvShows() {
        Resource<PagedList<MovieEntity>> dummyTvShows = Resource.success(tvShowEntityPagedList);
        when(dummyTvShows.data.size()).thenReturn(5);
        MutableLiveData<Resource<PagedList<MovieEntity>>> resourceMutableLiveData = new MutableLiveData<>();
        resourceMutableLiveData.setValue(dummyTvShows);

        when(movieCatalogueRepository.getTvShowsCatalogue()).thenReturn(resourceMutableLiveData);
        List<MovieEntity> movieEntityList = moviesCatalogueViewModel.getTvShowsCatalogue().getValue().data;
        verify(movieCatalogueRepository).getTvShowsCatalogue();
        assertNotNull(movieEntityList);
        assertEquals(5, movieEntityList.size());

        moviesCatalogueViewModel.getTvShowsCatalogue().observeForever(resourceObserver);
        verify(resourceObserver).onChanged(dummyTvShows);
    }

    @Test
    public void getFavoriteTvShows() {
        PagedList<MovieEntity> dummyFavoriteTvShows = favoriteTvShowEntityPagedList;
        when(dummyFavoriteTvShows.size()).thenReturn(2);
        MutableLiveData<PagedList<MovieEntity>> pagedListMutableLiveData = new MutableLiveData<>();
        pagedListMutableLiveData.setValue(dummyFavoriteTvShows);

        when(movieCatalogueRepository.getFavoriteTvShowsCatalogue()).thenReturn(pagedListMutableLiveData);
        List<MovieEntity> favoriteTvShowsEntityList = moviesCatalogueViewModel.getFavoriteTvShowsCatalogue().getValue();
        verify(movieCatalogueRepository).getFavoriteTvShowsCatalogue();
        assertNotNull(favoriteTvShowsEntityList);
        assertEquals(2, favoriteTvShowsEntityList.size());

        moviesCatalogueViewModel.getFavoriteTvShowsCatalogue().observeForever(observer);
        verify(observer).onChanged(dummyFavoriteTvShows);
    }
}
