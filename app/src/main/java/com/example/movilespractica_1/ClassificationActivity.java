package com.example.movilespractica_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClassificationActivity extends AppCompatActivity {

    private ScoreViewModel mScoreViewModel;
    private Button replayButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasification);
        GameLogic.GAME.setShownActivity(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewScores);
        final ScoreListAdapter adapter = new ScoreListAdapter(new ScoreListAdapter.ScoreDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mScoreViewModel = new ViewModelProvider(this).get(ScoreViewModel.class);

        mScoreViewModel.getAllScores().observe(this, scores -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(scores);
        });
        replayButton = findViewById(R.id.replayButton);

        String caller = getIntent().getStringExtra("caller");

        if (caller.equals("MainActivity"))
            replayButton.setVisibility(View.GONE);
        else
            replayButton.setVisibility(View.VISIBLE);
    }

    public void replay(View view) {
        GameLogic.GAME.resetGameLogic();
        GameLogic.GAME.changeActivity(this);
    }
}
