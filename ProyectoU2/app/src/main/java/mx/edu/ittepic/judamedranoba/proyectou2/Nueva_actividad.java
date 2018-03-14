package mx.edu.ittepic.judamedranoba.proyectou2;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.util.Calendar;

public class Nueva_actividad extends AppCompatActivity {

    EditText actividad;
    Button ini;
    Button fin;
    NumberPicker creditos;
    FloatingActionButton guardar;
    FeedReaderDbHelper mDbHelper;
    final Nueva_actividad puntero = this;
    String control;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_actividad);

        control = getIntent().getExtras().getString("control");
        mDbHelper = new FeedReaderDbHelper(this.getApplicationContext());
        actividad = (EditText)findViewById(R.id.actividad);
        ini = (Button)findViewById(R.id.inicio);
        fin = (Button) findViewById(R.id.finall);
        creditos = (NumberPicker) findViewById(R.id.numberPicker);
        creditos.setMaxValue(100);
        creditos.setMinValue(1);
        guardar = (FloatingActionButton) findViewById(R.id.nuevo);

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
                values.put(FeedReaderContract.FeedEntry.COLUMN_ID_ALUMNO_FK, control);
                db.insert(FeedReaderContract.FeedEntry.TABLE_ACTIVIDAD,null,values);
                puntero.finish();
            }
        });

        ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(Nueva_actividad.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                ini.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(Nueva_actividad.this,
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
    }
}
