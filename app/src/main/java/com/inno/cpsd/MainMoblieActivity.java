package com.inno.cpsd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.inno.cpsd.Fragment.PageCPSD;


/**
 * Created by MoonFalling on 1/2/2559.
 */
public class MainMoblieActivity extends BaseAcitivity {
    TextView tvloginandreg,tvloginname;
    String SHusername,SHstaffid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.moblie_main_activity);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container1, PageCPSD.newInstance(1))
                .commit();

        tvloginandreg =(TextView)findViewById(R.id.tvloginandreg);
        tvloginname = (TextView)findViewById(R.id.tvloginname);
        tvloginandreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(MainMoblieActivity.this, PageLoginandRegister.class);
                startActivity(newActivity);
            }
        });
    }
    public void loadinguserinfo(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SHusername = preferences.getString("SHusername" ,"");
        SHstaffid = preferences.getString("SHstaffid","");
    }
    public void updateusertv(){
        if(SHusername.isEmpty()){
            tvloginname.setVisibility(View.GONE);
            tvloginandreg.setVisibility(View.VISIBLE);
        }
        else{
            tvloginandreg.setVisibility(View.GONE);
            tvloginname.setVisibility(View.VISIBLE);
            tvloginname.setText(SHusername);
        }



    }
    @Override
    public void onResume(){
        super.onResume();
        // put your code here...
        loadinguserinfo();
        updateusertv();

    }

}
