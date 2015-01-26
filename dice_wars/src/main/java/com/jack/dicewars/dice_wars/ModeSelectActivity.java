package com.jack.dicewars.dice_wars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class ModeSelectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_mode_select);
    }

    // Activity Navigation

    /**
     * Calls another activity GameConfigActivity
     */
    public void goToGameConfig(View v) {
        Log.i("nav", "Go to Game Mode");

        Intent configIntent = new Intent(this, GameConfigActivity.class);
        startActivity(configIntent);
    }

    /**
     * Calls another activity OpenRoom
     */
    public void goToOpenRoom(View v) {
        Log.i("nav", "Go to Open Room");

    }

    /**
     * Calls another activity JoinRoom
     */
    public void goToJoinRoom(View v) {
        Log.i("nav", "Go to Join Room");

    }
}
