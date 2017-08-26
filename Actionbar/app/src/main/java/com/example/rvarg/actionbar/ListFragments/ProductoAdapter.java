package com.example.rvarg.actionbar.ListFragments;

import android.util.Log;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.List;
import com.example.rvarg.actionbar.R;





/**
 * Created by rvarg on 24/08/2017.
 */

public class ProductoAdapter extends BaseAdapter {
    private List<Producto> productos;
    public ProductoAdapter(List<Producto> contactos){this.productos=contactos;}
    @Override
    public int getCount(){return productos.size();}
    @Override
    public Object getItem(int i){return productos.get(i);}
    @Override
    public long getItemId(int i){return productos.get(i).getId();}
    @Override
    public View getView(int i,View convertView,ViewGroup viewGroup){
        View view;
        if(convertView==null){
            view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_producto,viewGroup, false);
        }
        else {
            view=convertView;
        }
        Producto producto=(Producto) getItem(i);
        TextView description=(TextView) view.findViewById(R.id.producto_descripcion);
        ImageView imagen=(ImageView) view.findViewById(R.id.producto_imagen);
        try {
            Class res=R.drawable.class;
            Field field=res.getField(producto.getImage());
            int drawableId=field.getInt(null);
            imagen.setImageResource(drawableId);
        }
        catch (Exception e){
            Log.e("Fallo","la imagen",e);
        }
        description.setText(producto.getDescription());
        return view;
    }
}
