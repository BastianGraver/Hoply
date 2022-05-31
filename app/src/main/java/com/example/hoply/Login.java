package com.example.hoply;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.hoply.viewmodel.LoginViewModel;

public class Login extends AppCompatActivity {
    EditText login;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.Username_Login);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }

    public void login(View view){
        if (loginViewModel.getLoginUser(login.getText().toString()).size() == 1){
            Intent switchActivity = new Intent(this, MainActivity.class);
            startActivity(switchActivity);
        }
    }
}