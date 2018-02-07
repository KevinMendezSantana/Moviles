package com.example.mendez26.juegogato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Contador de turnos
    //Impares son X y pares son O
    public int turno = 1,gameover = 0;
    public Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btnVolver = (Button)findViewById(R.id.btnVolver);
        btnVolver.setEnabled(false);
    }

    public void marca1(View v){

        if(turno%2 == 0){
            btn1.setText("O");
        }//if turno%2
        else{
            btn1.setText("X");
        }
        turno++;
        juegoGanado();
        btn1.setEnabled(false);

    }//marca1

    public void marca2(View v){

        if(turno%2 == 0){
            btn2.setText("O");
        }//if turno%2
        else{
            btn2.setText("X");
        }
        turno++;
        juegoGanado();
        btn2.setEnabled(false);

    }//marca2

    public void marca3(View v){

        if(turno%2 == 0){
            btn3.setText("O");
        }//if turno%2
        else{
            btn3.setText("X");
        }
        turno++;
        juegoGanado();
        btn3.setEnabled(false);

    }//marca3

    public void marca4(View v){

        if(turno%2 == 0){
            btn4.setText("O");
        }//if turno%2
        else{
            btn4.setText("X");
        }
        turno++;
        juegoGanado();
        btn4.setEnabled(false);

    }//marca4

    public void marca5(View v){

        if(turno%2 == 0){
            btn5.setText("O");
        }//if turno%2
        else{
            btn5.setText("X");
        }
        turno++;
        juegoGanado();
        btn5.setEnabled(false);

    }//marca5

    public void marca6(View v){

        if(turno%2 == 0){
            btn6.setText("O");
        }//if turno%2
        else{
            btn6.setText("X");
        }
        turno++;
        juegoGanado();
        btn6.setEnabled(false);

    }//marca6

    public void marca7(View v){

        if(turno%2 == 0){
            btn7.setText("O");
        }//if turno%2
        else{
            btn7.setText("X");
        }
        turno++;
        juegoGanado();
        btn7.setEnabled(false);

    }//marca7

    public void marca8(View v){

        if(turno%2 == 0){
            btn8.setText("O");
        }//if turno%2
        else{
            btn8.setText("X");
        }
        turno++;
        juegoGanado();
        btn8.setEnabled(false);

    }//marca8

    public void marca9(View v){

        if(turno%2 == 0){
            btn9.setText("O");
        }//if turno%2
        else{
            btn9.setText("X");
        }
        turno++;
        juegoGanado();
        btn9.setEnabled(false);

    }//marca9

    public void deshabilitarBotones(String ganador){

        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);

        Toast.makeText(this,"GANADOR " + ganador,Toast.LENGTH_LONG).show();
        btnVolver.setEnabled(true);
        gameover = 1;

    }//deshabilitarBotones

    public void juegoGanado(){

        //LINEAS HORIZONTALES

        if(btn1.getText().equals(btn2.getText()) && btn1.getText().equals(btn3.getText()) && (btn1.getText().equals("X") || btn1.getText().equals("O"))){

            //Mostrar mensaje
            deshabilitarBotones(btn1.getText().toString());

        }//linea de arriba horizontal

        if(btn4.getText().equals(btn5.getText()) && btn4.getText().equals(btn6.getText()) && (btn4.getText().equals("X") || btn4.getText().equals("O"))){

            //Mostrar mensaje
            deshabilitarBotones(btn4.getText().toString());

        }//linea de en medio horizontal

        if(btn7.getText().equals(btn8.getText()) && btn7.getText().equals(btn9.getText()) && (btn7.getText().equals("X") || btn7.getText().equals("O"))){

            //Mostrar mensaje
            deshabilitarBotones(btn7.getText().toString());

        }//linea de abajo horizontal

        //LINEAS VERTICALES

        if(btn1.getText().equals(btn4.getText()) && btn1.getText().equals(btn7.getText()) && (btn1.getText().equals("X") || btn1.getText().equals("O"))){

            //Mostrar mensaje
            deshabilitarBotones(btn1.getText().toString());

        }//linea de la izquierda vertical

        if(btn2.getText().equals(btn5.getText()) && btn2.getText().equals(btn8.getText()) && (btn2.getText().equals("X") || btn2.getText().equals("O"))){

            //Mostrar mensaje
            deshabilitarBotones(btn2.getText().toString());

        }//linea de en medio vertical

        if(btn3.getText().equals(btn6.getText()) && btn3.getText().equals(btn9.getText()) && (btn3.getText().equals("X") || btn3.getText().equals("O"))){

            //Mostrar mensaje
            deshabilitarBotones(btn3.getText().toString());

        }//linea de la derecha vertical

        //LINEAS CRUZADAS

        if(btn1.getText().equals(btn5.getText()) && btn1.getText().equals(btn9.getText()) && (btn1.getText().equals("X") || btn1.getText().equals("O"))){

            //Mostrar mensaje
            deshabilitarBotones(btn1.getText().toString());

        }//linea cruzada de izquierda a derecha

        if(btn3.getText().equals(btn5.getText()) && btn3.getText().equals(btn7.getText()) && (btn3.getText().equals("X") || btn3.getText().equals("O"))){

            //Mostrar mensaje
            deshabilitarBotones(btn3.getText().toString());

        }//linea cruzada de derecha a izquierda

        if(turno == 10 && gameover == 0){

            Toast.makeText(this,"Gato encerrado",Toast.LENGTH_LONG).show();

            btn1.setText("");
            btn2.setText("");
            btn3.setText("");
            btn4.setText("");
            btn5.setText("");
            btn6.setText("");
            btn7.setText("");
            btn8.setText("");
            btn9.setText("");

            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            btn5.setEnabled(true);
            btn6.setEnabled(true);
            btn7.setEnabled(true);
            btn8.setEnabled(true);
            btn9.setEnabled(true);

            turno = 1;

        }//GatoEncerrado

    }//juegoGanado

    public void jugarOtraVez(View v){

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btnVolver.setEnabled(false);

        turno = 1;

    }//jugarOtraVez

}//class
