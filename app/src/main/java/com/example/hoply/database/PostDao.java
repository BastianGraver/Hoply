package com.example.hoply.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PostDao {
    @Query("SELECT * FROM Posts")
    LiveData<List<Posts>> getAll();

    @Query("SELECT * FROM Posts where id = :input")
    LiveData<List<Posts>> findId(String input);

    @Query("DELETE FROM Posts")
    public void nukeTable();

    @Insert
    void insert(Posts post);

    @Delete
    void delete(Posts post);
}
