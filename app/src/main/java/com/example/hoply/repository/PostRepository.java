package com.example.hoply.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.hoply.database.AppDatabase;
import com.example.hoply.database.PostDao;
import com.example.hoply.database.Posts;

import java.util.List;

public class PostRepository {
    private PostDao postDao;
    private LiveData<List<Posts>> allPosts;

    public PostRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        postDao = database.postsDao();
        allPosts = postDao.getAll();
    }

    public void insert(Posts post) {
        new InsertPostAsyncTask(postDao).execute(post);
    }

    public LiveData<List<Posts>> getAllPosts() {
        return allPosts;
    }

    private static class InsertPostAsyncTask extends AsyncTask<Posts,Void,Void>{
        private PostDao postDao;

        private InsertPostAsyncTask(PostDao postDao){
            this.postDao = postDao;
        }

        @Override
        protected Void doInBackground(Posts... post){
            postDao.insert(post[0]);
            return null;
        }
    }
}
