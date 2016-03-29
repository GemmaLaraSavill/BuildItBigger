package com.nanodegree.gemma.jokeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * An activity that shows a joke
 * It receives the joke via an intent identified with the joke_key
 */
public class JokeActivity extends AppCompatActivity {

    public static String JOKE_KEY = "My joke key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jokeTextView = (TextView)findViewById(R.id.joke_text);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_KEY);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }

    }

}
