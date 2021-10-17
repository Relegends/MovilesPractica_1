package com.example.movilespractica_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        fragment = new Fragment();
        loadFragment(fragment);
    }

    private void loadFragment(Fragment fragment) {

    }


}