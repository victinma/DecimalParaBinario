package com.projectapp.realparadolar.splash;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.projectapp.realparadolar.MainActivity;
import com.projectapp.realparadolar.R;

public class SplashView extends Activity {

    private static int splahsTime = 3500;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashView.this, MainActivity.class);
                startActivity(i);

                finish();
            }
        }, splahsTime);
    }

}
