package com.legendary.teacherfox;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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

        TextView dimdim = (TextView)barra.findViewById(R.id.txMoney);
        TextView level = (TextView)barra.findViewById(R.id.txLvl);
        TextView texp = (TextView)barra.findViewById(R.id.txExp);
        dimdim.setText("$"+ String.valueOf(Avatar.money));
        texp.setText(String.valueOf(Avatar.exp) + "/" + Avatar.levels[Avatar.level +1]);
        level.setText(String.valueOf(Avatar.level));
        String mat=getIntent().getStringExtra("Matéria");
        ImageView hatav = (ImageView) barra.findViewById(R.id.hatav);
        ImageButton btnperf=(ImageButton)barra.findViewById(R.id.button);
        final Intent novatelap = new Intent(this, perfil.class);
        btnperf.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(novatelap);
            }
        });

        hatav.setVisibility(View.VISIBLE);
        RelativeLayout avatah=(RelativeLayout) barra.findViewById(R.id.Avatar);
        int iconbg = getResources().getIdentifier("drawable/skin" + Avatar.idSkin, "drawable", getPackageName());
        avatah.setBackgroundResource(iconbg);
        int icon = getResources().getIdentifier("drawable/item" + Avatar.idHat, "drawable", getPackageName());
        hatav.setImageResource(icon);
        Resources r = getResources();
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][1], r.getDisplayMetrics());

        int height =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][2], r.getDisplayMetrics());
        int m1 =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][5], r.getDisplayMetrics());

        int m2 =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][6] , r.getDisplayMetrics());
        RelativeLayout.LayoutParams size = new RelativeLayout.LayoutParams(width, height);
        size.setMargins(m1, m2, 0, 0);
        hatav.setLayoutParams(size);
        DBAdapter acesso = new DBAdapter(getBaseContext());
        Cursor obterquestao=acesso.AcessarQuestaoME(mat);

        if( obterquestao != null && obterquestao.moveToFirst() ){
            quest.setEnunc(obterquestao.getString(obterquestao.getColumnIndex(DBHelper.ENUNC)));
            quest.setAlta(obterquestao.getString(obterquestao.getColumnIndex(DBHelper.ALTA)));
            quest.setAltb(obterquestao.getString(obterquestao.getColumnIndex(DBHelper.ALTB)));
            quest.setAltc(obterquestao.getString(obterquestao.getColumnIndex(DBHelper.ALTC)));
            quest.setAltd(obterquestao.getString(obterquestao.getColumnIndex(DBHelper.ALTD)));
            quest.setAlte(obterquestao.getString(obterquestao.getColumnIndex(DBHelper.ALTE)));
            quest.setAltok(obterquestao.getString(obterquestao.getColumnIndex(DBHelper.ALTOK)));
            quest.setCoins(obterquestao.getInt(obterquestao.getColumnIndex(DBHelper.COINS)));
            //obterquestao.close();
        }
        Log.d("Foo", "Cursor is:" + obterquestao);
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
        Toast.makeText(getApplicationContext(),String.valueOf(quest.getCoins()), Toast.LENGTH_SHORT).show();

    }
    public void resposta(View v){
        boolean cert=false;
        switch(v.getId()) {
            case R.id.baltea:

                if(quest.getAlta().equals(quest.getAltok())){
                    //Toast.makeText(getApplicationContext(),"Acertou!", Toast.LENGTH_SHORT).show();
                    cert=true;
                }
                break;
            case R.id.balteb:

                if(quest.getAltb().equals(quest.getAltok())){
                    //Toast.makeText(getApplicationContext(),"Acertou!", Toast.LENGTH_SHORT).show();
                    cert=true;
                }
                break;
            case R.id.baltec:

                if(quest.getAltc().equals(quest.getAltok())){
                    //Toast.makeText(getApplicationContext(),"Acertou!", Toast.LENGTH_SHORT).show();
                    cert=true;
                }
                break;
            case R.id.balted:

                if(quest.getAltd().equals(quest.getAltok())){
                    //Toast.makeText(getApplicationContext(),"Acertou!", Toast.LENGTH_SHORT).show();
                    cert=true;
                }
                break;
            case R.id.baltee:

                if(quest.getAlte().equals(quest.getAltok())){
                    //Toast.makeText(getApplicationContext(),"Acertou!", Toast.LENGTH_SHORT).show();
                    cert=true;
                }
                break;
        }
        Intent result=new Intent(this, Results.class);
        result.putExtra("resultado", cert);
        result.putExtra("coins", quest.getCoins());
        startActivity(result);
        this.finish();

    }

}
