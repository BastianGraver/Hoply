package com.example.hoply.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hoply.database.Posts;
import com.example.hoply.repository.PostRepository;

import java.util.List;

public class PostViewModel extends AndroidViewModel {
    private PostRepository repository;
    private LiveData<List<Posts>> allPosts;

    public PostViewModel(@NonNull Application application){
        super(application);
        repository = new PostRepository(application);
        allPosts = repository.getAllPosts();
    }

    public void insert(Posts posts){
        repository.insert(posts);
    }
    public LiveData<List<Posts>> getAllPosts(){
        return allPosts;
    }
}
