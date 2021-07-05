package com.example.mynewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    private Adapter.RecyclerViewClickListener listener;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Plants> contacts;
    private Adapter adapter;
    private ApiInterface apiInterface;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //First call is to search the whole database without keyword
        fetchContact("plants", "");

        //TODO:Korjaa kaikkien hakutulosten näyttäminen "Etsi" nappia painamisen jälkeen
        //TODO: Create Click event for selected events

    }

    public void fetchContact(String type, String key) {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Plants>> call = apiInterface.getPlants(key);
        call.enqueue(new Callback<List<Plants>>() {

            @Override
            public void onResponse(Call<List<Plants>> call, Response<List<Plants>> response) {
                setOnClickListener();
                progressBar.setVisibility(View.GONE);
                contacts = response.body();
                adapter = new Adapter(contacts,MainActivity.this,listener);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Plants>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error\n" + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setOnClickListener() {
        listener = (v, position) -> {
            Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
            intent.putExtra("herb_name", contacts.get(position).getHerbName());
            startActivity(intent);
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fetchContact("plants", query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fetchContact("plants", newText);
                return false;
            }
        });
        return true;
    }
}
