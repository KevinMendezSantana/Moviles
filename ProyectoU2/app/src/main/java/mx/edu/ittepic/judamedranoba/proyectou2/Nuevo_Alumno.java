package mx.edu.ittepic.judamedranoba.proyectou2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class Nuevo_Alumno extends AppCompatActivity {
    EditText nombre;
    EditText correo;
    EditText telefono;
    EditText carrera;
    EditText control;
    FloatingActionButton save;
    FeedReaderDbHelper mDbHelper;
    final Nuevo_Alumno puntero = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo__alumno);

        mDbHelper = new FeedReaderDbHelper(this.getApplicationContext());
        nombre = (EditText)findViewById(R.id.Nombre);
        correo = (EditText)findViewById(R.id.correo);
        telefono = (EditText)findViewById(R.id.telefono);
        carrera = (EditText)findViewById(R.id.carrera);
        control = (EditText)findViewById(R.id.nocontrol);
        save = (FloatingActionButton)findViewById(R.id.guardar);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nombre.getText().toString().equals("") || correo.getText().toString().equals("") ||
                        telefono.getText().toString().equals("") || carrera.getText().toString().equals("") ||
                        control.getText().toString().equals("")){
                    return;
                }

                SQLiteDatabase db = mDbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(FeedReaderContract.FeedEntry.COLUMN_NOMBRE, nombre.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_CORREO, correo.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_TELEFONO, telefono.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_CARRERA, carrera.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_NUMERO_CONTROL, control.getText().toString());
                db.insert(FeedReaderContract.FeedEntry.TABLE_ALUMNO,null,values);

                values.clear();
                values.put(FeedReaderContract.FeedEntry.COLUMN_ID_ALUMNO_FK,control.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_CREDITOS,0);
                db.insert(FeedReaderContract.FeedEntry.TABLE_ACTIVIDAD,null,values);
                puntero.finish();
            }
        });


    }


}
