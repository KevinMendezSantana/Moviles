package com.example.mendez26.a34_firebase_backend;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView email,password;
    Button registro, acceder;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        registro=findViewById(R.id.registro);
        acceder=findViewById(R.id.acceder);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(email.getText())){
                    Toast.makeText(getApplicationContext(), "Introduce un email", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(password.getText())){
                    Toast.makeText(getApplicationContext(), "Introduce una contraseña", Toast.LENGTH_LONG).show();
                    return;
                }
                registrar();
            }
        });
        acceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(email.getText())){
                    Toast.makeText(getApplicationContext(), "Introduce un email", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(password.getText())){
                    Toast.makeText(getApplicationContext(), "Introduce una contraseña", Toast.LENGTH_LONG).show();
                    return;
                }
                entrar();
            }
        });
    }
    public void registrar(){
        progressDialog.setMessage("Registrando usuario...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Registro exitoso",Toast.LENGTH_LONG).show();
                }else{
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Registro fallido",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void entrar(){
        progressDialog.setMessage("Accediendo...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Acceso exitoso",Toast.LENGTH_LONG).show();
                    Intent alumnos=new Intent(getApplicationContext(),Alumnos.class);
                    startActivity(alumnos);
                    finish();
                }else{
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Acceso fallido",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
