package com.inno.cpsd.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.inno.cpsd.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MoonFalling on 11/2/2559.
 */
public class CpsdNavMenuAdapter extends BaseAdapter {
    String[] menulist = new String[]{"Profile", "Timeline", "Complain"};
    int[] imglist = new int[] {R.drawable.navprofile01,R.drawable.navprofile02,R.drawable.navprofile03};


    private LayoutInflater mInflater;
    private List<Content> mPosts;
    private ViewHolder mViewHolder;

    private Bitmap mBitmap;
    private Content mPost;
    private Activity mActivity;

    public CpsdNavMenuAdapter(Activity activity, List<Content> posts) {
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mPosts = posts;
        mActivity = activity;
    }



    @Override
    public int getCount() {
        return mPosts.size();
    }

    @Override
    public Object getItem(int position) {
        return mPosts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.nav_custom_lv, parent, false);
            mViewHolder = new ViewHolder();
            mViewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.navmenuicon);
            mViewHolder.title = (TextView) convertView.findViewById(R.id.navmenuname);



            convertView.setTag(mViewHolder);

        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }


        mPost = mPosts.get(position);

        Picasso.with(mActivity)
                .load(imglist.)
                .into(mViewHolder.thumbnail);

        mViewHolder.title.setText(mPost.getNews_head_title());


        return convertView;
    }

    private static class ViewHolder {
        ImageView thumbnail;
        TextView title;


    }

}
