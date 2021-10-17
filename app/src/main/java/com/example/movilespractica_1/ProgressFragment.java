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
import android.widget.Toast;


public class ProgressFragment extends Fragment {

    ProgressBar progressBar;
    CountDownTimer countDownTimer;
    int progress = 0;
    int maxTime = 60 * 1000;

    Button skipQuestionButton;
    int indexQuestion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View progressFragmentView = inflater.inflate(R.layout.fragment_progress, container, false);

        progressBar = progressFragmentView.findViewById(R.id.progressBar);
        countDownEvent();

        skipQuestionButton = (Button) progressFragmentView.findViewById(R.id.skipQuestion);
        nextQuestion();

        return progressFragmentView;
    }

    public void nextQuestion() {
        skipQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indexQuestion++;
                switch (indexQuestion) {
                    case 1:
                        ((ResultQuestionsFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.resultQuestionsFragment)).answerQuestion(false, 1);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.radioButtonQuestionFragment, ResultQuestionsFragment.class, null).commit();
                        break;
                    case 2:
                        ((ResultQuestionsFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.resultQuestionsFragment)).answerQuestion(true, 2);
                        break;
                    case 3:
                        ((ResultQuestionsFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.resultQuestionsFragment)).answerQuestion(true, 3);
                        break;
                    case 4:
                        ((ResultQuestionsFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.resultQuestionsFragment)).answerQuestion(false, 4);
                        break;
                    default:
                        ((ResultQuestionsFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.resultQuestionsFragment)).answerQuestion(false, 5);
                        Intent intent = new Intent(getActivity(), ResultsActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                        break;
                }
            }
        });

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
                Intent intent = new Intent(getActivity(), ResultsActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        }.start();
    }
}