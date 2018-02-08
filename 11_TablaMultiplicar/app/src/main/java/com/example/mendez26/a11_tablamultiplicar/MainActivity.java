package com.example.mendez26.a11_tablamultiplicar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText pan;
    public TextView respuestas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pan = (EditText)findViewById(R.id.pantalla);
        respuestas = (TextView) findViewById(R.id.resultados);

    }//onCreate

    public void tablaMultiplicar(View v){

        int numero = Integer.parseInt(pan.getText().toString());
        String cadena = "";

        for(int i = 1;i<=20;i++){

            cadena += numero + " x " + i + " = " + (numero*i) +"\n";

        }//for

        respuestas.setText(cadena);

    }//tablaMultiplicar

}//class
