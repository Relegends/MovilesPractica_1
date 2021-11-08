package com.example.movilespractica_1;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "PictureQuestion_Table")
public class PictureQuestion extends Question{

    @NonNull
    private int pictureId;

    public PictureQuestion(@NonNull String questionText, @NonNull String solution, @NonNull int pictureId) {
        super(questionText, QuestionType.PICTURE, solution);
        this.pictureId = pictureId;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
}
