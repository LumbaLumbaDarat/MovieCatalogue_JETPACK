package com.arifrizkihidayat.moviecatalogue.di;

import android.content.Context;

import com.arifrizkihidayat.moviecatalogue.data.MovieCatalogueRepository;
import com.arifrizkihidayat.moviecatalogue.data.source.local.MovieCatalogueLocalDataSource;
import com.arifrizkihidayat.moviecatalogue.data.source.local.room.MovieCatalogueDatabase;
import com.arifrizkihidayat.moviecatalogue.data.source.remote.MovieCatalogueRemoteDataSource;
import com.arifrizkihidayat.moviecatalogue.utils.AppsExecutors;

public class Injection {

    public static MovieCatalogueRepository movieCatalogueRepository(Context context)
    {
        MovieCatalogueDatabase movieCatalogueDatabase =
                MovieCatalogueDatabase.getInstance(context);

        MovieCatalogueRemoteDataSource movieCatalogueRemoteDataSource =
                MovieCatalogueRemoteDataSource.getInstance();
        MovieCatalogueLocalDataSource movieCatalogueLocalDataSource = MovieCatalogueLocalDataSource.
                getInstance(movieCatalogueDatabase.movieCatalogueDao());
        AppsExecutors appsExecutors = new AppsExecutors();

        return MovieCatalogueRepository.getInstance(movieCatalogueRemoteDataSource,
                movieCatalogueLocalDataSource, appsExecutors);
    }
}
