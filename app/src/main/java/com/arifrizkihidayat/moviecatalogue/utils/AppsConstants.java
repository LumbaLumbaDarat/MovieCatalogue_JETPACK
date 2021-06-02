package com.arifrizkihidayat.moviecatalogue.utils;

import com.arifrizkihidayat.moviecatalogue.R;

public class AppsConstants {

    public static final int WAIT_FOR_RUN_HANDLER_500_MS  = 500;
    public static final int WAIT_FOR_RUN_HANDLER_1000_MS = 1000;
    public static final int WAIT_FOR_RUN_HANDLER_2000_MS = 2000;
    public static final int WAIT_FOR_RUN_HANDLER_3000_MS = 3000;

    public static final int FRAGMENT_PAGER = 2;

    public static final String MOVIES_MODEL = "MOVIES_MODEL";
    public static final String MOVIE_TYPE   = "MOVIE_TYPE";

    public static final String IS_FRAGMENT_MOVIES  = "MOVIES";
    public static final String IS_FRAGMENT_TV_SHOW = "TV_SHOW";
    public static final String[] FRAGMENT_PAGE     = {IS_FRAGMENT_MOVIES, IS_FRAGMENT_TV_SHOW};

    public static final int[] FRAGMENT_PAGE_TITLE = {R.string.tab_movies, R.string.tab_tv_shows};

    public static final String EMPTY_STRING = "";

    public static final String FAVORITE_PAGE  = "FAVORITE_PAGE";
    public static final String IS_FAVORITE    = "IS_FAVORITE";
    public static final String ISN_T_FAVORITE = "ISN_T_FAVORITE";
}
