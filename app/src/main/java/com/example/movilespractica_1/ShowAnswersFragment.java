package com.example.movilespractica_1;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ShowAnswersFragment extends Fragment {

    ConstraintLayout questions[] = new ConstraintLayout[5];

    Button seeScoresButton;

    private ScoreViewModel mScoreViewModel;
    private ConfigurationViewModel mConfigurationViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View showFragmentAnswersView = inflater.inflate(R.layout.fragment_show_answers, container, false);

        mScoreViewModel = new ViewModelProvider(getActivity()).get(ScoreViewModel.class);
        mConfigurationViewModel = new ViewModelProvider(getActivity()).get(ConfigurationViewModel.class);

        questions[0] = showFragmentAnswersView.findViewById(R.id.Answer1);
        questions[1] = showFragmentAnswersView.findViewById(R.id.Answer2);
        questions[2] = showFragmentAnswersView.findViewById(R.id.Answer3);
        questions[3] = showFragmentAnswersView.findViewById(R.id.Answer4);
        questions[4] = showFragmentAnswersView.findViewById(R.id.Answer5);

        seeScoresButton = (Button) showFragmentAnswersView.findViewById(R.id.seeScoresButton);
        seeScores();

        answerQuestions(GameLogic.GAME.getAnswers());

        return showFragmentAnswersView;
    }

    public void answerQuestions(boolean answers[]) {

        for (int i = 0; i < answers.length; i++) {
            if (answers[i]) {
                questions[i].setBackgroundColor(0x8000FF00);
            } else {
                questions[i].setBackgroundColor(0x80FF0000);
            }
        }
    }

    public void seeScores() {
        seeScoresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int points = GameLogic.GAME.getPoints();

                Score score = new Score(mConfigurationViewModel.getConfiguration().getUserName(), points);
                mScoreViewModel.insertScore(score);
                GameLogic.GAME.changeActivity(getActivity());
            }
        });
    }

//    public void replay() {
//        replayButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GameLogic.GAME.resetIndexQuestion();
//                GameLogic.GAME.resetAnswers();
//                  GameLogic.GAME.resetPoints();
//                GameLogic.GAME.changeActivity(getActivity());
//            }
//        });
//    }
}