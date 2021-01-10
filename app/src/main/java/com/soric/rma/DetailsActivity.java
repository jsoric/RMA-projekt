package com.soric.rma;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private Game game;
    private ImageView gameImage;
    private TextView rank;
    private TextView title;
    private TextView releaseDate;
    private TextView platform;
    private TextView sales;
    private TextView developer;
    private TextView publisher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        game = (Game) intent.getSerializableExtra("game");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(game.getTitle());
            actionBar.setSubtitle(game.getDeveloper());
        }

        gameImage = findViewById(R.id.gameImage);
        rank = findViewById(R.id.rank);
        title = findViewById(R.id.title);
        releaseDate = findViewById(R.id.releaseDate);
        platform = findViewById(R.id.platform);
        sales = findViewById(R.id.sales);
        developer = findViewById(R.id.developer);
        publisher = findViewById(R.id.publisher);

        Picasso.get().load(game.getImage_url()).into(gameImage);
        rank.setText(String.valueOf(game.getRank()));
        title.setText(String.valueOf(game.getTitle()));
        releaseDate.setText(String.valueOf(game.getRelease_date()));
        platform.setText(String.valueOf(game.getPlatform()));
        sales.setText(String.valueOf(game.getSales()));
        developer.setText(String.valueOf(game.getDeveloper()));
        publisher.setText(String.valueOf(game.getPublisher()));

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}