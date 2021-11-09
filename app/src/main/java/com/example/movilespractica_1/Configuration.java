package com.example.movilespractica_1;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Configuration_Table")
public class Configuration {

    @NonNull
    private int numQuestionsSelected;

    @PrimaryKey
    @NonNull
    private String userName;

    public Configuration() {
        numQuestionsSelected = 5;
        userName = "Anónimo";
    }

    public int getNumQuestionsSelected() {
        return numQuestionsSelected;
    }

    public void setNumQuestionsSelected(int numQuestionsSelected) {
        this.numQuestionsSelected = numQuestionsSelected;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
