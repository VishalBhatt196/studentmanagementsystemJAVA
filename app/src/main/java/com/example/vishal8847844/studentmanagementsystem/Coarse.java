package com.example.vishal8847844.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class Coarse extends AppCompatActivity {
ImageView img;
ListView listView;
String name[]={"BCA","MCA","B.TECH"};
Integer image[]={R.drawable.hcl1,R.drawable.hcl2,R.drawable.hcl3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coarse);
        img=findViewById(R.id.image2);
        listView=findViewById(R.id.list1);
        Custome1 cs=new Custome1(Coarse.this,name,image);
        listView.setAdapter(cs);
        img.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable) img.getBackground()).start();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent i=new Intent(Coarse.this,StudentImges.class);
                        startActivity(i);
                        break;

                    case 1:
                        Intent i1=new Intent(Coarse.this,StudentImges.class);
                        startActivity(i1);
                        break;

                    case 2:
                        Intent i2=new Intent(Coarse.this,StudentImges.class);
                        startActivity(i2);
                        break;
                }

            }
        });
    }
}