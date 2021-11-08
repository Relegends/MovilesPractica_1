package com.example.movilespractica_1;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationViewModel extends AndroidViewModel {
    private ConfigurationRepository mRepository;

    private Configuration configuration;

    public ConfigurationViewModel (Application application) {
        super(application);
        mRepository = new ConfigurationRepository(application);
        configuration = mRepository.getConfiguration();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void insertConfiguration(Configuration configuration) { mRepository.insertConfiguration(configuration); }

    public void deleteConfiguration() { mRepository.deleteConfiguration(); }
}
