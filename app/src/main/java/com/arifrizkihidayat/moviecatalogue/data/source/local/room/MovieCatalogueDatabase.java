package com.arifrizkihidayat.moviecatalogue.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;

@Database(entities = {MovieEntity.class, MovieDetailEntity.class}, version = 1, exportSchema = false)
public abstract class MovieCatalogueDatabase extends RoomDatabase {

    public abstract MovieCatalogueDao movieCatalogueDao();
    private static volatile MovieCatalogueDatabase INSTANCE;

    public static MovieCatalogueDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MovieCatalogueDatabase.class) {
                if (INSTANCE == null)
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieCatalogueDatabase.class, "MoviesCatalogues.db")
                            .build();
            }
        }
        return INSTANCE;
    }
}
