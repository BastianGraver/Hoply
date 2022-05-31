package com.example.hoply;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoply.database.Posts;
import com.example.hoply.viewmodel.PostAdapter;
import com.example.hoply.viewmodel.PostViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.feed);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final PostAdapter adapter= new PostAdapter();
        recyclerView.setAdapter(adapter);

        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.getAllPosts().observe(this, new Observer<List<Posts>>() {
            @Override
            public void onChanged(@NonNull List<Posts> posts) {
                adapter.setPosts(posts);
            }
        });
    }

    public void addPost(View view){
        Posts newpost = new Posts();
        newpost.user_id = "bastian";
        newpost.content = "Main";
        newpost.timestamp = System.currentTimeMillis();
        postViewModel.insert(newpost);
    }
}