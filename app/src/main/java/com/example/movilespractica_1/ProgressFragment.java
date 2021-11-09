package com.example.movilespractica_1;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
    int maxTime = 60 * 1000 * 5;

    Button nextQuestionButton;

    TextView questionNumber, questionText;

    // Video
    ConstraintLayout videoLayout;
    MediaController mediaController;
    String videoPath;
    Uri uri;
    VideoView videoView;
    EditText videoPlainText;

    // Audio
    ConstraintLayout audioLayout;
    MediaPlayer mediaPlayer;
    Button playButton;
    Button pauseButton;
    Button stopButton;
    int audioId;

    // RadioButtonQuestion
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    RadioGroup radioGroup;
    ConstraintLayout radioButtonLayout;

    // CheckBoxQuestion
    ConstraintLayout checkBoxesLayout;
    CheckBox checkBoxIncorrect1, checkBoxCorrect1, checkBoxCorrect2, checkBoxInCorrect2;

    // ImageQuestion
    ConstraintLayout imageLayout;
    ImageView pictureImage;
    EditText countryPlainText;

    // SpinnerQuestion
    ConstraintLayout spinnerLayout;
    Spinner spinner;

    // FlagsQuestion
    ConstraintLayout flagLayout;
    ImageView flag1, flag2, flag3, flag4;
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

        radioButton1 = (RadioButton) progressFragmentView.findViewById(R.id.radioButtonP1);
        radioButton2 = (RadioButton) progressFragmentView.findViewById(R.id.radioButtonP2);
        radioButton3 = (RadioButton) progressFragmentView.findViewById(R.id.radioButtonP3);
        radioButton4 = (RadioButton) progressFragmentView.findViewById(R.id.radioButtonP4);
        radioGroup = (RadioGroup) progressFragmentView.findViewById(R.id.radioGroup);
        radioButtonLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.radioButtonsLayout);

        checkBoxesLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.checkBoxesLayout);
        checkBoxCorrect1 = (CheckBox) progressFragmentView.findViewById(R.id.checkBox1);
        checkBoxCorrect2 = (CheckBox) progressFragmentView.findViewById(R.id.checkBox2);
        checkBoxIncorrect1 = (CheckBox) progressFragmentView.findViewById(R.id.checkBox3);
        checkBoxInCorrect2 = (CheckBox) progressFragmentView.findViewById(R.id.checkBox4);

        imageLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.plainTextLayout);
        countryPlainText = (EditText) progressFragmentView.findViewById(R.id.editTextCountry);
        pictureImage = (ImageView) progressFragmentView.findViewById(R.id.pictureImage);

        spinnerLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.spinnerLayout);
        spinner = (Spinner) progressFragmentView.findViewById(R.id.spinner);

        flagLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.flagsLayout);

        nextQuestionButton = (Button) progressFragmentView.findViewById(R.id.skipQuestion);

        flag1 = (ImageView) progressFragmentView.findViewById(R.id.flag1);
        flag2 = (ImageView) progressFragmentView.findViewById(R.id.flag2);
        flag3 = (ImageView) progressFragmentView.findViewById(R.id.flag3);
        flag4 = (ImageView) progressFragmentView.findViewById(R.id.flag4);

        // Video
        videoLayout = (ConstraintLayout) progressFragmentView.findViewById(R.id.videoLayout);
        videoView = progressFragmentView.findViewById(R.id.videoView);
        videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.vidmarianas;
        Uri uri = Uri.parse((videoPath));
        videoView.setVideoURI(uri);
        videoPlainText = (EditText) progressFragmentView.findViewById(R.id.answer);

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

                if (mediaPlayer != null)
                    mediaPlayer.stop();

                GameLogic.GAME.nextQuestion();
                loadNextQuestion();
            }
        });
    }

    public void clickFlags() {
        flag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag4.setColorFilter(Color.argb(50, 0, 0, 0));
                flag1.setColorFilter(Color.argb(0, 0, 0, 0));
                flag2.setColorFilter(Color.argb(0, 0, 0, 0));
                flag3.setColorFilter(Color.argb(0, 0, 0, 0));
                isFlag = false;
            }
        });

        flag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag4.setColorFilter(Color.argb(0, 0, 0, 0));
                flag1.setColorFilter(Color.argb(50, 0, 0, 0));
                flag2.setColorFilter(Color.argb(0, 0, 0, 0));
                flag3.setColorFilter(Color.argb(0, 0, 0, 0));
                isFlag = false;
            }
        });

        flag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag4.setColorFilter(Color.argb(0, 0, 0, 0));
                flag1.setColorFilter(Color.argb(0, 0, 0, 0));
                flag2.setColorFilter(Color.argb(50, 0, 0, 0));
                flag3.setColorFilter(Color.argb(0, 0, 0, 0));
                isFlag = false;
            }
        });

        flag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag4.setColorFilter(Color.argb(0, 0, 0, 0));
                flag1.setColorFilter(Color.argb(0, 0, 0, 0));
                flag2.setColorFilter(Color.argb(0, 0, 0, 0));
                flag3.setColorFilter(Color.argb(50, 0, 0, 0));
                isFlag = true;
            }
        });
    }

    private void loadNextQuestion() {
        int indexQuestion = GameLogic.GAME.getIndexShownQuestion() + 1;
        questionNumber.setText("Question " + indexQuestion);
        Question q = mAllQuestions.get(GameLogic.GAME.getNextQuestionDB());
        questionText.setText(q.getQuestionText());

        switch (q.getQuestionType()) {
            case RADIOBUTTON:
                RadioButtonQuestion rq = (RadioButtonQuestion) q;
                disableVisibilityLayouts();
                radioButton1.setText(rq.getOption1());
                radioButton2.setText(rq.getOption2());
                radioButton3.setText(rq.getOption3());
                radioButton4.setText(rq.getOption4());
                radioButtonLayout.setVisibility(View.VISIBLE);
                break;
            case CHECKBOX:
                CheckBoxQuestion cq = (CheckBoxQuestion) q;
                disableVisibilityLayouts();
                checkBoxCorrect1.setText(cq.getCorrectAnswerText1());
                checkBoxCorrect2.setText(cq.getCorrectAnswerText2());
                checkBoxIncorrect1.setText(cq.getWrongAnswerText1());
                checkBoxInCorrect2.setText(cq.getWrongAnswerText2());
                checkBoxesLayout.setVisibility(View.VISIBLE);
                break;
            case SPINNER:
                SpinnerQuestion sq = (SpinnerQuestion) q;
                disableVisibilityLayouts();

                ArrayAdapter<String> adapter;
                List<String> data = new ArrayList<String>();
                data.add(sq.getOption1());
                data.add(sq.getOption2());
                data.add(sq.getOption3());
                data.add(sq.getOption4());
                adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, data);

                spinner.setAdapter(adapter);

                spinnerLayout.setVisibility(View.VISIBLE);
                break;
            case PICTURE:
                PictureQuestion pq = (PictureQuestion) q;
                disableVisibilityLayouts();

                pictureImage.setImageResource(pq.getPictureId());

                imageLayout.setVisibility(View.VISIBLE);
                break;
            case FLAGS:
                FlagsQuestion fq = (FlagsQuestion) q;
                disableVisibilityLayouts();

                flag1.setImageResource(fq.getFlagId1());
                flag2.setImageResource(fq.getFlagId2());
                flag3.setImageResource(fq.getFlagId3());
                flag4.setImageResource(fq.getFlagId4());

                flagLayout.setVisibility(View.VISIBLE);
                break;
            case VIDEO:
                VideoQuestion vq = (VideoQuestion) q;
                disableVisibilityLayouts();

                videoPath = "android.resource://" + getActivity().getPackageName() + "/" + vq.getVideoId();

                videoLayout.setVisibility(View.VISIBLE);
                break;
            case ANTHEM:
                AnthemQuestion aq = (AnthemQuestion) q;
                disableVisibilityLayouts();

                audioId = aq.getAnthemId();

                audioLayout.setVisibility(View.VISIBLE);
                break;
        }
        ((ResultQuestionsFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.resultQuestionsFragment)).answerQuestion();
    }

    private void disableVisibilityLayouts() {
        radioButtonLayout.setVisibility(View.GONE);
        checkBoxesLayout.setVisibility(View.GONE);
        imageLayout.setVisibility(View.GONE);
        spinnerLayout.setVisibility(View.GONE);
        flagLayout.setVisibility(View.GONE);
        videoLayout.setVisibility(View.GONE);
        audioLayout.setVisibility(View.GONE);
    }

    private void checkAnswer() {
        Question q = mAllQuestions.get(GameLogic.GAME.getNextQuestionDB());
        switch (q.getQuestionType()) {
            case RADIOBUTTON:
                RadioButtonQuestion rb = (RadioButtonQuestion) q;
                //GameLogic.GAME.setAnswer(true, GameLogic.GAME.getIndexShownQuestion());
                break;
            case CHECKBOX:
                if (checkBoxCorrect1.isChecked() && checkBoxCorrect2.isChecked() && !checkBoxInCorrect2.isChecked() && !checkBoxIncorrect1.isChecked())
                    GameLogic.GAME.setAnswer(true, GameLogic.GAME.getIndexShownQuestion());
                break;
            case SPINNER:
                SpinnerQuestion sq = (SpinnerQuestion) q;
                if (spinner.getSelectedItem().toString().equals(sq.getSolution()))
                    GameLogic.GAME.setAnswer(true, GameLogic.GAME.getIndexShownQuestion());
                break;
            case PICTURE:
                PictureQuestion pq = (PictureQuestion) q;
                if (countryPlainText.getText().toString().equals(pq.getSolution()))
                    GameLogic.GAME.setAnswer(true, GameLogic.GAME.getIndexShownQuestion());
                break;
            case FLAGS:
                FlagsQuestion fq = (FlagsQuestion) q;

                if (isFlag)
                    GameLogic.GAME.setAnswer(true, GameLogic.GAME.getIndexShownQuestion());

                break;
            case VIDEO:
                VideoQuestion vq = (VideoQuestion) q;
                if (videoPlainText.getText().toString().equals(vq.getSolution()))
                    GameLogic.GAME.setAnswer(true, GameLogic.GAME.getIndexShownQuestion());
                break;
            case ANTHEM:
                AnthemQuestion aq = (AnthemQuestion) q;

                break;
        }

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
                    mediaPlayer = MediaPlayer.create(getContext(), audioId);
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