package com.example.hoply.database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
 /*(foreignKeys = {@ForeignKey(entity = Users.class,
        parentColumns = "id",
        childColumns = "user_id",
        onDelete = ForeignKey.CASCADE)
})*/
@Entity  (foreignKeys = {@ForeignKey(entity = Users.class,
        parentColumns = "id",
        childColumns = "user_id",
        onDelete = ForeignKey.CASCADE)
})
public class Posts implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "user_id", index = true)
    public String user_id;

    @ColumnInfo(name = "content")
    public String content;

    @ColumnInfo(name = "timestamp")
    public long timestamp;

     public Posts(String user_id, String content) {
         this.user_id = user_id;
         this.content = content;
         timestamp = System.currentTimeMillis();
     }

     protected Posts(Parcel in) {
         id = in.readInt();
         user_id = in.readString();
         content = in.readString();
         timestamp = in.readLong();
     }

     public static final Creator<Posts> CREATOR = new Creator<Posts>() {
         @Override
         public Posts createFromParcel(Parcel in) {
             return new Posts(in);
         }

         @Override
         public Posts[] newArray(int size) {
             return new Posts[size];
         }
     };

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel parcel, int i) {
         parcel.writeInt(id);
         parcel.writeString(user_id);
         parcel.writeString(content);
         parcel.writeLong(timestamp);
     }
 }
