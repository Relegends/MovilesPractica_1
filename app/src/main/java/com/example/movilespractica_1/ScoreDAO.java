package com.example.movilespractica_1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ScoreDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertScore(Score score);

    @Query("DELETE FROM Score_Table")
    void deleteAll();

    @Query("SELECT * FROM Score_Table ORDER BY points ASC")
    LiveData<List<Score>> getOrderByPointsScores();
}
