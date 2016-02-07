package com.inno.cpsd.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.inno.cpsd.R;

/**
 * Created by MoonFalling on 1/2/2559.
 */
public class CpsdGridAdapter extends BaseAdapter {
    private Context mContext;
    private final String[] web;
    private final int[] Imageid;

    public CpsdGridAdapter(Context c,String[] web,int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_cpsd, null);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
//            imageView.setImageResource(Imageid[position]);
            Picasso.with(mContext)
                    .load(Imageid[position])
                    .into(imageView);
        } else {
            grid = (View) convertView;
        }



        return grid;
    }
}
