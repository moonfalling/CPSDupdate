package com.inno.cpsd.Fragment;

import android.content.Intent;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.bluelinelabs.logansquare.LoganSquare;
import com.inno.cpsd.BaseAcitivity;
import com.inno.cpsd.MainMoblieActivity;
import com.inno.cpsd.Model.LoginModel;
import com.inno.cpsd.PageLoginandRegister;
import com.inno.cpsd.PagePolicy;
import com.inno.cpsd.R;
import com.inno.cpsd.adapter.CpsdGridAdapter;

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
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.inno.cpsd.BaseAcitivity;

/**
 * Created by MoonFalling on 2/2/2559.
 */
public class PageLogin extends Fragment {
    Button btlogin,btcancle;
    EditText etusername,etpassword;
    String inusername,inpassword,staffid,name,surname,username,password,mobile,email,info,status;
    RequestQueue queue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_login, container, false);
        btlogin = (Button)rootView.findViewById(R.id.btloginconfirm);
        btcancle = (Button)rootView.findViewById(R.id.btcancle);
        etusername = (EditText) rootView.findViewById(R.id.etusername);
        etpassword = (EditText) rootView.findViewById(R.id.etpassword);

  btlogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          inusername = etusername.getText().toString();
          inpassword = etpassword.getText().toString();
          if (inusername.length() == 0 || inpassword.length() == 0) {
              ((PageLoginandRegister) getActivity()).AlertDialogError("Please fill in Username or Password");
              return;
          } else {

              String url = "http://61.90.233.91/cpsustain/api/login.php?username="+inusername+"&password="+inpassword;

              StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                      new Response.Listener<String>() {
                          @Override
                          public void onResponse(String response) {
                              try {
                                  JSONObject jsonResponse = new JSONObject(response);
                                  if (jsonResponse.has("info")) {
                                      info = jsonResponse.getString("info");
                                  }
                                  if (jsonResponse.has("status")) {
                                     status = jsonResponse.getString("status");
                                      if(status.equals("OK")){
                                          if (jsonResponse.has("staffid")) {
                                              staffid = jsonResponse.getString("staffid");
                                          }
                                          if (jsonResponse.has("name")) {
                                              name = jsonResponse.getString("name");
                                          }
                                          if (jsonResponse.has("surname")) {
                                              surname = jsonResponse.getString("surname");
                                          }
                                          if (jsonResponse.has("username")) {
                                              username = jsonResponse.getString("username");
                                          }
                                          if (jsonResponse.has("password")) {
                                              password = jsonResponse.getString("password");
                                          }if (jsonResponse.has("mobile")) {
                                              mobile = jsonResponse.getString("mobile");
                                          }
                                          if (jsonResponse.has("email")) {
                                              email = jsonResponse.getString("email");
                                          }


                                          Toast.makeText(getActivity(),info,Toast.LENGTH_SHORT).show();
                                          saveinformation();

                                      }
                                      else{
                                          if(status.equals("Error")){
                                              Toast.makeText(getActivity(),info ,Toast.LENGTH_SHORT).show();

                                          }

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
                  protected Map<String, String> getParams()
                  {
                      Map<String, String>  params = new HashMap<>();
                      // the POST parameters:
                      params.put("username", inusername);
                      params.put("password", inpassword);
                      return params;
                  }
              };
              Volley.newRequestQueue(getActivity()).add(postRequest);
          }


      }
  });

        return rootView;
    }

    public static PageLogin newInstance(int position){

        PageLogin fragment = new PageLogin();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    private void saveinformation(){

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("SHstaffid",staffid);
        editor.putString("SHname", name);
        editor.putString("SHsurname", surname);
        editor.putString("SHusername", username);
        editor.putString("SHpassword",password);
        editor.putString("SHmobile",mobile);
        editor.putString("SHemail",email);
        editor.putString("SHinfo",info);
        editor.putString("SHstatus",status);
        editor.apply();
        ((PageLoginandRegister) getActivity()).closepageloginandreg();

    }


}
