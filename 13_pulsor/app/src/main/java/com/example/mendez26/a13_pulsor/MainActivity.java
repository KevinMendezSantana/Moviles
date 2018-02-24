package com.example.mendez26.a13_pulsor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtnum,txtnumR, txtRes;
    Button btnParar;
    float numeroRandom;
    int intentos = 1;
    int i=0;
    boolean para=true;
    int tiempo=500;
    float[] numeros={1f,1.1f,1.2f,1.3f,1.4f,1.5f,1.6f,1.7f,1.8f,1.9f,2f,2.1f,
            2.2f,2.3f,2.4f,2.5f,2.6f,2.7f,2.8f,2.9f,3f,3f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnum=findViewById(R.id.txtnum);
        txtnumR=findViewById(R.id.txtnumR);
        txtRes=findViewById(R.id.txtRes);
        btnParar=findViewById(R.id.btnParar);
        numeroRandom=(int)(Math.random()*20+10);
        numeroRandom=numeroRandom/10;
        txtnumR.setText(numeroRandom+"");

    }//onCreate

    public void detener(View v){
        if(para) {
            para = false;
            btnParar.setText("Reiniciar");
        }//if
        else{
            para =true;
            update();
            numeroRandom=(int)(Math.random()*20+10);
            numeroRandom=numeroRandom/10;
            txtnumR.setText(numeroRandom+"");
            txtRes.setText("");
            btnParar.setText("Detener");
        }//else

    }//detener

    public void salir(View v){
        System.exit(0);
    }//salir

    protected void onStart() {
        super.onStart();
        update();
    }//onStart

    public void update(){
        txtnum.setText(numeros[i]+"");
        i++;
        if(i==numeros.length){
            i=0;
        }
        new java.util.Timer().schedule(

                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        // your code here, and if you have to refresh UI put this code:
                        runOnUiThread(new   Runnable() {
                            public void run() {
                                //your code
                                if(para) {
                                    update();
                                }
                                else{
                                    if(numeros[i-1]==numeroRandom){
                                        txtRes.setText("Ganaste en "+intentos +" intento(s)");
                                        tiempo=tiempo-50;
                                        intentos = 1;
                                    }else {
                                        txtRes.setText("Perdiste");
                                        tiempo=500;
                                        intentos++;
                                    }
                                }
                            }
                        });
                    }
                },
                tiempo
        );
    }//update

}//class
