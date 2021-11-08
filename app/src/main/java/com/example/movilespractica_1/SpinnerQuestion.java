package com.example.movilespractica_1;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "SpinnerQuestion_Table")
public class SpinnerQuestion extends Question {

    @NonNull
    private String option1, option2, option3, option4;

    public SpinnerQuestion(@NonNull String questionText, @NonNull String solution,
                               @NonNull String option1, @NonNull String option2,
                               @NonNull String option3, @NonNull String option4) {
        super(questionText, QuestionType.SPINNER, solution);
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
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

    @NonNull
    public String getOption4() {
        return option4;
    }

    public void setOption1(@NonNull String option1) {
        this.option1 = option1;
    }

    public void setOption2(@NonNull String option2) {
        this.option2 = option2;
    }

    public void setOption3(@NonNull String option3) {
        this.option3 = option3;
    }

    public void setOption4(@NonNull String option4) {
        this.option4 = option4;
    }
}
