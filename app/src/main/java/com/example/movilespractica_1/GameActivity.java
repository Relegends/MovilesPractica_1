package com.example.movilespractica_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

public class GameActivity extends AppCompatActivity implements FragmentCommunication {

    boolean answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

    }


    @Override
    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    @Override
    public boolean getAnswer() {
        //((ResultQuestionsFragment)getSupportFragmentManager().findFragmentById(R.id.resultQuestionsFragment))
        return this.answer;
    }
}