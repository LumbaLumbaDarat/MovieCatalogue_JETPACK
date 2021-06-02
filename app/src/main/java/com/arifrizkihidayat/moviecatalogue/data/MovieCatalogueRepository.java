package com.arifrizkihidayat.moviecatalogue.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.arifrizkihidayat.moviecatalogue.data.source.local.MovieCatalogueLocalDataSource;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieAndDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.ApiConnectionResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.MovieCatalogueRemoteDataSource;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.GenresResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.movieresponse.MovieDetailResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.movieresponse.MovieInListResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.movieresponse.MovieListResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.tvshowsresponse.TvShowsDetailResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.tvshowsresponse.TvShowsInListResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.tvshowsresponse.TvShowsListResponse;
import com.arifrizkihidayat.moviecatalogue.utils.AppsExecutors;
import com.arifrizkihidayat.moviecatalogue.vo.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.IS_FRAGMENT_MOVIES;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.IS_FRAGMENT_TV_SHOW;

public class MovieCatalogueRepository implements MovieCatalogueDataSource {

    private volatile static MovieCatalogueRepository INSTANCE = null;

    private final MovieCatalogueRemoteDataSource movieCatalogueRemoteDataSource;
    private final MovieCatalogueLocalDataSource movieCatalogueLocalDataSource;
    private final AppsExecutors appsExecutors;

    private MovieCatalogueRepository(@NonNull MovieCatalogueRemoteDataSource movieCatalogueRemoteDataSource,
                                     @NonNull MovieCatalogueLocalDataSource movieCatalogueLocalDataSource,
                                     AppsExecutors appsExecutors) {
        this.movieCatalogueRemoteDataSource = movieCatalogueRemoteDataSource;
        this.movieCatalogueLocalDataSource = movieCatalogueLocalDataSource;
        this.appsExecutors = appsExecutors;
    }

    public static MovieCatalogueRepository getInstance(MovieCatalogueRemoteDataSource movieCatalogueRemoteDataSource,
                                                       MovieCatalogueLocalDataSource movieCatalogueLocalDataSource,
                                                       AppsExecutors appsExecutors) {
        if (INSTANCE == null) {
            synchronized (MovieCatalogueRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieCatalogueRepository(movieCatalogueRemoteDataSource,
                            movieCatalogueLocalDataSource, appsExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<List<MovieEntity>>> getMoviesCatalogue() {
        return new NetworkBoundResource<List<MovieEntity>, MovieListResponse>(appsExecutors) {
            @Override
            protected LiveData<List<MovieEntity>> loadFromDB() {
                return movieCatalogueLocalDataSource.getMoviesCatalogues(IS_FRAGMENT_MOVIES);
            }

            @Override
            protected Boolean shouldFetch(List<MovieEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiConnectionResponse<MovieListResponse>> createCall() {
                return movieCatalogueRemoteDataSource.getMoviesCatalogue();
            }

            @Override
            protected void saveCallResult(MovieListResponse data) {
                ArrayList<MovieEntity> movieEntityArrayList = new ArrayList<>();
                for (MovieInListResponse movieInListResponse : data.getMovieInListResponseList()) {
                    MovieEntity movieEntity = new MovieEntity();
                    movieEntity.setMovieId(movieInListResponse.getId());
                    movieEntity.setMovieType(IS_FRAGMENT_MOVIES);
                    movieEntity.setMovieTitle(movieInListResponse.getTitle());
                    movieEntity.setMovieOverview(movieInListResponse.getOverview());
                    movieEntity.setMovieUserScore(movieInListResponse.getVoteAverage());
                    movieEntity.setMoviePoster(movieInListResponse.getPosterPath());
                    movieEntity.setFavorite(false);

                    movieEntityArrayList.add(movieEntity);
                }

                movieCatalogueLocalDataSource.insertMovies(movieEntityArrayList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<List<MovieEntity>> getFavoriteMoviesCatalogue() {
        return movieCatalogueLocalDataSource.getFavoriteMoviesCatalogues(IS_FRAGMENT_MOVIES);
    }

    @Override
    public LiveData<Resource<MovieAndDetailEntity>> getMovieDetailCatalogue(int movieId) {
        return new NetworkBoundResource<MovieAndDetailEntity, MovieDetailResponse>(appsExecutors) {
            @Override
            protected LiveData<MovieAndDetailEntity> loadFromDB() {
                return movieCatalogueLocalDataSource.getMovieDetailCatalogues(movieId);
            }

            @Override
            protected Boolean shouldFetch(MovieAndDetailEntity data) {
                return (data.movieDetailEntity == null);
            }

            @Override
            protected LiveData<ApiConnectionResponse<MovieDetailResponse>> createCall() {
                return movieCatalogueRemoteDataSource.getMovieDetailCatalogue(movieId);
            }

            @Override
            protected void saveCallResult(MovieDetailResponse data) {
                MovieDetailEntity movieDetailEntity = new MovieDetailEntity();
                movieDetailEntity.setMovieDetailId(movieId);
                movieDetailEntity.setMovieId(data.getId());

                ArrayList<String> stringArrayList = new ArrayList<>();
                for (GenresResponse genresResponse : data.getGenresResponseArrayList()) {
                    stringArrayList.add(genresResponse.getName());
                }
                movieDetailEntity.setMovieGenres(Arrays.toString(stringArrayList.toArray()));
                movieDetailEntity.setMovieOverview(data.getOverview());
                movieDetailEntity.setMovieReleaseStatus(data.getStatus());
                movieDetailEntity.setMovieReleaseDate(data.getReleaseDate());
                movieDetailEntity.setMovieRunTime(data.getRuntime());
                movieDetailEntity.setMovieHomePage(data.getHomepage());
                movieDetailEntity.setMovieUserScore(data.getVoteAverage());
                movieDetailEntity.setMoviePoster(data.getPosterPath());

                movieCatalogueLocalDataSource.insertMovieDetail(movieDetailEntity);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<MovieEntity>>> getTvShowsCatalogue() {
        return new NetworkBoundResource<List<MovieEntity>, TvShowsListResponse>(appsExecutors) {
            @Override
            protected LiveData<List<MovieEntity>> loadFromDB() {
                return movieCatalogueLocalDataSource.getMoviesCatalogues(IS_FRAGMENT_TV_SHOW);
            }

            @Override
            protected Boolean shouldFetch(List<MovieEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiConnectionResponse<TvShowsListResponse>> createCall() {
                return movieCatalogueRemoteDataSource.getTvShowsCatalogue();
            }

            @Override
            protected void saveCallResult(TvShowsListResponse data) {
                ArrayList<MovieEntity> movieEntityArrayList = new ArrayList<>();
                for (TvShowsInListResponse tvShowsInListResponse :
                        data.getTvShowsInListResponseArrayList()) {
                    MovieEntity movieEntity = new MovieEntity();
                    movieEntity.setMovieId(tvShowsInListResponse.getId());
                    movieEntity.setMovieType(IS_FRAGMENT_TV_SHOW);
                    movieEntity.setMovieTitle(tvShowsInListResponse.getName());
                    movieEntity.setMovieOverview(tvShowsInListResponse.getOverview());
                    movieEntity.setMovieUserScore(tvShowsInListResponse.getVoteAverage());
                    movieEntity.setMoviePoster(tvShowsInListResponse.getPosterPath());
                    movieEntity.setFavorite(false);

                    movieEntityArrayList.add(movieEntity);
                }

                movieCatalogueLocalDataSource.insertMovies(movieEntityArrayList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<List<MovieEntity>> getFavoriteTvShowsCatalogue() {
        return movieCatalogueLocalDataSource.getFavoriteMoviesCatalogues(IS_FRAGMENT_TV_SHOW);
    }

    @Override
    public LiveData<Resource<MovieAndDetailEntity>> getTvShowDetailCatalogue(int movieId) {
        return new NetworkBoundResource<MovieAndDetailEntity, TvShowsDetailResponse>(appsExecutors) {
            @Override
            protected LiveData<MovieAndDetailEntity> loadFromDB() {
                return movieCatalogueLocalDataSource.getMovieDetailCatalogues(movieId);
            }

            @Override
            protected Boolean shouldFetch(MovieAndDetailEntity data) {
                return (data.movieDetailEntity == null);
            }

            @Override
            protected LiveData<ApiConnectionResponse<TvShowsDetailResponse>> createCall() {
                return movieCatalogueRemoteDataSource.getTvShowDetailCatalogue(movieId);
            }

            @Override
            protected void saveCallResult(TvShowsDetailResponse data) {
                MovieDetailEntity movieDetailEntity = new MovieDetailEntity();
                movieDetailEntity.setMovieDetailId(movieId);
                movieDetailEntity.setMovieId(data.getId());

                ArrayList<String> stringArrayList = new ArrayList<>();
                for (GenresResponse genresResponse : data.getGenresResponseArrayList()) {
                    stringArrayList.add(genresResponse.getName());
                }
                movieDetailEntity.setMovieGenres(Arrays.toString(stringArrayList.toArray()));
                movieDetailEntity.setMovieOverview(data.getOverview());
                movieDetailEntity.setMovieReleaseStatus(data.getStatus());
                movieDetailEntity.setMovieReleaseDate(data.getFirstAirDate());
                movieDetailEntity.setMovieRunTime(data.getNumberOfEpisodes());
                movieDetailEntity.setMovieHomePage(data.getHomepage());
                movieDetailEntity.setMovieUserScore(data.getVoteAverage());
                movieDetailEntity.setMoviePoster(data.getPosterPath());

                movieCatalogueLocalDataSource.insertMovieDetail(movieDetailEntity);
            }
        }.asLiveData();
    }

    @Override
    public void setFavoriteMovie(int movieId, boolean isFavorite) {
        appsExecutors.diskIO().execute(() -> movieCatalogueLocalDataSource.
                setFavoriteMovie(movieId, isFavorite));
    }
}
