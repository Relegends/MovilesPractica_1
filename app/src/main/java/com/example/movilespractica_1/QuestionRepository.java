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
    private List<SpinnerQuestion> allSpinnerQuestions;
    private List<AnthemQuestion> allAnthemQuestions;
    private List<PictureQuestion> allPictureQuestions;
    private List<FlagsQuestion> allFlagsQuestions;

    QuestionRepository(Application application) {
        QuestionRoomDatabase db = QuestionRoomDatabase.getDatabase(application);
        questionDAO = db.questionDAO();
        allRadioButtonQuestions = questionDAO.getRadioButtonQuestions();
        allCheckBoxQuestions = questionDAO.getCheckBoxQuestions();
        allVideoQuestions = questionDAO.getVideoQuestions();
        allSpinnerQuestions = questionDAO.getSpinnerQuestions();
        allAnthemQuestions = questionDAO.getAnthemQuestions();
        allPictureQuestions = questionDAO.getPictureQuestions();
        allFlagsQuestions = questionDAO.getFlagsQuestions();
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

    List<SpinnerQuestion> getAllSpinnerQuestions() {
        return allSpinnerQuestions;
    }

    public List<AnthemQuestion> getAllAnthemQuestions() {
        return allAnthemQuestions;
    }

    public List<PictureQuestion> getAllPictureQuestions() {
        return allPictureQuestions;
    }

    public List<FlagsQuestion> getAllFlagsQuestions() {
        return allFlagsQuestions;
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

    void insertSpinnerQuestion(SpinnerQuestion question) {
        QuestionRoomDatabase.databaseWriteExecutor.execute(() -> {
            questionDAO.insertSpinnerQuestion(question);
        });
    }

    void insertAnthemQuestion(AnthemQuestion question) {
        QuestionRoomDatabase.databaseWriteExecutor.execute(() -> {
            questionDAO.insertAnthemQuestion(question);
        });
    }

    void insertPictureQuestion(PictureQuestion question) {
        QuestionRoomDatabase.databaseWriteExecutor.execute(() -> {
            questionDAO.insertPictureQuestion(question);
        });
    }

    void insertFlagsQuestion(FlagsQuestion question) {
        QuestionRoomDatabase.databaseWriteExecutor.execute(() -> {
            questionDAO.insertFlagsQuestion(question);
        });
    }

    void insertQuestion(Question question) {
        QuestionRoomDatabase.databaseWriteExecutor.execute(() -> {
            questionDAO.insertQuestion(question);
        });
    }
}

