package com.example.movilespractica_1;

public interface FragmentCommunication {

    public void setAnswer(boolean isCorrect, int indexQuestion);

    public boolean getAnswer(int indexQuestion);

    public void nextQuestion();

    public int getIndexShownQuestion();

    public int getCorrectAnswers();

    public void playAgain();
}
