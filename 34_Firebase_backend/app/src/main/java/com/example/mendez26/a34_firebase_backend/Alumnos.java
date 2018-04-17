package com.example.mendez26.a34_firebase_backend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Alumnos extends AppCompatActivity {
    List<Item> datos=new ArrayList<Item>();
    Button nuevo;
    RecyclerView lista;
    private DatabaseReference mDatabase;
    RecyclerView.LayoutManager layoutManager;
    boolean start=true;
    public static int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);
        nuevo=findViewById(R.id.nuevo);
        lista=findViewById(R.id.lista);
        final Adapter adapter=new Adapter(datos);
        layoutManager=new LinearLayoutManager(this);
        lista.setLayoutManager(layoutManager);
        lista.setAdapter(adapter);
        mDatabase= FirebaseDatabase.getInstance().getReference();
        mDatabase.child("alumno").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                try {
                    String nombre = dataSnapshot.child("nombre").getValue().toString();
                    String control = dataSnapshot.child("control").getValue().toString();
                    Item aux = new Item(nombre, control);
                    datos.add(aux);
                    adapter.notifyDataSetChanged();
                    if(start) {
                        index++;
                    }
                }catch(NullPointerException e){}
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start=false;
                Intent insertar=new Intent(Alumnos.this,Insertar.class);
                startActivity(insertar);
                finish();
            }
        });
    }

}
