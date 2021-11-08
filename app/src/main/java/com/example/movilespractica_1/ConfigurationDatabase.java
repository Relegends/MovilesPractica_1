package com.example.movilespractica_1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Configuration.class}, version = 1, exportSchema = false)

public abstract class ConfigurationDatabase extends RoomDatabase {

    public abstract ConfigurationDAO configurationDAO();

    private static volatile ConfigurationDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ConfigurationDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (QuestionRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ConfigurationDatabase.class, "configuration_database")
                            .addCallback(ConfigurationDatabaseCallback)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        INSTANCE.getOpenHelper().getWritableDatabase();
        return INSTANCE;
    }

    private static RoomDatabase.Callback ConfigurationDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                ConfigurationDAO dao = INSTANCE.configurationDAO();

                dao.deleteAllConfiguration();

                Configuration configuration = new Configuration();
                dao.insertConfiguration(configuration);

            });
        }
    };
}
