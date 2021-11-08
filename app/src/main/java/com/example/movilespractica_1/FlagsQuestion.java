package com.example.movilespractica_1;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "FlagsQuestion_Table")
public class FlagsQuestion extends Question{

    @NonNull
    private int flagId1, flagId2, flagId3, flagId4;

    public FlagsQuestion(@NonNull String questionText, @NonNull String solution,
                         @NonNull int flagId1, @NonNull int flagId2, @NonNull int flagId3, @NonNull int flagId4) {
        super(questionText, QuestionType.FLAGS, solution);
        this.flagId1 = flagId1;
        this.flagId2 = flagId2;
        this.flagId3 = flagId3;
        this.flagId4 = flagId4;
    }

    public int getFlagId1() {
        return flagId1;
    }

    public int getFlagId2() {
        return flagId2;
    }

    public int getFlagId3() {
        return flagId3;
    }

    public int getFlagId4() {
        return flagId4;
    }

    public void setFlagId1(int flagId1) {
        this.flagId1 = flagId1;
    }

    public void setFlagId2(int flagId2) {
        this.flagId2 = flagId2;
    }

    public void setFlagId3(int flagId3) {
        this.flagId3 = flagId3;
    }

    public void setFlagId4(int flagId4) {
        this.flagId4 = flagId4;
    }
}
