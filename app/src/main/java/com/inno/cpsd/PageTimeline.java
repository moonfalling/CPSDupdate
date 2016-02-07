package com.inno.cpsd;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.inno.cpsd.Fragment.PageLogin;
import com.inno.cpsd.Fragment.PageReg;

/**
 * Created by MoonFalling on 2/2/2559.
 */
public class PageTimeline extends FragmentActivity {
    ListView lvtimeline;
    ImageView btbacklefttimeline;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.page_cpsd_timeline);
        lvtimeline = (ListView)findViewById(R.id.lvtimeline);
        btbacklefttimeline = (ImageView)findViewById(R.id.btbacklefttimeline);

        btbacklefttimeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }
}


