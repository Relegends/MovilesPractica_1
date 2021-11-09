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

@Database(entities = {Question.class, RadioButtonQuestion.class, CheckBoxQuestion.class,
        VideoQuestion.class, SpinnerQuestion.class, AnthemQuestion.class, PictureQuestion.class,
        FlagsQuestion.class}, version = 1, exportSchema = false)
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
                dao.deleteAllSpinnerQuestions();
                dao.deleteAllPictureQuestions();
                dao.deleteAllFlagsQuestions();
                dao.deleteAllAnthemQuestions();
                dao.deleteAllVideoQuestions();

                ArrayList<RadioButtonQuestion> radioButtonQuestionList = new ArrayList<>();
                ArrayList<CheckBoxQuestion> checkBoxQuestionList = new ArrayList<>();
                ArrayList<SpinnerQuestion> spinnerQuestionList = new ArrayList<>();
                ArrayList<PictureQuestion> pictureQuestionList = new ArrayList<>();
                ArrayList<FlagsQuestion> flagsQuestionList = new ArrayList<>();

                ArrayList<VideoQuestion> videoQuestionList = new ArrayList<>();
                ArrayList<AnthemQuestion> anthemQuestionList = new ArrayList<>();

                radioButtonQuestionList.add(new RadioButtonQuestion("¿Cuál es la capital de España?", "Madrid",
                        "Madrid", "Barcelona", "Málaga", "Burgos"));

                radioButtonQuestionList.add(new RadioButtonQuestion("¿Cuál de estos países es más grande?", "Alemania",
                        "Alemania", "Siria", "Dinamarca", "Grecia"));

                radioButtonQuestionList.add(new RadioButtonQuestion("¿En qué continente está Ruanda?", "África",
                        "Asia", "África", "Europa", "Oceanía"));

                radioButtonQuestionList.add(new RadioButtonQuestion("¿Cuál es la capital de Etiopía?", "Adís Abeba",
                        "Abuya", "Tokio", "Zagreb", "Adís Abeba"));

                checkBoxQuestionList.add(new CheckBoxQuestion("¿Cuáles de estos países pertenecen a la UE?", "", "Bélgica", "Portugal", "Turquía", "Rusia"));

                spinnerQuestionList.add(new SpinnerQuestion("Seleccione el país más pequeño del mundo:", "Ciudad del Vaticano", "Montenegro", "Andorra", "Corea del Sur", "Ciudad del Vaticano"));
                spinnerQuestionList.add(new SpinnerQuestion("Selecciona el país que se encuentra en América", "Honduras", "Honduras", "Malasia", "Papúa Nueva Guinea", "Algeria"));

                pictureQuestionList.add(new PictureQuestion("¿Qué país es este?", "Polonia", R.mipmap.poland_pmage_foreground));
                pictureQuestionList.add(new PictureQuestion("¿Qué país es este?", "Croacia", R.mipmap.croatia_pmage_foreground));

                flagsQuestionList.add(new FlagsQuestion("¿Cuál es la bandera de Serbia?", Integer.toString(R.mipmap.serbia_foreground), R.mipmap.canarias_foreground, R.mipmap.alemania_foreground, R.mipmap.andalucia_image_foreground, R.mipmap.serbia_foreground));

                videoQuestionList.add(new VideoQuestion("¿Cuál fué la capital del Imperio ruso (1721-1917)?", "San Petersburgo", R.raw.vidrusia));
                videoQuestionList.add(new VideoQuestion("¿Cómo se llama la ciudad capital que aparece en el vídeo?", "Pekín", R.raw.vidchina));
                videoQuestionList.add(new VideoQuestion("¿En qué país está este famoso castillo?", "Alemania", R.raw.vidalemania));
                videoQuestionList.add(new VideoQuestion("¿Cómo se llama el país de los mil lagos?", "Finlandia", R.raw.vidfinlandia));
                videoQuestionList.add(new VideoQuestion("¿Cuál es el lugar más profundo de los océanos de la tierra?", "Fosa de las Marianas", R.raw.vidmarianas));
                videoQuestionList.add(new VideoQuestion("¿Qué país quedó fusionado con Alemania tras el Anschluss?", "Austria", R.raw.vidww2));

                anthemQuestionList.add(new AnthemQuestion("¿De qué país es el siguiente himno?", "Japón", R.raw.himnojapon));
                anthemQuestionList.add(new AnthemQuestion("¿De qué país es el siguiente himno?", "Reino Unido", R.raw.himnouk));
                anthemQuestionList.add(new AnthemQuestion("¿De qué país es el siguiente himno?", "España", R.raw.himnoespana));
                anthemQuestionList.add(new AnthemQuestion("¿De qué país es el siguiente himno?", "Brasil", R.raw.himnobrasil));


                for (RadioButtonQuestion q : radioButtonQuestionList) {
                    dao.insertRadioButtonQuestion(q);
                }

                for (CheckBoxQuestion q : checkBoxQuestionList) {
                    dao.insertCheckBoxQuestion(q);
                }

                for (SpinnerQuestion q : spinnerQuestionList) {
                    dao.insertSpinnerQuestion(q);
                }

                for (PictureQuestion q : pictureQuestionList) {
                    dao.insertPictureQuestion(q);
                }

                for (FlagsQuestion q : flagsQuestionList) {
                    dao.insertFlagsQuestion(q);
                }

                for (VideoQuestion q : videoQuestionList) {
                    dao.insertVideoQuestion(q);
                }

                for (AnthemQuestion q : anthemQuestionList) {
                    dao.insertAnthemQuestion(q);
                }
            });
        }



    };
}
