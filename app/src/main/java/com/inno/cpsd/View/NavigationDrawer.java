package com.inno.cpsd.View;

/**
 * Created by MoonFalling on 11/2/2559.
 */
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.inno.cpsd.Fragment.PageLogin;
import com.inno.cpsd.Model.NavmenuModel;
import com.inno.cpsd.R;
import com.inno.cpsd.adapter.CpsdNavMenuAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by MoonFalling on 12/9/2558.
 */
public class NavigationDrawer extends Fragment {
    private ImageView headerpicmainmenu;
    private ListView listView;
    private TextView tvusername;
    private String user_name;
    static NavigationDrawer fragment;
    DrawerLayout drawerLayout;
    CpsdNavMenuAdapter mAdapter;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.nav_layout, container, false);


        String[] menuary = {"Profile", "Timeline", "Complain"};
        Integer[] imglist = {R.drawable.navprofile01,R.drawable.navprofile02,R.drawable.navprofile03};
        listView = (ListView)rootView.findViewById(R.id.mainmenu);
        drawerLayout = (DrawerLayout)rootView.findViewById(R.id.drawer_layout);

        CpsdNavMenuAdapter adapter=new CpsdNavMenuAdapter(getActivity(), menuary, imglist);
        listView.setAdapter(adapter);


        return rootView;

    }
    public static NavigationDrawer newInstance(){
        if(fragment == null){
            fragment = new NavigationDrawer();
            return fragment;
        }
        return fragment;
    }

}
