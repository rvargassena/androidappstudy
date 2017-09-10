package com.example.rvarg.actionbar.Agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.example.rvarg.actionbar.R;

/**
 * Created by rvarg on 07/09/2017.
 */

public class ConctactoActivity extends AppCompatActivity {
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    EditText etNombreE, etTelefonoE, etEmailE;
    DaoContacto daocontacto;
    Conctacto contacto;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        etNombreE = (EditText) findViewById(R.id.etNombreE);
        etTelefonoE = (EditText) findViewById(R.id.etTelefonoE);
        etEmailE = (EditText) findViewById(R.id.etEmailE);
        daocontacto = new DaoContacto(this);

        if (bundle != null) {
            contacto = new Conctacto(bundle.get("email").toString(),
                    bundle.get("phone").toString(),
                    bundle.get("nombre").toString(),
                    Integer.parseInt(bundle.get("id").toString()));
            etNombreE.setText(contacto.getNombre());
            etTelefonoE.setText(contacto.getTelefono());
            etEmailE.setText(contacto.getEmail());
        }
    }
}
