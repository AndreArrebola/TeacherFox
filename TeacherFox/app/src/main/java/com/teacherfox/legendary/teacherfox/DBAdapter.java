package com.teacherfox.legendary.teacherfox;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by andre on 11/09/16.
 */
public class DBAdapter {
    private SQLiteDatabase banco;
    private DBHelper dbHelper;
    public DBAdapter(Context context) {
        dbHelper = new DBHelper(context);
    }
    private String[] allColumnsL = { DBHelper.IDITEM, DBHelper.IMGITEM, DBHelper.VALORITEM, DBHelper.TIPOITEM};
    private String[] allColumnsOK = {DBHelper.IDCOMPOK, DBHelper.IDITEMOK, DBHelper.COMPOK};
    private String[] allColumns = { DBHelper.ID, DBHelper.ALTA, DBHelper.ENUNC,
            DBHelper.ALTB, DBHelper.ALTC, DBHelper.ALTD, DBHelper.ALTE, DBHelper.COINS, DBHelper.MATERIA, DBHelper.ALTOK};
    public Cursor AcessarQuestao(){
        Cursor cursorquestao;
        banco = dbHelper.getReadableDatabase();
        cursorquestao= banco.query(DBHelper.TABLE_NAME, allColumns, null, null,null, null, "RANDOM()", "1");

        cursorquestao.moveToFirst();
        return cursorquestao;
    }
    public Cursor AcessarQuestaoME(String materia){
        Cursor cursorquestao;
        banco = dbHelper.getReadableDatabase();
        if(materia.equals("Random")){
            cursorquestao= banco.query(DBHelper.TABLE_NAME, allColumns, null, null,null, null, "RANDOM()", "1");

            cursorquestao.moveToFirst();
        }else{
            cursorquestao= banco.query(DBHelper.TABLE_NAME, allColumns, DBHelper.MATERIA + " like '" + materia + "'", null,null, null, "RANDOM()", "1");

            cursorquestao.moveToFirst();
        }


        return cursorquestao;
    }
    public Cursor ObterLoja(){
        Cursor itensloja;
        banco = dbHelper.getWritableDatabase();
        itensloja=banco.query(DBHelper.TABLE_LOJA, allColumnsL, null, null, null, null, null);
        itensloja.moveToFirst();
        return itensloja;
    }
    public void setBuy(int itemid){

        banco = dbHelper.getWritableDatabase();

        banco.execSQL("update " + DBHelper.TABLE_BUYOK + " set " + DBHelper.COMPOK + " = 1 where " + DBHelper.IDITEMOK + "=" + itemid);

    }
    public int getType(int id){
        Cursor checkname;
        int tipoitem;
        banco=dbHelper.getReadableDatabase();

        checkname=banco.query(DBHelper.TABLE_LOJA, allColumnsL, DBHelper.IDITEM + "=" + id, null, null, null, null);
        checkname.moveToFirst();
        tipoitem=checkname.getInt(checkname.getColumnIndex(DBHelper.TIPOITEM));
        return tipoitem;
    }
    public boolean getBuy(int id){
        Cursor checkBuy;
        Boolean tfBuy=false;
        banco=dbHelper.getWritableDatabase();

        checkBuy=banco.query(DBHelper.TABLE_BUYOK, allColumnsOK, DBHelper.IDITEMOK + "=" + id, null, null, null, null);
        Log.d("Foo", "Cursor is:" + checkBuy);
        if( checkBuy != null && checkBuy.moveToFirst() ){
            if(checkBuy.getInt(checkBuy.getColumnIndex(DBHelper.COMPOK))==1){
                tfBuy=true;
            }else{
                tfBuy=false;
            }
        }else{
            Log.w("app", "Cursor nulo");
        }


        return tfBuy;
    }
    public String getItemName(int id){
        Cursor checkname;
        String nomeitem;
        banco=dbHelper.getReadableDatabase();

        checkname=banco.query(DBHelper.TABLE_LOJA, allColumnsL, DBHelper.IDITEM + "=" + id, null, null, null, null);
        checkname.moveToFirst();
        nomeitem=checkname.getString(checkname.getColumnIndex(DBHelper.IMGITEM));
        return nomeitem;
    }

}