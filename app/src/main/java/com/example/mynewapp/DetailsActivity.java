package com.example.mynewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity{

    private List<DataValues> values;
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        TextView name = findViewById(R.id.tv_detail_name);
        ImageView imageView = findViewById(R.id.image_details);
        TextView latin_name_txt = findViewById(R.id.textView2);
        TextView temp = findViewById(R.id.tempature_set);
        TextView water_txt = findViewById(R.id.water_set);
        TextView humidity_txt = findViewById(R.id.hum_set);
        TextView sun_txt = findViewById(R.id.sun_set);
        TextView ph_txt = findViewById(R.id.ph_set);


        String plant_name = "Plant name not set";
        String latin_name = "Plant latin name not set";
        String image_path = "Image path not set";
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
            image_path = extras.getString("img");

        }

        name.setText(plant_name);
        latin_name_txt.setText(latin_name);
        water_txt.setText(water);
        sun_txt.setText(sun);
        temp.setText(String.valueOf(tempInt));
        humidity_txt.setText(String.valueOf(humidity));
        ph_txt.setText(String.valueOf(ph));

        //Load the images from URL to imageview
        Glide.with(this).load(image_path).into(imageView);

    }

    //TODO: Here we should create the method that gets plants measure values!
    public void getValues(View view){

        Context context = getApplicationContext();
        CharSequence text = "Loading the values...";
        int duration = Toast.LENGTH_SHORT;
        //Get the JSON data from URL
        fetchContact("runscript","runscript");

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    public void fetchContact(String type, String key) {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<DataValues>> call = apiInterface.getDataValues(key);
        call.enqueue(new Callback<List<DataValues>>() {

            @Override
            public void onResponse(Call<List<DataValues>> call, Response<List<DataValues>> response) {
                values = response.body();
                TextView tempGet = findViewById(R.id.your_temp_set);
                TextView water_Get = findViewById(R.id.your_water_set);
                TextView humidity_Get = findViewById(R.id.your_hum_set);
                TextView sun_Get = findViewById(R.id.your_sun_set);

                water_Get.setText(values.get(0).getWater());
                sun_Get.setText(values.get(0).getSun());
                tempGet.setText(values.get(0).getTempature());
                humidity_Get.setText(values.get(0).getHumidity());
            }

            @Override
            public void onFailure(Call<List<DataValues>> call, Throwable t) {
                Toast.makeText(DetailsActivity.this, "Something went wrong\n" + "Please try calculating again", Toast.LENGTH_LONG).show();

            }
        });
    }
}