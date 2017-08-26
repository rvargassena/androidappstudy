package com.example.rvarg.actionbar.ListFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rvarg.actionbar.R;

import java.lang.reflect.Field;

/**
 * Created by rvarg on 24/08/2017.
 */

public class DetallesProductoFragment extends Fragment{
    public static final String ID="id";
    public static final String DESCRIPCION="descripcion";
    public static final String PRECIO="precio";
    public static final String IMAGEN="imagen";
    private Producto producto;

    public static DetallesProductoFragment newInstance(Producto producto){
        DetallesProductoFragment frag=new DetallesProductoFragment();
        Bundle args= new Bundle();
        args.putInt(ID,producto.getId());
        args.putString(DESCRIPCION,producto.getDescription());
        args.putDouble(PRECIO,producto.getPrice());
        args.putString(IMAGEN,producto.getImage());
        frag.setArguments(args);
        return frag;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ID)){
            producto= new Producto(
                    getArguments().getInt(ID),
                    getArguments().getString(DESCRIPCION),
                    getArguments().getDouble(PRECIO),
                    getArguments().getString(IMAGEN));
        }
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_detalle_producto,container,false);
    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        TextView id=(TextView)getView().findViewById(R.id.id);
        id.setText("#" + String.valueOf(producto.getId()));
        TextView descripcion=(TextView) getView().findViewById(R.id.descripcion);
        descripcion.setText(producto.getDescription());
        TextView precio=(TextView)getView().findViewById(R.id.precio);
        precio.setText("$" + String.valueOf(producto.getPrice()));
        ImageView imagen=(ImageView) getView().findViewById(R.id.imagen);
        try {
            Class res=R.drawable.class;
            Field field=res.getField(producto.getImage());
            int drawableId=field.getInt(null);
            imagen.setImageResource(drawableId);
        }
        catch (Exception e){
            Log.e("Fallo","la imagen",e);
        }
    }

}
