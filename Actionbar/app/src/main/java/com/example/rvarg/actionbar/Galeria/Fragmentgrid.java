package com.example.rvarg.actionbar.Galeria;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rvarg.actionbar.R;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

/**
 * Created by rvarg on 02/09/2017.
 */

public class Fragmentgrid extends Fragment {
    private static final String ARG_SECTION_NUMBER="section_number";
    public static Fragmentgrid newInstance (int sectionNumber){
        Fragmentgrid fragment=new Fragmentgrid();
        Bundle args=new Bundle();
        args.putInt(ARG_SECTION_NUMBER,sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.frag_principal_galeria,container, false);
        GridViewWithHeaderAndFooter grid=(GridViewWithHeaderAndFooter)rootView.findViewById(R.id.gridview);
        setUpGridView(grid);
        return rootView;
    }

    private void setUpGridView(GridViewWithHeaderAndFooter grid) {
        int section_number=getArguments().getInt(ARG_SECTION_NUMBER);
        switch (section_number){
            case 1:
                grid.addHeaderView(createHeaderView(6,Main3Activity.getDesayunos()));
                grid.setAdapter(new AdapterComida(getActivity(),Main3Activity.getDesayunos()));
                break;
            case 2:
                grid.addHeaderView(createHeaderView(6,Main3Activity.getAlmuerzos()));
                grid.setAdapter(new AdapterComida(getActivity(),Main3Activity.getAlmuerzos()));
                break;
            case 3:
                grid.addHeaderView(createHeaderView(6,Main3Activity.getPostres()));
                grid.setAdapter(new AdapterComida(getActivity(),Main3Activity.getPostres()));
                break;
            case 4:
                grid.addHeaderView(createHeaderView(6,Main3Activity.getEnsaldas()));
                grid.setAdapter(new AdapterComida(getActivity(),Main3Activity.getEnsaldas()));
                break;
        }
    }

    private View createHeaderView(int position, Comidas[] items) {
        View view;
        LayoutInflater inflater= getActivity().getLayoutInflater();
        view=inflater.inflate(R.layout.head_comidas,null,false);
        Comidas item= items[position];
        ImageView image=(ImageView) view.findViewById(R.id.imagen);
        Glide.with(image.getContext()).load(item.getImagenComida()).into(image);

        TextView name=(TextView) view.findViewById(R.id.nombrecomida);
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
