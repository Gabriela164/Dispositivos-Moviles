package com.example.menuy3puntitos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DatosTarjetaBDD {

    private static final int version = 2;
    //Nombre de la base de datos y la tabla que ocuparemos.
    private static final String NOM_BDD = "restaurante.bd";
    private static final String TABLA_DATOS_TARJETA = "tabla_datos_de_tarjeta";

    //Nombres asignados a cada columna de nuestra tabla
    private static final String COLUMNA_ID = "ID";
    private static final String COLUMNA_TOTAL = "TOTAL";
    private static final String COLUMNA_METODO_DE_PAGO = "METODO_PAGO";
    private static final String COLUMNA_NUM_TARJETA = "NUM_TARJETA";
    private static final String COLUMNA_VENCIMIENTO = "VENCIMIENTO";
    private static final String COLUMNA_CVV = "CVV";
    private static final String COLUMNA_PROPIETARIO = "PROPIETARIO";
    private static final String COLUMNA_GUARDAR_DATOS = "GUARDAR_DATOS";

    //Indice para cada columna.
    private static final int NUM_COL_ID = 0;
    private static final int NUM_COLUMNA_TOTAL = 1;
    private static final int NUM_COLUMNA_METODO_DE_PAGO = 2;
    private static final int NUM_COLUMNA_NUM_TARJETA = 3;
    private static final int NUM_COLUMNA_VENCIMIENTO = 4;
    private static final int NUM_COLUMNA_CVV = 5;
    private static final int NUM_COLUMNA_PROPIETARIO = 6;
    private static final int NUM_COLUMNA_GUARDAR_DATOS = 7;

    private SQLiteDatabase bdd;
    private final DatosTarjetaBaseSQLite datosDeTarjeta;

    /*Constructor*/
    public DatosTarjetaBDD(Context context) {
        datosDeTarjeta = new DatosTarjetaBaseSQLite(context, NOM_BDD, null, version);
    }

    /* Metodo que nos permite escribir en la base de datos*/
    public void openForWrite(){
        bdd = datosDeTarjeta.getWritableDatabase();
    }

    public void openToRead(){
        bdd = datosDeTarjeta.getReadableDatabase();
    }

    public void close(){
        bdd.close();
    }

    public SQLiteDatabase getBdd(){
        return bdd;
    }

    /*Insertamos un registro en la tabla tabla_datos_tarjeta en la BD*/
    public long insertDato(DatosTarjeta datosTarjeta){
        ContentValues content = new ContentValues();
        content.put(COLUMNA_TOTAL, datosTarjeta.getTotal());
        content.put(COLUMNA_METODO_DE_PAGO, datosTarjeta.getMetodoDePago());
        content.put(COLUMNA_NUM_TARJETA, datosTarjeta.getNumTarjeta());
        content.put(COLUMNA_VENCIMIENTO, datosTarjeta.getVencimiento());
        content.put(COLUMNA_CVV, datosTarjeta.getCvv());
        content.put(COLUMNA_PROPIETARIO, datosTarjeta.getPropietario());
        content.put(COLUMNA_GUARDAR_DATOS, datosTarjeta.getGuardarDatos());
        return bdd.insert( TABLA_DATOS_TARJETA, null, content );
    }


    /*Actualizamos la información de un registro*/
    public int updateDato(int id, DatosTarjeta dato){
        ContentValues content = new ContentValues();
        content.put(COLUMNA_TOTAL, dato.getTotal());
        content.put(COLUMNA_METODO_DE_PAGO, dato.getMetodoDePago());
        content.put(COLUMNA_NUM_TARJETA, dato.getNumTarjeta());
        content.put(COLUMNA_VENCIMIENTO, dato.getVencimiento());
        content.put(COLUMNA_CVV, dato.getCvv());
        content.put(COLUMNA_PROPIETARIO, dato.getPropietario());
        content.put(COLUMNA_GUARDAR_DATOS, dato.getGuardarDatos());
        return bdd.update( TABLA_DATOS_TARJETA, content, COLUMNA_ID + " = " + id, null );
    }

    /*Para eliminar un registro por user*/
    public int removeDato(String propietario){
        return bdd.delete(TABLA_DATOS_TARJETA, COLUMNA_PROPIETARIO + " = " + propietario, null );
    }

    /*Obtenemos un registro*/
    public DatosTarjeta getDatosTarjeta(String propietario) {
        // Realizamos la consulta usando un Cursor
        Cursor c = bdd.query(
                TABLA_DATOS_TARJETA, // Tabla
                new String[]{COLUMNA_ID, COLUMNA_TOTAL, COLUMNA_METODO_DE_PAGO, COLUMNA_NUM_TARJETA, COLUMNA_VENCIMIENTO,
                        COLUMNA_CVV, COLUMNA_PROPIETARIO, COLUMNA_GUARDAR_DATOS},
                COLUMNA_PROPIETARIO + " LIKE \"" + propietario + "\"", null, null,
                null, COLUMNA_PROPIETARIO);
        return cursorToChapter(c);
    }

    public DatosTarjeta cursorToChapter( Cursor c ) {
        if ( c.getCount() == 0 ) {
            c.close();
            return null;
        }
        DatosTarjeta dato = new DatosTarjeta();
        dato.setId( c.getInt( NUM_COL_ID ) );
        dato.setTotal( c.getString( NUM_COLUMNA_TOTAL ) );
        dato.setMetodoDePago( c.getString( NUM_COLUMNA_METODO_DE_PAGO ));
        dato.setNumTarjeta(c.getString( NUM_COLUMNA_NUM_TARJETA));
        dato.setVencimiento(c.getString( NUM_COLUMNA_VENCIMIENTO));
        dato.setCvv(c.getString( NUM_COLUMNA_CVV));
        dato.setPropietario(c.getString( NUM_COLUMNA_PROPIETARIO));
        dato.setGuardarDatos(c.getString( NUM_COLUMNA_GUARDAR_DATOS));
        c.close();
        return dato;
    }


    public ArrayList<DatosTarjeta> getAll() {
        Cursor c = bdd.query(
                TABLA_DATOS_TARJETA,
                new String[]{COLUMNA_ID, COLUMNA_TOTAL,
                        COLUMNA_METODO_DE_PAGO, COLUMNA_NUM_TARJETA,
                        COLUMNA_VENCIMIENTO, COLUMNA_CVV,
                        COLUMNA_PROPIETARIO, COLUMNA_GUARDAR_DATOS},
                null,
                null,
                null,
                null,
                COLUMNA_PROPIETARIO
        );
        if (c.getCount() == 0) {
            c.close();
            return null;
        }
        ArrayList<DatosTarjeta> list = new ArrayList<DatosTarjeta> ();
        while ( c.moveToNext() ) {
            DatosTarjeta dato = new DatosTarjeta();
            dato.setId( c.getInt( NUM_COL_ID ));
            dato.setTotal( c.getString( NUM_COLUMNA_TOTAL ));
            dato.setMetodoDePago( c.getString( NUM_COLUMNA_METODO_DE_PAGO ));
            dato.setNumTarjeta( c.getString( NUM_COLUMNA_NUM_TARJETA ));
            dato.setVencimiento( c.getString( NUM_COLUMNA_VENCIMIENTO ));
            dato.setCvv( c.getString( NUM_COLUMNA_CVV));
            dato.setPropietario(c.getString( NUM_COLUMNA_PROPIETARIO));
            dato.setGuardarDatos(c.getString(NUM_COLUMNA_GUARDAR_DATOS));
            list.add( dato );
        }
        c.close();
        return list;
    }


}
