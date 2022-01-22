package com.example.vishal8847844.studentmanagementsystem;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class fragment1 extends Fragment {
View view;
Button b11,b12;
EditText edit11,edit12,edit13;
String s11,s12,s13;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_fragment1, container, false);
        edit11=view.findViewById(R.id.userid1);
        edit12=view.findViewById(R.id.userpass1);
        edit13=view.findViewById(R.id.userphone);
        b11=view.findViewById(R.id.registerbutton);
        b12=view.findViewById(R.id.show_detailsbutton);
        s11=edit11.getText().toString();
        s12=edit12.getText().toString();
        s13=edit13.getText().toString();
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s11=edit11.getText().toString();
                s12=edit12.getText().toString();
                s13=edit13.getText().toString();
                register();
            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Fetch_Activity.class);
                startActivity(i);
            }
        });
        return view;
    }
    public void register(){
        RequestQueue rq= Volley.newRequestQueue(getContext());
        String url="https://studentmanagement4567.000webhostapp.com/info1/register.php";
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(),"Register data",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"Not Register data",Toast.LENGTH_SHORT).show();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hm=new HashMap<>();
                hm.put("u",s11);
                hm.put("p",s12);
                hm.put("m",s13);
                return hm;
            }
        };
        rq.add(sr);

    }
}