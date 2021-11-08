package com.example.movilespractica_1;

import androidx.annotation.NonNull;
import androidx.room.Entity;

import java.util.Arrays;

@Entity(tableName = "CheckBoxQuestion_Table")
public class CheckBoxQuestion extends Question{

    @NonNull
    private String correctAnswerText1, correctAnswerText2;

    @NonNull
    private String wrongAnswerText1, wrongAnswerText2;


    public CheckBoxQuestion(@NonNull String questionText, @NonNull String solution,
                               @NonNull String correctAnswerText1, @NonNull String correctAnswerText2,
                            @NonNull String wrongAnswerText1, @NonNull String wrongAnswerText2) {
        super(questionText, QuestionType.CHECKBOX, solution);
        this.correctAnswerText1 = correctAnswerText1;
        this.correctAnswerText2 = correctAnswerText2;
        this.wrongAnswerText1 = wrongAnswerText1;
        this.wrongAnswerText2 = wrongAnswerText2;
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
    public String getCorrectAnswerText1() {
        return correctAnswerText1;
    }

    @NonNull
    public String getCorrectAnswerText2() {
        return correctAnswerText2;
    }

    public void setCorrectAnswerText1(@NonNull String correctAnswerText1) {
        this.correctAnswerText1 = correctAnswerText1;
    }

    public void setCorrectAnswerText2(@NonNull String correctAnswerText2) {
        this.correctAnswerText2 = correctAnswerText2;
    }

    public void setWrongAnswerText1(@NonNull String wrongAnswerText1) {
        this.wrongAnswerText1 = wrongAnswerText1;
    }

    public void setWrongAnswerText2(@NonNull String wrongAnswerText2) {
        this.wrongAnswerText2 = wrongAnswerText2;
    }
}
