package com.example.hoply;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hoply.database.Posts;
import com.example.hoply.database.Users;
import com.example.hoply.viewmodel.PostViewModel;

public class Create_Post extends AppCompatActivity {
    EditText postInput;
    Users currentUser;
    PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        currentUser = getIntent().getParcelableExtra("user");
        postInput = findViewById(R.id.Post_input_text);

        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

    }
    public void MakePost(View view){
        Posts newPost = new Posts(
                currentUser.id,
                postInput.getText().toString()
        );
        postViewModel.insert(newPost);
        Intent sendPost = new Intent(this, User_page.class);
        sendPost.putExtra("Username", currentUser);
        startActivity(sendPost);
        finish();
    }
}