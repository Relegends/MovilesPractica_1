package com.example.movilespractica_1;

import android.app.Activity;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import java.util.Arrays;

public class GameLogic implements FragmentCommunication {

    public static GameLogic GAME = new GameLogic();

    private int indexShownQuestion = 0;

    private int correctAnswers;

    private boolean answers[] = new boolean[5];

    private Activity shownActivity;

    private Fragment shownFragment;


    @Override
    public void setAnswer(boolean isCorrect, int indexQuestion) {
        indexShownQuestion = indexQuestion;
        answers[indexShownQuestion] = isCorrect;
    }

    @Override
    public boolean getAnswer(int indexQuestion) {
        return answers[indexQuestion];
    }

    @Override
    public void nextQuestion() {
        indexShownQuestion++;
        if (indexShownQuestion > 4) {
            changeActivity(shownActivity);
        }
    }

    @Override
    public int getIndexShownQuestion() {
        return indexShownQuestion;
    }

    @Override
    public int getCorrectAnswers() {
        correctAnswers = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i])
                correctAnswers++;
        }
        return correctAnswers;
    }

    @Override
    public void playAgain() {
        resetIndexQuestion();
        changeActivity(shownActivity);
    }


    public void setShownFragment(Fragment shownFragment) {
        this.shownFragment = shownFragment;
    }

    public void setShownActivity(Activity shownActivity) {
        this.shownActivity = shownActivity;
    }


    public void changeActivity(Activity shownActivity) {
        setShownActivity(shownActivity);

        resetIndexQuestion();

        Intent intent;

        switch (shownActivity.getLocalClassName()) {
            case "MainActivity":
                intent = new Intent(shownActivity, GameActivity.class);
                shownActivity.startActivity(intent);
                resetAnswers();
                break;
            case "ResultsActivity":
                intent = new Intent(shownActivity, GameActivity.class);
                shownActivity.startActivity(intent);
                shownActivity.finish();
                break;
            case "GameActivity":
                intent = new Intent(shownActivity, ResultsActivity.class);
                shownActivity.startActivity(intent);
                shownActivity.finish();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + shownActivity.getLocalClassName());
        }

    }

    public boolean[] getAnswers() {
        return answers.clone();
    }

    public void resetIndexQuestion() {
        indexShownQuestion = 0;
    }

    public void resetAnswers() {
        Arrays.fill(answers, false);
    }

}
