package com.inno.cpsd;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.R.layout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by MoonFalling on 1/2/2559.
 */
public class BaseAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//         try {
//             String urlParameters = "tag=" + URLEncoder.encode("Dota2", "UTF-8");
//             String result = executePost("http://mylive.in.th/api/main",urlParameters);
//             if (checkJson(result)){
//                 // result is json format
//             } else {
//                 // result is plain text / invalid format
//             }
//         } catch (UnsupportedEncodingException e){
//             // Display error on screen
//         }
    }

    public static String executePost(String targetURL, String urlParameters) {

        URL url;

        HttpURLConnection connection = null;
        try {
            //Create connection
            url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length", "" +
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
    }
public static void checkJson(){

}
    public void AlertDialogError(String msg) {
        // dialogCheck.cancel();
        AlertDialog.Builder ad = new AlertDialog.Builder(this); // adb.create();
        ad.setMessage(msg);
        ad.show();
    }
    public boolean checkNetworkConnectivityfunction() {
        // TODO Auto-generated method stub
        ConnectivityManager connMgr = (ConnectivityManager)
                this.getSystemService(Context.CONNECTIVITY_SERVICE);

        final android.net.NetworkInfo wifi =
                connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        final android.net.NetworkInfo mobile =
                connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if( wifi.isConnected() || mobile.isConnected()) {

            return true;

        } else {

            return false;
        }
    }


}
