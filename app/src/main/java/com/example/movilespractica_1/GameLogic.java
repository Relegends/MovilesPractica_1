package com.example.movilespractica_1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameLogic implements FragmentCommunication {

    public static GameLogic GAME = new GameLogic();

    private int numMaxQuestions;

    private String userName;

    private int points;

    private int indexShownQuestion = 0;
    private int indexQuestionDB[];

    private int correctAnswers;

    private boolean answers[];

    private Activity shownActivity;

    private ArrayList<Question> questionsInGame;

    private String chronoText;


    private List<Integer> generateRandomQuestions() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            numbers.add(i);
        Collections.shuffle(numbers);
        return numbers;
    }

    public void resetIndexQuestionDB() {
        indexQuestionDB = new int[numMaxQuestions];
        List<Integer> randomList = generateRandomQuestions();
        for (int i = 0; i < indexQuestionDB.length; i++) {
            indexQuestionDB[i] = randomList.get(i);
        }
    }

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
        if (indexShownQuestion >= numMaxQuestions) {
            changeActivity(shownActivity);
        }
    }

    @Override
    public int getIndexShownQuestion() {
        return indexShownQuestion;
    }

    public int getNextQuestionDB() {return indexQuestionDB[indexShownQuestion];}


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


    public void setShownActivity(Activity shownActivity) {
        this.shownActivity = shownActivity;
    }


    public void changeActivity(Activity shownActivity) {
        setShownActivity(shownActivity);

        resetIndexQuestion();

        Intent intent;

        switch (shownActivity.getLocalClassName()) {
            case "LoadingActivity":
                intent = new Intent(shownActivity, MainActivity.class);
                GameLogic.GAME.resetGameLogic();
                shownActivity.startActivity(intent);
                resetAnswers();
                shownActivity.finish();
                break;
            case "MainActivity":
                intent = new Intent(shownActivity, GameActivity.class);
                GameLogic.GAME.resetGameLogic();
                shownActivity.startActivity(intent);
                resetAnswers();
                break;
            case "ResultsActivity":
                intent = new Intent(shownActivity, ClassificationActivity.class);
                shownActivity.startActivity(intent);
                shownActivity.finish();
                break;
            case "GameActivity":
                intent = new Intent(shownActivity, ResultsActivity.class);
                shownActivity.startActivity(intent);
                shownActivity.finish();
                break;
            case "ClassificationActivity":
            case "ConfigurationActivity":
                intent = new Intent(shownActivity, GameActivity.class);
                GameLogic.GAME.resetGameLogic();
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
        answers = new boolean[getNumMaxQuestions()];
        Arrays.fill(answers, false);
    }

    public void resetPoints() { points = 0; }

    public int getPoints() {
        return points;
    }

    public void setNumMaxQuestions(int numMaxQuestions) {
        this.numMaxQuestions = numMaxQuestions;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNumMaxQuestions() {
        return numMaxQuestions;
    }

    public void resetGameLogic() {
        resetIndexQuestion();
        resetIndexQuestionDB();
        resetPoints();
        resetAnswers();
        resetQuestionsInGame();
        resetChronoText();
    }

    public int[] getIndexQuestionDB() {
        return indexQuestionDB;
    }

    public void addPoints(QuestionType questionType) {
        switch (questionType) {
            case RADIOBUTTON:
            case SPINNER:
            case CHECKBOX:
                points += 10;
                break;
            case PICTURE:
            case FLAGS:
                points += 25;
                break;
            case VIDEO:
                points += 50;
                break;
            case ANTHEM:
                points += 100;
                break;
        }
    }

    public void addPoints(int progress) {
        int multiplier = 100 - progress;
        points *= multiplier;
    }

    public void resetQuestionsInGame() {
        questionsInGame = new ArrayList<>();
    }

    public void addQuestionInGame(Question q) {
        questionsInGame.add(q);
    }

    public ArrayList<Question> getQuestionsInGame() {
        questionsInGame.remove(questionsInGame.size()-1);
        return questionsInGame;
    }

    public void setChronoText(String chronoText) {
        this.chronoText = chronoText;
    }

    public String getChronoText() {
        return chronoText;
    }

    public void resetChronoText() {
        chronoText = "";
    }
}
