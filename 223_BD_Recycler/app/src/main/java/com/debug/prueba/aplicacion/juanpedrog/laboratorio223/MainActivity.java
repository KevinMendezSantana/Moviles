package com.debug.prueba.aplicacion.juanpedrog.laboratorio223;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView clave,nombre,salario;
    Button add,remove,update,show;
    RecyclerView lista;
    SqliteHelper db_helper;
    List<Datos> datos;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos=new ArrayList<Datos>();
        clave=findViewById(R.id.txtClave);
        nombre=findViewById(R.id.txtNombre);
        salario=findViewById(R.id.txtSalario);
        add=findViewById(R.id.btnAdd);
        remove=findViewById(R.id.btnEliminar);
        update=findViewById(R.id.btnUpdate);
        show=findViewById(R.id.btnMostrar);
        lista=findViewById(R.id.lista);
        layoutManager=new LinearLayoutManager(this);
        Datos ejemplo=new Datos("dakj","kdajf","dsjkf");
        datos.add(ejemplo);
        Adapter adapter=new Adapter(datos);
        lista.setAdapter(adapter);
        lista.setLayoutManager(layoutManager);


        db_helper=new SqliteHelper(this);
        db_helper.openDB();
        addData();
        showData();
        updateData();
        deleteData();
    }
    public void addData(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted=db_helper.insertData(clave.getText().toString(),nombre.getText().toString(),salario.getText().toString() );
                if(isInserted){
                    Toast.makeText(MainActivity.this,"Insertado",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Error al insertar",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void showData(){
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=db_helper.getAllData();
                if(res.getCount()==0){
                    return;
                }
                while(res.moveToNext()){
                    Datos aux=new Datos(res.getString(1),res.getString(2),res.getString(3));
                    datos.add(aux);
                }
                Adapter adapter=new Adapter(datos);
                lista.setAdapter(adapter);
                lista.setLayoutManager(layoutManager);
            }
        });
    }
    public void updateData(){
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(db_helper.updateData(clave.getText().toString(),nombre.getText().toString(),salario.getText().toString())){
                    Toast.makeText(MainActivity.this,"Actualizado",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Error al actualizar",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void deleteData(){
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deleteRows=db_helper.deleteData(clave.getText().toString());
                if(deleteRows>0){
                    Toast.makeText(MainActivity.this,"Eliminado",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Error al eliminar",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
