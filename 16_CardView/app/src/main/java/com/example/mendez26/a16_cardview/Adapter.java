package com.example.mendez26.a16_cardview;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by mendez26 on 26/02/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ListaViewHolder>{
    String[][] datos;
    public Adapter(String[][] datos){
        this.datos=datos;
    }
    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        ListaViewHolder listaViewHolder=new ListaViewHolder(v);
        return listaViewHolder;
    }

    @Override
    public void onBindViewHolder(ListaViewHolder holder, int position) {
        holder.lblTitulo.setText(datos[position][0]);
        holder.lblDescripcion.setText(datos[position][1]);
    }

    @Override
    public int getItemCount() {
        return datos.length;
    }

    public static class ListaViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView lblTitulo,lblDescripcion;
        public ListaViewHolder(View itemView) {
            super(itemView);
            String[] colores={"#ffd700","#192931","#ff0cff","#504438","#ee0000","#ff82ab","#0091ff","#9846dd","#9aff9a"};
            itemView.setBackgroundColor(Color.parseColor(colores[(int)(new Random().nextInt(9))]));
            lblTitulo=itemView.findViewById(R.id.lblTitulo);
            lblDescripcion=itemView.findViewById(R.id.lblDescripcion);

        }
    }
}