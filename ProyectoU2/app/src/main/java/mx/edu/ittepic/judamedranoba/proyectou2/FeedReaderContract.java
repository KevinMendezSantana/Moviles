package mx.edu.ittepic.judamedranoba.proyectou2;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    private FeedReaderContract() {}

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_ALUMNO = "ALUMNO";
        public static final String COLUMN_NOMBRE = "NOMBRE";
        public static final String COLUMN_NUMERO_CONTROL = "NO_CONTROL";
        public static final String COLUMN_TELEFONO = "TELEFONO";
        public static final String COLUMN_CORREO = "CORREO";
        public static final String COLUMN_CARRERA = "CARRERA";

        public static final String TABLE_ACTIVIDAD = "ACTIVIDAD";
        public static final String COLUMN_ID = "ID";
        public static final String COLUMN_ID_ALUMNO_FK = "ID_FK";
        public static final String COLUMN_FECHA_INICIO = "INICIO";
        public static final String COLUMN_FECHA_FIN = "FIN";
        public static final String COLUMN_CREDITOS = "CREDITOS";
        public static final String COLUMN_ACTIVIDAD = "ACTIVIDAD";
    }
}