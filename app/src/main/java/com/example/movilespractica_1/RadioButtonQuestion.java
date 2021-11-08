package com.example.movilespractica_1;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "RadioButtonQuestion_Table")
public class RadioButtonQuestion extends Question {

    @NonNull
    private String correctAnswerText, wrongAnswerText1, wrongAnswerText2, wrongAnswerText3;

    public RadioButtonQuestion(@NonNull String questionText, @NonNull String solution,
                               @NonNull String correctAnswerText, @NonNull String wrongAnswerText1,
                               @NonNull String wrongAnswerText2, @NonNull String wrongAnswerText3) {
        super(questionText, QuestionType.RADIOBUTTON, solution);
        this.correctAnswerText = correctAnswerText;
        this.wrongAnswerText1 = wrongAnswerText1;
        this.wrongAnswerText2 = wrongAnswerText2;
        this.wrongAnswerText3 = wrongAnswerText3;
    }

    @NonNull
    public String getCorrectAnswerText() {
        return correctAnswerText;
    }

    @NonNull
    public String getWrongAnswerText1() {
        return wrongAnswerText1;
    }

    @NonNull
    public String getWrongAnswerText2() {
        return wrongAnswerText2;
    }

    @NonNull
    public String getWrongAnswerText3() {
        return wrongAnswerText3;
    }
}
