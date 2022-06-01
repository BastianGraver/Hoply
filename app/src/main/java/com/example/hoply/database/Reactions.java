package com.example.hoply.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity (foreignKeys = {@ForeignKey(entity = Users.class,
        parentColumns = "id",
        childColumns = "user_id",
        onDelete = ForeignKey.CASCADE),

        @ForeignKey(entity = Posts.class,
        parentColumns = "id",
        childColumns ="post_id",
        onDelete = ForeignKey.CASCADE)})

public class Reactions {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user_id", index = true)
    public String user_id;

    @PrimaryKey
    @ColumnInfo(name = "post_id", index = true)
    public int post_id;

    @ColumnInfo(name = "type")
    public int type;

    @PrimaryKey
    @ColumnInfo(name = "timestamp")
    public long timestamp;

    public Reactions(@NonNull String user_id, int post_id, int type, long timestamp) {
        this.user_id = user_id;
        this.post_id = post_id;
        this.type = type;
        this.timestamp = System.currentTimeMillis();
    }
}
