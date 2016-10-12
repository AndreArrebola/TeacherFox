package com.teacherfox.legendary.teacherfox;

import android.database.Cursor;
import android.os.Bundle;
import com.firebase.client.Firebase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by andre on 11/09/16.
 */
public class QuestActivity extends AppCompatActivity {
    Questao quest = new Questao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questoes);
        LinearLayout barra = (LinearLayout)findViewById(R.id.thebar);
        TextView nomeraposa = (TextView)barra.findViewById(R.id.avtrname);
        nomeraposa.setText(Avatar.nome.toString());
        String password="txt";

        DBAdapter acesso = new DBAdapter(getBaseContext());
        Random idquest=new Random();
        int randomNum = idquest.nextInt((3 - 1) + 1) + 1;
        Cursor obterquestao = acesso.AcessarQuestao(randomNum);

        if( obterquestao != null && obterquestao.moveToFirst() ){
            quest.setEnunc(obterquestao.getString(obterquestao.getColumnIndex(DBHelper.ENUNC)));
            quest.setAlta(obterquestao.getString(obterquestao.getColumnIndex(DBHelper.ALTA)));
            quest.setAltb(obterquestao.getString(obterquestao.getColumnIndex(DBHelper.ALTB)));
            quest.setAltc(obterquestao.getString(obterquestao.getColumnIndex(DBHelper.ALTC)));
            quest.setAltd(obterquestao.getString(obterquestao.getColumnIndex(DBHelper.ALTD)));
            quest.setAlte(obterquestao.getString(obterquestao.getColumnIndex(DBHelper.ALTE)));
            quest.setAltok(obterquestao.getString(obterquestao.getColumnIndex(DBHelper.ALTOK)));
            obterquestao.close();
        }
        TextView nunc=(TextView)findViewById(R.id.nunciado);
        TextView txt_alta=(TextView)findViewById(R.id.altea);
        TextView txt_altb=(TextView)findViewById(R.id.alteb);
        TextView txt_altc=(TextView)findViewById(R.id.altec);
        TextView txt_altd=(TextView)findViewById(R.id.alted);
        TextView txt_alte=(TextView)findViewById(R.id.altee);
        nunc.setText(quest.getEnunc());
        txt_alta.setText(quest.getAlta());
        txt_altb.setText(quest.getAltb());
        txt_altc.setText(quest.getAltc());
        txt_altd.setText(quest.getAltd());
        txt_alte.setText(quest.getAlte());

    }
    public void resposta(View v){
        switch(v.getId()) {
            case R.id.baltea:

                if(quest.getAlta().equals(quest.getAltok())){
                    Toast.makeText(getApplicationContext(),"Acertou!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.balteb:

                if(quest.getAltb().equals(quest.getAltok())){
                    Toast.makeText(getApplicationContext(),"Acertou!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.baltec:

                if(quest.getAltc().equals(quest.getAltok())){
                    Toast.makeText(getApplicationContext(),"Acertou!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.balted:

                if(quest.getAltd().equals(quest.getAltok())){
                    Toast.makeText(getApplicationContext(),"Acertou!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.baltee:

                if(quest.getAlte().equals(quest.getAltok())){
                    Toast.makeText(getApplicationContext(),"Acertou!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        this.finish();

    }
}
