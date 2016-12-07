package com.teacherfox.legendary.teacherfox;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
        Context context=this;
        saveFile = context.getSharedPreferences("save", Context.MODE_PRIVATE);
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
        ImageView hatav = (ImageView) barra.findViewById(R.id.hatav);


        hatav.setVisibility(View.VISIBLE);
        RelativeLayout avatah=(RelativeLayout) barra.findViewById(R.id.Avatar);
        int iconbg = getResources().getIdentifier("drawable/skin" + Avatar.skinum, "drawable", getPackageName());
        avatah.setBackgroundResource(iconbg);
        int icon = getResources().getIdentifier("drawable/item" + Avatar.hatnum, "drawable", getPackageName());
        hatav.setImageResource(icon);
        Resources r = getResources();
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][1], r.getDisplayMetrics());

        int height =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][2], r.getDisplayMetrics());
        int m1 =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][5], r.getDisplayMetrics());

        int m2 =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][6] , r.getDisplayMetrics());
        RelativeLayout.LayoutParams size = new RelativeLayout.LayoutParams(width, height);
        size.setMargins(m1, m2, 0, 0);
        hatav.setLayoutParams(size);

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
        RelativeLayout avatah=(RelativeLayout) barra.findViewById(R.id.Avatar);
        DBAdapter dba=new DBAdapter(this);
        switch(v.getId()){
            case R.id.iLoja1:
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
                    if(dba.getType(1)==1){
                        if(Avatar.hatnum==1){
                            int icon = getResources().getIdentifier("drawable/item0", "drawable", getPackageName());
                            hatav.setImageResource(icon);
                            Avatar.saveCloth(this, 1, 0);
                        }else{
                            hatav.setVisibility(View.VISIBLE);
                            Log.w("teste", dba.getItemName(1));
                            int icon = getResources().getIdentifier("drawable/" + dba.getItemName(1), "drawable", getPackageName());
                            hatav.setImageResource(icon);
                            Resources r = getResources();
                            int width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][1], r.getDisplayMetrics());

                            int height =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][2], r.getDisplayMetrics());
                            int m1 =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][5], r.getDisplayMetrics());

                            int m2 =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][6] , r.getDisplayMetrics());
                            RelativeLayout.LayoutParams size = new RelativeLayout.LayoutParams(width, height);
                            size.setMargins(m1, m2, 0, 0);
                            hatav.setLayoutParams(size);
                            Avatar.saveCloth(this, 1, 1);
                        }

                    }else{

                        int icon = getResources().getIdentifier("drawable/" + dba.getItemName(1), "drawable", getPackageName());
                        avatah.setBackgroundResource(icon);
                        Avatar.saveCloth(this, 2, 1);
                    }




                }
                break;
            case R.id.iLoja2:
                TextView value2=(TextView)findViewById(R.id.iLoja2c);
                TextView value2ok=(TextView)findViewById(R.id.iLoja2cok);
                int buyvalue2=Integer.parseInt(value2.getText().toString());
                if(dba.getBuy(2)==false){
                    if(buyvalue2>Avatar.money){
                        Toast.makeText(getApplicationContext(),"Moedas Insuficientes!", Toast.LENGTH_SHORT).show();
                    }else{
                        Avatar.money=Avatar.money-buyvalue2;
                        SharedPreferences.Editor editSave = saveFile.edit();
                        editSave.putInt("Dinheiro", Avatar.money);

                        editSave.apply();
                        TextView dimdim = (TextView)barra.findViewById(R.id.txMoney);

                        value2ok.setVisibility(View.VISIBLE);
                        value2.setVisibility(View.INVISIBLE);
                        dba.setBuy(2);
                        dimdim.setText(String.valueOf(Avatar.money));


                    }

                }else{
                    if(dba.getType(2)==1){
                        hatav.setVisibility(View.VISIBLE);
                        Log.w("teste", dba.getItemName(2));
                        int icon = getResources().getIdentifier("drawable/" + dba.getItemName(2), "drawable", getPackageName());
                        hatav.setImageResource(icon);
                        Resources r = getResources();
                        int width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][1], r.getDisplayMetrics());

                        int height =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][2], r.getDisplayMetrics());
                        int m1 =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][5], r.getDisplayMetrics());

                        int m2 =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][6] , r.getDisplayMetrics());
                        RelativeLayout.LayoutParams size = new RelativeLayout.LayoutParams(width, height);
                        size.setMargins(m1, m2, 0, 0);
                        hatav.setLayoutParams(size);
                        Avatar.saveCloth(this, 1, 2);
                    }else{
                        if(Avatar.skinum==1){
                            int icon = getResources().getIdentifier("drawable/skin0", "drawable", getPackageName());
                            avatah.setBackgroundResource(icon);
                            Avatar.saveCloth(this, 2, 0);
                        }else{
                            int icon = getResources().getIdentifier("drawable/" + dba.getItemName(2), "drawable", getPackageName());
                            avatah.setBackgroundResource(icon);
                            Avatar.saveCloth(this, 2, 1);
                        }

                    }




                }
                break;
        }



    }
    public void mostrarItens(){
        DBAdapter acesso = new DBAdapter(getBaseContext());
        itens=acesso.ObterLoja();
        DBAdapter dba=new DBAdapter(this);
        TextView li1=(TextView)findViewById(R.id.iLoja1c);
        ImageView li1i=(ImageView)findViewById(R.id.iloja1p);
        TextView li1ok=(TextView)findViewById(R.id.iLoja1cok);
        TextView li2=(TextView)findViewById(R.id.iLoja2c);
        ImageView li2i=(ImageView)findViewById(R.id.iLoja2p);
        TextView li2ok=(TextView)findViewById(R.id.iLoja2cok);
        if(itens!=null && itens.moveToFirst()){
            if(dba.getBuy(1)==false){
                li1.setText(Integer.toString(itens.getInt(itens.getColumnIndex(DBHelper.VALORITEM))));

            }else{
                li1.setVisibility(View.INVISIBLE);
                li1ok.setVisibility(View.VISIBLE);
            }
            int icon = getResources().getIdentifier("drawable/" + itens.getString(itens.getColumnIndex(DBHelper.IMGITEM)), "drawable", getPackageName());
            li1i.setImageResource(icon);

        }
        if(itens!=null && itens.moveToNext()){
            if(dba.getBuy(2)==false){
                li2.setText(Integer.toString(itens.getInt(itens.getColumnIndex(DBHelper.VALORITEM))));

            }else{
                li2.setVisibility(View.INVISIBLE);
                li2ok.setVisibility(View.VISIBLE);
            }
            int icon = getResources().getIdentifier("drawable/" + itens.getString(itens.getColumnIndex(DBHelper.IMGITEM)), "drawable", getPackageName());
            li2i.setImageResource(icon);

        }

    }

}