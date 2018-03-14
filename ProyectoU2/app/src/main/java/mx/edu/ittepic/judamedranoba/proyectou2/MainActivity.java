package mx.edu.ittepic.judamedranoba.proyectou2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    ArrayList conceptosArray;
    Vector ID_Vector;
    FeedReaderDbHelper mDbHelper;
    ListView lista;
    final MainActivity puntero = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new FeedReaderDbHelper(this.getApplicationContext());
        conceptosArray = new ArrayList();
        ID_Vector = new Vector();

        lista = (ListView)findViewById(R.id.Lista);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(puntero, Actividades.class);
                intent.putExtra("control",(ID_Vector.get(i)).toString());
                startActivityForResult(intent,2);
            }
        });

        FloatingActionButton boton = (FloatingActionButton)findViewById(R.id.nuevo);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(puntero, Nuevo_Alumno.class);
                startActivityForResult(intent,2);
            }
        });
        this.obtenerDatos();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.obtenerDatos();
    }

    private void obtenerDatos() {
        SQLiteDatabase dbb = mDbHelper.getReadableDatabase();
        String[] projection = {
                FeedReaderContract.FeedEntry.COLUMN_NUMERO_CONTROL,
                FeedReaderContract.FeedEntry.COLUMN_NOMBRE,
                "SUM("+FeedReaderContract.FeedEntry.COLUMN_CREDITOS+") as CREDITOS"
        };
        Cursor c = dbb.query(
                FeedReaderContract.FeedEntry.TABLE_ALUMNO+","+FeedReaderContract.FeedEntry.TABLE_ACTIVIDAD,                     // The table to query
                projection,                               // The columns to return
                FeedReaderContract.FeedEntry.COLUMN_NUMERO_CONTROL + " = "+FeedReaderContract.FeedEntry.COLUMN_ID_ALUMNO_FK,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                FeedReaderContract.FeedEntry.COLUMN_NUMERO_CONTROL,                                     // don't group the rows
                null,                                     // don't filter by row groups
                FeedReaderContract.FeedEntry.COLUMN_NOMBRE + " ASC"
        );
        ID_Vector.removeAllElements();
        conceptosArray.removeAll(conceptosArray);

        if(c.getCount()<1){
            lista.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,new String [] {}));
            return;
        }
        c.moveToFirst();
        do{
            String id = c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NUMERO_CONTROL));
            ID_Vector.add(id);
            String autor = c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NOMBRE));
            String a = c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_CREDITOS));
            conceptosArray.add(autor+"\n"+"Creditos: "+a);
        }while(c.moveToNext());
        lista.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,conceptosArray));
    }
}
