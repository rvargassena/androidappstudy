package com.example.rvarg.actionbar.ListFragments;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.rvarg.actionbar.R;

/**
 * Created by rvarg on 24/08/2017.
 */

public class DetallesProductoActivity extends AppCompatActivity {
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_detail);
        ActionBar Volver=getSupportActionBar();
        Volver.setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState==null){
            Producto producto=new Producto(
                    getIntent().getIntExtra(DetallesProductoFragment.ID,0),
                    getIntent().getStringExtra(DetallesProductoFragment.DESCRIPCION),
                    getIntent().getDoubleExtra(DetallesProductoFragment.PRECIO,0),
                    getIntent().getStringExtra(DetallesProductoFragment.IMAGEN));
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.producto_detail_container,DetallesProductoFragment.newInstance(producto))
                    .commit();
        }
    }
}
