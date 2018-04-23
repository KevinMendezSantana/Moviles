package com.example.mendez26.laboratorio_2304_asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView serie;
    Button btn;
    EditText numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serie = findViewById(R.id.txtSerie);
        btn = findViewById(R.id.btnIniciar);
        numero = findViewById(R.id.txtIngresar);


        //Añadimos el evento al boton que ejecutara una nueva tarea asincrona
        btn.setOnClickListener((View view) ->{
            btn.setClickable(false);
            AsyncTask_load hilo1 = new AsyncTask_load(btn,serie,Integer.parseInt(numero.getText().toString()));
            hilo1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        });

    }//onCreate

    private void unSegundo() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class AsyncTask_load extends AsyncTask<Void, Integer, Void>{

        int numero,limite,numAnt,numDes;
        Button btn;
        TextView txt;
        String cadena = "";

        public AsyncTask_load(Button btn,TextView textview,int limite){
            this.limite = limite;
            this.btn = btn;
            this.txt = textview;
        }//Constructor

        @Override
        protected void onPreExecute(){
            numero = 0;
            numAnt = 0;
            numDes = 1;
            super.onPreExecute();

        }//onPreExecute

        @Override
        protected Void doInBackground(Void... params) {

            while(this.numero < this.limite){
                numero++;
                int resultado = numAnt + numDes;
                publishProgress(numAnt);
                numAnt = numDes;
                numDes = resultado;
                unSegundo();
            }//while

            return null;
        }//doInBackground

        @Override
        protected void onProgressUpdate(Integer... values){
            super.onProgressUpdate(values);
            this.cadena += values[0].toString() + "\n";
            this.txt.setText(this.cadena);
        }//onProgressUpdate

        @Override
        protected void onPostExecute(Void result){
            btn.setClickable(true);
        }//onPostExecute


    }//AsyncTask_load

}//MainActivity
