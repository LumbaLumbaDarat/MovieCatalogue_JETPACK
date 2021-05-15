package com.arifrizkihidayat.moviecatalogue.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.arifrizkihidayat.moviecatalogue.ui.fragment.MoviesCatalogueFragment;

import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.EMPTY_STRING;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.FRAGMENT_PAGE;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.FRAGMENT_PAGER;

public class MoviesCataloguePagerAdapter extends FragmentStateAdapter {

    public MoviesCataloguePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return MoviesCatalogueFragment.
                newInstance(FRAGMENT_PAGE[position], EMPTY_STRING);
    }

    @Override
    public int getItemCount() {
        return FRAGMENT_PAGER;
    }
}
