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
    void insertButtonCheckBoxQuestions(ButtonCheckBoxQuestion question);

    @Query("DELETE FROM Button_CheckBox_Question_Table")
    void deleteAllButtonCheckBoxQuestions();

    @Query("SELECT * FROM Button_CheckBox_Question_Table ORDER BY question ASC")
    LiveData<List<Question>> getButtonCheckBoxQuestions();
}
