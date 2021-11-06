package com.example.movilespractica_1;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "Button_CheckBox_Question_Table")
public class ButtonCheckBoxQuestion extends Question {

    @NonNull
    private String correctAnswerText, wrongAnswerText1, wrongAnswerText2, wrongAnswerText3;

    public ButtonCheckBoxQuestion(@NonNull String questionText, @NonNull QuestionType questionType,
                                  @NonNull String correctAnwerText, @NonNull String wrongAnswerText1,
                                  @NonNull String wrongAnswerText2, @NonNull String wrongAnswerText3) {
        super(questionText, questionType);
        this.correctAnswerText = correctAnwerText;
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
