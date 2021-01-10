package com.soric.rma;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements ItemClickInterface {

    private RecyclerView recyclerView;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getResources().getString(R.string.app_title));
        }

        recyclerView = findViewById(R.id.lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listAdapter = new ListAdapter(this);
        listAdapter.setItemClickInterface(this);

        recyclerView.setAdapter(listAdapter);

        String url = "https://firebasestorage.googleapis.com/v0/b/rma-projekt-e321a.appspot.com/o/api.json?alt=media";

        RESTTask task = new RESTTask();
        task.execute(url);
    }

    public class RESTTask extends AsyncTask<String, Void, List<Game>> {

        @Override
        protected List<Game> doInBackground(String... strings) {
            String address = strings[0];
            try {
                URL url = new URL(address);
                HttpsURLConnection http = (HttpsURLConnection) url.openConnection();
                http.setRequestMethod("GET");
                http.setReadTimeout(15000);
                http.setConnectTimeout(15000);
                http.connect();
                InputStreamReader inputStreamReader = new InputStreamReader(http.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                Response response = new Gson().fromJson(bufferedReader, Response.class);
                bufferedReader.close();
                inputStreamReader.close();
                Log.wtf("Error", String.valueOf(response.getGames()));
                return response.getGames();
            } catch (MalformedURLException e) {
                Log.e("Address error", e.getMessage());
            } catch (IOException e) {
                Log.e("Access error", e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Game> games) {
            super.onPostExecute(games);
            listAdapter.setGames(games);
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(Game game) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("game", game);
        startActivity(intent);
    }
}