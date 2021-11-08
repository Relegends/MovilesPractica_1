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
    private Configuration configuration;

    @NonNull
    @ColumnInfo(name = "points")
    private int points;

    public Score(@NonNull Configuration configuration, @NonNull int points) {
        id = (int) (Math.random() * 10000);
        this.configuration = configuration;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(@NonNull Configuration configuration) {
        this.configuration = configuration;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
