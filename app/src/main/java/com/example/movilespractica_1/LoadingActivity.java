package com.example.movilespractica_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LoadingActivity extends AppCompatActivity {

    private ConfigurationViewModel configurationViewModel;
    private QuestionViewModel mQuestionViewModel;
    private ArrayList<Question> mAllQuestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        configurationViewModel = new ViewModelProvider(this).get(ConfigurationViewModel.class);
        mQuestionViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        mAllQuestions = mQuestionViewModel.getAllQuestions();

        try {
            TimeUnit.SECONDS.sleep(3);
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}