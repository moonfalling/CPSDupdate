package com.inno.cpsd.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import com.inno.cpsd.PageComplain;
import com.inno.cpsd.PageListPage;
import com.inno.cpsd.PageLoginandRegister;
import com.inno.cpsd.PagePolicy;
import com.inno.cpsd.PageTimeline;
import com.inno.cpsd.R;
import com.inno.cpsd.adapter.CpsdGridAdapter;

/**
 * Created by MoonFalling on 1/2/2559.
 */
public class PageCPSD extends android.support.v4.app.Fragment {
    GridView gridcategory;
    Spinner spcpandtrue;
    TextView tvpolicy,tvloginname;
    Button btcomplain,bttimeline;
    int[] imageId = {
            R.drawable.esdgicons01,
            R.drawable.esdgicons02,
            R.drawable.esdgicons03,
            R.drawable.esdgicons04,
            R.drawable.esdgicons05,
            R.drawable.esdgicons06,
            R.drawable.esdgicons07,
            R.drawable.esdgicons08,
            R.drawable.esdgicons09,
            R.drawable.esdgicons10,
            R.drawable.esdgicons11,
            R.drawable.esdgicons12,
            R.drawable.esdgicons13,
            R.drawable.esdgicons14,
            R.drawable.esdgicons15,
            R.drawable.esdgicons16,
            R.drawable.esdgicons17
    };
    String[] web = {
            "No Poverty",
            "Zero Hunger",
            "Good Health And Well-Being",
            "Quility Education",
            "Gender Equality",
            "Clean Water And Sanitation",
            "Affordable and Clean Enegy",
            "Decent Work and Economic Growth",
            "Industry,Innovation and Infrastructure",
            "Reduce Inequalities",
            "Sustainable Cities and Communities",
            "Responsible Comsumption and Production",
            "Climate Action",
            "Life Below Water",
            "Life on Land",
            "Peace,Justice and Strong Institutuions",
            "Partnerships for the Goals"
    } ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.page_cpsd_main, container, false);
        CpsdGridAdapter adapter = new CpsdGridAdapter(PageCPSD.this.getActivity(), web, imageId);
        gridcategory=(GridView)rootView.findViewById(R.id.cpsdmaincategory);
        gridcategory.setAdapter(adapter);
        spcpandtrue =(Spinner)rootView.findViewById(R.id.spcpandtrue);
        tvloginname=(TextView)rootView.findViewById(R.id.tvloginname);
        tvpolicy =(TextView)rootView.findViewById(R.id.tvpolicy);

        btcomplain = (Button)rootView.findViewById(R.id.btcomplain);
        bttimeline = (Button)rootView.findViewById(R.id.bttimeline);
        final String[] spcategory = getResources().getStringArray(R.array.spcptrue);
        final ArrayAdapter<String> infosp = new ArrayAdapter<String>(getContext(),android.R.layout.simple_dropdown_item_1line,spcategory);
        spcpandtrue.setAdapter(infosp);

        tvpolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(getActivity(), PagePolicy.class);
                startActivity(newActivity);
            }
        });

        btcomplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(getContext(),PageComplain.class);
                startActivity(newActivity);
            }
        });
        bttimeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(getContext(),PageTimeline.class);
                startActivity(newActivity);
            }
        });
       gridcategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch (position){
                   default:Intent newActivity = new Intent(getContext(),PageListPage.class);
                       startActivity(newActivity);
               }
           }
       });
        return rootView;
    }
    public static PageCPSD newInstance(int position){

        PageCPSD fragment = new PageCPSD();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

}


