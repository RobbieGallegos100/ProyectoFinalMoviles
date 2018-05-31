package com.tec.robert.jexchangeproyecto.Entidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tec.robert.jexchangeproyecto.Utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_SEEKER);
        db.execSQL(Utilidades.CREAR_TABLA_FINDER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionVieja, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_SEEKER);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_FINDER);
        onCreate(db);
    }
}
