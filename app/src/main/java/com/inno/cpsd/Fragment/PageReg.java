package com.inno.cpsd.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inno.cpsd.R;

/**
 * Created by MoonFalling on 2/2/2559.
 */
public class PageReg extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_register, container, false);


        return rootView;
    }
    public static PageReg newInstance(int position){

        PageReg fragment = new PageReg();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }
}
