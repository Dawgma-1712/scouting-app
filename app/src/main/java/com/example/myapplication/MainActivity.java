package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//This is the script for activity_main.xml. The only thing it does is let you pick between pit scouting and match scouting
//so there isn't much going on.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Called when the user presses the match scouting button, switches to the match scouting screen
    public void switchToMatchScouting (View view) {
        Intent intent = new Intent(this, MatchScouting.class);
        startActivity(intent);
    }
}