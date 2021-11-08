package com.example.movilespractica_1;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Score_Table")
public class Score {

    @PrimaryKey
    @NonNull
    private int id;

    @NonNull
    private String userName;

    @NonNull
    @ColumnInfo(name = "points")
    private int points;

    public Score(@NonNull String userName, @NonNull int points) {
        id = (int) (Math.random() * 10000);
        this.userName = userName;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
