package com.inno.cpsd.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.inno.cpsd.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MoonFalling on 11/2/2559.
 */
public class CpsdNavMenuAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public CpsdNavMenuAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.nav_layout, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {


        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.nav_custom_lv, parent,false);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.navmenuname);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.navmenuicon);


        txtTitle.setText(itemname[position]);
        Picasso.with(context)
                .load(imgid[position])
                .into(imageView);



        return rowView;

    };
}