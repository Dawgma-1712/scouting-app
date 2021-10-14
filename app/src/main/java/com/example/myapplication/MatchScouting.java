package com.example.myapplication;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//This is the script for the activity_match_scouting.xml layout
public class MatchScouting extends AppCompatActivity {
    //Declaring variables
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public AutoFragment autoFragment = new AutoFragment();

    private static int teamNumber;
    private static int matchNumber;
    private static int[][] buttonData;
    private static int[] checkBoxData;
    private static String defendedOnByNumber;

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
        vpAdapter.addFragment(new SaveFragment(), "SAVE");
        viewPager.setAdapter(vpAdapter);

        buttonData = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        checkBoxData = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    }

    //Swtiches the screen back to the home screen
    //This happens when you press the "back" button on the match scouting layout
    public void switchToHomeScreen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public static void editMatchData(int ind0, int ind1, int value) {
        buttonData[ind0][ind1] = value;
    }

    public static void onCheckBoxClicked(View view) {
        // Is view checked
        boolean checked = ((CheckBox) view).isChecked();

        // Check which one clicked
        switch(view.getId()) {
            case R.id.groundPickupCheckbox:
                checkBoxData[0] = checked ? 1 : 0;
                break;
            case R.id.HPPickupCheckBox:
                checkBoxData[1] = checked ? 1 : 0;
                break;
            case R.id.playedDefenseCheckBox:
                checkBoxData[2] = checked ? 1 : 0;
                break;
            case R.id.defendedOnCheckBox:
                checkBoxData[3] = checked ? 1 : 0;
                break;
            case R.id.targetZoneCheckBox:
                checkBoxData[4] = checked ? 1 : 0;
                break;
            case R.id.trenchCheckBox:
                checkBoxData[5] = checked ? 1 : 0;
                break;
            case R.id.neutralZoneCheckBox:
                checkBoxData[6] = checked ? 1 : 0;
                break;
            case R.id.farZoneCheckBox:
                checkBoxData[7] = checked ? 1 : 0;
                break;
            case R.id.rotationCheckBox:
                checkBoxData[8] = checked ? 1 : 0;
                break;
            case R.id.positionCheckBox:
                checkBoxData[9] = checked ? 1 : 0;
                break;
            case R.id.parkCheckBox:
                checkBoxData[10] = checked ? 1 : 0;
                break;
            case R.id.hangFailedCheckBox:
                checkBoxData[11] = checked ? 1 : 0;
                break;
            case R.id.hangScoredCheckBox:
                checkBoxData[12] = checked ? 1 : 0;
                break;
            case R.id.balancedCheckBox:
                checkBoxData[13] = checked ? 1 : 0;
                break;
            case R.id.moveAlongBarCheckBox:
                checkBoxData[14] = checked ? 1 : 0;
                break;
            case R.id.underTrenchCheckBox:
                checkBoxData[15] = checked ? 1 : 0;
                break;
            case R.id.botDeadCheckBox:
                checkBoxData[16] = checked ? 1 : 0;
                break;

        }
    }

    public static int[][] getButtonData() {
        return buttonData;
    }

    public static final int CREATE_FILE = 1;
    public static Uri fileUri;

    public void saveMatchData(View view) {
        // Get text field values
        teamNumber = 0;
        matchNumber = 0;
        defendedOnByNumber = "";
        if (((EditText)findViewById(R.id.teamNum)).getText().toString() != null && ((EditText)findViewById(R.id.matchNum)).getText().toString() != null) {
            teamNumber = Integer.parseInt(((EditText)findViewById(R.id.teamNum)).getText().toString());
            matchNumber = Integer.parseInt(((EditText)findViewById(R.id.matchNum)).getText().toString());
        }
        if (((EditText)findViewById(R.id.defendedOnTeamNum)).getText().toString() != null) {
            defendedOnByNumber = ((EditText)findViewById(R.id.defendedOnTeamNum)).getText().toString();
        }
        Log.d("TEXTFIELD THING", "Value of defended on by, is " + ((EditText)findViewById(R.id.defendedOnTeamNum)).getText().toString());

        // Create and save file
        if (teamNumber != 0 && matchNumber != 0) {
            Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("application/csv");
            String fileName = "match" + (new Integer(matchNumber)).toString() + "_team" + (new Integer(teamNumber)).toString() + ".csv";
            intent.putExtra(Intent.EXTRA_TITLE, fileName);

            // TODO: Automatically direct user to correct save location

            startActivityForResult(intent, CREATE_FILE);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);
        if (requestCode == CREATE_FILE && resultCode == Activity.RESULT_OK) {
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                fileUri = uri;

                // Good luck reading :)
                String data = "";
                data += (new Integer(teamNumber)).toString() + "," + (new Integer(matchNumber)).toString() + ","
                        /* AUTO */ + (new Integer(buttonData[0][4])).toString() + "," + (new Integer(buttonData[0][5])).toString() + "," + (new Integer(buttonData[0][2])).toString() + "," + (new Integer(buttonData[0][3])).toString() + "," + (new Integer(buttonData[0][0])).toString() + "," + (new Integer(buttonData[0][1])).toString() + "," + (new Integer(buttonData[0][6])).toString() + ","
                        /* TELEOP */ + (new Integer(checkBoxData[0])).toString() + "," + (new Integer(checkBoxData[1])).toString() + ","
                        /* DEFENSE */ + (new Integer(checkBoxData[2])).toString() + "," + (new Integer(checkBoxData[3])).toString() + "," + defendedOnByNumber + ","
                        /* POWER CELLS */ + (new Integer(buttonData[1][2])).toString() + "," + (new Integer(buttonData[1][3])).toString() + "," + (new Integer(buttonData[1][0])).toString() + "," + (new Integer(buttonData[1][1])).toString() + ","
                        /* SHOT FROM */ + (new Integer(checkBoxData[4])).toString() + "," + (new Integer(checkBoxData[5])).toString() + "," + (new Integer(checkBoxData[6])).toString() + "," + (new Integer(checkBoxData[7])).toString() + ","
                        /* CONTROL PANEL */ + (new Integer(checkBoxData[8])).toString() + "," + "" + "," + (new Integer(checkBoxData[9])).toString() + "," + "" + ","
                        /* ENDGAME */ + (new Integer(checkBoxData[10])).toString() + "," + (new Integer(checkBoxData[11])).toString() + "," + (new Integer(checkBoxData[12])).toString() + "," + "" + "," + "" + "," + (new Integer(checkBoxData[13])).toString() + "," + (new Integer(checkBoxData[14])).toString() + ","
                        /* ADDITIONAL INFO */ + (new Integer(checkBoxData[15])).toString() + "," + "" + "," + (new Integer(checkBoxData[16])).toString();

                alterDocument(uri, data);
            }
        }
    }

    private void alterDocument(Uri uri, String data) {
        try {
            ParcelFileDescriptor pfd = this.getContentResolver().openFileDescriptor(uri, "w");
            FileOutputStream fileOutputStream = new FileOutputStream(pfd.getFileDescriptor());
            fileOutputStream.write((data + "\n").getBytes());
            // Let the document provider know you're done by closing the stream.
            fileOutputStream.close();
            pfd.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}