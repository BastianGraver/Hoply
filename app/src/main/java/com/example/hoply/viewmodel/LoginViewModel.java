package com.example.hoply.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.hoply.database.Users;
import com.example.hoply.repository.Repository;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {
    private Repository repository;

    public LoginViewModel(@NonNull Application application){
        super(application);
        repository = new Repository(application);
    }

    public List<Users> getLoginUser(String login){
        Log.d("Bastian", "Login");
        return repository.findLoginUser(login);
    }
}
