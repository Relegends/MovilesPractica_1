package com.example.movilespractica_1;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
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
    RadioGroup radioGroup;

    // Question 2
    ConstraintLayout checkBoxesLayout;
    CheckBox checkBoxIncorrect, checkBoxCorrect1, checkBoxCorrect2, checkBoxCorrect3;

    // Question 3
    ConstraintLayout imageLayout;
    EditText countryPlainText;

    // Question 4
    ConstraintLayout spinnerLayout;
    Spinner spinner;

    // Question 5
    ConstraintLayout flagLayout;
    ImageView alemaniaFlag, andaluciaFlag, serbiaFlag, canariasFlag;
    boolean isFlag;

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
        radioGroup = (RadioGroup) progressFragmentView.findViewById(R.id.radioGroup);

        checkBoxesLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.checkBoxes);
        checkBoxCorrect1 = (CheckBox) progressFragmentView.findViewById(R.id.checkBox1);
        checkBoxCorrect2 = (CheckBox) progressFragmentView.findViewById(R.id.checkBox2);
        checkBoxIncorrect = (CheckBox) progressFragmentView.findViewById(R.id.checkBox3);
        checkBoxCorrect3 = (CheckBox) progressFragmentView.findViewById(R.id.checkBox4);

        imageLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.ImageConstraint);
        countryPlainText = (EditText) progressFragmentView.findViewById(R.id.editTextCountry);

        spinnerLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.SpinnerConstraint);
        spinner = (Spinner) progressFragmentView.findViewById(R.id.spinner);

        flagLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.flagsLayout);

        nextQuestionButton = (Button) progressFragmentView.findViewById(R.id.skipQuestion);

        canariasFlag = (ImageView)  progressFragmentView.findViewById(R.id.canariasFlag);
        alemaniaFlag = (ImageView)  progressFragmentView.findViewById(R.id.alemaniaFlag);
        andaluciaFlag = (ImageView)  progressFragmentView.findViewById(R.id.andaluciaFlag);
        serbiaFlag = (ImageView)  progressFragmentView.findViewById(R.id.serbiaFlag);

        nextQuestion();
        clickFlags();

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

    public void clickFlags() {
        canariasFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canariasFlag.setColorFilter(Color.argb(50, 0, 0, 0));
                alemaniaFlag.setColorFilter(Color.argb(0, 0, 0, 0));
                andaluciaFlag.setColorFilter(Color.argb(0, 0, 0, 0));
                serbiaFlag.setColorFilter(Color.argb(0, 0, 0, 0));
                isFlag = false;
            }
        });

        alemaniaFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canariasFlag.setColorFilter(Color.argb(0, 0, 0, 0));
                alemaniaFlag.setColorFilter(Color.argb(50, 0, 0, 0));
                andaluciaFlag.setColorFilter(Color.argb(0, 0, 0, 0));
                serbiaFlag.setColorFilter(Color.argb(0, 0, 0, 0));
                isFlag = false;
            }
        });

        andaluciaFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canariasFlag.setColorFilter(Color.argb(0, 0, 0, 0));
                alemaniaFlag.setColorFilter(Color.argb(0, 0, 0, 0));
                andaluciaFlag.setColorFilter(Color.argb(50, 0, 0, 0));
                serbiaFlag.setColorFilter(Color.argb(0, 0, 0, 0));
                isFlag = false;
            }
        });

        serbiaFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canariasFlag.setColorFilter(Color.argb(0, 0, 0, 0));
                alemaniaFlag.setColorFilter(Color.argb(0, 0, 0, 0));
                andaluciaFlag.setColorFilter(Color.argb(0, 0, 0, 0));
                serbiaFlag.setColorFilter(Color.argb(50, 0, 0, 0));
                isFlag = true;
            }
        });
    }

    private void loadNextQuestion() {
        switch (GameLogic.GAME.getIndexShownQuestion()) {
            case 1:
                radioGroup.setVisibility(View.GONE);
                questionNumber.setText("Question 2");
                questionText.setText("¿Cuáles de estos países están en la UE?");
                checkBoxesLayout.setVisibility(View.VISIBLE);
                break;
            case 2:
                checkBoxesLayout.setVisibility(View.GONE);
                questionNumber.setText("Question 3");
                questionText.setText("¿Qué país es este?");
                imageLayout.setVisibility(View.VISIBLE);
                break;
            case 3:
                imageLayout.setVisibility(View.GONE);
                questionNumber.setText("Question 4");
                questionText.setText("Seleccione el país más\npequeño del mundo:");
                spinnerLayout.setVisibility(View.VISIBLE);
                break;
            case 4:
                spinnerLayout.setVisibility(View.GONE);
                questionNumber.setText("Question 5");
                questionText.setText("¿Cuál es la bandera de Serbia?");
                flagLayout.setVisibility(View.VISIBLE);
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
            case 1:
                if (checkBoxCorrect1.isChecked() && checkBoxCorrect2.isChecked() && checkBoxCorrect3.isChecked() && !checkBoxIncorrect.isChecked())
                    GameLogic.GAME.setAnswer(true, indexQuestion);
                break;
            case 2:
                if (countryPlainText.getText().toString().equals("Polonia"))
                    GameLogic.GAME.setAnswer(true, indexQuestion);
                break;
            case 3:
                if (spinner.getSelectedItem().toString().equals("Ciudad del Vaticano"))
                    GameLogic.GAME.setAnswer(true, indexQuestion);
                break;
            case 4:
                if (isFlag)
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