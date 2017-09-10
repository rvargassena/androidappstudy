package com.example.rvarg.actionbar.Agenda;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rvarg.actionbar.ListFragments.Producto;
import com.example.rvarg.actionbar.R;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by rvarg on 05/09/2017.
 */

public class ContactoAdapter extends BaseAdapter {
    private List<Conctacto> list;
    private Activity activity;
    public ContactoAdapter(Activity activity, List<Conctacto> list) {
        this.activity = activity;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View v = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.infocontac, null);

        }
        Conctacto movimiento = list.get(position);
        TextView tvNombreV = (TextView) v.findViewById(R.id.tvNombreV);
        tvNombreV.setText(movimiento.getNombre());
        TextView tvNumeroV = (TextView) v.findViewById(R.id.tvNumeroV);
        tvNumeroV.setText(movimiento.getTelefono());
        TextView tvEmailV = (TextView) v.findViewById(R.id.tvEmailV);
        tvEmailV.setText(movimiento.getEmail());
        return v;
    }
}

