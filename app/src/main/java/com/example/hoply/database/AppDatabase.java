package com.example.hoply.database;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Users.class, Posts.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract UserDao userDao();
    public abstract PostDao postsDao();

    public static synchronized AppDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,"App Database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .allowMainThreadQueries()
                    .build();
            Log.d("Bastian", "db build");
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            Log.d("Bastian", "callback");
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private PostDao postDao;

        private PopulateDbAsyncTask(AppDatabase db) {
            postDao = db.postsDao();
            Log.d("Bastian", "Task");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.d("Bastian", "Fallback");
            Posts post = new Posts();
            post.timestamp = System.currentTimeMillis();
            post.content = "Hey Bastian";
            post.user_id = "Bastian";
            postDao.insert(post);
            return null;
        }
    }
}
