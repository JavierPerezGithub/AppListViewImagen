package com.example.a21650521.applistviewimagen;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 21650521 on 22/11/2017.
 */

public class ListaAdaptador extends BaseAdapter {

    public ListaAdaptador(MainActivity contexto, int idView, ArrayList<ItemLista> lista) {
        this.lista = lista;
        this.idView = idView;
        this.contexto = contexto;
    }

    private ArrayList<ItemLista> lista;
    private int idView;
    private Context contexto;

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    private class Item {
        ImageView imagen;
        TextView textoSup;
        TextView textoInf;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        Item elemento;
        if (view == null) {
            view = LayoutInflater.from(contexto).inflate(idView, null);
            elemento = new Item();
            elemento.imagen = (ImageView) view.findViewById(R.id.imageView);
            elemento.textoSup = (TextView) view.findViewById(R.id.tvSuperior);
            elemento.textoInf = (TextView) view.findViewById(R.id.tvInferior);
            view.setTag(elemento);
        } else {
            elemento = (Item) view.getTag();
        }

        elemento.imagen.setImageResource(lista.get(i).getIdImagen());
        elemento.textoSup.setText(lista.get(i).getTxtSuperior());
        elemento.textoInf.setText(lista.get(i).getTxtInferior());
        return view;
    }
}
