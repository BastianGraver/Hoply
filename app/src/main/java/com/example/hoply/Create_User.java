package com.example.hoply;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.hoply.database.Users;
import com.example.hoply.viewmodel.UserViewModel;

public class Create_User extends AppCompatActivity {
    private UserViewModel userViewModel;
    private EditText username_input;
    private EditText name_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        username_input = findViewById(R.id.Username_Input);
        name_input = findViewById(R.id.Name_Input);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }

    public void addUser(View view){
        Users newUser = new Users(username_input.getText().toString(), name_input.getText().toString());
        userViewModel.insert(newUser);
        Intent switchActivity = new Intent(this, Start.class);
        startActivity(switchActivity);
    }
}