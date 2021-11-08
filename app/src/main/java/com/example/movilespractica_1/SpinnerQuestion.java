package com.example.movilespractica_1;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "SpinnerQuestion_Table")
public class SpinnerQuestion {

    @NonNull
    private String option1, option2, option3, option4;
}
