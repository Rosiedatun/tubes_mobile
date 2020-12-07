package com.example.drakor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SplashSreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sreen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        int Loading_app = 1000;
        new Handler().postDelayed(new Runnable(){
            public void run(){
               Intent intent = new Intent(com.example.drakor.SplashSreen.this, MainActivity.class);
               com.example.drakor.SplashSreen.this.startActivity(intent);
               com.example.drakor.SplashSreen.this.finish();

            }
        }, Loading_app);
    }
}