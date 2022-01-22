package com.example.vishal8847844.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginPage extends AppCompatActivity {
TextInputEditText e1,e2;
MaterialButton b1;
String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        e1=findViewById(R.id.userid);
        e2=findViewById(R.id.userpass);
        b1=findViewById(R.id.loginbutton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                if(s1.contentEquals("admin") && s2.contentEquals("1234")){
                    Intent i=new Intent(LoginPage.this,Coarse.class);
                    startActivity(i);
                    Toast.makeText(LoginPage.this, "Login", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginPage.this, "Not Login", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}