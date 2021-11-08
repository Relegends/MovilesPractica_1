package com.example.movilespractica_1;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;


public class ProgressFragment extends Fragment {

    private QuestionViewModel mQuestionViewModel;

    private ArrayList<Question> mAllQuestions = new ArrayList<>();

    ProgressBar progressBar;
    CountDownTimer countDownTimer;
    int progress = 0;
    int maxTime = 60 * 1000;

    Button nextQuestionButton;

    TextView questionNumber, questionText;

    // Video
    ConstraintLayout videoLayout;
    MediaController mediaController;
    String videoPath;
    Uri uri;
    VideoView videoView;

    // Audio
    ConstraintLayout audioLayout;
    MediaPlayer mediaPlayer;
    Button playButton;
    Button pauseButton;
    Button stopButton;

    // Question 1
    RadioButton radioButtonCorrect;
    RadioGroup radioGroup;
    ConstraintLayout radioButtonLayout;

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
        mQuestionViewModel = new ViewModelProvider(getActivity()).get(QuestionViewModel.class);
        mAllQuestions = mQuestionViewModel.getAllQuestions();
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
        radioButtonLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.radioButtonsLayout);

        checkBoxesLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.checkBoxesLayout);
        checkBoxCorrect1 = (CheckBox) progressFragmentView.findViewById(R.id.checkBox1);
        checkBoxCorrect2 = (CheckBox) progressFragmentView.findViewById(R.id.checkBox2);
        checkBoxIncorrect = (CheckBox) progressFragmentView.findViewById(R.id.checkBox3);
        checkBoxCorrect3 = (CheckBox) progressFragmentView.findViewById(R.id.checkBox4);

        imageLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.plainTextLayout);
        countryPlainText = (EditText) progressFragmentView.findViewById(R.id.editTextCountry);

        spinnerLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.spinnerLayout);
        spinner = (Spinner) progressFragmentView.findViewById(R.id.spinner);

        flagLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.flagsLayout);

        nextQuestionButton = (Button) progressFragmentView.findViewById(R.id.skipQuestion);

        canariasFlag = (ImageView) progressFragmentView.findViewById(R.id.canariasFlag);
        alemaniaFlag = (ImageView) progressFragmentView.findViewById(R.id.alemaniaFlag);
        andaluciaFlag = (ImageView) progressFragmentView.findViewById(R.id.andaluciaFlag);
        serbiaFlag = (ImageView) progressFragmentView.findViewById(R.id.serbiaFlag);

        // Video
        videoLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.videoLayout);
        videoView = progressFragmentView.findViewById(R.id.videoView);
        videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.vidmarianas;
        Uri uri = Uri.parse((videoPath));
        videoView.setVideoURI(uri);

        mediaController = new MediaController(getContext());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // Audio
        audioLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.audioLayout);
        playButton = (Button) progressFragmentView.findViewById(R.id.playMusicButton);
        pauseButton = (Button) progressFragmentView.findViewById(R.id.pauseMusicButton);
        stopButton = (Button) progressFragmentView.findViewById(R.id.stopMusicButton);

        loadNextQuestion();
        nextQuestion();

        clickFlags();
        setMediaPlayer();

        return progressFragmentView;
    }

    public void nextQuestion() {
        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();

                videoView.stopPlayback();
                mediaPlayer.stop();

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
        questionNumber.setText("Question " + GameLogic.GAME.getIndexShownQuestion());
        Question q = mAllQuestions.get(GameLogic.GAME.getNextQuestionDB());
        questionText.setText(q.getQuestionText());

        switch (q.getQuestionType()) {
            case RADIOBUTTON:
                RadioButtonQuestion rq = (RadioButtonQuestion) q;
                disableVisibilityLayouts();
                radioButtonCorrect.setText(rq.getCorrectAnswerText());
                radioButtonLayout.setVisibility(View.VISIBLE);
                break;
            case PICTURE:
                disableVisibilityLayouts();

                imageLayout.setVisibility(View.VISIBLE);
                break;
            case SPINNER:
                disableVisibilityLayouts();

                spinnerLayout.setVisibility(View.VISIBLE);
                break;
            case VIDEO:
                disableVisibilityLayouts();

                flagLayout.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void disableVisibilityLayouts() {
        radioButtonLayout.setVisibility(View.GONE);
        checkBoxesLayout.setVisibility(View.GONE);
        imageLayout.setVisibility(View.GONE);
        spinnerLayout.setVisibility(View.GONE);
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

    // Mediaplayer handling

    public void setMediaPlayer() {

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getContext(), R.raw.himnouk);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            stopPlayer();
                        }
                    });
                }
                mediaPlayer.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                }
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                stopPlayer();
            }
        });
    }

    private void stopPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            //Toast.makeText(getContext(), "Recursos liberados", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        stopPlayer();
    }
}