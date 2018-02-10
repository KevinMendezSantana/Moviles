package com.example.mendez26.a12_tablamultiplicar_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ListView tablaMultiplicar;

    private ArrayList<String> multiplos;
    private ArrayAdapter<String> adaptador;

    public EditText pan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multiplos = new ArrayList<>();
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,multiplos);

        tablaMultiplicar = (ListView) findViewById(R.id.tabla);
        tablaMultiplicar.setAdapter(adaptador);

        pan = (EditText) findViewById(R.id.caja);

    }//onCreate

    public void tablaMultiplicar(View v){

        limpiarTabla();
        int numero = Integer.parseInt(pan.getText().toString());

        for(int i = 1; i <= 20; i++){

            multiplos.add(numero + " x " + i + " = " + (numero*i));

        }//for

        adaptador.notifyDataSetChanged();

    }//tablaMultiplicar

    public void limpiarTabla(){

        int elementos = multiplos.size();
        for(int i=0; i<elementos;i++){
            multiplos.remove(0);
        }//for

    }//limpiarTabla


}//class
