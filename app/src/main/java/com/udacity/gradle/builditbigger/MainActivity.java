package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.androidjoke.JokeActivity;
import com.example.androidjoke.JokeFragment;


public class MainActivity extends AppCompatActivity {

    TextView instruction;
    Button button;
    ProgressBar progressBar;

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

    public void tellJoke(View view) {
        View rootView = view.getRootView();
        instruction = rootView.findViewById(R.id.instructions_text_view);
        button = view.findViewById(R.id.button_tellJoke);
        progressBar = rootView.findViewById(R.id.pb_joke);

        // generating the intent
        final Intent intent = new Intent(this, JokeActivity.class);
        // I retrieve a joke
        new EndpointsAsyncTask(new EndpointsAsyncListener<String>() {
            @Override
            public void onPreTaskExecute() {
                instruction.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTaskComplete(String joke) {
                instruction.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                // then I send it by an intent to the Android Library androidJoke
                intent.putExtra(JokeFragment.JOKE_KEY, joke);
                startActivity(intent);
            }
        }).execute(this);

    }

}
