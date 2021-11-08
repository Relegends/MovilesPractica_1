package com.example.movilespractica_1;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class QuestionViewModel extends AndroidViewModel {
    private QuestionRepository mRepository;

    private final List<RadioButtonQuestion> mAllRadioButtonQuestions;
    private final List<CheckBoxQuestion> mAllCheckBoxQuestions;
    private final List<VideoQuestion> mAllVideoQuestions;

    public QuestionViewModel (Application application) {
        super(application);
        mRepository = new QuestionRepository(application);
        mAllRadioButtonQuestions = mRepository.getAllRadioButtonQuestions();
        mAllCheckBoxQuestions = mRepository.getAllCheckBoxQuestions();
        mAllVideoQuestions = mRepository.getAllVideoQuestions();
    }

    public List<RadioButtonQuestion> getAllRadioButtonQuestions() {
        return mAllRadioButtonQuestions;
    }

    public List<CheckBoxQuestion> getAllCheckBoxQuestions() {
        return mAllCheckBoxQuestions;
    }

    public List<VideoQuestion> getAllVideoQuestions() {
        return mAllVideoQuestions;
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> list = new ArrayList<>();
        list.addAll(mAllRadioButtonQuestions);
        list.addAll(mAllCheckBoxQuestions);
        list.addAll(mAllVideoQuestions);
        return list;
    }

    public void insertQuestion(Question question) { mRepository.insertQuestion(question); }
}
