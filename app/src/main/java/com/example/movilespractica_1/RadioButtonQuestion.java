package com.example.movilespractica_1;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "RadioButtonQuestion_Table")
public class RadioButtonQuestion extends Question {

    @NonNull
    private String option1, option2, option3, option4;

    public RadioButtonQuestion(@NonNull String questionText, @NonNull String solution,
                               @NonNull String option1, @NonNull String option2,
                               @NonNull String option3, @NonNull String option4) {
        super(questionText, QuestionType.RADIOBUTTON, solution);
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    @NonNull
    public String getOption4() {
        return option4;
    }

    @NonNull
    public String getOption1() {
        return option1;
    }

    @NonNull
    public String getOption2() {
        return option2;
    }

    @NonNull
    public String getOption3() {
        return option3;
    }
}
