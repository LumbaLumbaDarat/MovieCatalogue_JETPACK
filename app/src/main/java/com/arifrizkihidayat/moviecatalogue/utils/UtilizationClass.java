package com.arifrizkihidayat.moviecatalogue.utils;

import android.content.Context;
import android.content.pm.PackageManager;

import com.arifrizkihidayat.moviecatalogue.R;

import static com.arifrizkihidayat.moviecatalogue.data.source.remote.ApiConnectionConstants.IMAGE_CONNECTION_URL;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.EMPTY_STRING;

public class UtilizationClass {
    public static String getVersion(Context context) {
        String versionName = "";
        try {
            versionName = context.getResources().getString(R.string.version_apps,
                    context.getPackageManager().getPackageInfo(
                            context.getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e) { e.printStackTrace(); }
        return versionName;
    }

    public static String getImageUrl(String image) {
        return IMAGE_CONNECTION_URL.concat(image);
    }

    public static String getUserScore(Context context, double userScore) {
        return context.getResources().getString(R.string.user_score, String.valueOf(userScore));
    }

    public static String getMovieRuntime(Context context, int runTime, String unit) {
        return context.getResources().getString(R.string.runtime_value,
                String.valueOf(runTime), unit);
    }

    public static String getReleaseDate(Context context, String releaseDate)
    {
        String monthInName = EMPTY_STRING;
        String[] splitReleaseDate = releaseDate.split("-");
        String[] month = context.getResources().getStringArray(R.array.month);
        for (String s : month)
        {
            String[] detailMonth = s.split("\\|");
            int monthInteger = Integer.parseInt(detailMonth[0]) + 1;

            if (Integer.parseInt(splitReleaseDate[1]) == monthInteger)
                monthInName = detailMonth[1];
        }

        return context.getResources().getString(R.string.release_date_value,
                splitReleaseDate[2], monthInName, splitReleaseDate[0]);
    }

    public static String getGenres(String genres) {
        return genres.replace("[", "").replace("]", "");
    }
}
