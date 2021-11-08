package com.example.movilespractica_1;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ScoreRepository {

    private ScoreDAO mScoreDao;
    private LiveData<List<Score>> mAllScores;


    ScoreRepository(Application application) {
        ScoreDatabase db = ScoreDatabase.getDatabase(application);
        mScoreDao = db.scoreDAO();
        mAllScores = mScoreDao.getOrderByPointsScores();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Score>> getAllScores() {
        return mAllScores;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insertScore(Score score) {
        ScoreDatabase.databaseWriteExecutor.execute(() -> {
            mScoreDao.insertScore(score);
        });
    }
}
