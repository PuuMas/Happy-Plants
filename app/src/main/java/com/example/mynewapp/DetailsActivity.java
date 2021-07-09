package com.example.mynewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    public static final String EXTRA_PLANT = "extra_plant";

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
        String plant_latin = "Plant latin name not set";
        Double temp_val = 0.0;
        String water_set = "Plant water level not set";
        Double humidity_set = 0.0;
        String sun_set = "Plant sun value not set";
        Double ph_set = 0.0;


        Bundle extras = getIntent().getExtras();
        if(extras != null){
            plant_name = extras.getString("herb_name");
            plant_latin = extras.getString("latin_name");
            temp_val = extras.getDouble("temp");
            water_set = extras.getString("water");
            humidity_set = extras.getDouble("humidity");
            sun_set = extras.getString("sun");
            ph_set = extras.getDouble("ph");
        }

        info.setText(plant_latin);
        name.setText(plant_name);
        temp.setText(temp_val.toString());
        water.setText(water_set);
        humidity.setText(humidity_set.toString());
        sun.setText(sun_set);
        ph.setText(ph_set.toString());

    }
}