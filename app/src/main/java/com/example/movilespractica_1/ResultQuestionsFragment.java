package com.example.movilespractica_1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


public class ResultQuestionsFragment extends Fragment {

    ProgressBar progressBar;
    CountDownTimer countDownTimer;
    int progress = 0;
    int maxTime = 60 * 1000;

    TextView question1;

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


        progressBar = (ProgressBar) resultQuestionsFragmentView.findViewById(R.id.progressBar);
        countDownEvent();



        return resultQuestionsFragmentView;
    }



    private void countDownEvent() {
        progressBar.setProgress(progress);
        countDownTimer = new CountDownTimer(maxTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progress++;
                progressBar.setProgress((int)progress*100/(maxTime/1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(getActivity(), ResultsActivity.class);
                startActivity(intent);
            }
        }.start();
    }


}