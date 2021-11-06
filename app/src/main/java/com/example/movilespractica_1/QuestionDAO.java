package com.example.movilespractica_1;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

public interface QuestionDAO {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertButtonCheckBoxQuestions(RadioButtonQuestion question);

    @Query("DELETE FROM RadioButtonQuestion_Table")
    void deleteAllButtonCheckBoxQuestions();

    @Query("DELETE FROM CheckBoxQuestion_Table")
    void deleteAllCheckBoxQuestions();

    @Query("SELECT * FROM RadioButtonQuestion_Table ORDER BY question ASC")
    LiveData<List<RadioButtonQuestion>> getButtonCheckBoxQuestions();
}
