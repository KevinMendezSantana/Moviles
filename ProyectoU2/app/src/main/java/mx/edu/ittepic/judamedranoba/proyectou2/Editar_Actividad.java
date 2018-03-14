package mx.edu.ittepic.judamedranoba.proyectou2;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;

public class Editar_Actividad extends AppCompatActivity {

    EditText actividad;
    Button ini;
    Button fin;
    NumberPicker creditos;
    FloatingActionButton guardar;
    FloatingActionButton eliminar;
    FeedReaderDbHelper mDbHelper;
    final Editar_Actividad puntero = this;
    DatePickerDialog datePickerDialog;
    String ID;

    int mYear;
    int mMonth;
    int mDay;
    int amYear;
    int amMonth;
    int amDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar__actividad);

        ID = getIntent().getExtras().getString("id");
        mDbHelper = new FeedReaderDbHelper(this.getApplicationContext());
        actividad = (EditText)findViewById(R.id.actividad);
        ini = (Button)findViewById(R.id.inicio);
        fin = (Button) findViewById(R.id.finall);
        creditos = (NumberPicker) findViewById(R.id.numberPicker);
        creditos.setMaxValue(100);
        creditos.setMinValue(1);
        guardar = (FloatingActionButton) findViewById(R.id.nuevo);
       // eliminar= (FloatingActionButton) findViewById(R.id.elimiar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(actividad.getText().toString().equals("") || ini.getText().toString().equals("") ||
                        fin.getText().toString().equals("")){
                    return;
                }
                SQLiteDatabase db = mDbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(FeedReaderContract.FeedEntry.COLUMN_ACTIVIDAD, actividad.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_FECHA_INICIO, ini.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_FECHA_FIN, fin.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_CREDITOS, creditos.getValue());
                db.update(FeedReaderContract.FeedEntry.TABLE_ACTIVIDAD,values,FeedReaderContract.FeedEntry.COLUMN_ID + "= ?",new String[]{ID});
                puntero.finish();
            }
        });

        ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // date picker dialog
                datePickerDialog = new DatePickerDialog(Editar_Actividad.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                ini.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, amYear, amMonth, amDay);
                datePickerDialog.show();
            }
        });

        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // date picker dialog
                datePickerDialog = new DatePickerDialog(Editar_Actividad.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                fin.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        obtenerDatosActividad();
    }

    private void obtenerDatosActividad() {
        SQLiteDatabase dbb = mDbHelper.getReadableDatabase();
        String[] projection = {
                FeedReaderContract.FeedEntry.COLUMN_ACTIVIDAD,
                FeedReaderContract.FeedEntry.COLUMN_FECHA_INICIO,
                FeedReaderContract.FeedEntry.COLUMN_FECHA_FIN,
                FeedReaderContract.FeedEntry.COLUMN_CREDITOS
        };
        Cursor c = dbb.query(
                FeedReaderContract.FeedEntry.TABLE_ACTIVIDAD,
                projection,                               // The columns to return
                FeedReaderContract.FeedEntry.COLUMN_ID + " = "+ID,
                null,                            // The values for the WHERE clause
                null,
                null,                                     // don't filter by row groups
                null
        );
        c.moveToFirst();
        do{
            actividad.setText(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_ACTIVIDAD)));
            ini.setText(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_FECHA_INICIO)));
            amYear = Integer.parseInt(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_FECHA_INICIO)).split("/")[2]);
            amMonth = Integer.parseInt(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_FECHA_INICIO)).split("/")[1]);
            amDay = Integer.parseInt(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_FECHA_INICIO)).split("/")[0]);
            mYear = Integer.parseInt(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_FECHA_FIN)).split("/")[2]);
            mMonth = Integer.parseInt(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_FECHA_FIN)).split("/")[1]);
            mDay = Integer.parseInt(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_FECHA_FIN)).split("/")[0]);
            fin.setText(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_FECHA_FIN)));
            creditos.setValue(Integer.parseInt(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_CREDITOS))));
        }while(c.moveToNext());
    }
}

