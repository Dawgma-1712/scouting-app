package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.service.autofill.FieldClassification;
import android.util.Log;
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

    //initialize lower port text views
    private TextView lowerPortAutoMissed;
    private TextView lowerPortAutoScored;

    //Initialize collected power cell text view
    private TextView collectedPC;



    //counter variables
    private int innerPortAutoScoredCounter = 0;
    private int innerPortAutoMissedCounter = 0;

    private int outerPortAutoScoredCounter = 0;
    private int outerPortAutoMissedCounter = 0;

    private int lowerPortAutoScoredCounter = 0;
    private int lowerPortAutoMissedCounter = 0;

    private int collectedPCCounter = 0;

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

        lowerPortAutoScored = (TextView) view.findViewById(R.id.lowerPortAutoScored);
        lowerPortAutoMissed = (TextView) view.findViewById(R.id.lowerPortAutoMissed);

        collectedPC = (TextView) view.findViewById(R.id.collectedPC);

        //Define Buttons

        //inner port buttons
        view.findViewById(R.id.innerPortAutoScoredIncrease).setOnClickListener(this);
        view.findViewById(R.id.innerPortAutoScoredDecrease).setOnClickListener(this);

        view.findViewById(R.id.innerPortAutoMissedIncrease).setOnClickListener(this);
        view.findViewById(R.id.innerPortAutoMissedDecrease).setOnClickListener(this);

        //outer port buttons
        view.findViewById(R.id.outerPortAutoScoredIncrease).setOnClickListener(this);
        view.findViewById(R.id.outerPortAutoScoredDecrease).setOnClickListener(this);

        view.findViewById(R.id.outerPortAutoMissedIncrease).setOnClickListener(this);
        view.findViewById(R.id.outerPortAutoMissedDecrease).setOnClickListener(this);

        //lower port buttons
        view.findViewById(R.id.lowerPortAutoScoredIncrease).setOnClickListener(this);
        view.findViewById(R.id.lowerPortAutoScoredDecrease).setOnClickListener(this);

        view.findViewById(R.id.lowerPortAutoMissedIncrease).setOnClickListener(this);
        view.findViewById(R.id.lowerPortAutoMissedDecrease).setOnClickListener(this);

        //collected power cells buttons
        view.findViewById(R.id.collectedPCDecrease).setOnClickListener(this);
        view.findViewById(R.id.collectedPCIncrease).setOnClickListener(this);

        return view;
    }

    //click listener
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.innerPortAutoScoredIncrease:
                innerPortAutoScoredCounter++;
                innerPortAutoScored.setText(Integer.toString(innerPortAutoScoredCounter));
                MatchScouting.editMatchData(0, 0, MatchScouting.getButtonData()[0][0] + 1);
                break;

            case R.id.innerPortAutoScoredDecrease:
                innerPortAutoScoredCounter--;
                innerPortAutoScored.setText(Integer.toString(innerPortAutoScoredCounter));
                MatchScouting.editMatchData(0, 0, MatchScouting.getButtonData()[0][0] - 1);
                break;

            case R.id.innerPortAutoMissedIncrease:
                innerPortAutoMissedCounter++;
                innerPortAutoMissed.setText(Integer.toString(innerPortAutoMissedCounter));
                MatchScouting.editMatchData(0, 1, MatchScouting.getButtonData()[0][1] + 1);
                break;

            case R.id.innerPortAutoMissedDecrease:
                innerPortAutoMissedCounter--;
                innerPortAutoMissed.setText(Integer.toString(innerPortAutoMissedCounter));
                MatchScouting.editMatchData(0, 1, MatchScouting.getButtonData()[0][1] - 1);
                break;

            case R.id.outerPortAutoScoredIncrease:
                outerPortAutoScoredCounter++;
                outerPortAutoScored.setText(Integer.toString(outerPortAutoScoredCounter));
                MatchScouting.editMatchData(0, 2, MatchScouting.getButtonData()[0][2] + 1);
                break;

            case R.id.outerPortAutoScoredDecrease:
                outerPortAutoScoredCounter--;
                outerPortAutoScored.setText(Integer.toString(outerPortAutoScoredCounter));
                MatchScouting.editMatchData(0, 2, MatchScouting.getButtonData()[0][2] - 1);
                break;

            case R.id.outerPortAutoMissedIncrease:
                outerPortAutoMissedCounter++;
                outerPortAutoMissed.setText(Integer.toString(outerPortAutoMissedCounter));
                MatchScouting.editMatchData(0, 3, MatchScouting.getButtonData()[0][3] + 1);
                break;

            case R.id.outerPortAutoMissedDecrease:
                outerPortAutoMissedCounter--;
                outerPortAutoMissed.setText(Integer.toString(outerPortAutoMissedCounter));
                MatchScouting.editMatchData(0, 3, MatchScouting.getButtonData()[0][3] - 1);
                break;

            case R.id.lowerPortAutoScoredIncrease:
                lowerPortAutoScoredCounter++;
                lowerPortAutoScored.setText(Integer.toString(lowerPortAutoScoredCounter));
                MatchScouting.editMatchData(0, 4, MatchScouting.getButtonData()[0][4] + 1);
                break;

            case R.id.lowerPortAutoScoredDecrease:
                lowerPortAutoScoredCounter--;
                lowerPortAutoScored.setText(Integer.toString(lowerPortAutoScoredCounter));
                MatchScouting.editMatchData(0, 4, MatchScouting.getButtonData()[0][4] - 1);
                break;

            case R.id.lowerPortAutoMissedIncrease:
                lowerPortAutoMissedCounter++;
                lowerPortAutoMissed.setText(Integer.toString(lowerPortAutoMissedCounter));
                MatchScouting.editMatchData(0, 5, MatchScouting.getButtonData()[0][5] + 1);
                break;

            case R.id.lowerPortAutoMissedDecrease:
                lowerPortAutoMissedCounter--;
                lowerPortAutoMissed.setText(Integer.toString(lowerPortAutoMissedCounter));
                MatchScouting.editMatchData(0, 5, MatchScouting.getButtonData()[0][5] - 1);
                break;

            case R.id.collectedPCIncrease:
                collectedPCCounter++;
                collectedPC.setText(Integer.toString(collectedPCCounter));
                MatchScouting.editMatchData(0, 6, MatchScouting.getButtonData()[0][6] + 1);
                break;
            case R.id.collectedPCDecrease:
                collectedPCCounter--;
                collectedPC.setText(Integer.toString(collectedPCCounter));
                MatchScouting.editMatchData(0, 6, MatchScouting.getButtonData()[0][6] - 1);
                break;
        }

    }

    public void onResume() {
        super.onResume();

        innerPortAutoScored.setText(Integer.toString(innerPortAutoScoredCounter));
        innerPortAutoMissed.setText(Integer.toString(innerPortAutoMissedCounter));
        outerPortAutoScored.setText(Integer.toString(outerPortAutoScoredCounter));
        outerPortAutoMissed.setText(Integer.toString(outerPortAutoMissedCounter));
        lowerPortAutoScored.setText(Integer.toString(lowerPortAutoScoredCounter));
        lowerPortAutoMissed.setText(Integer.toString(lowerPortAutoMissedCounter));
        collectedPC.setText(Integer.toString(collectedPCCounter));

    }

    public void onCheckBoxClicked(View view) {
        MatchScouting.onCheckBoxClicked(view);
    }
}