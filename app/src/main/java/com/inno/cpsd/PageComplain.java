package com.inno.cpsd;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by MoonFalling on 2/2/2559.
 */
public class PageComplain extends FragmentActivity {
    ImageView btback;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_cpsd_complain);
        btback = (ImageView)findViewById(R.id.btbackleftcomplain);

        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
