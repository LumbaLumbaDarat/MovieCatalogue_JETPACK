package com.arifrizkihidayat.moviecatalogue.utils;

import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieAndDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieDetailEntity;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;

import java.util.ArrayList;
import java.util.Arrays;

import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.IS_FRAGMENT_MOVIES;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.IS_FRAGMENT_TV_SHOW;
import static com.arifrizkihidayat.moviecatalogue.utils.UtilizationClass.getImageUrl;

public class DummyData {

    public static ArrayList<MovieEntity> dummyMovies() {
        ArrayList<MovieEntity> movieEntityArrayList = new ArrayList<>();
        MovieEntity movieEntity;

        movieEntity = new MovieEntity();
        movieEntity.setMovieId(399566);
        movieEntity.setMovieType(IS_FRAGMENT_MOVIES);
        movieEntity.setMovieTitle("Godzilla vs. Kong");
        movieEntity.setMovieOverview("In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.");
        movieEntity.setMovieUserScore(8.1);
        movieEntity.setMoviePoster(getImageUrl("/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"));
        movieEntityArrayList.add(movieEntity);

        movieEntity = new MovieEntity();
        movieEntity.setMovieId(412656);
        movieEntity.setMovieType(IS_FRAGMENT_MOVIES);
        movieEntity.setMovieTitle("Chaos Walking");
        movieEntity.setMovieOverview("Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.");
        movieEntity.setMovieUserScore(7.2);
        movieEntity.setMoviePoster(getImageUrl("/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg"));
        movieEntityArrayList.add(movieEntity);

        movieEntity = new MovieEntity();
        movieEntity.setMovieId(460465);
        movieEntity.setMovieType(IS_FRAGMENT_MOVIES);
        movieEntity.setMovieTitle("Mortal Kombat");
        movieEntity.setMovieOverview("Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.");
        movieEntity.setMovieUserScore(7.7);
        movieEntity.setMoviePoster(getImageUrl("/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg"));
        movieEntityArrayList.add(movieEntity);

        movieEntity = new MovieEntity();
        movieEntity.setMovieId(527774);
        movieEntity.setMovieType(IS_FRAGMENT_MOVIES);
        movieEntity.setMovieTitle("Raya and the Last Dragon");
        movieEntity.setMovieOverview("Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.");
        movieEntity.setMovieUserScore(8.2);
        movieEntity.setMoviePoster(getImageUrl("/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg"));
        movieEntityArrayList.add(movieEntity);

        movieEntity = new MovieEntity();
        movieEntity.setMovieId(544401);
        movieEntity.setMovieType(IS_FRAGMENT_MOVIES);
        movieEntity.setMovieTitle("Cherry");
        movieEntity.setMovieOverview("Cherry drifts from college dropout to army medic in Iraq - anchored only by his true love, Emily. But after returning from the war with PTSD, his life spirals into drugs and crime as he struggles to find his place in the world.");
        movieEntity.setMovieUserScore(7.5);
        movieEntity.setMoviePoster(getImageUrl("/pwDvkDyaHEU9V7cApQhbcSJMG1w.jpg"));
        movieEntityArrayList.add(movieEntity);

        return movieEntityArrayList;
    }

    public static ArrayList<MovieEntity> dummyTvShows() {
        ArrayList<MovieEntity> movieEntityArrayList = new ArrayList<>();
        MovieEntity movieEntity;

        movieEntity = new MovieEntity();
        movieEntity.setMovieId(100);
        movieEntity.setMovieType(IS_FRAGMENT_TV_SHOW);
        movieEntity.setMovieTitle("I Am Not an Animal");
        movieEntity.setMovieOverview("I Am Not An Animal is an animated comedy series about the only six talking animals in the world, whose cosseted existence in a vivisection unit is turned upside down when they are liberated by animal rights activists.");
        movieEntity.setMovieUserScore(9.4);
        movieEntity.setMoviePoster(getImageUrl("/qG59J1Q7rpBc1dvku4azbzcqo8h.jpg"));
        movieEntityArrayList.add(movieEntity);

        movieEntity = new MovieEntity();
        movieEntity.setMovieId(61663);
        movieEntity.setMovieType(IS_FRAGMENT_TV_SHOW);
        movieEntity.setMovieTitle("Your Lie in April");
        movieEntity.setMovieOverview("Kousei Arima was a genius pianist until his mother's sudden death took away his ability to play. Each day was dull for Kousei. But, then he meets a violinist named Kaori Miyazono who has an eccentric playing style. Can the heartfelt sounds of the girl's violin lead the boy to play the piano again?");
        movieEntity.setMovieUserScore(9.0);
        movieEntity.setMoviePoster(getImageUrl("/IGbeFv5Ji4W0x530JcSHiQpamY.jpg"));
        movieEntityArrayList.add(movieEntity);

        movieEntity = new MovieEntity();
        movieEntity.setMovieId(65648);
        movieEntity.setMovieType(IS_FRAGMENT_TV_SHOW);
        movieEntity.setMovieTitle("Maid Sama!");
        movieEntity.setMovieOverview("Misaki Ayuzawa is the first female student council president at a once all-boys school turned co-ed. She rules the school with strict discipline demeanor. But she has a secret—she works at a maid cafe due to her families circumstances. One day the popular A-student and notorious heart breaker Takumi Usui finds out her secret and makes a deal with her to keep it hush from the school in exchange for spending some time with him.");
        movieEntity.setMovieUserScore(8.9);
        movieEntity.setMoviePoster(getImageUrl("/igkn0M1bgMeATz59LShvVxZNdVd.jpg"));
        movieEntityArrayList.add(movieEntity);

        movieEntity = new MovieEntity();
        movieEntity.setMovieId(65930);
        movieEntity.setMovieType(IS_FRAGMENT_TV_SHOW);
        movieEntity.setMovieTitle("My Hero Academia");
        movieEntity.setMovieOverview("In a world where eighty percent of the population has some kind of super-powered Quirk, Izuku was unlucky enough to be born completely normal. But that won’t stop him from enrolling in a prestigious hero academy. Now, he’ll get his first taste of brutal rivalry from other schools as he braves the cutthroat, no-holds-barred provisional license exam.");
        movieEntity.setMovieUserScore(8.9);
        movieEntity.setMoviePoster(getImageUrl("/phuYuzqWW9ru8EA3HVjE9W2Rr3M.jpg"));
        movieEntityArrayList.add(movieEntity);

        movieEntity = new MovieEntity();
        movieEntity.setMovieId(68129);
        movieEntity.setMovieType(IS_FRAGMENT_TV_SHOW);
        movieEntity.setMovieTitle("Yuri!!! on Ice");
        movieEntity.setMovieOverview("Yūri Katsuki carried all of Japan's hopes on his shoulders to win at the Gran Prix Finale ice skating competition, but suffered a crushing defeat. He returns home to Kyushu and half feels like he wants to retire, and half feels like he wants to continue ice skating. Suddenly the five-time consecutive world championship ice skater Victor Nikiforov appears before him with Yuri Plisetsky, a young Russian figure skater who is already defeating his seniors. Victor and both Yuris take up the challenge on an unprecedented Gran Prix series.");
        movieEntity.setMovieUserScore(8.9);
        movieEntity.setMoviePoster(getImageUrl("/oKVFf2uNCLMsovWBxAW14MmhHUm.jpg"));
        movieEntityArrayList.add(movieEntity);

        return movieEntityArrayList;
    }

    public static ArrayList<MovieDetailEntity> dummyDetailMovies() {
        ArrayList<MovieDetailEntity> movieDetailEntityArrayList = new ArrayList<>();
        MovieDetailEntity movieDetailEntity;

        movieDetailEntity = new MovieDetailEntity();
        movieDetailEntity.setMovieDetailId(399566);
        movieDetailEntity.setMovieId(399566);
        movieDetailEntity.setMovieGenres(Arrays.toString(new String[] {"Science Fiction", "Action", "Drama"}));
        movieDetailEntity.setMovieOverview("In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.");
        movieDetailEntity.setMovieReleaseStatus("Released");
        movieDetailEntity.setMovieReleaseDate("2021-03-24");
        movieDetailEntity.setMovieRunTime(113);
        movieDetailEntity.setMovieHomePage("https://www.godzillavskong.net/");
        movieDetailEntity.setMovieUserScore(8.1);
        movieDetailEntity.setMoviePoster(getImageUrl("/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"));
        movieDetailEntityArrayList.add(movieDetailEntity);

        movieDetailEntity = new MovieDetailEntity();
        movieDetailEntity.setMovieDetailId(412656);
        movieDetailEntity.setMovieId(412656);
        movieDetailEntity.setMovieGenres(Arrays.toString(new String[] {"Science Fiction", "Action", "Adventure", "Thriller"}));
        movieDetailEntity.setMovieOverview("Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.");
        movieDetailEntity.setMovieReleaseStatus("Released");
        movieDetailEntity.setMovieReleaseDate("2021-02-24");
        movieDetailEntity.setMovieRunTime(109);
        movieDetailEntity.setMovieHomePage("https://chaoswalking.movie");
        movieDetailEntity.setMovieUserScore(7.2);
        movieDetailEntity.setMoviePoster(getImageUrl("/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg"));
        movieDetailEntityArrayList.add(movieDetailEntity);

        movieDetailEntity = new MovieDetailEntity();
        movieDetailEntity.setMovieDetailId(460465);
        movieDetailEntity.setMovieId(460465);
        movieDetailEntity.setMovieGenres(Arrays.toString(new String[] {"Action", "Fantasy", "Adventure"}));
        movieDetailEntity.setMovieOverview("Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.");
        movieDetailEntity.setMovieReleaseStatus("Released");
        movieDetailEntity.setMovieReleaseDate("2021-04-07");
        movieDetailEntity.setMovieRunTime(110);
        movieDetailEntity.setMovieHomePage("https://www.mortalkombatmovie.net");
        movieDetailEntity.setMovieUserScore(7.7);
        movieDetailEntity.setMoviePoster(getImageUrl("/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg"));
        movieDetailEntityArrayList.add(movieDetailEntity);

        movieDetailEntity = new MovieDetailEntity();
        movieDetailEntity.setMovieDetailId(527774);
        movieDetailEntity.setMovieId(527774);
        movieDetailEntity.setMovieGenres(Arrays.toString(new String[] {"Animation", "Adventure", "Fantasy", "Family", "Action"}));
        movieDetailEntity.setMovieOverview("Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.");
        movieDetailEntity.setMovieReleaseStatus("Released");
        movieDetailEntity.setMovieReleaseDate("2021-03-03");
        movieDetailEntity.setMovieRunTime(107);
        movieDetailEntity.setMovieHomePage("https://movies.disney.com/raya-and-the-last-dragon");
        movieDetailEntity.setMovieUserScore(8.2);
        movieDetailEntity.setMoviePoster(getImageUrl("/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg"));
        movieDetailEntityArrayList.add(movieDetailEntity);

        movieDetailEntity = new MovieDetailEntity();
        movieDetailEntity.setMovieDetailId(544401);
        movieDetailEntity.setMovieId(544401);
        movieDetailEntity.setMovieGenres(Arrays.toString(new String[] {"Crime", "Drama"}));
        movieDetailEntity.setMovieOverview("Cherry drifts from college dropout to army medic in Iraq - anchored only by his true love, Emily. But after returning from the war with PTSD, his life spirals into drugs and crime as he struggles to find his place in the world.");
        movieDetailEntity.setMovieReleaseStatus("Released");
        movieDetailEntity.setMovieReleaseDate("2021-02-26");
        movieDetailEntity.setMovieRunTime(140);
        movieDetailEntity.setMovieHomePage("https://tv.apple.com/movie/umc.cmc.40gvwq6hnbilmnxuutvmejx4r");
        movieDetailEntity.setMovieUserScore(7.5);
        movieDetailEntity.setMoviePoster(getImageUrl("/pwDvkDyaHEU9V7cApQhbcSJMG1w.jpg"));
        movieDetailEntityArrayList.add(movieDetailEntity);

        movieDetailEntity = new MovieDetailEntity();
        movieDetailEntity.setMovieDetailId(100);
        movieDetailEntity.setMovieId(100);
        movieDetailEntity.setMovieGenres(Arrays.toString(new String[] {"Animation", "Comedy"}));
        movieDetailEntity.setMovieOverview("I Am Not An Animal is an animated comedy series about the only six talking animals in the world, whose cosseted existence in a vivisection unit is turned upside down when they are liberated by animal rights activists.");
        movieDetailEntity.setMovieReleaseStatus("Ended");
        movieDetailEntity.setMovieReleaseDate("2004-05-10");
        movieDetailEntity.setMovieRunTime(6);
        movieDetailEntity.setMovieHomePage("https://www.bbc.co.uk/programmes/p011fgk5");
        movieDetailEntity.setMovieUserScore(9.4);
        movieDetailEntity.setMoviePoster(getImageUrl("/qG59J1Q7rpBc1dvku4azbzcqo8h.jpg"));
        movieDetailEntityArrayList.add(movieDetailEntity);

        movieDetailEntity = new MovieDetailEntity();
        movieDetailEntity.setMovieDetailId(61663);
        movieDetailEntity.setMovieId(61663);
        movieDetailEntity.setMovieGenres(Arrays.toString(new String[] {"Animation", "Comedy", "Drama"}));
        movieDetailEntity.setMovieOverview("Kousei Arima was a genius pianist until his mother's sudden death took away his ability to play. Each day was dull for Kousei. But, then he meets a violinist named Kaori Miyazono who has an eccentric playing style. Can the heartfelt sounds of the girl's violin lead the boy to play the piano again?");
        movieDetailEntity.setMovieReleaseStatus("Ended");
        movieDetailEntity.setMovieReleaseDate("2014-10-10");
        movieDetailEntity.setMovieRunTime(22);
        movieDetailEntity.setMovieHomePage("http://www.kimiuso.jp/");
        movieDetailEntity.setMovieUserScore(9.0);
        movieDetailEntity.setMoviePoster(getImageUrl("/IGbeFv5Ji4W0x530JcSHiQpamY.jpg"));
        movieDetailEntityArrayList.add(movieDetailEntity);

        movieDetailEntity = new MovieDetailEntity();
        movieDetailEntity.setMovieDetailId(65648);
        movieDetailEntity.setMovieId(65648);
        movieDetailEntity.setMovieGenres(Arrays.toString(new String[] {"Animation", "Comedy", "Drama"}));
        movieDetailEntity.setMovieOverview("Misaki Ayuzawa is the first female student council president at a once all-boys school turned co-ed. She rules the school with strict discipline demeanor. But she has a secret—she works at a maid cafe due to her families circumstances. One day the popular A-student and notorious heart breaker Takumi Usui finds out her secret and makes a deal with her to keep it hush from the school in exchange for spending some time with him.");
        movieDetailEntity.setMovieReleaseStatus("Ended");
        movieDetailEntity.setMovieReleaseDate("2010-04-02");
        movieDetailEntity.setMovieRunTime(26);
        movieDetailEntity.setMovieHomePage("http://www.tbs.co.jp/anime/maidsama/index-j.html");
        movieDetailEntity.setMovieUserScore(8.9);
        movieDetailEntity.setMoviePoster(getImageUrl("/igkn0M1bgMeATz59LShvVxZNdVd.jpg"));
        movieDetailEntityArrayList.add(movieDetailEntity);

        movieDetailEntity = new MovieDetailEntity();
        movieDetailEntity.setMovieDetailId(65930);
        movieDetailEntity.setMovieId(65930);
        movieDetailEntity.setMovieGenres(Arrays.toString(new String[] {"Sci-Fi & Fantasy", "Action & Adventure", "Comedy", "Animation"}));
        movieDetailEntity.setMovieOverview("In a world where eighty percent of the population has some kind of super-powered Quirk, Izuku was unlucky enough to be born completely normal. But that won’t stop him from enrolling in a prestigious hero academy. Now, he’ll get his first taste of brutal rivalry from other schools as he braves the cutthroat, no-holds-barred provisional license exam.");
        movieDetailEntity.setMovieReleaseStatus("Returning Series");
        movieDetailEntity.setMovieReleaseDate("2016-04-03");
        movieDetailEntity.setMovieRunTime(113);
        movieDetailEntity.setMovieHomePage("http://www.heroaca.com/");
        movieDetailEntity.setMovieUserScore(8.9);
        movieDetailEntity.setMoviePoster(getImageUrl("/phuYuzqWW9ru8EA3HVjE9W2Rr3M.jpg"));
        movieDetailEntityArrayList.add(movieDetailEntity);

        movieDetailEntity = new MovieDetailEntity();
        movieDetailEntity.setMovieDetailId(68129);
        movieDetailEntity.setMovieId(68129);
        movieDetailEntity.setMovieGenres(Arrays.toString(new String[] {"Animation", "Comedy", "Drama"}));
        movieDetailEntity.setMovieOverview("Yūri Katsuki carried all of Japan's hopes on his shoulders to win at the Gran Prix Finale ice skating competition, but suffered a crushing defeat. He returns home to Kyushu and half feels like he wants to retire, and half feels like he wants to continue ice skating. Suddenly the five-time consecutive world championship ice skater Victor Nikiforov appears before him with Yuri Plisetsky, a young Russian figure skater who is already defeating his seniors. Victor and both Yuris take up the challenge on an unprecedented Gran Prix series.");
        movieDetailEntity.setMovieReleaseStatus("Ended");
        movieDetailEntity.setMovieReleaseDate("2016-10-06");
        movieDetailEntity.setMovieRunTime(12);
        movieDetailEntity.setMovieHomePage("https://yurionice.com/");
        movieDetailEntity.setMovieUserScore(8.9);
        movieDetailEntity.setMoviePoster(getImageUrl("/oKVFf2uNCLMsovWBxAW14MmhHUm.jpg"));
        movieDetailEntityArrayList.add(movieDetailEntity);

        return movieDetailEntityArrayList;
    }

    public static MovieAndDetailEntity dummyDetailMovie(MovieEntity movieEntity) {
        MovieAndDetailEntity movieAndDetailEntity = new MovieAndDetailEntity();
        movieAndDetailEntity.setMovieEntity(movieEntity);
        for (MovieDetailEntity movieDetailEntity : dummyDetailMovies()) {
            if (movieEntity.getMovieId() == movieDetailEntity.getMovieId())
                movieAndDetailEntity.setMovieDetailEntity(movieDetailEntity);
        }

        return movieAndDetailEntity;
    }
}
