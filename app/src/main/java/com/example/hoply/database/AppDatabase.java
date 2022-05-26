package com.example.hoply.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

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
                    .enableMultiInstanceInvalidation()
                    .build();
        }
        return instance;
    }
}
