package com.example.vishal8847844.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StudentImges extends AppCompatActivity {
ImageView im1,im2,im3,im4,im5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_imges);

        im1=findViewById(R.id.image1);
        im2=findViewById(R.id.image2);
        im3=findViewById(R.id.image3);
        im4=findViewById(R.id.image4);
        im5=findViewById(R.id.image5);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StudentImges.this,RegisterPage.class);
                i.putExtra("a",R.drawable.student1);
                startActivity(i);
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StudentImges.this,RegisterPage.class);
                i.putExtra("a",R.drawable.student2);
                startActivity(i);
            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StudentImges.this,RegisterPage.class);
                i.putExtra("a",R.drawable.student3);
                startActivity(i);
            }
        });

        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StudentImges.this,RegisterPage.class);
                i.putExtra("a",R.drawable.student4);
                startActivity(i);
            }
        });

        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StudentImges.this,RegisterPage.class);
                i.putExtra("a",R.drawable.student5);
                startActivity(i);
            }
        });
    }
}