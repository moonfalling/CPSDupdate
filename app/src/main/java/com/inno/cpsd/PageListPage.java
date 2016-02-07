package com.inno.cpsd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by MoonFalling on 2/2/2559.
 */
public class PageListPage extends FragmentActivity {
    ImageView btback;
    ListView lvshow;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_cpsd_listpage);
        btback = (ImageView)findViewById(R.id.btbackleftlistpage);
        lvshow =(ListView)findViewById(R.id.lvlistpage);

        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
