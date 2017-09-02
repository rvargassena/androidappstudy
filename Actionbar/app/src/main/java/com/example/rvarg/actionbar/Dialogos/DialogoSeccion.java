package com.example.rvarg.actionbar.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

/**
 * Created by rvarg on 29/08/2017.
 */

public class DialogoSeccion extends DialogFragment {
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final String[] items = {"Español", "Ingles", "frances"};
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Seleccione el idioma")
                    .setItems(items, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int item) {
                            Toast.makeText(getActivity(), "Seleccionaste " + items[item],Toast.LENGTH_SHORT).show();
                        }
                    });
                return builder.create();
        }
}
