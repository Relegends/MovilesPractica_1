package com.example.movilespractica_1;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class ShowAnswersFragment extends Fragment {

    ConstraintLayout questions[] = new ConstraintLayout[20];
    TextView textQuestion[] = new TextView[20];
    TextView textNumber[] = new TextView[20];
    TextView textSol[] = new TextView[20];

    ArrayList<ConstraintLayout> questionsAux;

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
        textQuestion[0] = showFragmentAnswersView.findViewById(R.id.text_question1);
        textNumber[0] = showFragmentAnswersView.findViewById(R.id.label_question1);
        textNumber[0] = showFragmentAnswersView.findViewById(R.id.label_question1);
        textSol[0] = showFragmentAnswersView.findViewById(R.id.textSol1);

        questions[1] = showFragmentAnswersView.findViewById(R.id.Answer2);
        textQuestion[1] = showFragmentAnswersView.findViewById(R.id.text_question2);
        textNumber[1] = showFragmentAnswersView.findViewById(R.id.label_question2);
        textSol[1] = showFragmentAnswersView.findViewById(R.id.textSol2);

        questions[2] = showFragmentAnswersView.findViewById(R.id.Answer3);
        textQuestion[2] = showFragmentAnswersView.findViewById(R.id.text_question3);
        textNumber[2] = showFragmentAnswersView.findViewById(R.id.label_question3);
        textSol[2] = showFragmentAnswersView.findViewById(R.id.textSol3);

        questions[3] = showFragmentAnswersView.findViewById(R.id.Answer4);
        textQuestion[3] = showFragmentAnswersView.findViewById(R.id.text_question4);
        textNumber[3] = showFragmentAnswersView.findViewById(R.id.label_question4);
        textSol[3] = showFragmentAnswersView.findViewById(R.id.textSol4);

        questions[4] = showFragmentAnswersView.findViewById(R.id.Answer5);
        textQuestion[4] = showFragmentAnswersView.findViewById(R.id.text_question5);
        textNumber[4] = showFragmentAnswersView.findViewById(R.id.label_question5);
        textSol[4] = showFragmentAnswersView.findViewById(R.id.textSol5);

        questions[5] = showFragmentAnswersView.findViewById(R.id.Answer6);
        textQuestion[5] = showFragmentAnswersView.findViewById(R.id.text_question6);
        textNumber[5] = showFragmentAnswersView.findViewById(R.id.label_question6);
        textSol[5] = showFragmentAnswersView.findViewById(R.id.textSol6);

        questions[6] = showFragmentAnswersView.findViewById(R.id.Answer7);
        textQuestion[6] = showFragmentAnswersView.findViewById(R.id.text_question7);
        textNumber[6] = showFragmentAnswersView.findViewById(R.id.label_question7);
        textSol[6] = showFragmentAnswersView.findViewById(R.id.textSol7);

        questions[7] = showFragmentAnswersView.findViewById(R.id.Answer8);
        textQuestion[7] = showFragmentAnswersView.findViewById(R.id.text_question8);
        textNumber[7] = showFragmentAnswersView.findViewById(R.id.label_question8);
        textSol[7] = showFragmentAnswersView.findViewById(R.id.textSol8);

        questions[8] = showFragmentAnswersView.findViewById(R.id.Answer9);
        textQuestion[8] = showFragmentAnswersView.findViewById(R.id.text_question9);
        textNumber[8] = showFragmentAnswersView.findViewById(R.id.label_question9);
        textSol[8] = showFragmentAnswersView.findViewById(R.id.textSol9);

        questions[9] = showFragmentAnswersView.findViewById(R.id.Answer10);
        textQuestion[9] = showFragmentAnswersView.findViewById(R.id.text_question10);
        textNumber[9] = showFragmentAnswersView.findViewById(R.id.label_question10);
        textSol[9] = showFragmentAnswersView.findViewById(R.id.textSol10);

        questions[10] = showFragmentAnswersView.findViewById(R.id.Answer11);
        textQuestion[10] = showFragmentAnswersView.findViewById(R.id.text_question11);
        textNumber[10] = showFragmentAnswersView.findViewById(R.id.label_question11);
        textSol[10] = showFragmentAnswersView.findViewById(R.id.textSol11);

        questions[11] = showFragmentAnswersView.findViewById(R.id.Answer12);
        textQuestion[11] = showFragmentAnswersView.findViewById(R.id.text_question12);
        textNumber[11] = showFragmentAnswersView.findViewById(R.id.label_question12);
        textSol[11] = showFragmentAnswersView.findViewById(R.id.textSol12);

        questions[12] = showFragmentAnswersView.findViewById(R.id.Answer13);
        textQuestion[12] = showFragmentAnswersView.findViewById(R.id.text_question13);
        textNumber[12] = showFragmentAnswersView.findViewById(R.id.label_question13);
        textSol[12] = showFragmentAnswersView.findViewById(R.id.textSol13);

        questions[13] = showFragmentAnswersView.findViewById(R.id.Answer14);
        textQuestion[13] = showFragmentAnswersView.findViewById(R.id.text_question14);
        textNumber[13] = showFragmentAnswersView.findViewById(R.id.label_question14);
        textSol[13] = showFragmentAnswersView.findViewById(R.id.textSol14);

        questions[14] = showFragmentAnswersView.findViewById(R.id.Answer15);
        textQuestion[14] = showFragmentAnswersView.findViewById(R.id.text_question15);
        textNumber[14] = showFragmentAnswersView.findViewById(R.id.label_question15);
        textSol[14] = showFragmentAnswersView.findViewById(R.id.textSol15);

        questions[15] = showFragmentAnswersView.findViewById(R.id.Answer16);
        textQuestion[15] = showFragmentAnswersView.findViewById(R.id.text_question16);
        textNumber[15] = showFragmentAnswersView.findViewById(R.id.label_question16);
        textSol[15] = showFragmentAnswersView.findViewById(R.id.textSol16);

        questions[16] = showFragmentAnswersView.findViewById(R.id.Answer17);
        textQuestion[16] = showFragmentAnswersView.findViewById(R.id.text_question17);
        textNumber[16] = showFragmentAnswersView.findViewById(R.id.label_question17);
        textSol[16] = showFragmentAnswersView.findViewById(R.id.textSol17);

        questions[17] = showFragmentAnswersView.findViewById(R.id.Answer18);
        textQuestion[17] = showFragmentAnswersView.findViewById(R.id.text_question18);
        textNumber[17] = showFragmentAnswersView.findViewById(R.id.label_question18);
        textSol[17] = showFragmentAnswersView.findViewById(R.id.textSol18);

        questions[18] = showFragmentAnswersView.findViewById(R.id.Answer19);
        textQuestion[18] = showFragmentAnswersView.findViewById(R.id.text_question19);
        textNumber[18] = showFragmentAnswersView.findViewById(R.id.label_question19);
        textSol[18] = showFragmentAnswersView.findViewById(R.id.textSol19);

        questions[19] = showFragmentAnswersView.findViewById(R.id.Answer20);
        textQuestion[19] = showFragmentAnswersView.findViewById(R.id.text_question20);
        textNumber[19] = showFragmentAnswersView.findViewById(R.id.label_question20);
        textSol[19] = showFragmentAnswersView.findViewById(R.id.textSol20);


        setVisibilityAnswers();

        seeScoresButton = (Button) showFragmentAnswersView.findViewById(R.id.seeScoresButton);
        seeScores();

        answerQuestions(GameLogic.GAME.getAnswers());

        return showFragmentAnswersView;
    }

    private void setVisibilityAnswers() {
        for (ConstraintLayout question : questions) {
            question.setVisibility(View.GONE);
        }

        questionsAux = new ArrayList<>();

        ArrayList<Question> questionsGame = GameLogic.GAME.getQuestionsInGame();
        ArrayList<Integer> aux = new ArrayList<>();

        for (Question q : questionsGame) {
            boolean added = false;
            for (int i = 0; i < textQuestion.length; i++) {
                if (added) break;
                if (q.getQuestionText().equals(textQuestion[i].getText().toString()) && q.getSolution().equals(textSol[i].getText().toString())) {
                    if (!aux.contains(i)) {
                        questions[i].setVisibility(View.VISIBLE);
                        questionsAux.add(questions[i]);
                        textNumber[i].setText("Question " + (i+1));
                        aux.add(i);
                        added = true;
                    }
                }
            }
        }
    }

    public void answerQuestions(boolean answers[]) {
        ArrayList<Question> questionsGame = GameLogic.GAME.getQuestionsInGame();


        int[] aux = GameLogic.GAME.getIndexQuestionDB();


        for (int i = 0; i < answers.length; i++) {
            if (answers[i]) {
                questionsAux.get(i).setBackgroundColor(0x8000FF00);
            } else {
                questionsAux.get(i).setBackgroundColor(0x80FF0000);
            }
        }
    }

    public void seeScores() {
        seeScoresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int points = GameLogic.GAME.getPoints();

                Score score = new Score(GameLogic.GAME.getUserName(), points, GameLogic.GAME.getChronoText());
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