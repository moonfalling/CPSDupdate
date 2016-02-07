package com.inno.cpsd.Fragment;

import android.content.Intent;

import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.bluelinelabs.logansquare.LoganSquare;
import com.inno.cpsd.PagePolicy;
import com.inno.cpsd.R;
import com.inno.cpsd.adapter.CpsdGridAdapter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by MoonFalling on 2/2/2559.
 */
public class PageLogin extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_login, container, false);


        return rootView;
    }

    public static PageLogin newInstance(int position){

        PageLogin fragment = new PageLogin();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }


}
