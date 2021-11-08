package com.example.movilespractica_1;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "AnthemQuestion_Table")
public class AnthemQuestion extends Question {

    @NonNull
    private int anthemId;

    public AnthemQuestion(@NonNull String questionText, @NonNull String solution, @NonNull int anthemId) {
        super(questionText, QuestionType.ANTHEM, solution);
        this.anthemId = anthemId;
    }

    public int getAnthemId() {
        return anthemId;
    }

    public void setAnthemId(int anthemId) {
        this.anthemId = anthemId;
    }
}
