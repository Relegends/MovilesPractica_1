package com.example.movilespractica_1;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Question_Table")
public class Question {

    @NonNull
    @ColumnInfo(name = "Question")
    private String questionText;

    @NonNull
    @ColumnInfo(name = "Question_Type")
    private QuestionType questionType;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Solution")
    private String solution;

    public Question(@NonNull String questionText, @NonNull QuestionType questionType, @NonNull String solution) {
        this.questionText = questionText;
        this.questionType = questionType;
        this.solution = solution;
    }

    @NonNull
    public String getQuestionText() {
        return questionText;
    }

    @NonNull
    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionText(@NonNull String questionText) {
        this.questionText = questionText;
    }

    public void setQuestionType(@NonNull QuestionType questionType) {
        this.questionType = questionType;
    }

    @NonNull
    public String getSolution() {
        return solution;
    }

    public void setSolution(@NonNull String solution) {
        this.solution = solution;
    }
}
