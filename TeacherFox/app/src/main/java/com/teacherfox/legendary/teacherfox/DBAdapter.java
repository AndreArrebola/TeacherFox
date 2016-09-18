package com.teacherfox.legendary.teacherfox;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by andre on 11/09/16.
 */
public class DBAdapter {
    private SQLiteDatabase banco;
    private DBHelper dbHelper;
    public DBAdapter(Context context) {
        dbHelper = new DBHelper(context);
    }
    private String[] allColumns = { DBHelper.ID, DBHelper.ALTA, DBHelper.ENUNC,
            DBHelper.ALTB, DBHelper.ALTC, DBHelper.ALTD, DBHelper.ALTE, DBHelper.ALTOK};
    public Cursor AcessarQuestao(int numquest){
        Cursor cursorquestao;
        banco = dbHelper.getReadableDatabase();
        cursorquestao= banco.query(DBHelper.TABLE_NAME, allColumns, DBHelper.ID + " = " + numquest, null, null, null, null);
        return cursorquestao;
    }


}
