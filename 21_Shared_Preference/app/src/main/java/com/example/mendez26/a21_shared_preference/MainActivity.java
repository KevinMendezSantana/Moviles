package com.example.mendez26.a21_shared_preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView correo;
    RadioGroup radioGroup;
    CheckBox ch1,ch2,ch3;
    Spinner signos;
    Button guardar,leer;
    int genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciamos los objetos
        correo = (TextView) findViewById(R.id.txtEmail);
        radioGroup = (RadioGroup) findViewById(R.id.rdgGrupo);
        ch1 = (CheckBox)findViewById(R.id.check1);
        ch2 = (CheckBox)findViewById(R.id.check2);
        ch3 = (CheckBox)findViewById(R.id.check3);
        signos = (Spinner)findViewById(R.id.sp_signos);
        guardar = (Button) findViewById(R.id.btn_save);
        leer = (Button) findViewById(R.id.btn_get);

        //Llenamos el spinner
        String[] letra = {"Aries","Tauro","Geminis","Cancer","Leo","Virgo","Libra","Escorpio","Sagitario","Capricornio","Acuario","Picis"};
        signos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, letra));

        //Metodo para saber que se selecciono en el genero
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                genero = checkedId;

            }//onCheckedChanged

        });//setOnCheckedChangeListener



        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarDatos();
            }
        });

        leer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperarDatos();
            }
        });

    }//onCreate

    private void guardarDatos(){
        SharedPreferences datos = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=datos.edit();

        //Correo
        editor.putString("email",correo.getText().toString());
        //Genero
        editor.putInt("gender",genero);
        //Hobbies
        editor.putBoolean("hobbie1",ch1.isChecked());
        editor.putBoolean("hobbie2",ch2.isChecked());
        editor.putBoolean("hobbie3",ch3.isChecked());
        //Signo zodiacal
        editor.putInt("zodiaco",signos.getSelectedItemPosition());

        editor.commit();
        Toast.makeText(getApplicationContext(),"Datos guardados satisfactoriamente!",Toast.LENGTH_SHORT).show();


    }//guardarDatos

    private void recuperarDatos(){
        SharedPreferences datos=getSharedPreferences("data", Context.MODE_PRIVATE);

        String email = datos.getString("email","No se proporciono ningun correo");
        int gender = datos.getInt("gender",0);
        boolean check01 = datos.getBoolean("hobbie1",false);
        boolean check02 = datos.getBoolean("hobbie2",false);
        boolean check03 = datos.getBoolean("hobbie3",false);
        int zodiaco = datos.getInt("zodiaco",0);

        //EMAIL
        correo.setText(email);

        //GENERO
        RadioButton radio = (RadioButton)findViewById(gender);
        if(radio != null){
            radio.setChecked(true);
        }else{
            Toast.makeText(getApplicationContext(),"No se selecciono el genero",Toast.LENGTH_SHORT).show();
        }

        //HOBBIES
        ch1.setChecked(check01);
        ch2.setChecked(check02);
        ch3.setChecked(check03);

        //SIGNO ZODIACAL
        signos.setSelection(zodiaco);

    }//recuperarDatos

}//MainActivity
