package com.example.mynewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        ImageView imageView = findViewById(R.id.image_details);
        TextView name = findViewById(R.id.tv_detail_name);
        TextView info = findViewById(R.id.info);
        TextView temp = findViewById(R.id.tempature_set);
        TextView water = findViewById(R.id.water_set);
        TextView humidity = findViewById(R.id.hum_set);
        TextView sun = findViewById(R.id.sun_set);
        TextView ph = findViewById(R.id.ph_set);
        TextView your_temp = findViewById(R.id.your_temp_set);
        TextView your_water = findViewById(R.id.your_water_set);
        TextView your_humidity = findViewById(R.id.your_hum_set);
        TextView your_sun = findViewById(R.id.your_sun_set);
        TextView your_ph = findViewById(R.id.your_ph_set);

        String plant_name = "Plant name not set";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            plant_name = extras.getString("herb_name");
        }

        name.setText(plant_name);

    }
}