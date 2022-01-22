package com.example.vishal8847844.studentmanagementsystem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Fetch_Activity extends AppCompatActivity {
EditText edit21,edit22,edit23;
Button b21,b22,b23;
String s21,s22,s23,s91,s92;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);
        edit21=findViewById(R.id.userid2);
        edit22=findViewById(R.id.userpass2);
        edit23=findViewById(R.id.userphone2);

        b21=findViewById(R.id.fetch_button);
        b22=findViewById(R.id.updatebutton);
        b23=findViewById(R.id.deletebutton);

        s21=edit21.getText().toString();
        s22=edit22.getText().toString();
        s23=edit23.getText().toString();

        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s21=edit21.getText().toString();
                fetch();
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s21=edit21.getText().toString();
                s22=edit22.getText().toString();
                s23=edit23.getText().toString();
                update();
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s21=edit21.getText().toString();
                delete();
            }
        });
    }
    public  void fetch(){
        RequestQueue rq= Volley.newRequestQueue(Fetch_Activity.this);
        StringRequest sr=new StringRequest(Config.DATA_URL + s21, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONFETCH(response);
                Toast.makeText(Fetch_Activity.this, "fetch data", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Fetch_Activity.this, "Not fetch", Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(sr);
    }
    public void JSONFETCH(String response){
        try {
            JSONObject jb = new JSONObject(response);
            JSONArray jr = jb.getJSONArray(Config.DATA_RESULT);
            JSONObject jb1 = jr.getJSONObject(0);
            s91 = jb1.getString(Config.DATA_PASS);
            s92 = jb1.getString(Config.DATA_MOBILE);
        }catch (JSONException e){

        }
        edit22.setText(s91);
        edit23.setText(s92);
    }
    public void update(){
        RequestQueue rq=Volley.newRequestQueue(Fetch_Activity.this);
        String url="https://studentmanagement4567.000webhostapp.com/info1/update.php";
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Fetch_Activity.this, "update", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Fetch_Activity.this, "Not update", Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hm=new HashMap<>();
                hm.put("u",s21);
                hm.put("p",s22);
                hm.put("m",s23);
                return hm;
            }
        };
        rq.add(sr);
    }
    public void delete(){
        RequestQueue rq=Volley.newRequestQueue(Fetch_Activity.this);
        String url="https://studentmanagement4567.000webhostapp.com/info1/delete.php";
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Fetch_Activity.this, "delete", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Fetch_Activity.this, "Not delete", Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hm=new HashMap<>();
                hm.put("u",s21);
                return hm;
            }
        };
        rq.add(sr);
    }
}