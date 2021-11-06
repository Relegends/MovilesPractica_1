package com.example.movilespractica_1;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class QuestionRepository {

    private QuestionDAO questionDAO;
    private LiveData<List<RadioButtonQuestion>> allButtonCheckBoxQuestions;

    QuestionRepository(Application application) {
        QuestionRoomDatabase db = QuestionRoomDatabase.getDatabase(application);
        questionDAO = db.questionDAO();
        allButtonCheckBoxQuestions = questionDAO.getButtonCheckBoxQuestions();
    }

    LiveData<List<RadioButtonQuestion>> getAllButtonCheckBoxQuestions() {
        return allButtonCheckBoxQuestions;
    }

    void insertButtonCheckBoxQuestions(RadioButtonQuestion question) {
        QuestionRoomDatabase.databaseWriteExecutor.execute(() -> {
            questionDAO.insertButtonCheckBoxQuestions(question);
        });
    }
}

