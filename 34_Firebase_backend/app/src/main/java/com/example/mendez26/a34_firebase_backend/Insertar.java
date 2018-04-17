package com.example.mendez26.a34_firebase_backend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Insertar extends AppCompatActivity {
    TextView nombre,control;
    Button insertar;
    DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        mDatabase=FirebaseDatabase.getInstance().getReference();
        nombre=findViewById(R.id.nombre);
        control=findViewById(R.id.control);
        insertar=findViewById(R.id.insertar);
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference index=mDatabase.child("alumno").child(Alumnos.index+"");
                DatabaseReference dbNombre=index.child("nombre");
                DatabaseReference dbControl=index.child("control");
                dbNombre.setValue(nombre.getText().toString());
                dbControl.setValue(control.getText().toString());
                Toast.makeText(Insertar.this,"Insertado",Toast.LENGTH_LONG).show();
                Alumnos.index++;
                Intent alumnos=new Intent(Insertar.this,Alumnos.class);
                startActivity(alumnos);
                finish();
            }
        });
    }
}
