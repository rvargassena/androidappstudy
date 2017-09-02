package com.example.rvarg.actionbar.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by rvarg on 29/08/2017.
 */

public class DialogoAlerta extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        builder.setMessage("Desea guardar la informacion")
                .setTitle("Informacion importane")
                .setNegativeButton("Cancelar",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }

                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id){
                 dialog.cancel();}
                 });
            return builder.create();
    }
}
