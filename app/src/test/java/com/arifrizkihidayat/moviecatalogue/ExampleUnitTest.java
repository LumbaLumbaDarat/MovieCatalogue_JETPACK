package com.arifrizkihidayat.moviecatalogue;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.arifrizkihidayat.moviecatalogue.data.FakeMovieCatalogueRepository;
import com.arifrizkihidayat.moviecatalogue.data.source.local.MovieCatalogueLocalDataSource;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieAndDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.MovieCatalogueRemoteDataSource;
import com.arifrizkihidayat.moviecatalogue.utils.AppsExecutors;
import com.arifrizkihidayat.moviecatalogue.utils.DummyData;
import com.arifrizkihidayat.moviecatalogue.utils.LiveDataTest;
import com.arifrizkihidayat.moviecatalogue.vo.Resource;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.IS_FRAGMENT_MOVIES;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.IS_FRAGMENT_TV_SHOW;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ExampleUnitTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private final MovieCatalogueRemoteDataSource movieCatalogueRemoteDataSource =
            Mockito.mock(MovieCatalogueRemoteDataSource.class);
    private final MovieCatalogueLocalDataSource movieCatalogueLocalDataSource =
            Mockito.mock(MovieCatalogueLocalDataSource.class);
    private final AppsExecutors appsExecutors = Mockito.mock(AppsExecutors.class);

    private final FakeMovieCatalogueRepository fakeMovieCatalogueRepository =
            new FakeMovieCatalogueRepository(movieCatalogueRemoteDataSource,
                    movieCatalogueLocalDataSource, appsExecutors);

    private final ArrayList<MovieEntity> movieEntityArrayList = DummyData.dummyMovies();
    private final int movieId = movieEntityArrayList.get(0).getMovieId();
    private final MovieAndDetailEntity movieAndDetailEntity =
            DummyData.dummyDetailMovie(movieEntityArrayList.get(0));

    private final ArrayList<MovieEntity> tvShowsEntityArrayList = DummyData.dummyTvShows();
    private final int tvShowId = tvShowsEntityArrayList.get(0).getMovieId();
    private final MovieAndDetailEntity tvShowAndDetailEntity =
            DummyData.dummyDetailMovie(tvShowsEntityArrayList.get(0));

    @Test
    public void getMoviesCatalogue() {
        MutableLiveData<List<MovieEntity>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(DummyData.dummyMovies());
        when(movieCatalogueLocalDataSource.getMoviesCatalogues(IS_FRAGMENT_MOVIES)).
                thenReturn(mutableLiveData);

        Resource<List<MovieEntity>> resource = LiveDataTest.
                getValue(fakeMovieCatalogueRepository.getMoviesCatalogue());
        verify(movieCatalogueLocalDataSource).getMoviesCatalogues(IS_FRAGMENT_MOVIES);
        assertNotNull(resource.data);
        assertEquals(movieEntityArrayList.size(), resource.data.size());
    }

    @Test
    public void getTvShowsCatalogue() {
        MutableLiveData<List<MovieEntity>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(DummyData.dummyTvShows());
        when(movieCatalogueLocalDataSource.getMoviesCatalogues(IS_FRAGMENT_TV_SHOW)).
                thenReturn(mutableLiveData);

        Resource<List<MovieEntity>> resource = LiveDataTest.
                getValue(fakeMovieCatalogueRepository.getTvShowsCatalogue());
        verify(movieCatalogueLocalDataSource).getMoviesCatalogues(IS_FRAGMENT_TV_SHOW);
        assertNotNull(resource.data);
        assertEquals(tvShowsEntityArrayList.size(), resource.data.size());
    }

    @Test
    public void getMovieDetail() {
        MutableLiveData<MovieAndDetailEntity> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(DummyData.dummyDetailMovie(movieEntityArrayList.get(0)));
        when(movieCatalogueLocalDataSource.getMovieDetailCatalogues(movieId)).
                thenReturn(mutableLiveData);

        Resource<MovieAndDetailEntity> resource = LiveDataTest.
                getValue(fakeMovieCatalogueRepository.getMovieDetailCatalogue(movieId));
        verify(movieCatalogueLocalDataSource).getMovieDetailCatalogues(movieId);
        assertNotNull(resource.data);
        assertNotNull(resource.data.getMovieEntity());
        assertNotNull(resource.data.getMovieDetailEntity());

        assertEquals(movieEntityArrayList.get(0).getMovieTitle(),
                resource.data.movieEntity.getMovieTitle());
        assertEquals(movieAndDetailEntity.getMovieDetailEntity().getMovieDetailId(),
                resource.data.movieDetailEntity.getMovieDetailId());
        assertEquals(movieAndDetailEntity.getMovieDetailEntity().getMovieId(),
                resource.data.movieDetailEntity.getMovieId());
        assertEquals(movieAndDetailEntity.getMovieDetailEntity().getMovieOverview(),
                resource.data.movieDetailEntity.getMovieOverview());
        assertEquals(movieAndDetailEntity.getMovieDetailEntity().getMovieGenres(),
                resource.data.movieDetailEntity.getMovieGenres());
        assertEquals(movieAndDetailEntity.getMovieDetailEntity().getMovieUserScore(),
                resource.data.movieDetailEntity.getMovieUserScore(), 0.0);
        assertEquals(movieAndDetailEntity.getMovieDetailEntity().getMovieReleaseStatus(),
                resource.data.movieDetailEntity.getMovieReleaseStatus());
        assertEquals(movieAndDetailEntity.getMovieDetailEntity().getMovieReleaseDate(),
                resource.data.movieDetailEntity.getMovieReleaseDate());
        assertEquals(movieAndDetailEntity.getMovieDetailEntity().getMovieRunTime(),
                resource.data.movieDetailEntity.getMovieRunTime());
    }

    @Test
    public void getTvShowDetail() {
        MutableLiveData<MovieAndDetailEntity> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(DummyData.dummyDetailMovie(tvShowsEntityArrayList.get(0)));
        when(movieCatalogueLocalDataSource.getMovieDetailCatalogues(tvShowId)).
                thenReturn(mutableLiveData);

        Resource<MovieAndDetailEntity> resource = LiveDataTest.
                getValue(fakeMovieCatalogueRepository.getTvShowDetailCatalogue(tvShowId));
        verify(movieCatalogueLocalDataSource).getMovieDetailCatalogues(tvShowId);
        assertNotNull(resource.data);
        assertNotNull(resource.data.getMovieEntity());
        assertNotNull(resource.data.getMovieDetailEntity());

        assertEquals(tvShowsEntityArrayList.get(0).getMovieTitle(),
                resource.data.movieEntity.getMovieTitle());
        assertEquals(tvShowAndDetailEntity.getMovieDetailEntity().getMovieDetailId(),
                resource.data.movieDetailEntity.getMovieDetailId());
        assertEquals(tvShowAndDetailEntity.getMovieDetailEntity().getMovieId(),
                resource.data.movieDetailEntity.getMovieId());
        assertEquals(tvShowAndDetailEntity.getMovieDetailEntity().getMovieOverview(),
                resource.data.movieDetailEntity.getMovieOverview());
        assertEquals(tvShowAndDetailEntity.getMovieDetailEntity().getMovieGenres(),
                resource.data.movieDetailEntity.getMovieGenres());
        assertEquals(tvShowAndDetailEntity.getMovieDetailEntity().getMovieUserScore(),
                resource.data.movieDetailEntity.getMovieUserScore(), 0.0);
        assertEquals(tvShowAndDetailEntity.getMovieDetailEntity().getMovieReleaseStatus(),
                resource.data.movieDetailEntity.getMovieReleaseStatus());
        assertEquals(tvShowAndDetailEntity.getMovieDetailEntity().getMovieReleaseDate(),
                resource.data.movieDetailEntity.getMovieReleaseDate());
        assertEquals(tvShowAndDetailEntity.getMovieDetailEntity().getMovieRunTime(),
                resource.data.movieDetailEntity.getMovieRunTime());
    }
}