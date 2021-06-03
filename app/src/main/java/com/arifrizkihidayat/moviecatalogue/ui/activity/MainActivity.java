package com.arifrizkihidayat.moviecatalogue.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.arifrizkihidayat.moviecatalogue.R;
import com.arifrizkihidayat.moviecatalogue.databinding.ActivityMainBinding;
import com.arifrizkihidayat.moviecatalogue.ui.adapter.MoviesCataloguePagerAdapter;
import com.google.android.material.tabs.TabLayoutMediator;

import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.EMPTY_STRING;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.FAVORITE_PAGE;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.FRAGMENT_PAGE_TITLE;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.ISN_T_FAVORITE;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.IS_FAVORITE;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private String isFavoriteMenu = EMPTY_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent() != null)
            isFavoriteMenu = getIntent().getStringExtra(FAVORITE_PAGE);

        if (TextUtils.isEmpty(isFavoriteMenu) || isFavoriteMenu == null)
            isFavoriteMenu = ISN_T_FAVORITE;

        if (getSupportActionBar() != null)
        {
            if (isFavoriteMenu.equalsIgnoreCase(IS_FAVORITE))
            {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setTitle(
                        getResources().getString(R.string.label_favorite_app_bar));
            }
        }

        MoviesCataloguePagerAdapter moviesCataloguePagerAdapter =
                new MoviesCataloguePagerAdapter(this);
        moviesCataloguePagerAdapter.setIsFavoriteMenu(isFavoriteMenu);
        binding.vpMain.setAdapter(moviesCataloguePagerAdapter);

        new TabLayoutMediator(binding.tlMain, binding.vpMain,
                (tab, position) -> tab.setText(FRAGMENT_PAGE_TITLE[position])).attach();

        for(int i = 0; i < binding.tlMain.getTabCount(); i++) {
            View tab = ((ViewGroup) binding.tlMain.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();

            if (i == 0)
                p.setMargins(20, 0, 10, 0);
            else if (i == binding.tlMain.getTabCount() - 1)
                p.setMargins(10, 0, 20, 0);
            else p.setMargins(10, 0, 10, 0);

            tab.requestLayout();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (isFavoriteMenu.equalsIgnoreCase(ISN_T_FAVORITE)) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.movie_main_menu, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.favorite_main:
                goToFavorite();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (isFavoriteMenu.equalsIgnoreCase(IS_FAVORITE))
            super.onBackPressed();
        else {
            if (binding.vpMain.getCurrentItem() == 0)
                super.onBackPressed();
            else binding.vpMain.setCurrentItem(
                    binding.vpMain.getCurrentItem() - 1);
        }
    }

    private void goToFavorite() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(FAVORITE_PAGE, IS_FAVORITE);

        startActivity(intent);
    }
}