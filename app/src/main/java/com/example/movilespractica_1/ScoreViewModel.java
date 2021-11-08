package com.example.movilespractica_1;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ScoreViewModel extends AndroidViewModel {

    private ScoreRepository mRepository;

    private final LiveData<List<Score>> mAllScores;

    public ScoreViewModel (Application application) {
        super(application);
        mRepository = new ScoreRepository(application);
        mAllScores = mRepository.getAllScores();
    }

    LiveData<List<Score>> getAllScores() { return mAllScores; }

    public void insertScore(Score score) { mRepository.insertScore(score); }
}
