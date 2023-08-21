package com.arrowwouldpro.wallpaperapp.openads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.window.SplashScreen;

import com.arrowwouldpro.wallpaperapp.MainActivity;
import com.arrowwouldpro.wallpaperapp.R;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Splash_Screen extends AppCompatActivity {

    TextView txtView;
    private AppOpenManager appOpenManager;
    private CountDownTimer countDownTimer;
    private ProgressBar adsLoaderPbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//        txtView = findViewById(R.id);
        adsLoaderPbar = findViewById(R.id.adsloader);

        MobileAds.initialize(Splash_Screen.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();


        if (netInfo.isConnected() && netInfo != null) {
            appOpenManager = new AppOpenManager(Splash_Screen.this);
            appOpenManager.fetchAd(getResources().getString(R.string.app_open_ads_id));

            countDownTimer = new CountDownTimer(10000, 1000) {

                public void onTick(long millisUntilFinished) {

                    if (AppOpenManager.adsisLoaded() == true) {
                        adsLoaderPbar.setVisibility(View.GONE);
                        appOpenManager.showAdIfAvailable();
                        countDownTimer.cancel();
                        Log.d("mmmm","ads is show");
                    }

                }

                public void onFinish() {
//                    txtTitle.setText("done!");

                    if (AppOpenManager.adsisLoaded() != true) {
                        intentToHomeScreen();
                        adsLoaderPbar.setVisibility(View.GONE);
                    }

                }

            }.start();

        }else {
//            countDownTimer.cancel();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    intentToHomeScreen();
                    adsLoaderPbar.setVisibility(View.GONE);
                }
            },3000);
        }


    }


    public void intentToHomeScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 400);
    }

    public void stopCountdown(){
        countDownTimer.cancel();
        Log.d("mmmm","stop countdown");
    }
}
