package com.example.movilespractica_1;

import androidx.annotation.NonNull;
import androidx.room.Entity;

import java.util.Arrays;

@Entity(tableName = "CheckBoxQuestion_Table")
public class CheckBoxQuestion extends Question{

    @NonNull
    private String correctAnswerText[];

    @NonNull
    private String wrongAnswerText[];


    public CheckBoxQuestion(@NonNull String questionText,
                               @NonNull String correctAnswerText[], @NonNull String wrongAnswerText[]) {
        super(questionText, QuestionType.CHECKBOX);
        this.correctAnswerText = Arrays.copyOf(correctAnswerText, correctAnswerText.length);
        this.wrongAnswerText = Arrays.copyOf(wrongAnswerText, wrongAnswerText.length);
    }

    @NonNull
    public String[] getCorrectAnswerText() {
        return correctAnswerText;
    }

    @NonNull
    public String[] getWrongAnswerText() {
        return wrongAnswerText;
    }
}
