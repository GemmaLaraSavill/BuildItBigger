package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.nanodegree.gemma.jokeactivity.JokeActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.jokes.Joker;


public class MainActivity extends AppCompatActivity {

    private static MyApi myApiService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Method called when user requests a joke
     * It displays as a Toast
     * @param view
     */
    public void tellJoke(View view){
        Joker joker = new Joker();
        String joke = joker.getAJoke();
        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }



    /**
     * Gets a joke from the java joke library
     * Passes the joke to the Android Joke Activity library
     * via an intent
     */
    public void launchJokeActivity(){
        Intent intent = new Intent(this, JokeActivity.class);
        Joker joker = new Joker();
        String joke = joker.getAJoke();
        intent.putExtra(JokeActivity.JOKE_KEY, joke);
        startActivity(intent);
    }

    /**
     * Starts a task to receive a joke from the Java Library via a GCE module
     */
    public void startJokeRetreivalTask(View view) {
        GetJokeAsyncTask loadJokeTask = new GetJokeAsyncTask();
        loadJokeTask.setContext(this);
        loadJokeTask.execute(this);
    }



}


