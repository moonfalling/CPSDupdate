package com.inno.cpsd;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MoonFalling on 1/2/2559.
 */
public class PagePolicy extends BaseAcitivity {
    ImageView btback;
    TextView tvpolicy;
    String staff_id,status,info,policy_detail,error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_cpsd_policy);
        btback = (ImageView) findViewById(R.id.btbackleftpoloicy);
        tvpolicy = (TextView) findViewById(R.id.policydetail);

        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        loadingstaffid();

        String url = "http://61.90.233.91/cpsustain/api/policy.php";

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            if (jsonResponse.has("status")) {
                                status = jsonResponse.getString("status");
                                if (status.equals("OK")) {
                                    if (jsonResponse.has("policy_detail")) {
                                        policy_detail = jsonResponse.getString("policy_detail");
                                        tvpolicy.setText(policy_detail);
                                    }
                                    if (jsonResponse.has("info")) {
                                        info = jsonResponse.getString("info");
                                    }

//                                    Toast.makeText(getApplicationContext(),info,Toast.LENGTH_SHORT).show();

                                } else {
                                    if (jsonResponse.has("status")) {
                                        error = jsonResponse.getString("Error");
                                    }
                                    Toast.makeText(getApplicationContext(),error,Toast.LENGTH_SHORT).show();
                                }
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                // the POST parameters:
                params.put("staff_id", staff_id);
                params.put("password", "");
                return params;
            }
        };
        Volley.newRequestQueue(getApplicationContext()).add(postRequest);

    }

public void loadingstaffid(){

    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    staff_id = preferences.getString("staff_id" ,"");

}
}
