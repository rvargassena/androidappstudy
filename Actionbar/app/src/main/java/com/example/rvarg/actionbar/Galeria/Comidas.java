package com.example.rvarg.actionbar.Galeria;

import android.widget.TextView;

import com.example.rvarg.actionbar.R;

/**
 * Created by rvarg on 01/09/2017.
 */

public class Comidas {
    private String Nplato;
    private String Ingredientes;
    private String precio;
    private float Valoracion;
    private int imagenComida;

        public Comidas(String nplato, String ingredientes, String precio, float valoracion, int imagenComida) {
            Nplato = nplato;
            Ingredientes = ingredientes;
            this.precio = precio;
            Valoracion = valoracion;
            this.imagenComida = imagenComida;


        }
        public String getNplato() {
            return Nplato;
        }

        public void setNplato(String nplato) {
            Nplato = nplato;
        }

        public String getIngredientes() {
            return Ingredientes;
        }

        public void setIngredientes(String ingredientes) {
            Ingredientes = ingredientes;
        }

        public String getPrecio() {
            return precio;
        }

        public void setPrecio(String precio) {
            this.precio = precio;
        }

        public float getValoracion() {
            return Valoracion;
        }

        public void setValoracion(float valoracion) {
            Valoracion = valoracion;
        }

        public int getImagenComida() {
            return imagenComida;
        }

        public void setImagenComida(int imagenComida) {
            this.imagenComida = imagenComida;
        }


}
