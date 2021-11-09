package com.example.movilespractica_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ConfigurationActivity extends AppCompatActivity {

    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private EditText userName;
    private TextView userNameDisplay;

    private ConfigurationViewModel configurationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        configurationViewModel = new ViewModelProvider(this).get(ConfigurationViewModel.class);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupNumQ);

        userName = (EditText) findViewById(R.id.userNameText);
        userNameDisplay = (TextView) findViewById(R.id.userNameDisplay);
        //userNameDisplay.setText(configurationViewModel.getConfiguration().getUserName());
        userNameDisplay.setText("Introduzca nombre de usuario");
    }

    public void saveConfiguration(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        String userString = userName.getText().toString();

        if (radioButton != null && !userString.equals("")) {
            Configuration configuration = new Configuration();
            configuration.setNumQuestionsSelected(Integer.parseInt((String) radioButton.getText()));
            configuration.setUserName(userString);

            configurationViewModel.deleteConfiguration();
            configurationViewModel.insertConfiguration(configuration);

            Toast.makeText(this, "Ajustes guardados", Toast.LENGTH_SHORT).show();
            userNameDisplay.setText(userString);

        } else {
            Toast.makeText(this, "Rellene toda la configuración", Toast.LENGTH_SHORT).show();
        }
    }
}