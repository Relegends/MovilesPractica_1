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

    ConstraintLayout questions[] = new ConstraintLayout[20];

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
//        questions[5] = showFragmentAnswersView.findViewById(R.id.Answer6);
//        questions[6] = showFragmentAnswersView.findViewById(R.id.Answer7);
//        questions[7] = showFragmentAnswersView.findViewById(R.id.Answer8);
//        questions[8] = showFragmentAnswersView.findViewById(R.id.Answer9);
//        questions[9] = showFragmentAnswersView.findViewById(R.id.Answer10);
//        questions[10] = showFragmentAnswersView.findViewById(R.id.Answer11);
//        questions[11] = showFragmentAnswersView.findViewById(R.id.Answer12);
//        questions[12] = showFragmentAnswersView.findViewById(R.id.Answer13);
//        questions[13] = showFragmentAnswersView.findViewById(R.id.Answer14);
//        questions[14] = showFragmentAnswersView.findViewById(R.id.Answer15);
//        questions[15] = showFragmentAnswersView.findViewById(R.id.Answer16);
//        questions[16] = showFragmentAnswersView.findViewById(R.id.Answer17);
//        questions[17] = showFragmentAnswersView.findViewById(R.id.Answer18);
//        questions[18] = showFragmentAnswersView.findViewById(R.id.Answer19);
//        questions[19] = showFragmentAnswersView.findViewById(R.id.Answer20);

        setVisibilityAnswers();

        seeScoresButton = (Button) showFragmentAnswersView.findViewById(R.id.seeScoresButton);
        seeScores();

        answerQuestions(GameLogic.GAME.getAnswers());

        return showFragmentAnswersView;
    }

    private void setVisibilityAnswers() {
        for (int i = 0; i < questions.length; i++) {
            questions[i].setVisibility(View.GONE);
        }

        int[] aux = GameLogic.GAME.getIndexQuestionDB();
        for (int i = 0; i < questions.length; i++) {
            for (int j = 0; j < aux.length; j++) {
                if (i == aux[j]) {
                    questions[i].setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void answerQuestions(boolean answers[]) {
        int[] aux = GameLogic.GAME.getIndexQuestionDB();

        for (int i = 0; i < answers.length; i++) {
            if (answers[i]) {
                questions[aux[i]].setBackgroundColor(0x8000FF00);
            } else {
                questions[aux[i]].setBackgroundColor(0x80FF0000);
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