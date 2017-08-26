package com.example.rvarg.actionbar.Fragmentos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.rvarg.actionbar.R;

public class Main2Activity extends AppCompatActivity {
    private fragment3 primerfragmento;
    private fragment4 segundofragmento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar Volver=getSupportActionBar();
        Volver.setDisplayHomeAsUpEnabled(true);
    }
    public void onClickFrament1(){
        //primerfragmento.onSelected(false);
    }


}
