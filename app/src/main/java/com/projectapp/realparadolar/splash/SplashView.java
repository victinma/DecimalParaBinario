package com.projectapp.realparadolar.splash;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;

import com.projectapp.realparadolar.MainActivity;
import com.projectapp.realparadolar.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashView extends Activity {

    private static int splahsTime = 3500;
    ProgressBar pb;
    private int contador = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        prog();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashView.this,
                        MainActivity.class);
                startActivity(i);
                finish();
            }
        }, splahsTime);
    }

    public void prog(){
        pb = (ProgressBar)findViewById(R.id.pb);

        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run()
            {
                contador++;
                pb.setProgress(contador);

                if(contador == 100)
                    t.cancel();
            }
        };

        t.schedule(tt,0,100);
    }
}