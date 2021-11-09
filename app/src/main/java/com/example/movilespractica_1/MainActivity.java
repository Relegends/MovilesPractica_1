package com.example.movilespractica_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private ConfigurationViewModel configurationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameLogic.GAME.setShownActivity(this);
        configurationViewModel = new ViewModelProvider(this).get(ConfigurationViewModel.class);
    }

    public void play(View view) {
        GameLogic.GAME.setNumMaxQuestions(configurationViewModel.getConfiguration().getNumQuestionsSelected());
        GameLogic.GAME.setUserName(configurationViewModel.getConfiguration().getUserName());
        GameLogic.GAME.changeActivity(this);
    }

    public void options(View view) {
        Intent intent = new Intent(this, ConfigurationActivity.class);
        this.startActivity(intent);
    }

    public void scores(View view) {
        Intent intent = new Intent(this, ClassificationActivity.class);
        this.startActivity(intent);
    }
}