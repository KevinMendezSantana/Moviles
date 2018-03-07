package com.debug.prueba.aplicacion.juanpedrog.laboratorio223;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by juanpedrog on 5/03/18.
 */

public class SqliteHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME="empleados.db";
    private final static int DATABASE_VERSION=1;
    private final static String CLAVE_NAME="clave";
    private final static String NOMBRE_NAME="nombre";
    private final static String SALARIO_NAME="salario";
    private final static String TABLE_NAME="empleados";
    private final static String DATABASE_SCHEMA=
            "CREATE TABLE "+TABLE_NAME+"(id INTEGER PRIMARY KEY AUTOINCREMENT,"+CLAVE_NAME+" TEXT, "+NOMBRE_NAME+" TEXT, "+SALARIO_NAME+" TEXT)";
    public SQLiteDatabase db;
    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_SCHEMA);

    }
    public void openDB(){
        db=getWritableDatabase();
    }
    public void closeDB() {
        if (db != null && db.isOpen()) {
            db.close();

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertData(String clave,String nombre, String salario){
        openDB();
        ContentValues contentValues=new ContentValues();
        contentValues.put(CLAVE_NAME,clave);
        contentValues.put(NOMBRE_NAME,nombre);
        contentValues.put(SALARIO_NAME,salario);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;
        }else{
            return  true;
        }

    }
    public Cursor getAllData(){
        openDB();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;

    }
    public boolean updateData(String clave,String nombre,String salario){
        openDB();
        ContentValues contentValues=new ContentValues();
        contentValues.put(CLAVE_NAME,clave);
        contentValues.put(NOMBRE_NAME,nombre);
        contentValues.put(SALARIO_NAME,salario);
        db.update(TABLE_NAME,contentValues,"clave=?",new String[]{clave});
        return true;
    }
    public Integer deleteData(String clave){
        openDB();
        return db.delete(TABLE_NAME,"clave=?",new String[]{clave});
    }
}
