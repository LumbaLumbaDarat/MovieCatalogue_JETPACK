package com.arifrizkihidayat.moviecatalogue.data.source.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.arifrizkihidayat.moviecatalogue.data.source.remote.ApiConnectionConstants.API_CONNECTION_URL;
import static com.arifrizkihidayat.moviecatalogue.data.source.remote.ApiConnectionConstants.CONNECT_TIME_OUT;
import static com.arifrizkihidayat.moviecatalogue.data.source.remote.ApiConnectionConstants.READ_TIME_OUT;
import static com.arifrizkihidayat.moviecatalogue.data.source.remote.ApiConnectionConstants.WRITE_TIME_OUT;

public class ApiConnection {

    private static Retrofit retrofit;

    public static Retrofit getConnectionApi(){
        if (retrofit == null)
        {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().
                    addInterceptor(interceptor).
                    connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS).
                    readTimeout(READ_TIME_OUT, TimeUnit.SECONDS).
                    writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS).
                    build();

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder().
                    baseUrl(API_CONNECTION_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson)).
                            client(client).build();
        }

        return retrofit;
    }
}
