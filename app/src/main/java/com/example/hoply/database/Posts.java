package com.example.hoply.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Users.class,
        parentColumns = "id",
        childColumns = "user_id",
        onDelete = ForeignKey.CASCADE)
})

public class Posts {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "user_id", index = true)
    public String user_id;

    @ColumnInfo(name = "content")
    public String content;

    @ColumnInfo(name = "timestamp")
    public long timestamp;

}
