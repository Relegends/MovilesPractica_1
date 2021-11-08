package com.example.movilespractica_1;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Question_Table")
public class Question {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Question")
    private String questionText;

    @NonNull
    @ColumnInfo(name = "Question_Type")
    private QuestionType questionType;

    public Question(@NonNull String questionText, @NonNull QuestionType questionType) {
        this.questionText = questionText;
        this.questionType = questionType;
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
}
