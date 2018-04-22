package com.example.mendez26.a41_threads_doinbackground;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaramos las variables que apuntaran a nuestros objetos
    ProgressBar barra, barra2;
    Button boton,boton2;
    EditText limite,limite2;
    TextView txt1,txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Apuntamos a los objetos
        barra = findViewById(R.id.progressBar);
        barra2 = findViewById(R.id.progressBar2);
        boton = findViewById(R.id.btnIngresar);
        boton2 = findViewById(R.id.btnIngresar2);
        limite = findViewById(R.id.txtIngresar);
        limite2 = findViewById(R.id.txtIngresar2);
        txt1 = findViewById(R.id.contador1);
        txt2 = findViewById(R.id.contador2);

        //Añadimos el evento al boton que ejecutara una nueva tarea asincrona
        boton.setOnClickListener((View view) ->{
            barra.setMax(Integer.parseInt(limite.getText().toString()));
            boton.setClickable(false);
            AsyncTask_load hilo1 = new AsyncTask_load(barra,Integer.parseInt(limite.getText().toString()),boton,txt1);
            hilo1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        });

        //Añadimos el evento al boton que ejecutara una nueva tarea asincrona
        boton2.setOnClickListener((View view) ->{
            barra2.setMax(Integer.parseInt(limite2.getText().toString()));
            boton2.setClickable(false);
            AsyncTask_load hilo1 = new AsyncTask_load(barra2,Integer.parseInt(limite2.getText().toString()),boton2,txt2);
            hilo1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        });


    }//onCreate

    private void unSegundo() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class AsyncTask_load extends AsyncTask<Void, Integer, Void>{

        ProgressBar bar;
        int progreso,maximo;
        Button btn;
        TextView txt;

        public AsyncTask_load(ProgressBar bar, int limite,Button btn,TextView textview){
                this.bar = bar;
                this.maximo = limite;
                this.btn = btn;
                this.txt = textview;
        }//Constructor

        @Override
        protected void onPreExecute(){
            progreso = 0;
            this.txt.setText(""+progreso);
            super.onPreExecute();
            this.bar.setMax(this.maximo);
        }//onPreExecute

        @Override
        protected Void doInBackground(Void... params) {

            while(progreso < this.bar.getMax()){
                    progreso++;
                    publishProgress(progreso);
                    unSegundo();
            }//while

            return null;
        }//doInBackground

        @Override
        protected void onProgressUpdate(Integer... values){
            super.onProgressUpdate(values);
            this.bar.setProgress(values[0]);
            this.txt.setText(""+values[0]);
        }//onProgressUpdate

        @Override
        protected void onPostExecute(Void result){
            btn.setClickable(true);
        }//onPostExecute


    }//AsyncTask_load

}//MainActivity
