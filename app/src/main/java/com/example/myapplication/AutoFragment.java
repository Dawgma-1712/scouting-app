package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class AutoFragment extends Fragment implements View.OnClickListener {
    //initialize variables

    //Initialize inner port text views
    private TextView innerPortAutoScored;
    private TextView innerPortAutoMissed;

    //initialize outer port text views
    private TextView outerPortAutoMissed;
    private TextView outerPortAutoScored;

    //initialize inner port buttons
    private Button innerPortAutoScoredIncrease;
    private Button innerPortAutoScoredDecrease;
    private Button innerPortAutoMissedIncrease;
    private Button innerPortAutoMissedDecrease;

    //initialize outer port buttons
    private Button outerPortAutoScoredIncrease;
    private Button outerPortAutoScoredDecrease;
    private Button outerPortAutoMissedIncrease;
    private Button outerPortAutoMissedDecrease;


    //counter variables
    private int innerPortAutoScoredCounter;
    private int innerPortAutoMissedCounter;
    private int outerPortAutoScoredCounter;
    private int outerPortAutoMissedCounter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auto, container, false);

        //Define TextViews
        innerPortAutoScored = (TextView) view.findViewById(R.id.innerPortAutoScored);
        innerPortAutoMissed = (TextView) view.findViewById(R.id.innerPortAutoMissed);

        outerPortAutoScored = (TextView) view.findViewById(R.id.outerPortAutoScored);
        outerPortAutoMissed = (TextView) view.findViewById(R.id.outerPortAutoMissed);

        //Define Buttons
        //inner port buttons
        innerPortAutoScoredIncrease = (Button) view.findViewById(R.id.innerPortAutoScoredIncrease);
        innerPortAutoScoredIncrease.setOnClickListener(this);
        innerPortAutoScoredDecrease = (Button) view.findViewById(R.id.innerPortAutoScoredDecrease);
        innerPortAutoScoredDecrease.setOnClickListener(this);

        innerPortAutoMissedIncrease = (Button) view.findViewById(R.id.innerPortAutoMissedIncrease);
        innerPortAutoMissedIncrease.setOnClickListener(this);
        innerPortAutoMissedDecrease = (Button) view.findViewById(R.id.innerPortAutoMissedDecrease);
        innerPortAutoMissedDecrease.setOnClickListener(this);

        //outer port buttons
        outerPortAutoScoredIncrease = (Button) view.findViewById(R.id.outerPortAutoScoredIncrease);
        outerPortAutoScoredIncrease.setOnClickListener(this);
        outerPortAutoScoredDecrease = (Button) view.findViewById(R.id.outerPortAutoScoredDecrease);
        outerPortAutoScoredDecrease.setOnClickListener(this);

        outerPortAutoMissedIncrease = (Button) view.findViewById(R.id.outerPortAutoMissedIncrease);
        outerPortAutoMissedIncrease.setOnClickListener(this);
        outerPortAutoMissedDecrease = (Button) view.findViewById(R.id.outerPortAutoMissedDecrease);
        outerPortAutoMissedDecrease.setOnClickListener(this);


        //Define other variables
        innerPortAutoScoredCounter = 0;
        innerPortAutoMissedCounter = 0;
        outerPortAutoScoredCounter = 0;
        outerPortAutoMissedCounter = 0;

        return view;
    }

    //click listener
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.innerPortAutoScoredIncrease:
                innerPortAutoScoredCounter++;
                innerPortAutoScored.setText(Integer.toString(innerPortAutoScoredCounter));
                break;

            case R.id.innerPortAutoScoredDecrease:
                innerPortAutoScoredCounter--;
                innerPortAutoScored.setText(Integer.toString(innerPortAutoScoredCounter));
                break;

            case R.id.innerPortAutoMissedIncrease:
                innerPortAutoMissedCounter++;
                innerPortAutoMissed.setText(Integer.toString(innerPortAutoMissedCounter));
                break;

            case R.id.innerPortAutoMissedDecrease:
                innerPortAutoMissedCounter--;
                innerPortAutoMissed.setText(Integer.toString(innerPortAutoMissedCounter));
                break;

            case R.id.outerPortAutoScoredIncrease:
                outerPortAutoScoredCounter++;
                outerPortAutoScored.setText(Integer.toString(outerPortAutoScoredCounter));
                break;

            case R.id.outerPortAutoScoredDecrease:
                outerPortAutoScoredCounter--;
                outerPortAutoScored.setText(Integer.toString(outerPortAutoScoredCounter));
                break;

            case R.id.outerPortAutoMissedIncrease:
                outerPortAutoMissedCounter++;
                outerPortAutoMissed.setText(Integer.toString(outerPortAutoMissedCounter));
                break;

            case R.id.outerPortAutoMissedDecrease:
                outerPortAutoMissedCounter--;
                outerPortAutoMissed.setText(Integer.toString(outerPortAutoMissedCounter));
                break;
        }

    }
}