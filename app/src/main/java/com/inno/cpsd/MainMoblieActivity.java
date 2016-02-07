package com.inno.cpsd;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.inno.cpsd.Fragment.PageCPSD;


/**
 * Created by MoonFalling on 1/2/2559.
 */
public class MainMoblieActivity extends BaseAcitivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.moblie_main_activity);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container1, PageCPSD.newInstance(1))
                .commit();
    }


}
