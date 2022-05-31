package com.example.hoply.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hoply.database.Users;
import com.example.hoply.repository.Repository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<Users>> allUsers;

    public UserViewModel(@NonNull Application application){
        super(application);
        repository = new Repository(application);
        allUsers = repository.getAllUsers();
    }

    public void insert(Users users){
        repository.insertUser(users);
    }
    public LiveData<List<Users>> getAllUsers(){
        return allUsers;
    }
}
