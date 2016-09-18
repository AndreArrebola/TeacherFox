package com.teacherfox.legendary.teacherfox;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by andre on 11/09/16.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "bancoquestoes.db";
    public static final String TABLE_NAME = "quests";
    private static final int DATABASE_VERSION = 1;
    public static final String ID = "_id";
    public static final String ENUNC     = "enunc";
    public static final String ALTA = "alta";
    public static final String ALTB = "altb";
    public static final String ALTC = "altc";
    public static final String ALTD = "altd";
    public static final String ALTE = "alte";
public static final String ALTOK = "altok";
    private String[] allColumns = { DBHelper.ID, DBHelper.ALTA, DBHelper.ENUNC,
            DBHelper.ALTB, DBHelper.ALTC, DBHelper.ALTD, DBHelper.ALTE, DBHelper.ALTOK};
    private static final String CRIAR_TABELA="create table " + TABLE_NAME + "(" +
            ID + " integer primary key autoincrement, " +
            ENUNC + " text not null, " +
            ALTA + " text not null, " +
            ALTB + " text not null, " +
            ALTC + " text not null, " +
            ALTD + " text not null, " +
            ALTOK + " text not null);";

    public DBHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CRIAR_TABELA);
        ContentValues values = new ContentValues();
        values.put(DBHelper.ENUNC, "Qual a resposta certa?");
        values.put(DBHelper.ALTA, "Alternativa 1");
        values.put(DBHelper.ALTB, "Alternativa 2");
        values.put(DBHelper.ALTC, "Alternativa 3(ok)");
        values.put(DBHelper.ALTD, "Alternativa 4");
        values.put(DBHelper.ALTE, "Alternativa 5");
        values.put(DBHelper.ALTOK, "Alternativa 3(ok)");
        db.insert(TABLE_NAME, null, values );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
