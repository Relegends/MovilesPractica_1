package com.example.movilespractica_1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertRadioButtonQuestion(RadioButtonQuestion question);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCheckBoxQuestion(CheckBoxQuestion question);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertVideoQuestion(VideoQuestion question);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertQuestion(Question question);

    @Query("DELETE FROM RadioButtonQuestion_Table")
    void deleteAllRadioButtonQuestions();

    @Query("DELETE FROM CheckBoxQuestion_Table")
    void deleteAllCheckBoxQuestions();

    @Query("DELETE FROM VideoQuestion_Table")
    void deleteAllVideoQuestions();

    @Query("DELETE FROM Question_Table")
    void deleteAllQuestions();

    @Query("SELECT * FROM RadioButtonQuestion_Table")
    List<RadioButtonQuestion> getRadioButtonQuestions();

    @Query("SELECT * FROM CheckBoxQuestion_Table")
    List<CheckBoxQuestion> getCheckBoxQuestions();

    @Query("SELECT * FROM VideoQuestion_Table")
    List<VideoQuestion> getVideoQuestions();

    @Query("SELECT * FROM Question_Table")
    List<Question> getQuestions();
}
