package com.example.menuy3puntitos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatosTarjetaBaseSQLite extends SQLiteOpenHelper {

    //Creamos las variables para determinar el nombre de la tabla correspondiente a la act datos de la tarjeta del usuario.
    //y los nombres correspondientes a cada columna.
    private static final String TABLA_DATOS_TARJETA = "tabla_datos_de_tarjeta";
    private static final String COLUMNA_ID = "ID";
    private static final String COLUMNA_TOTAL = "TOTAL";
    private static final String COLUMNA_METODO_DE_PAGO = "METODO_PAGO";
    private static final String COLUMNA_NUM_TARJETA = "NUM_TARJETA";
    private static final String COLUMNA_VENCIMIENTO = "VENCIMIENTO";
    private static final String COLUMNA_CVV = "CVV";
    private static final String COLUMNA_PROPIETARIO = "PROPIETARIO";
    private static final String COLUMNA_GUARDAR_DATOS = "GUARDAR_DATOS";

    //Instrucción para crear la tabla en la BD.
    private static final String CREATE_BD = "CREATE TABLE " + TABLA_DATOS_TARJETA + " (" +
            COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMNA_TOTAL + " TEXT NOT NULL, " +
            COLUMNA_METODO_DE_PAGO + " TEXT NOT NULL, " +
            COLUMNA_NUM_TARJETA + " TEXT NOT NULL, " +
            COLUMNA_VENCIMIENTO + " TEXT NOT NULL, " +
            COLUMNA_CVV + " TEXT NOT NULL, " +
            COLUMNA_PROPIETARIO + " TEXT NOT NULL, " +
            COLUMNA_GUARDAR_DATOS + " TEXT NOT NULL); ";


    //Constructor
    public DatosTarjetaBaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Creamos la BD
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BD);
    }

    //Actualizamos la version de la BD
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_DATOS_TARJETA);
        onCreate(db);
    }

}
