package com.inno.cpsd;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.inno.cpsd.Fragment.PageLogin;
import com.inno.cpsd.Fragment.PageReg;

/**
 * Created by MoonFalling on 2/2/2559.
 */
public class PageLoginandRegister extends FragmentActivity {
    Button btpagelogin,btpagereg;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.page_cpsd_loginandregister);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.logincontainer, PageLogin.newInstance(1))
                .commit();

        btpagelogin = (Button)findViewById(R.id.btlogin);
        btpagereg = (Button)findViewById(R.id.btreg);


        btpagereg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getSupportFragmentManager().beginTransaction()
                       .replace(R.id.logincontainer, PageReg.newInstance(1))
                       .commit();
            }
        });

        btpagelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.logincontainer, PageLogin.newInstance(1))
                        .commit();
            }
        });

    }
}
