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
    private TextView userDisplay;

    private ConfigurationViewModel configurationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        configurationViewModel = new ViewModelProvider(this).get(ConfigurationViewModel.class);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupNumQ);

        userName = (EditText) findViewById(R.id.userNameText);
        userDisplay = (TextView) findViewById(R.id.userDisplay);
        //userDisplay.setText("Nuevo nombre de usuario");
        userDisplay.setText(configurationViewModel.getConfiguration().getUserName());
    }

    public void saveConfiguration(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        if(radioButton != null) {
            Configuration configuration = new Configuration();
            configuration.setNumQuestionsSelected(Integer.parseInt((String) radioButton.getText()));
            configuration.setUserName(userName.getText().toString());

            configurationViewModel.deleteConfiguration();
            configurationViewModel.insertConfiguration(configuration);

            Toast.makeText(this, "Ajustes guardados", Toast.LENGTH_SHORT).show();
            userDisplay.setText(userName.getText().toString());

        } else {
            Toast.makeText(this, "Rellene toda la configuración", Toast.LENGTH_SHORT).show();
        }
    }
}