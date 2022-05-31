package com.example.hoply;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.hoply.database.Users;
import com.example.hoply.viewmodel.LoginViewModel;

import java.util.List;

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
        List<Users> currentUser = loginViewModel.getLoginUser(login.getText().toString());
        if (currentUser.size() == 1){
            Intent switchActivity = new Intent(this, User_page.class);
            switchActivity.putExtra("Username", currentUser.get(0));
            startActivity(switchActivity);
        }
    }
}