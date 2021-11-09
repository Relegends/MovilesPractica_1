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
    private final List<SpinnerQuestion> mAllSpinnerQuestions;
    private final List<AnthemQuestion> mAllAnthemQuestions;
    private final List<PictureQuestion> mAllPictureQuestions;
    private final List<FlagsQuestion> mAllFlagsQuestions;

    public QuestionViewModel (Application application) {
        super(application);
        mRepository = new QuestionRepository(application);
        mAllRadioButtonQuestions = mRepository.getAllRadioButtonQuestions();
        mAllCheckBoxQuestions = mRepository.getAllCheckBoxQuestions();
        mAllVideoQuestions = mRepository.getAllVideoQuestions();
        mAllSpinnerQuestions = mRepository.getAllSpinnerQuestions();
        mAllAnthemQuestions = mRepository.getAllAnthemQuestions();
        mAllPictureQuestions = mRepository.getAllPictureQuestions();
        mAllFlagsQuestions = mRepository.getAllFlagsQuestions();
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

    public List<SpinnerQuestion> getAllSpinnerQuestions() {
        return mAllSpinnerQuestions;
    }

    public List<AnthemQuestion> getAllAnthemQuestions() {
        return mAllAnthemQuestions;
    }

    public List<PictureQuestion> getAllPictureQuestions() {
        return mAllPictureQuestions;
    }

    public List<FlagsQuestion> getAllFlagsQuestions() {
        return mAllFlagsQuestions;
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> list = new ArrayList<>();
        list.addAll(mAllRadioButtonQuestions);
        list.addAll(mAllCheckBoxQuestions);
        list.addAll(mAllVideoQuestions);
        list.addAll(mAllSpinnerQuestions);
        list.addAll(mAllAnthemQuestions);
        list.addAll(mAllPictureQuestions);
        list.addAll(mAllFlagsQuestions);
        return list;
    }

    public ArrayList<Question> getMultimediaQuestions() {
        ArrayList<Question> list = new ArrayList<>();
        list.addAll(mAllVideoQuestions);
        list.addAll(mAllAnthemQuestions);
        list.addAll(mAllPictureQuestions);
        list.addAll(mAllFlagsQuestions);
        return list;
    }

    public void insertQuestion(Question question) { mRepository.insertQuestion(question); }
}
