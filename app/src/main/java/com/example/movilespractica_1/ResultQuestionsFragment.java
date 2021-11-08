package com.example.movilespractica_1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


public class ResultQuestionsFragment extends Fragment {

    TextView questions[] = new TextView[5];

    TextView correctAnswersText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View resultQuestionsFragmentView = inflater.inflate(R.layout.fragment_result_questions, container, false);

        questions[0] = resultQuestionsFragmentView.findViewById(R.id.questionMenu1);
        questions[1] = resultQuestionsFragmentView.findViewById(R.id.questionMenu2);
        questions[2] = resultQuestionsFragmentView.findViewById(R.id.questionMenu3);
        questions[3] = resultQuestionsFragmentView.findViewById(R.id.questionMenu4);
        questions[4] = resultQuestionsFragmentView.findViewById(R.id.questionMenu5);

        correctAnswersText = resultQuestionsFragmentView.findViewById(R.id.correctAnswersNumber);
        correctAnswersText.setText("0");

        if (Objects.equals(getActivity().getLocalClassName(), "ResultsActivity")) {
            correctAnswersText.setText(String.valueOf(GameLogic.GAME.getCorrectAnswers()));
            answerQuestions(GameLogic.GAME.getAnswers());
        }

        return resultQuestionsFragmentView;
    }

    public void answerQuestion() {

        int correctAnswers = GameLogic.GAME.getCorrectAnswers();
        int indexQuestion = GameLogic.GAME.getIndexShownQuestion();
        boolean isCorrect = GameLogic.GAME.getAnswer(indexQuestion);

        if (isCorrect) {
            questions[indexQuestion].setBackgroundColor(Color.GREEN);
            correctAnswersText.setText(String.valueOf(correctAnswers));
            Toast.makeText(getActivity(), "CORRECT!", Toast.LENGTH_SHORT).show();
        } else {
            questions[indexQuestion].setBackgroundColor(Color.RED);
            Toast.makeText(getActivity(), "INCORRECT!", Toast.LENGTH_SHORT).show();
        }
    }

    public void answerQuestions(boolean answers[]) {

        for (int i = 0; i < answers.length; i++) {
            if (answers[i]) {
                questions[i].setBackgroundColor(Color.GREEN);
            } else {
                questions[i].setBackgroundColor(Color.RED);
            }
        }
    }


}