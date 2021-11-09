package com.example.movilespractica_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements UserWarning.userWarningDialogInterface {

    private ConfigurationViewModel configurationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameLogic.GAME.setShownActivity(this);
    }

    public void play(View view) throws InterruptedException {


        configurationViewModel = new ViewModelProvider(this).get(ConfigurationViewModel.class);
        Configuration configuration = configurationViewModel.getConfiguration();

        if (!configuration.getUserName().equals("Anónimo")) {
            TimeUnit.SECONDS.sleep(1);
            GameLogic.GAME.setNumMaxQuestions(configuration.getNumQuestionsSelected());
            GameLogic.GAME.setUserName(configuration.getUserName());
            GameLogic.GAME.setGameMode(configuration.getGameMode());
            GameLogic.GAME.resetGameLogic();
            GameLogic.GAME.changeActivity(this);
        } else {
            openUserWarning();
        }
    }

    public void openUserWarning() {
        UserWarning userWarning = new UserWarning();
        userWarning.show(getSupportFragmentManager(), "Aviso");
    }

    @Override
    public void sendAnswerToActivity(boolean answer) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        configurationViewModel = new ViewModelProvider(this).get(ConfigurationViewModel.class);
        Configuration configuration = configurationViewModel.getConfiguration();

        if (answer) {
            GameLogic.GAME.setNumMaxQuestions(configuration.getNumQuestionsSelected());
            GameLogic.GAME.setUserName(configuration.getUserName());
            GameLogic.GAME.setGameMode(configuration.getGameMode());
            GameLogic.GAME.resetGameLogic();
            GameLogic.GAME.changeActivity(this);
        } else {
            Intent intent = new Intent(this, ConfigurationActivity.class);
            this.startActivity(intent);
        }
    }

    public void options(View view) {
        Intent intent = new Intent(this, ConfigurationActivity.class);
        this.startActivity(intent);
    }

    public void scores(View view) {
        Intent intent = new Intent(this, ClassificationActivity.class);
        intent.putExtra("caller", "MainActivity");
        this.startActivity(intent);
    }
}