package com.example.rvarg.actionbar.ListFragments;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.rvarg.actionbar.R;

import java.util.List;

/**
 * Created by rvarg on 24/08/2017.
 */

public class ListaProductosFragment extends Fragment {
    private ListView lista;
    private List<Producto>productos;
    private Callbacks callback;
    public interface Callbacks {
        public void onProductoSelected(Producto producto);
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        productos= new ProductoFactory().obtenerProductos();
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try {
                callback=(Callbacks) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.getClass().getName() + "debe implementar la interface Callbacks");
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState){
        return inflater.inflate(R.layout.fragment_listado_productos,container,false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        lista=(ListView) getView();
        lista.setAdapter(new ProductoAdapter(productos));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                callback.onProductoSelected((Producto) lista.getItemAtPosition(position));
            }
        });
    }

}
