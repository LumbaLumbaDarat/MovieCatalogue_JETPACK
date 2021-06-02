package com.arifrizkihidayat.moviecatalogue.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.arifrizkihidayat.moviecatalogue.R;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;
import com.arifrizkihidayat.moviecatalogue.databinding.ActivityMovieDetailBinding;
import com.arifrizkihidayat.moviecatalogue.ui.viewmodel.MovieDetailViewModel;
import com.arifrizkihidayat.moviecatalogue.ui.viewmodel.factory.ViewModelFactory;
import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.EMPTY_STRING;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.IS_FAVORITE;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.IS_FRAGMENT_MOVIES;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.IS_FRAGMENT_TV_SHOW;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.MOVIES_MODEL;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.MOVIE_TYPE;
import static com.arifrizkihidayat.moviecatalogue.utils.UtilizationClass.getGenres;
import static com.arifrizkihidayat.moviecatalogue.utils.UtilizationClass.getImageUrl;
import static com.arifrizkihidayat.moviecatalogue.utils.UtilizationClass.getMovieRuntime;
import static com.arifrizkihidayat.moviecatalogue.utils.UtilizationClass.getReleaseDate;

@SuppressLint("NonConstantResourceId")
public class MovieDetailActivity extends AppCompatActivity {

    private ActivityMovieDetailBinding binding;
    private MovieDetailViewModel movieDetailViewModel;

    private int movieId = 0;
    private String movieType = EMPTY_STRING;
    private boolean isFavorite = false;

    private MovieDetailEntity movieDetailEntity;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent() != null) {
            movieId = getIntent().getIntExtra(MOVIES_MODEL, 0);
            movieType = getIntent().getStringExtra(MOVIE_TYPE);
            isFavorite = getIntent().getBooleanExtra(IS_FAVORITE, false);
        }

        ViewModelFactory viewModelFactory = ViewModelFactory.getInstance(this);
        movieDetailViewModel = new ViewModelProvider(this, viewModelFactory).
                        get(MovieDetailViewModel.class);

        if (movieId != 0) {
            if (movieType.equalsIgnoreCase(IS_FRAGMENT_MOVIES)) {
                movieDetailViewModel.getMovieDetail(movieId).observe(this,
                        movieAndDetailEntityResource ->
                {
                    if (movieAndDetailEntityResource != null) {
                        switch (movieAndDetailEntityResource.status) {
                            case LOADING:
                                binding.pbMovieDetail.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                setMovieDetail(movieAndDetailEntityResource.data.movieEntity,
                                        movieAndDetailEntityResource.data.movieDetailEntity);
                                movieDetailEntity = movieAndDetailEntityResource.data.movieDetailEntity;
                                binding.pbMovieDetail.setVisibility(View.GONE);
                                break;
                            case ERROR:
                                Log.e("TAG", "onViewCreated: ERROR  ".
                                        concat(movieAndDetailEntityResource.status.toString()).
                                        concat(" - ").concat(movieAndDetailEntityResource.message));
                                binding.pbMovieDetail.setVisibility(View.GONE);
                                Toast.makeText(this, getResources().
                                                getString(R.string.error_message_something_wrong).
                                                concat("\n").
                                                concat(movieAndDetailEntityResource.status.toString()).
                                                concat(" - ").concat(movieAndDetailEntityResource.message),
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }

                    }
                });
            } else {
                movieDetailViewModel.getTvShowDetail(movieId).observe(this,
                        movieAndDetailEntityResource ->
                {
                    if (movieAndDetailEntityResource != null) {
                        switch (movieAndDetailEntityResource.status) {
                            case LOADING:
                                binding.pbMovieDetail.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                setMovieDetail(movieAndDetailEntityResource.data.movieEntity,
                                        movieAndDetailEntityResource.data.movieDetailEntity);
                                movieDetailEntity = movieAndDetailEntityResource.data.movieDetailEntity;
                                binding.pbMovieDetail.setVisibility(View.GONE);
                                break;
                            case ERROR:
                                Log.e("TAG", "onViewCreated: ERROR ".
                                        concat(movieAndDetailEntityResource.status.toString()).
                                        concat(" - ").concat(movieAndDetailEntityResource.message));
                                binding.pbMovieDetail.setVisibility(View.GONE);
                                Toast.makeText(this, getResources().
                                                getString(R.string.error_message_something_wrong).
                                                concat("\n").
                                                concat(movieAndDetailEntityResource.status.toString()).
                                                concat(" - ").concat(movieAndDetailEntityResource.message),
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.movie_detail_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuFavorite = menu.findItem(R.id.favorite);
        if (movieDetailEntity != null) {
            if (isFavorite)
                menuFavorite.setIcon(R.drawable.ic_round_favorite_24);
            else menuFavorite.setIcon(R.drawable.ic_round_favorite_border_24);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.favorite:
                favoriteMovie();
                break;
            case R.id.url:
                if (movieDetailEntity != null)
                    openLink(movieDetailEntity);
                else Toast.makeText(this, getResources().
                                getString(R.string.error_message_something_wrong),
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                if (movieDetailEntity != null)
                    shareUrl(movieDetailEntity);
                else Toast.makeText(this, getResources().
                                getString(R.string.error_message_something_wrong),
                        Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setMovieDetail(MovieEntity movieEntity, MovieDetailEntity movieDetailEntity) {
        Glide.with(this).
                load(getImageUrl(movieDetailEntity.getMoviePoster())).
                error(R.drawable.ic_round_broken_image_24).
                placeholder(R.drawable.ic_round_hourglass_bottom_24).
                into(binding.ivImageMovieDetail);

        binding.tvTitleMovieDetail.setText(movieEntity.getMovieTitle());
        binding.tvOverviewOverviewDetail.setText(movieDetailEntity.getMovieOverview());
        binding.tvGenreMovieDetail.setText(getGenres(movieDetailEntity.getMovieGenres()));

        binding.pbUserScoreMovieDetail.setProgress((int) Math.
                round(movieDetailEntity.getMovieUserScore()));

        binding.tvUserScoreMovieDetail.setText(getResources().
                getString(R.string.user_score_detail,
                        String.valueOf(movieDetailEntity.getMovieUserScore())));
        binding.tvReleaseStatusMovieDetail.setText(movieDetailEntity.getMovieReleaseStatus());

        if (movieType.equalsIgnoreCase(IS_FRAGMENT_TV_SHOW)) {
            binding.tvTitleReleaseDateMovieDetail.setText(getResources().
                    getString(R.string.release_date_tiv_show_title));
            binding.tvTitleRuntimeMovieDetail.setText(getResources().
                    getString(R.string.runtime_tv_show_title));

            binding.tvRuntimeMovieDetail.
                    setText(getMovieRuntime(this,
                            movieDetailEntity.getMovieRunTime(),
                            getResources().getString(R.string.runtime_unit_episode)));
        } else binding.tvRuntimeMovieDetail.
                setText(getMovieRuntime(this,
                        movieDetailEntity.getMovieRunTime(),
                        getResources().getString(R.string.runtime_unit_minute)));

        binding.tvReleaseDateMovieDetail.setText(getReleaseDate(this,
                movieDetailEntity.getMovieReleaseDate()));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void favoriteMovie() {
        movieDetailViewModel.setFavoriteMovie(movieId, !isFavorite);

        Snackbar snackbar;
        if (isFavorite) {
            menu.getItem(0).setIcon(getResources().
                    getDrawable(R.drawable.ic_round_favorite_border_24, null));
            snackbar = Snackbar.make(binding.getRoot(), getResources().
                    getString(R.string.message_success_remove_favorite), Snackbar.LENGTH_SHORT);

        } else {
            menu.getItem(0).setIcon(getResources().
                    getDrawable(R.drawable.ic_round_favorite_24, null));
            snackbar = Snackbar.make(binding.getRoot(), getResources().
                    getString(R.string.message_success_add_favorite), Snackbar.LENGTH_SHORT);
        }

        snackbar.setAction(getResources().getString(R.string.label_ok),
                v -> snackbar.dismiss());
        snackbar.show();
    }

    private void shareUrl(MovieDetailEntity movieDetailEntity) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
        intent.putExtra(Intent.EXTRA_TEXT, movieDetailEntity.getMovieHomePage());

        startActivity(Intent.createChooser(intent,
                getResources().getString(R.string.message_share)));
    }

    private void openLink(MovieDetailEntity movieDetailEntity) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(movieDetailEntity.getMovieHomePage()));

        startActivity(intent);
    }
}