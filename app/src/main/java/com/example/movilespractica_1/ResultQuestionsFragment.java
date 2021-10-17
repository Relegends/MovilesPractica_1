package com.example.movilespractica_1;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class ResultQuestionsFragment extends Fragment {

    TextView question1, question2, question3, question4, question5;

    TextView correctAnswersText;
    int correctAnswers = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View resultQuestionsFragmentView = inflater.inflate(R.layout.fragment_result_questions, container, false);

        question1 = resultQuestionsFragmentView.findViewById(R.id.questionMenu1);
        question2 = resultQuestionsFragmentView.findViewById(R.id.questionMenu2);
        question3 = resultQuestionsFragmentView.findViewById(R.id.questionMenu3);
        question4 = resultQuestionsFragmentView.findViewById(R.id.questionMenu4);
        question5 = resultQuestionsFragmentView.findViewById(R.id.questionMenu5);

        correctAnswersText = resultQuestionsFragmentView.findViewById(R.id.correctAnswersNumber);
        correctAnswersText.setText("0");

        return resultQuestionsFragmentView;
    }

    public void answerQuestion(boolean isCorrect, int questionsIndex) {
        switch (questionsIndex) {
            case 1:
                if (isCorrect) {
                    question1.setBackgroundColor(Color.GREEN);
                    correctAnswers++;
                    correctAnswersText.setText(String.valueOf(correctAnswers));
                    Toast.makeText(getActivity(), "CORRECT!", Toast.LENGTH_SHORT).show();
                } else {
                    question1.setBackgroundColor(Color.RED);
                    Toast.makeText(getActivity(), "INCORRECT!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                if (isCorrect) {
                    question2.setBackgroundColor(Color.GREEN);
                    correctAnswers++;
                    correctAnswersText.setText(String.valueOf(correctAnswers));
                    Toast.makeText(getActivity(), "CORRECT!", Toast.LENGTH_SHORT).show();
                } else {
                    question2.setBackgroundColor(Color.RED);
                    Toast.makeText(getActivity(), "INCORRECT!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 3:
                if (isCorrect) {
                    question3.setBackgroundColor(Color.GREEN);
                    correctAnswers++;
                    correctAnswersText.setText(String.valueOf(correctAnswers));
                    Toast.makeText(getActivity(), "CORRECT!", Toast.LENGTH_SHORT).show();
                } else {
                    question3.setBackgroundColor(Color.RED);
                    Toast.makeText(getActivity(), "INCORRECT!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 4:
                if (isCorrect) {
                    question4.setBackgroundColor(Color.GREEN);
                    correctAnswers++;
                    correctAnswersText.setText(String.valueOf(correctAnswers));
                    Toast.makeText(getActivity(), "CORRECT!", Toast.LENGTH_SHORT).show();
                } else {
                    question4.setBackgroundColor(Color.RED);
                    Toast.makeText(getActivity(), "INCORRECT!", Toast.LENGTH_SHORT).show();
                }

                break;
            case 5:
                if (isCorrect) {
                    question5.setBackgroundColor(Color.GREEN);
                    correctAnswers++;
                    correctAnswersText.setText(String.valueOf(correctAnswers));
                    Toast.makeText(getActivity(), "CORRECT!", Toast.LENGTH_SHORT).show();
                } else {
                    question5.setBackgroundColor(Color.RED);
                    Toast.makeText(getActivity(), "INCORRECT!", Toast.LENGTH_SHORT).show();
                }


                break;
        }


    }


}