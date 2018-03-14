package com.example.mendez26.a231_persitencia_archivos;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText textBox;
    static final int READ_BLOCK_SIZE = 100;
    boolean sdDisponible = false;
    boolean sdAccesoEscritura = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox = (EditText) findViewById(R.id.editText);
    }

    public void onClickSave(View view) {
        //Comprobamos el estado de la memoria
        estadoSD();
        if(sdDisponible) {

            if(sdAccesoEscritura) {

                String str = textBox.getText().toString();
                try {
                    //Creamos el archivo en la raiz y le damos nombre a dicho archivo
                    File ruta_sd = Environment.getExternalStorageDirectory();
                    File f = new File(ruta_sd.getAbsolutePath(), "file_sd.txt");

                    OutputStreamWriter fout =
                            new OutputStreamWriter(
                                    new FileOutputStream(f));

                    //Escribimos en el archivo el contenido del TextView
                    fout.write(str);
                    fout.close();
                    textBox.setText("");
                    Toast.makeText(getApplicationContext(),"File save Successfully",Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
                }

            }else{
                Toast.makeText(getApplicationContext(),"La memoria SD esta disponible pero no se cuentan con permisos de escritura.",Toast.LENGTH_SHORT).show();
            }//sdAccesoEscritura

        }else{
            Toast.makeText(getApplicationContext(),"La memoria SD no se encuentra disponible.",Toast.LENGTH_SHORT).show();
        }//sdDisponible

    }//onClickSave

    public void onClickLoad(View view) {
        try {
            //Cargamos el archivo, para le decimos la ruta y el nombre
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "file_sd.txt");

            BufferedReader fin =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(f)));
            //Realizamos la lectura del archivo y la almacenamos en un String
            String texto = fin.readLine();
            fin.close();
            //Le asignamos el texto recuperado al TextView
            textBox.setText(texto);
            Toast.makeText(getApplicationContext(),"File Load Successfully.",Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Log.e("Ficheros", "Error al leer fichero desde tarjeta SD");
        }

    }//onClickLoad

    public void estadoSD(){

        //Comprobamos el estado de la memoria externa (tarjeta SD)
        String estado = Environment.getExternalStorageState();

        if (estado.equals(Environment.MEDIA_MOUNTED)) {
            //Esta disponible y se tienen permisos de lectura y escritura.
            sdDisponible = true;
            sdAccesoEscritura = true;

        }else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            //Esta disponible pero solo se tienen permisos de lectura
            sdDisponible = true;
            sdAccesoEscritura = false;

        }else{
            //Algun otro estado de la SD que no nos permite acceder a la SD o que no tiene permisos
            sdDisponible = false;
            sdAccesoEscritura = false;

        }

    }//estadoSD

}//MainActivity
