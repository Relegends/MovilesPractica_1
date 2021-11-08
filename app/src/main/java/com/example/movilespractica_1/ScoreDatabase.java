package com.example.movilespractica_1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Score.class}, version = 1, exportSchema = false)
public abstract class ScoreDatabase extends RoomDatabase {

    public abstract ScoreDAO scoreDAO();

    private static volatile ScoreDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ScoreDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ScoreDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ScoreDatabase.class, "score_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
