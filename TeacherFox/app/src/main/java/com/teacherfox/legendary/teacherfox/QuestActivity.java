package com.teacherfox.legendary.teacherfox;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by andre on 11/09/16.
 */
public class QuestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questoes);
DBAdapter acesso = new DBAdapter(getBaseContext());
        Cursor obterquestao = acesso.AcessarQuestao(1);

        String password= obterquestao.getString(obterquestao.getColumnIndex("enunc"));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(password);
        AlertDialog mostrar;
        mostrar = builder.create();
        mostrar.show();
    }
}
