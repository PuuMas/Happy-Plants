package com.example.mynewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        getSupportActionBar().hide();

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        long splashscreen = 5000L;

        Animation topAnimation;
        Animation bottomAnimation;
        ImageView imageView;
        TextView textView;

        //Animations
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);

        //Hooks
        imageView = findViewById(R.id.logo);
        textView = findViewById(R.id.happy_plants);

        imageView.startAnimation(topAnimation);
        textView.startAnimation(bottomAnimation);


        new Handler().postDelayed (() -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }, splashscreen);
    }
}