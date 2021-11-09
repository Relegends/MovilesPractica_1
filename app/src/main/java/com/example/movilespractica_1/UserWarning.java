package com.example.movilespractica_1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class UserWarning extends AppCompatDialogFragment {

    private userWarningDialogInterface sendAnswer;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setTitle("Aviso")
                .setMessage("No se ha introducido ningún usuario, puede continuar de forma anónima o añadir un nuevo usuario")
                .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            sendAnswer.sendAnswerToActivity(true);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                })
                .setNegativeButton("Añadir usuario", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            sendAnswer.sendAnswerToActivity(false);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
        return dialogBuilder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            sendAnswer = (userWarningDialogInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement userWarningDialogInterface");
        }
    }

    public interface userWarningDialogInterface {
        void sendAnswerToActivity(boolean answer) throws InterruptedException;
    }
}
