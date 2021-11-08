package com.example.movilespractica_1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ConfigurationDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertConfiguration(Configuration configuration);

    @Query("DELETE FROM Configuration_Table")
    void deleteAllConfiguration();

    @Query("SELECT * FROM Configuration_Table")
    Configuration getConfiguration();
}
