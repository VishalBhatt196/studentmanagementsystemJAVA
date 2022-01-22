package com.example.vishal8847844.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RegisterPage extends AppCompatActivity {
ImageView im10;
Button clicks;
FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        im10=findViewById(R.id.image10);
        clicks=findViewById(R.id.add);

        Bundle extras = getIntent().getExtras();
        int std=extras.getInt("a");
        im10.setImageResource(std);

        fm=getSupportFragmentManager();

        clicks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.frame,new fragment1()).commit();

            }
        });
    }
}