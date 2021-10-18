package com.example.movilespractica_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameLogic.GAME.setShownActivity(this);
    }

    public void play(View view) {
        GameLogic.GAME.changeActivity(this);
    }
}