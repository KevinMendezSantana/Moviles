package com.example.mendez26.a34_firebase_backend;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ListaViewHolder>{
    List<Item> datos;
    public Adapter(List<Item> datos){
        this.datos=datos;
    }
    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ListaViewHolder listaViewHolder=new ListaViewHolder(v);
        return listaViewHolder;
    }

    @Override
    public void onBindViewHolder(ListaViewHolder holder, int position) {
        holder.nombre.setText(datos.get(position).getNombre());
        holder.control.setText(datos.get(position).getControl());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ListaViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,control;
        public ListaViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombre);
            control=itemView.findViewById(R.id.control);
        }
    }
}
