package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link TeleopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeleopFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    //private String mParam1;
    //private String mParam2;

    //initialize variables

    //Initialize inner port text views
    private TextView upperPortTeleopScored;
    private TextView upperPortTeleopMissed;

    //initialize outer port text views
    private TextView lowerPortTeleopMissed;
    private TextView lowerPortTeleopScored;

    //initialize counter variables
    private int upperPortTeleopScoredCounter = 0;
    private int upperPortTeleopMissedCounter = 0;

    private int lowerPortTeleopScoredCounter = 0;
    private int lowerPortTeleopMissedCounter = 0;

    /*
    public TeleopFragment() {
        // Required empty public constructor
    }

     */

    /*
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeleopFragment.
     */
    // TODO: Rename and change types and number of parameters
    /*
    public static TeleopFragment newInstance(String param1, String param2) {
        TeleopFragment fragment = new TeleopFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    */

    /*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }
    */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teleop, container, false);

        //upper port text views
        upperPortTeleopScored = (TextView) view.findViewById(R.id.upperPortTeleopScored);
        upperPortTeleopMissed = (TextView) view.findViewById(R.id.upperPortTeleopMissed);

        //lower port text views
        lowerPortTeleopScored = (TextView) view.findViewById(R.id.lowerPortTeleopScored);
        lowerPortTeleopMissed = (TextView) view.findViewById(R.id.lowerPortTeleopMissed);


        //upper port buttons
        view.findViewById(R.id.upperPortTeleopScoredIncrease).setOnClickListener(this);
        view.findViewById(R.id.upperPortTeleopScoredDecrease).setOnClickListener(this);

        view.findViewById(R.id.upperPortTeleopMissedIncrease).setOnClickListener(this);
        view.findViewById(R.id.upperPortTeleopMissedDecrease).setOnClickListener(this);

        //lower port buttons
        view.findViewById(R.id.lowerPortTeleopScoredIncrease).setOnClickListener(this);
        view.findViewById(R.id.lowerPortTeleopScoredDecrease).setOnClickListener(this);

        view.findViewById(R.id.lowerPortTeleopMissedIncrease).setOnClickListener(this);
        view.findViewById(R.id.lowerPortTeleopMissedDecrease).setOnClickListener(this);

        /*
        // Upper checkboxes and team #
        view.findViewById(R.id.groundPickupCheckbox).setOnClickListener(this);
        view.findViewById(R.id.HPPickupCheckBox).setOnClickListener(this);
        view.findViewById(R.id.playedDefenseCheckBox).setOnClickListener(this);
        view.findViewById(R.id.defendedOnCheckBox).setOnClickListener(this);
        view.findViewById(R.id.teamNum).setOnClickListener(this);

        // Shot from
        view.findViewById(R.id.targetZoneCheckBox).setOnClickListener(this);
        view.findViewById(R.id.trenchCheckBox).setOnClickListener(this);
        view.findViewById(R.id.neutralZoneCheckBox).setOnClickListener(this);
        view.findViewById(R.id.farZoneCheckBox).setOnClickListener(this);

        // Control panel
        view.findViewById(R.id.rotationCheckBox).setOnClickListener(this);
        view.findViewById(R.id.positionCheckBox).setOnClickListener(this);

        // End game
        view.findViewById(R.id.parkCheckBox).setOnClickListener(this);
        view.findViewById(R.id.hangFailedCheckBox).setOnClickListener(this);
        view.findViewById(R.id.hangScoredCheckBox).setOnClickListener(this);
        view.findViewById(R.id.balancedCheckBox).setOnClickListener(this);
        view.findViewById(R.id.moveAlongBarCheckBox).setOnClickListener(this);
        view.findViewById(R.id.underTrenchCheckBox).setOnClickListener(this);
        view.findViewById(R.id.botDeadCheckBox).setOnClickListener(this);

         */

        //counter variables

        return view;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case(R.id.upperPortTeleopScoredIncrease):
                upperPortTeleopScoredCounter++;
                upperPortTeleopScored.setText(Integer.toString(upperPortTeleopScoredCounter));
                MatchScouting.editMatchData(1, 0, MatchScouting.getButtonData()[1][0] + 1);
                break;

            case(R.id.upperPortTeleopScoredDecrease):
                upperPortTeleopScoredCounter--;
                upperPortTeleopScored.setText(Integer.toString(upperPortTeleopScoredCounter));
                MatchScouting.editMatchData(1, 0, MatchScouting.getButtonData()[1][0] - 1);
                break;

            case(R.id.upperPortTeleopMissedIncrease):
                upperPortTeleopMissedCounter++;
                upperPortTeleopMissed.setText(Integer.toString(upperPortTeleopMissedCounter));
                MatchScouting.editMatchData(1, 1, MatchScouting.getButtonData()[1][1] + 1);
                break;

            case(R.id.upperPortTeleopMissedDecrease):
                upperPortTeleopMissedCounter--;
                upperPortTeleopMissed.setText(Integer.toString(upperPortTeleopMissedCounter));
                MatchScouting.editMatchData(1, 1, MatchScouting.getButtonData()[1][1] - 1);
                break;




            case(R.id.lowerPortTeleopScoredIncrease):
                lowerPortTeleopScoredCounter++;
                lowerPortTeleopScored.setText(Integer.toString(lowerPortTeleopScoredCounter));
                MatchScouting.editMatchData(1, 2, MatchScouting.getButtonData()[1][2] + 1);
                break;

            case(R.id.lowerPortTeleopScoredDecrease):
                lowerPortTeleopScoredCounter--;
                lowerPortTeleopScored.setText(Integer.toString(lowerPortTeleopScoredCounter));
                MatchScouting.editMatchData(1, 2, MatchScouting.getButtonData()[1][2] - 1);
                break;

            case(R.id.lowerPortTeleopMissedIncrease):
                lowerPortTeleopMissedCounter++;
                lowerPortTeleopMissed.setText(Integer.toString(lowerPortTeleopMissedCounter));
                MatchScouting.editMatchData(1, 3, MatchScouting.getButtonData()[1][3] + 1);
                break;

            case(R.id.lowerPortTeleopMissedDecrease):
                lowerPortTeleopMissedCounter--;
                lowerPortTeleopMissed.setText(Integer.toString(lowerPortTeleopMissedCounter));
                MatchScouting.editMatchData(1, 3, MatchScouting.getButtonData()[1][3] - 1);
                break;
        }
    }

    public void onResume() {
        super.onResume();

        upperPortTeleopScored.setText(Integer.toString(upperPortTeleopScoredCounter));
        upperPortTeleopMissed.setText(Integer.toString(upperPortTeleopMissedCounter));
        lowerPortTeleopScored.setText(Integer.toString(lowerPortTeleopScoredCounter));
        lowerPortTeleopMissed.setText(Integer.toString(lowerPortTeleopMissedCounter));

    }
}