package com.arifrizkihidayat.moviecatalogue.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.arifrizkihidayat.moviecatalogue.databinding.ActivitySplashScreenBinding;

import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.WAIT_FOR_RUN_HANDLER_1000_MS;
import static com.arifrizkihidayat.moviecatalogue.utils.UtilizationClass.getVersion;

public class SplashScreenActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashScreenBinding binding =
                ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvVersionApps.setText(getVersion(this));

        new Handler().postDelayed(() -> {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }, WAIT_FOR_RUN_HANDLER_1000_MS);
    }
}