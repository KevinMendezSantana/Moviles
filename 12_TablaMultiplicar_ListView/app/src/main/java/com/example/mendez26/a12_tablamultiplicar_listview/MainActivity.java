package com.example.mendez26.a12_tablamultiplicar_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ListView tablaMultiplicar;

    private ArrayList<String> multiplos;
    private ArrayAdapter<String> adaptador;

    public EditText pan;

    private TextView mostrarPorcentaje;
    private SeekBar barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multiplos = new ArrayList<>();
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,multiplos);

        tablaMultiplicar = (ListView) findViewById(R.id.tabla);
        tablaMultiplicar.setAdapter(adaptador);

        mostrarPorcentaje = (TextView)findViewById(R.id.txtCargar);

        tablaMultiplicar(1);
        // SeekBar
        barra = (SeekBar)findViewById(R.id.seekBar);
        // Valor Inicial
        barra.setProgress(0);
        // Valot Final
        barra.setMax(9);
        barra.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //hace un llamado a la perilla cuando se arrastra
                    @Override
                    public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser){

                        int cantidad = Integer.parseInt(String.valueOf(progress));
                        mostrarPorcentaje.setText((cantidad+1)+"");
                        tablaMultiplicar(cantidad+1);

                    }//onProgressChanged

                    //hace un llamado  cuando se toca la perilla
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    //hace un llamado  cuando se detiene la perilla
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });

        //pan = (EditText) findViewById(R.id.caja);

    }//onCreate

    public void tablaMultiplicar(int numero){

        limpiarTabla();

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
