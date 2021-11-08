package com.example.movilespractica_1;


import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "VideoQuestion_Table")
public class VideoQuestion extends Question{

    @NonNull
    private int videoId;

    //Add way to answer question


    public VideoQuestion(@NonNull String questionText, @NonNull int videoId) {
        super(questionText, QuestionType.VIDEO);
        this.videoId = videoId;
    }

    public int getVideoId() {
        return videoId;
    }
}
