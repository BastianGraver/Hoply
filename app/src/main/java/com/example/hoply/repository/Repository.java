package com.example.hoply.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.hoply.database.AppDatabase;
import com.example.hoply.database.PostDao;
import com.example.hoply.database.Posts;
import com.example.hoply.database.UserDao;
import com.example.hoply.database.Users;

import java.util.List;

public class Repository {
    private PostDao postDao;
    private UserDao userDao;
    private LiveData<List<Posts>> allPosts;
    private LiveData<List<Users>> allUsers;

    public Repository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        postDao = database.postsDao();
        userDao = database.userDao();
        allPosts = postDao.getAll();
        allUsers = userDao.getAll();
        Log.d("Bastian", "Repo created");
    }

    public void insertPost(Posts post) {
        new InsertPostAsyncTask(postDao).execute(post);
    }

    public LiveData<List<Posts>> getAllPosts() {
        return allPosts;
    }

    public void insertUser(Users user) {
        new InsertUserAsyncTask(userDao).execute(user);
    }

    public LiveData<List<Users>> getAllUsers() {
        return allUsers;
    }

    // inserts a post
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

    // Inserts a user.
    private static class InsertUserAsyncTask extends AsyncTask<Users,Void,Void>{
        private UserDao userDao;

        private InsertUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(Users... users){
            userDao.insert(users[0]);
            return null;
        }
    }

    public List<Users> findLoginUser(String login){
        Log.d("Bastian", "findUserLogin");
        return userDao.findId(login);
    }
}
