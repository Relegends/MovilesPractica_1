package com.example.movilespractica_1;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuestionRepository {

    private QuestionDAO questionDAO;

    private LiveData<List<Question>> allQuestions;

    private List<RadioButtonQuestion> allRadioButtonQuestions;
    private List<CheckBoxQuestion> allCheckBoxQuestions;
    private List<VideoQuestion> allVideoQuestions;

    QuestionRepository(Application application) {
        QuestionRoomDatabase db = QuestionRoomDatabase.getDatabase(application);
        questionDAO = db.questionDAO();
        allRadioButtonQuestions = questionDAO.getRadioButtonQuestions();
        allCheckBoxQuestions = questionDAO.getCheckBoxQuestions();
        allVideoQuestions = questionDAO.getVideoQuestions();
    }

    List<RadioButtonQuestion> getAllRadioButtonQuestions() {
        return allRadioButtonQuestions;
    }

    List<CheckBoxQuestion> getAllCheckBoxQuestions() {
        return allCheckBoxQuestions;
    }

    List<VideoQuestion> getAllVideoQuestions() {
        return allVideoQuestions;
    }


    void insertRadioButtonQuestion(RadioButtonQuestion question) {
        QuestionRoomDatabase.databaseWriteExecutor.execute(() -> {
            questionDAO.insertRadioButtonQuestion(question);
        });
    }

    void insertCheckBoxQuestion(CheckBoxQuestion question) {
        QuestionRoomDatabase.databaseWriteExecutor.execute(() -> {
            questionDAO.insertCheckBoxQuestion(question);
        });
    }

    void insertVideoQuestion(VideoQuestion question) {
        QuestionRoomDatabase.databaseWriteExecutor.execute(() -> {
            questionDAO.insertVideoQuestion(question);
        });
    }

    void insertQuestion(Question question) {
        QuestionRoomDatabase.databaseWriteExecutor.execute(() -> {
            questionDAO.insertQuestion(question);
        });
    }
}

