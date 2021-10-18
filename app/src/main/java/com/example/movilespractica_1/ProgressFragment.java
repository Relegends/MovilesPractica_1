package com.example.movilespractica_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class ProgressFragment extends Fragment {

    ProgressBar progressBar;
    CountDownTimer countDownTimer;
    int progress = 0;
    int maxTime = 60 * 1000;

    Button nextQuestionButton;

    TextView questionNumber, questionText;

    // Question 1
    RadioButton radioButtonCorrect;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View progressFragmentView = inflater.inflate(R.layout.fragment_progress, container, false);

        questionNumber = (TextView) progressFragmentView.findViewById(R.id.numberQuestion);
        questionText = (TextView) progressFragmentView.findViewById(R.id.text_question);

        progressBar = progressFragmentView.findViewById(R.id.progressBar);
        countDownEvent();

        radioButtonCorrect = (RadioButton) progressFragmentView.findViewById(R.id.radioButtonCorrect);

        nextQuestionButton = (Button) progressFragmentView.findViewById(R.id.skipQuestion);
        nextQuestion();

        return progressFragmentView;
    }

    public void nextQuestion() {
        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                GameLogic.GAME.nextQuestion();
                loadNextQuestion();
            }
        });
    }

    private void loadNextQuestion() {
        switch (GameLogic.GAME.getIndexShownQuestion()) {
            case 1:
                questionNumber.setText("Question 2");
                questionText.setText("¿Cuáles de estos países están en la UE?");
                break;
            case 2:
                questionNumber.setText("Question 3");
                questionText.setText("¿Qué país es este?");
                break;
            case 3:
                questionNumber.setText("Question 4");
                questionText.setText("Seleccione el país más pequeño del mundo:");
                break;
            case 4:
                questionNumber.setText("Question 5");
                questionText.setText("¿En qué continente se encuentra Yemen?");
                break;
        }
    }

    private void checkAnswer() {
        int indexQuestion = GameLogic.GAME.getIndexShownQuestion();

        switch (indexQuestion) {
            case 0:
                if (radioButtonCorrect.isChecked())
                    GameLogic.GAME.setAnswer(true, indexQuestion);
                break;
        }
        ((ResultQuestionsFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.resultQuestionsFragment)).answerQuestion();

    }

    private void countDownEvent() {
        progressBar.setProgress(progress);
        countDownTimer = new CountDownTimer(maxTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progress++;
                progressBar.setProgress(progress * 100 / (maxTime / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(getActivity(), "TIME OUT!", Toast.LENGTH_SHORT).show();
                GameLogic.GAME.changeActivity(getActivity());
            }
        }.start();
    }
}