package com.example.movilespractica_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ConfigurationActivity extends AppCompatActivity {

    private RadioButton radioButtonQuestionNumber;
    private RadioButton radioButtonGameMode;
    private RadioGroup radioGroupQuestionNumber;
    private RadioGroup radioGroupGameMode;
    private EditText userName;

    private ConfigurationViewModel configurationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        GameLogic.GAME.setShownActivity(this);

        configurationViewModel = new ViewModelProvider(this).get(ConfigurationViewModel.class);

        radioGroupQuestionNumber = (RadioGroup) findViewById(R.id.radioGroupNumQ);
        radioGroupGameMode = (RadioGroup) findViewById(R.id.radioGroupQType);

        userName = (EditText) findViewById(R.id.userNameText);
    }

    public void saveConfiguration(View view) {
        int radioId = radioGroupQuestionNumber.getCheckedRadioButtonId();
        radioButtonQuestionNumber = findViewById(radioId);
        radioId = radioGroupGameMode.getCheckedRadioButtonId();
        radioButtonGameMode = findViewById(radioId);

        if (radioButtonQuestionNumber != null && radioButtonGameMode != null && !userName.getText().toString().equals("")) {
            if (radioButtonGameMode.getText().toString().equals("Preguntas de todo tipo") ||
                    (radioButtonGameMode.getText().toString().equals("Preguntas multimedia") &&
                    !radioButtonQuestionNumber.getText().toString().equals("15"))) {
                Configuration configuration = new Configuration();
                configuration.setNumQuestionsSelected(Integer.parseInt((String) radioButtonQuestionNumber.getText()));
                configuration.setUserName(userName.getText().toString());
                configuration.setGameMode((String) radioButtonQuestionNumber.getText());

                configurationViewModel.deleteConfiguration();
                configurationViewModel.insertConfiguration(configuration);

                GameLogic.GAME.setUserName(userName.getText().toString());
                GameLogic.GAME.setNumMaxQuestions(Integer.parseInt((String) radioButtonQuestionNumber.getText()));
                GameLogic.GAME.setGameMode(configuration.getGameMode());
                GameLogic.GAME.resetGameLogic();

                Toast.makeText(this, "Ajustes guardados", Toast.LENGTH_SHORT).show();
                GameLogic.GAME.changeActivity(this);
            } else
                Toast.makeText(this, "Seleccione menos preguntas para este modo de juego", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Rellene toda la configuración", Toast.LENGTH_SHORT).show();
    }
}