package com.example.rvarg.actionbar.ListFragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.example.rvarg.actionbar.R;

/**
 * Created by rvarg on 24/08/2017.
 */

public class ListaProductosActivity extends FragmentActivity implements ListaProductosFragment.Callbacks{
    private boolean esDoblepanel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_lista);
        if(findViewById(R.id.producto_detail_container)!=null){
            esDoblepanel=true;
        }
    }
    public void onProductoSelected(Producto producto){
        if (esDoblepanel){
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.producto_detail_container,DetallesProductoFragment.newInstance(producto))
                .commit();
        }
        else {
            Intent detailIntent= new Intent(this,DetallesProductoActivity.class);
            detailIntent.putExtra(DetallesProductoFragment.ID,producto.getId());
            detailIntent.putExtra(DetallesProductoFragment.DESCRIPCION,producto.getDescription());
            detailIntent.putExtra(DetallesProductoFragment.PRECIO,producto.getPrice());
            detailIntent.putExtra(DetallesProductoFragment.IMAGEN,producto.getImage());
            startActivity(detailIntent);
        }
    }
}
