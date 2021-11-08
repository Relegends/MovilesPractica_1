package com.example.movilespractica_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ConfigurationViewModel configurationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameLogic.GAME.setShownActivity(this);
    }

    public void play(View view) {
        configurationViewModel = new ViewModelProvider(this).get(ConfigurationViewModel.class);
        Configuration configuration = configurationViewModel.getConfiguration();
        GameLogic.GAME.setNumMaxQuestions(configuration.getNumQuestionsSelected());
        GameLogic.GAME.setUserName(configuration.getUserName());
        GameLogic.GAME.changeActivity(this);
    }

    public void options(View view) {
        Intent intent = new Intent(this, ConfigurationActivity.class);
        this.startActivity(intent);
    }
}