package com.teacherfox.legendary.teacherfox;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Loja extends AppCompatActivity {
Cursor itens;
    SharedPreferences saveFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loja);
        mostrarItens();
        LinearLayout barra = (LinearLayout)findViewById(R.id.thebar);
        TextView nomeraposa = (TextView)barra.findViewById(R.id.avtrname);
        nomeraposa.setText(Avatar.nome.toString());
        DBAdapter dba=new DBAdapter(this);
        TextView dimdim = (TextView)barra.findViewById(R.id.txMoney);
        TextView level = (TextView)barra.findViewById(R.id.txLvl);
        TextView texp = (TextView)barra.findViewById(R.id.txExp);
        dimdim.setText(String.valueOf(Avatar.money));
        texp.setText(String.valueOf(Avatar.exp) + "/" + Avatar.levels[Avatar.lvl+1]);
        level.setText(String.valueOf(Avatar.lvl));
        String tf;
        if(dba.getBuy(1)==false){
            tf="false";
        }else
        {
            tf="true;";
        }
        Toast.makeText(getApplicationContext(),tf, Toast.LENGTH_SHORT).show();
    }
    public void setCloth(View v){
        LinearLayout barra = (LinearLayout)findViewById(R.id.thebar);
        ImageView hatav = (ImageView) barra.findViewById(R.id.hatav);
        DBAdapter dba=new DBAdapter(this);
        TextView value1=(TextView)findViewById(R.id.iLoja1c);
        TextView value1ok=(TextView)findViewById(R.id.iLoja1cok);
        int buyvalue=Integer.parseInt(value1.getText().toString());
        if(dba.getBuy(1)==false){
            if(buyvalue>Avatar.money){
                Toast.makeText(getApplicationContext(),"Moedas Insuficientes!", Toast.LENGTH_SHORT).show();
            }else{
                Avatar.money=Avatar.money-buyvalue;
                SharedPreferences.Editor editSave = saveFile.edit();
                editSave.putInt("Dinheiro", Avatar.money);

                editSave.apply();
                TextView dimdim = (TextView)barra.findViewById(R.id.txMoney);

                value1ok.setVisibility(View.VISIBLE);
                value1.setVisibility(View.INVISIBLE);
                dba.setBuy(1);
                dimdim.setText(String.valueOf(Avatar.money));


            }

        }else{
            hatav.setVisibility(View.VISIBLE);
        }


    }
    public void mostrarItens(){
        DBAdapter acesso = new DBAdapter(getBaseContext());
        itens=acesso.ObterLoja();
        TextView li1=(TextView)findViewById(R.id.iLoja1c);
        ImageView li1i=(ImageView)findViewById(R.id.iloja1p);
        if(itens!=null && itens.moveToFirst()){
            li1.setText(Integer.toString(itens.getInt(itens.getColumnIndex(DBHelper.VALORITEM))));
            int icon = getResources().getIdentifier("drawable/" + itens.getString(itens.getColumnIndex(DBHelper.IMGITEM)), "drawable", getPackageName());
            li1i.setImageResource(icon);
        }
    }

}