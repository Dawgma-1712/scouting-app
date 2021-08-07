package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

//This is the script for the activity_match_scouting.xml layout
public class MatchScouting extends AppCompatActivity {
    //Declaring variables
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_scouting);

        //assigning variables
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);

        //Configuring the tablayout element with the viewpager element
        tabLayout.setupWithViewPager(viewPager);
        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new AutoFragment(),"AUTO");
        vpAdapter.addFragment(new TeleopFragment(),"TELEOP");
        vpAdapter.addFragment(new EndgameFragment(),"ENDGAME");
        viewPager.setAdapter(vpAdapter);


    }

    //Swtiches the screen back to the home screen
    //This happens when you press the "back" button on the match scouting layout
    public void switchToHomeScreen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}