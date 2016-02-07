package com.inno.cpsd;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bluelinelabs.logansquare.LoganSquare;
import com.inno.cpsd.Model.LoginModel;
import com.inno.cpsd.adapter.CpsdGridAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MoonFalling on 1/2/2559.
 */
public class PagePolicy extends BaseAcitivity {
    ImageView btback;
    TextView tvpolicy;
    String staff_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_cpsd_policy);
        btback= (ImageView)findViewById(R.id.btbackleftpoloicy);
        tvpolicy = (TextView)findViewById(R.id.policydetail);

        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}
