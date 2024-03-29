package com.arifrizkihidayat.moviecatalogue;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.platform.app.InstrumentationRegistry;

import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;
import com.arifrizkihidayat.moviecatalogue.ui.activity.MainActivity;
import com.arifrizkihidayat.moviecatalogue.utils.DummyData;
import com.arifrizkihidayat.moviecatalogue.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.arifrizkihidayat.moviecatalogue.utils.UtilizationClass.getGenres;
import static com.arifrizkihidayat.moviecatalogue.utils.UtilizationClass.getMovieRuntime;
import static com.arifrizkihidayat.moviecatalogue.utils.UtilizationClass.getReleaseDate;

public class ExampleInstrumentedTest {

    private Context context;

    private final ArrayList<MovieEntity> movieEntityArrayList = DummyData.dummyMovies();
    private final ArrayList<MovieEntity> favoriteMovieEntityArrayList = DummyData.dummyFavoriteMovies();

    private final ArrayList<MovieEntity> tvShowEntityArrayList = DummyData.dummyTvShows();
    private final ArrayList<MovieEntity> favoriteTvShowEntityArrayList = DummyData.dummyFavoriteTvShows();

    @Before
    public void setup() {
        ActivityScenario.launch(MainActivity.class);
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovies() {
        onView(withId(R.id.rv_movies_catalogues)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies_catalogues)).perform(RecyclerViewActions.
                scrollToPosition(movieEntityArrayList.size()));
    }

    @Test
    public void loadDetailMovies() {
        onView(withId(R.id.rv_movies_catalogues)).perform(RecyclerViewActions.
                scrollToPosition(0));
        onView(withId(R.id.rv_movies_catalogues)).
                perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.tv_title_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_overview_overview_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_genre_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_user_score_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_release_status_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_release_date_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_runtime_movie_detail)).check(matches(isDisplayed()));
    }

    @Test
    public void loadFavoriteMovies() {
        onView(withId(R.id.favorite_main)).perform(click());
        onView(withId(R.id.rv_movies_catalogues)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies_catalogues)).perform(RecyclerViewActions.
                scrollToPosition(favoriteMovieEntityArrayList.size()));
    }

    @Test
    public void loadDetailFavoriteMovies() {
        onView(withId(R.id.rv_movies_catalogues)).perform(RecyclerViewActions.
                scrollToPosition(0));
        onView(withId(R.id.rv_movies_catalogues)).
                perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.tv_title_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_overview_overview_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_genre_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_user_score_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_release_status_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_release_date_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_runtime_movie_detail)).check(matches(isDisplayed()));
    }

    @Test
    public void loadTvShows() {
        onView(withText("Tv Shows")).perform(click());
        onView(withId(R.id.rv_movies_catalogues)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies_catalogues)).perform(RecyclerViewActions.
                scrollToPosition(tvShowEntityArrayList.size()));
    }

    @Test
    public void loadDetailTvShows() {
        onView(withId(R.id.rv_movies_catalogues)).perform(RecyclerViewActions.
                scrollToPosition(0));
        onView(withId(R.id.rv_movies_catalogues)).
                perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.tv_title_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_overview_overview_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_genre_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_user_score_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_release_status_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_release_date_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_runtime_movie_detail)).check(matches(isDisplayed()));
    }

    @Test
    public void loadFavoriteTvShows() {
        onView(withId(R.id.favorite_main)).perform(click());
        onView(withText("Tv Shows")).perform(click());
        onView(withId(R.id.rv_movies_catalogues)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies_catalogues)).perform(RecyclerViewActions.
                scrollToPosition(favoriteTvShowEntityArrayList.size()));
    }

    @Test
    public void loadDetailFavoriteTvShows() {
        onView(withText("Tv Shows")).perform(click());
        onView(withId(R.id.rv_movies_catalogues)).
                perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.tv_title_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_overview_overview_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_genre_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_user_score_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_release_status_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_release_date_movie_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_runtime_movie_detail)).check(matches(isDisplayed()));
    }
}