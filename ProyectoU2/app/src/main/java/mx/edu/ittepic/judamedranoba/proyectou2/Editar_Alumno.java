package mx.edu.ittepic.judamedranoba.proyectou2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Editar_Alumno extends AppCompatActivity {
    EditText nombre;
    EditText correo;
    EditText telefono;
    EditText carrera;
    EditText control;
    FloatingActionButton save;
    FeedReaderDbHelper mDbHelper;
    final Editar_Alumno puntero = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar__alumno);

        mDbHelper = new FeedReaderDbHelper(this.getApplicationContext());
        nombre = (EditText) findViewById(R.id.Nombre);
        correo = (EditText) findViewById(R.id.correo);
        telefono = (EditText) findViewById(R.id.telefono);
        carrera = (EditText) findViewById(R.id.carrera);
        control = (EditText) findViewById(R.id.nocontrol);
        save = (FloatingActionButton) findViewById(R.id.guardar);
        control.setText(getIntent().getExtras().getString("control"));
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nombre.getText().toString().equals("") || correo.getText().toString().equals("") ||
                        telefono.getText().toString().equals("") || carrera.getText().toString().equals("") ||
                        control.getText().toString().equals("")) {
                    return;
                }

                SQLiteDatabase db = mDbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(FeedReaderContract.FeedEntry.COLUMN_NOMBRE, nombre.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_CORREO, correo.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_TELEFONO, telefono.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_CARRERA, carrera.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_NUMERO_CONTROL, control.getText().toString());

                long count = db.update(FeedReaderContract.FeedEntry.TABLE_ALUMNO, values, FeedReaderContract.FeedEntry.COLUMN_NUMERO_CONTROL + " like ?",new String[]{control.getText().toString()});

                puntero.finish();

            }
        });
        obtenerDatosAlumno();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        obtenerDatosAlumno();
    }

    private void obtenerDatosAlumno() {
        SQLiteDatabase dbb = mDbHelper.getReadableDatabase();
        String[] projection = {
                FeedReaderContract.FeedEntry.COLUMN_NOMBRE,
                FeedReaderContract.FeedEntry.COLUMN_CARRERA,
                FeedReaderContract.FeedEntry.COLUMN_CORREO,
                FeedReaderContract.FeedEntry.COLUMN_TELEFONO
        };
        Cursor c = dbb.query(
                FeedReaderContract.FeedEntry.TABLE_ALUMNO,                     // The table to query
                projection,                               // The columns to return
                FeedReaderContract.FeedEntry.COLUMN_NUMERO_CONTROL+ " = "+control.getText().toString(),                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null
        );
        c.moveToFirst();
        do{
            nombre.setText(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NOMBRE)));
            correo.setText(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_CORREO)));
            telefono.setText(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_TELEFONO)));
            carrera.setText(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_CARRERA)));
        }while(c.moveToNext());
    }
}
