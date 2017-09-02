package com.example.rvarg.actionbar.Dialogos;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

import com.example.rvarg.actionbar.R;

public class Main4Activity extends FragmentActivity {
    private Button btnAlerta=null;
    private Button btnSeleccion=null;
    private Button btnConfirmacion=null;
    private Button btnMensajep=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4layout);
        btnAlerta=(Button)findViewById(R.id.BtnAlerta);
        btnSeleccion=(Button)findViewById(R.id.botonselecion);
        btnConfirmacion=(Button)findViewById(R.id.botonconfirmacion);
        btnMensajep=(Button)findViewById(R.id.botonpersonalizado);

        btnAlerta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                DialogoAlerta dialogo= new DialogoAlerta();
                dialogo.show(fragmentManager,"tagAlerta");
            }
        });
        btnSeleccion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                DialogoSeccion dialogo= new DialogoSeccion();
                dialogo.show(fragmentManager,"tagAlerta");
            }
        });

        btnMensajep.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                DialogoPersonalizado dialogo= new DialogoPersonalizado();
                dialogo.show(fragmentManager,"tagAlerta");
            }
        });

    }
}
