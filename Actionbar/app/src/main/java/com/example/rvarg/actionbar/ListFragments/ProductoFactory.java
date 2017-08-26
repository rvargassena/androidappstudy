package com.example.rvarg.actionbar.ListFragments;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rvarg on 24/08/2017.
 */

public class ProductoFactory {
    private List<Producto> productos;
    public ProductoFactory(){
        this.productos= new ArrayList<>();
        productos.add(new Producto(1,"Mouse",12.5,"mouse"));
        productos.add(new Producto(2,"Teclado",56,"teclado"));
        productos.add(new Producto(3,"Fuente",34,"fuente"));
        productos.add(new Producto(4,"Monitor",12.5,"monitor"));
        productos.add(new Producto(5,"Cpu",34,"cpu"));
        productos.add(new Producto(6,"Palmouse",34,"palmouse"));
        productos.add(new Producto(7,"Webcam",34,"webcam"));
        productos.add(new Producto(8,"Speakers",34,"speakers"));
        productos.add(new Producto(9,"Watch",34,"watcher"));
        productos.add(new Producto(10,"Smartv",34,"smartv"));
        productos.add(new Producto(11,"Hometeather",34,"hometeather"));ddadadklaj
    }
    public List<Producto> obtenerProductos(){return productos;}
}
