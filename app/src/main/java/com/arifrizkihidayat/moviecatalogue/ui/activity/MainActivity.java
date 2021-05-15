package com.arifrizkihidayat.moviecatalogue.ui.activity;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.arifrizkihidayat.moviecatalogue.databinding.ActivityMainBinding;
import com.arifrizkihidayat.moviecatalogue.ui.adapter.MoviesCataloguePagerAdapter;
import com.google.android.material.tabs.TabLayoutMediator;

import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.FRAGMENT_PAGE_TITLE;

public class MainActivity extends FragmentActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MoviesCataloguePagerAdapter moviesCataloguePagerAdapter =
                new MoviesCataloguePagerAdapter(this);
        binding.vpMain.setAdapter(moviesCataloguePagerAdapter);

        new TabLayoutMediator(binding.tlMain, binding.vpMain,
                (tab, position) -> tab.setText(FRAGMENT_PAGE_TITLE[position])).attach();
    }

    @Override
    public void onBackPressed() {
        if (binding.vpMain.getCurrentItem() == 0)
            super.onBackPressed();
        else binding.vpMain.setCurrentItem(
                binding.vpMain.getCurrentItem() - 1);
    }
}