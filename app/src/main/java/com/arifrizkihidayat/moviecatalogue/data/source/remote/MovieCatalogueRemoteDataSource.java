package com.arifrizkihidayat.moviecatalogue.data.source.remote;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.movieresponse.MovieDetailResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.movieresponse.MovieListResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.tvshowsresponse.TvShowsDetailResponse;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.response.tvshowsresponse.TvShowsListResponse;
import com.arifrizkihidayat.moviecatalogue.utils.EspressoIdlingResource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieCatalogueRemoteDataSource {

    private static MovieCatalogueRemoteDataSource INSTANCE;

    public static MovieCatalogueRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MovieCatalogueRemoteDataSource();
        }
        return INSTANCE;
    }

    public LiveData<ApiConnectionResponse<MovieListResponse>> getMoviesCatalogue() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiConnectionResponse<MovieListResponse>>
                apiConnectionResponseMutableLiveData = new MutableLiveData<>();
        ApiConnectionEndPoint apiConnectionEndPoint = ApiConnection.
                getConnectionApi().create(ApiConnectionEndPoint.class);
        Call<MovieListResponse> call = apiConnectionEndPoint.getMovieCatalogue();
        call.enqueue(new Callback<MovieListResponse>() {
            @Override
            public void onResponse(Call<MovieListResponse> call, Response<MovieListResponse> response) {
                apiConnectionResponseMutableLiveData.setValue(
                        ApiConnectionResponse.success(response.body()));
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(Call<MovieListResponse> call, Throwable t) {
                EspressoIdlingResource.decrement();
                Log.e("TAG", "onFailure: ".concat(t.getMessage()));
            }
        });

        return apiConnectionResponseMutableLiveData;
    }

    public LiveData<ApiConnectionResponse<MovieDetailResponse>> getMovieDetailCatalogue(int movieId) {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiConnectionResponse<MovieDetailResponse>>
                apiConnectionResponseMutableLiveData = new MutableLiveData<>();
        ApiConnectionEndPoint apiConnectionEndPoint = ApiConnection.
                getConnectionApi().create(ApiConnectionEndPoint.class);
        Call<MovieDetailResponse> call = apiConnectionEndPoint.getMovieDetailCatalogue(movieId);
        call.enqueue(new Callback<MovieDetailResponse>() {
            @Override
            public void onResponse(Call<MovieDetailResponse> call, Response<MovieDetailResponse> response) {
                apiConnectionResponseMutableLiveData.setValue(
                        ApiConnectionResponse.success(response.body()));
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(Call<MovieDetailResponse> call, Throwable t) {
                EspressoIdlingResource.decrement();
                Log.e("TAG", "onFailure: ".concat(t.getMessage()));
            }
        });
        return apiConnectionResponseMutableLiveData;
    }

    public LiveData<ApiConnectionResponse<TvShowsListResponse>> getTvShowsCatalogue() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiConnectionResponse<TvShowsListResponse>>
                apiConnectionResponseMutableLiveData = new MutableLiveData<>();
        ApiConnectionEndPoint apiConnectionEndPoint = ApiConnection.
                getConnectionApi().create(ApiConnectionEndPoint.class);
        Call<TvShowsListResponse> call = apiConnectionEndPoint.getTvShowCatalogue();
        call.enqueue(new Callback<TvShowsListResponse>() {
            @Override
            public void onResponse(Call<TvShowsListResponse> call, Response<TvShowsListResponse> response) {
                apiConnectionResponseMutableLiveData.setValue(
                        ApiConnectionResponse.success(response.body()));
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(Call<TvShowsListResponse> call, Throwable t) {
                EspressoIdlingResource.decrement();
                Log.e("TAG", "onFailure: ".concat(t.getMessage()));
            }
        });

        return apiConnectionResponseMutableLiveData;
    }

    public LiveData<ApiConnectionResponse<TvShowsDetailResponse>> getTvShowDetailCatalogue(int movieId) {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiConnectionResponse<TvShowsDetailResponse>>
                apiConnectionResponseMutableLiveData = new MutableLiveData<>();
        ApiConnectionEndPoint apiConnectionEndPoint = ApiConnection.
                getConnectionApi().create(ApiConnectionEndPoint.class);
        Call<TvShowsDetailResponse> call = apiConnectionEndPoint.getTvShowDetailCatalogue(movieId);
        call.enqueue(new Callback<TvShowsDetailResponse>() {
            @Override
            public void onResponse(Call<TvShowsDetailResponse> call, Response<TvShowsDetailResponse> response) {
                apiConnectionResponseMutableLiveData.setValue(
                        ApiConnectionResponse.success(response.body()));
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(Call<TvShowsDetailResponse> call, Throwable t) {
                EspressoIdlingResource.decrement();
                Log.e("TAG", "onFailure: ".concat(t.getMessage()));
            }
        });
        return apiConnectionResponseMutableLiveData;
    }
}
