package com.debug.prueba.aplicacion.juanpedrog.laboratorio223;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by juanpedrog on 5/03/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ListaViewHolder>{
    List<Datos> lista;

    public Adapter(List<Datos> lista){
        this.lista=lista;
    }
    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ListaViewHolder listaViewHolder=new ListaViewHolder(view);
        return listaViewHolder;
    }

    @Override
    public void onBindViewHolder(ListaViewHolder holder, int position) {
        holder.clave.setText(lista.get(position).getClave());
        holder.nombre.setText(lista.get(position).getNombre());
        holder.salario.setText(lista.get(position).getSalario());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ListaViewHolder extends RecyclerView.ViewHolder{
        TextView clave;
        TextView nombre;
        TextView salario;
        public ListaViewHolder(View itemView) {
            super(itemView);
            clave=itemView.findViewById(R.id.lblClave);
            nombre=itemView.findViewById(R.id.lblNombre);
            salario=itemView.findViewById(R.id.lblSalario);
        }
    }

}
