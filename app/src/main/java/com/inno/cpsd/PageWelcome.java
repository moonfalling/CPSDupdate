package com.inno.cpsd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Window;

/**
 * Created by MoonFalling on 1/2/2559.
 */
public class PageWelcome extends BaseAcitivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cpsdwelcome);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        if(preferences.getString("password", null) != null){
            Runnable r = new Runnable() {

                @Override
                public void run(){
                    onPostAgain();
                }
            };
            Handler h = new Handler();
            h.postDelayed(r, 1000); // <-- the "1000" is the delay time in miliseconds.

        }
        else{
            Runnable r = new Runnable() {
                @Override
                public void run(){
                    onPost(); //<-- put your code in here.
                }
            };

            Handler h = new Handler();
            h.postDelayed(r, 1000); // <-- the "1000" is the delay time in miliseconds.
        }
    }

    protected void onPost() {
        Intent newActivity = new Intent(this,MainMoblieActivity.class);
        startActivity(newActivity);
        finish();

    };
    protected void onPostAgain() {
        Intent newActivity = new Intent(this,MainMoblieActivity.class);
        startActivity(newActivity);
        finish();
    };
    }


