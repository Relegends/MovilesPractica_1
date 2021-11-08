package com.example.movilespractica_1;

import android.app.Application;

import java.util.List;

public class ConfigurationRepository {

    private ConfigurationDAO configurationDAO;

    private Configuration configuration;

    ConfigurationRepository(Application application) {
        ConfigurationDatabase db = ConfigurationDatabase.getDatabase(application);
        configurationDAO = db.configurationDAO();
        configuration = configurationDAO.getConfiguration();
    }

    Configuration getConfiguration() {
        return configuration;
    }

    void insertConfiguration(Configuration configuration) {
        ConfigurationDatabase.databaseWriteExecutor.execute(() -> {
            configurationDAO.insertConfiguration(configuration);
        });
    }

    void deleteConfiguration() {
        ConfigurationDatabase.databaseWriteExecutor.execute(() -> {
            configurationDAO.deleteAllConfiguration();
        });
    }
}
