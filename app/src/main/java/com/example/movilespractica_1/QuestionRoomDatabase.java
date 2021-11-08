package com.example.movilespractica_1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Question.class, RadioButtonQuestion.class, CheckBoxQuestion.class, VideoQuestion.class}, version = 1, exportSchema = false)
public abstract class QuestionRoomDatabase extends RoomDatabase {

    public abstract QuestionDAO questionDAO();


    private static volatile QuestionRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static QuestionRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (QuestionRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    QuestionRoomDatabase.class, "questions_database")
                            .addCallback(sRoomDatabaseCallback)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        INSTANCE.getOpenHelper().getWritableDatabase();
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                QuestionDAO dao = INSTANCE.questionDAO();
                dao.deleteAllRadioButtonQuestions();
                dao.deleteAllCheckBoxQuestions();
                dao.deleteAllVideoQuestions();
                dao.deleteAllQuestions();

                ArrayList<RadioButtonQuestion> radioButtonQuestionList = new ArrayList<>();
                //ArrayList<CheckBoxQuestion> checkBoxQuestionList = new ArrayList<>();
                //ArrayList<SpinnerQuestion> spinnerQuestionList = new ArrayList<>();
                //ArrayList<PictureQuestion> pictureQuestionList = new ArrayList<>();
                //ArrayList<FlagsQuestion> flagsQuestionList = new ArrayList<>();

                ArrayList<VideoQuestion> videoQuestionList = new ArrayList<>();
                //ArrayList<AnthemQuestion> anthemQuestionList = new ArrayList<>();

                radioButtonQuestionList.add(new RadioButtonQuestion("¿Cuál es la capital de España?", "Madrid",
                        "Madrid", "Barcelona", "Málaga", "Burgos"));

                radioButtonQuestionList.add(new RadioButtonQuestion("¿Cuál de estos países es el más grande?", "Alemania",
                        "Alemania", "Siria", "Dinamarca", "Grecia"));

                videoQuestionList.add(new VideoQuestion("¿Cuál fué la capital del Imperio ruso (1721-1917)?", "San Petesburgo", R.raw.vidrusia));
                videoQuestionList.add(new VideoQuestion("Cómo se llama la ciudad capital que aparece en el vídeo?", "Pekín", R.raw.vidchina));
                videoQuestionList.add(new VideoQuestion("¿En qué país está este famoso castillo?", "Alemania", R.raw.vidalemania));
                videoQuestionList.add(new VideoQuestion("¿Cómo se llama el país de los mil lagos?", "Finlandia", R.raw.vidfinlandia));
                videoQuestionList.add(new VideoQuestion("¿Cuál es el lugar más profundo de los océanos de la tierra?", "Fosa de las marianas", R.raw.vidmarianas));
                videoQuestionList.add(new VideoQuestion("¿Qué país quedó fusionado con Alemania tras el Anschluss?", "Austria", R.raw.vidww2));

                for (RadioButtonQuestion q : radioButtonQuestionList) {
                    dao.insertRadioButtonQuestion(q);
                }

                for (VideoQuestion q : videoQuestionList) {
                    dao.insertVideoQuestion(q);
                }

            });
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                QuestionDAO dao = INSTANCE.questionDAO();
                dao.deleteAllRadioButtonQuestions();
                dao.deleteAllCheckBoxQuestions();
                dao.deleteAllVideoQuestions();
                dao.deleteAllQuestions();

                ArrayList<RadioButtonQuestion> radioButtonQuestionList = new ArrayList<>();
                //ArrayList<CheckBoxQuestion> checkBoxQuestionList = new ArrayList<>();
                //ArrayList<SpinnerQuestion> spinnerQuestionList = new ArrayList<>();
                //ArrayList<PictureQuestion> pictureQuestionList = new ArrayList<>();
                //ArrayList<FlagsQuestion> flagsQuestionList = new ArrayList<>();

                ArrayList<VideoQuestion> videoQuestionList = new ArrayList<>();
                //ArrayList<AnthemQuestion> anthemQuestionList = new ArrayList<>();

                radioButtonQuestionList.add(new RadioButtonQuestion("¿Cuál es la capital de España?", "Madrid",
                        "Madrid", "Barcelona", "Málaga", "Burgos"));

                radioButtonQuestionList.add(new RadioButtonQuestion("¿Cuál de estos países es el más grande?", "Alemania",
                        "Alemania", "Siria", "Dinamarca", "Grecia"));

                videoQuestionList.add(new VideoQuestion("¿Cuál fué la capital del Imperio ruso (1721-1917)?", "San Petesburgo", R.raw.vidrusia));
                videoQuestionList.add(new VideoQuestion("Cómo se llama la ciudad capital que aparece en el vídeo?", "Pekín", R.raw.vidchina));
                videoQuestionList.add(new VideoQuestion("¿En qué país está este famoso castillo?", "Alemania", R.raw.vidalemania));
                videoQuestionList.add(new VideoQuestion("¿Cómo se llama el país de los mil lagos?", "Finlandia", R.raw.vidfinlandia));
                videoQuestionList.add(new VideoQuestion("¿Cuál es el lugar más profundo de los océanos de la tierra?", "Fosa de las marianas", R.raw.vidmarianas));
                videoQuestionList.add(new VideoQuestion("¿Qué país quedó fusionado con Alemania tras el Anschluss?", "Austria", R.raw.vidww2));

                for (RadioButtonQuestion q : radioButtonQuestionList) {
                    dao.insertRadioButtonQuestion(q);
                }

                for (VideoQuestion q : videoQuestionList) {
                    dao.insertVideoQuestion(q);
                }


            });
        }
    };
}
