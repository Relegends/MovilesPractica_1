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
    void insertSpinnerQuestion(SpinnerQuestion question);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAnthemQuestion(AnthemQuestion question);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPictureQuestion(PictureQuestion question);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFlagsQuestion(FlagsQuestion question);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertQuestion(Question question);

    @Query("DELETE FROM RadioButtonQuestion_Table")
    void deleteAllRadioButtonQuestions();

    @Query("DELETE FROM CheckBoxQuestion_Table")
    void deleteAllCheckBoxQuestions();

    @Query("DELETE FROM VideoQuestion_Table")
    void deleteAllVideoQuestions();

    @Query("DELETE FROM SpinnerQuestion_Table")
    void deleteAllSpinnerQuestions();

    @Query("DELETE FROM AnthemQuestion_Table")
    void deleteAllAnthemQuestions();

    @Query("DELETE FROM PictureQuestion_Table")
    void deleteAllPictureQuestions();

    @Query("DELETE FROM FlagsQuestion_Table")
    void deleteAllFlagsQuestions();

    @Query("DELETE FROM Question_Table")
    void deleteAllQuestions();

    @Query("SELECT * FROM RadioButtonQuestion_Table")
    List<RadioButtonQuestion> getRadioButtonQuestions();

    @Query("SELECT * FROM CheckBoxQuestion_Table")
    List<CheckBoxQuestion> getCheckBoxQuestions();

    @Query("SELECT * FROM VideoQuestion_Table")
    List<VideoQuestion> getVideoQuestions();

    @Query("SELECT * FROM SpinnerQuestion_Table")
    List<SpinnerQuestion> getSpinnerQuestions();

    @Query("SELECT * FROM AnthemQuestion_Table")
    List<AnthemQuestion> getAnthemQuestions();

    @Query("SELECT * FROM PictureQuestion_Table")
    List<PictureQuestion> getPictureQuestions();

    @Query("SELECT * FROM FlagsQuestion_Table")
    List<FlagsQuestion> getFlagsQuestions();

    @Query("SELECT * FROM Question_Table")
    List<Question> getQuestions();
}
