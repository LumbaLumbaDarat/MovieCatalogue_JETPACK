package com.arifrizkihidayat.moviecatalogue.data.source.remote;

import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.movieresponse.MovieDetailResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.movieresponse.MovieListResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.tvshowsresponse.TvShowsDetailResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.tvshowsresponse.TvShowsListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import static com.arifrizkihidayat.moviecatalogue.data.source.remote.ApiConnectionConstants.API_KEYS;

public interface ApiConnectionEndPoint {

    @Headers("Content-Type: application/json")
    @GET("movie/popular?api_key=" + API_KEYS + "&language=en-US&page=1")
    Call<MovieListResponse> getMovieCatalogue();

    @Headers("Content-Type: application/json")
    @GET("movie/{movieId}?api_key=" + API_KEYS + "&language=en-US")
    Call<MovieDetailResponse> getMovieDetailCatalogue(@Path("movieId") int movieId);

    @Headers("Content-Type: application/json")
    @GET("tv/top_rated?api_key=" + API_KEYS + "&language=en-US&page=1")
    Call<TvShowsListResponse> getTvShowCatalogue();

    @Headers("Content-Type: application/json")
    @GET("tv/{tvShowId}?api_key=" + API_KEYS + "&language=en-US")
    Call<TvShowsDetailResponse> getTvShowDetailCatalogue(@Path("tvShowId") int tvShowId);
}
