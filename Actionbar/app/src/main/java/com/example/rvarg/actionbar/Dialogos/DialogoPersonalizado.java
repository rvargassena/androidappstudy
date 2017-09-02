package com.example.rvarg.actionbar.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.rvarg.actionbar.R;

/**
 * Created by rvarg on 30/08/2017.
 */

public class DialogoPersonalizado extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.mensajes_personalizado,null))
                .setPositiveButton("Ingresar",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Welcome to the Jungle",Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Esperamos que vuelvas",Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
