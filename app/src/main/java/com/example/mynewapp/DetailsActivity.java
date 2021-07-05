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
        TextView latin_name_txt = findViewById(R.id.textView2);
        TextView temp = findViewById(R.id.tempature_set);
        TextView water_txt = findViewById(R.id.water_set);
        TextView humidity_txt = findViewById(R.id.hum_set);
        TextView sun_txt = findViewById(R.id.sun_set);
        TextView ph_txt = findViewById(R.id.ph_set);
        TextView your_temp = findViewById(R.id.your_temp_set);
        TextView your_water = findViewById(R.id.your_water_set);
        TextView your_humidity = findViewById(R.id.your_hum_set);
        TextView your_sun = findViewById(R.id.your_sun_set);
        TextView your_ph = findViewById(R.id.your_ph_set);

        String plant_name = "Plant name not set";
        String latin_name = "Plant latin name not set";
        int tempInt = 0;
        String water = "Water level not set";
        float humidity = 0;
        String sun = "Sun level not set";
        float ph = 0;


        Bundle extras = getIntent().getExtras();
        if(extras != null){
            plant_name = extras.getString("herb_name");
            latin_name = extras.getString("latin_name");
            tempInt = extras.getInt("temp");
            water = extras.getString("water");
            humidity = extras.getFloat("humidity");
            sun = extras.getString("sun");
            ph = extras.getFloat("ph");

        }

        name.setText(plant_name);
        latin_name_txt.setText(latin_name);
        water_txt.setText(water);
        sun_txt.setText(sun);
        temp.setText(String.valueOf(tempInt));
        humidity_txt.setText(String.valueOf(humidity));
        ph_txt.setText(String.valueOf(ph));

    }
}