package com.example.rvarg.actionbar.Galeria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rvarg.actionbar.R;

/**
 * Created by rvarg on 02/09/2017.
 */

public class AdapterComida extends BaseAdapter {
     private final Context mContext;
     private final Comidas[] items;

     public AdapterComida(Context c, Comidas[] items){
         mContext=c;
         this.items= items;
     }
     @Override

     public  int getCount(){
         return items.length -1;
     }

     @Override

     public Comidas getItem(int position){
         return items[position];
     }
     @Override

     public long getItemId(int position){
            return 0;
     }
     @Override

     public View getView(int position, View view, ViewGroup viewGroup){
            if (view==null){
                LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view=inflater.inflate(R.layout.head_comidas, viewGroup, false);
            }
         Comidas item= getItem(position);
         ImageView image=(ImageView) view.findViewById(R.id.imagen);
         Glide.with(image.getContext()).load(item.getImagenComida()).into(image);

         TextView name=(TextView)view.findViewById(R.id.nombrecomida);
         name.setText(item.getNplato());

         TextView descripcion=(TextView) view.findViewById(R.id.Ingredientes);
         descripcion.setText(item.getIngredientes());

         TextView precio=(TextView) view.findViewById(R.id.precio);
         precio.setText(item.getPrecio());

         RatingBar ratingBar=(RatingBar) view.findViewById(R.id.Valoracion);
         ratingBar.setRating(item.getValoracion());

         return view;
     }

}
