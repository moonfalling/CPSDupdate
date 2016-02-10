package com.inno.cpsd.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.inno.cpsd.PageLoginandRegister;
import com.inno.cpsd.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MoonFalling on 2/2/2559.
 */
public class PageReg extends Fragment {
    String inusername,inpassword,inname,insurname,inmoblie,inemail,inimageproflie,status,info;
    EditText etusername,etpassword,etname,etsurname,etmoblie,etemail;
    Button btreg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_register, container, false);
        etusername = (EditText) rootView.findViewById(R.id.etreguser);
        etpassword = (EditText) rootView.findViewById(R.id.etregpassword);
        etname = (EditText) rootView.findViewById(R.id.etregname);
        etsurname = (EditText) rootView.findViewById(R.id.etreglastname);
        etmoblie = (EditText) rootView.findViewById(R.id.etregtel);
        etemail = (EditText) rootView.findViewById(R.id.etregemail);
        btreg = (Button)rootView.findViewById(R.id.btregsignup);

        btreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etusername.length() == 0 || etpassword.length() == 0
                        || etname.length() == 0|| etsurname.length() == 0|| etmoblie.length() == 0
                        || etemail.length() == 0) {
                    ((PageLoginandRegister) getActivity()).AlertDialogError("Please fill in blank");
                    return;
                } else {
                    inusername = etusername.getText().toString();
                    inpassword = etpassword.getText().toString();
                    inname = etname.getText().toString();
                    insurname = etsurname.getText().toString();
                    inmoblie = etmoblie.getText().toString();
                    inemail = etemail.getText().toString();

                    String url = "http://61.90.233.91/cpsustain/api/createuser.php";

                    StringRequest postRequest = new StringRequest(Request.Method.POST, url,
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

                                                Toast.makeText(getActivity(),info,Toast.LENGTH_SHORT).show();
                                                ((PageLoginandRegister) getActivity()).closepageloginandreg();
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
                            params.put("name", inname);
                            params.put("surname", insurname);
                            params.put("mobile", inmoblie);
                            params.put("email", inemail);
                            params.put("imageprofile", inusername);

                            return params;
                        }
                    };
                    Volley.newRequestQueue(getActivity()).add(postRequest);
                }


            }
        });


        return rootView;
    }
    public static PageReg newInstance(int position){

        PageReg fragment = new PageReg();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }
}
