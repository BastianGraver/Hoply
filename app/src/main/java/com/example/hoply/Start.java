package com.example.hoply;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void toCreateUser(View view){
        Intent switchActivity = new Intent(this, Create_User.class);
        startActivity(switchActivity);
    }
    public void toLogin(View view){
        Intent switchActivity = new Intent(this, Login.class);
        startActivity(switchActivity);
    }
}