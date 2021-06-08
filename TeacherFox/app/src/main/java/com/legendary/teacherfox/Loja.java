package com.legendary.teacherfox;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.legendary.teacherfox.databinding.ActivityLojaBinding;
import com.legendary.teacherfox.databinding.BarraBinding;
import com.legendary.teacherfox.databinding.QuestoesBinding;

import java.util.Locale;

public class Loja extends AppCompatActivity {
    private ActivityLojaBinding telaLoja;
    Cursor itens;
    SharedPreferences saveFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        telaLoja = ActivityLojaBinding.inflate(getLayoutInflater());
        setContentView(telaLoja.getRoot());
        BarraBinding barra = telaLoja.thebar;
        TextView nomeraposa = barra.avtrname;
        nomeraposa.setText(Avatar.nome);

        mostrarItens();
        Context context=this;
        saveFile = context.getSharedPreferences("save", Context.MODE_PRIVATE);

        nomeraposa.setText(Avatar.nome);
        DBAdapter dba=new DBAdapter(this);
        TextView dimdim = barra.txMoney;
        TextView level = barra.txLvl;
        TextView texp = barra.txExp;
        dimdim.setText(String.valueOf(Avatar.money));
        texp.setText(String.valueOf(Avatar.exp) + "/" + Avatar.levels[Avatar.level +1]);
        level.setText(String.valueOf(Avatar.level));
        String tf;
        ImageView hatav = barra.hatav;


        hatav.setVisibility(View.VISIBLE);
        RelativeLayout avatah=(RelativeLayout) barra.Avatar;
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
        ImageButton btnperf= barra.button;
        final Intent novatelap = new Intent(this, perfil.class);
        btnperf.setOnClickListener(v -> startActivity(novatelap));
        if(!dba.getBuy(1)){
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
                        if(Avatar.idHat ==1){
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
                if(!dba.getBuy(2)){
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
                        if(Avatar.idSkin ==1){
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
        TextView li1= telaLoja.iLoja1c;
        ImageView li1i= telaLoja.iloja1p;
        TextView li1ok= telaLoja.iLoja1cok;
        TextView li2= telaLoja.iLoja2c;
        ImageView li2i= telaLoja.iLoja2p;
        TextView li2ok= telaLoja.iLoja2cok;
        if(itens!=null && itens.moveToFirst()){
            criarBotaoItem(1, dba,  li1, li1ok, li1i );

        }
        if(itens!=null && itens.moveToNext()){
            criarBotaoItem(2, dba,  li2, li2ok, li2i );

        }

    }
    public void criarBotaoItem(int idItem, DBAdapter dba, TextView labelItem, TextView labelComprado, ImageView iconeItem){
        if(!dba.getBuy(idItem)){
            labelItem.setText(String.format(Locale.getDefault(),"%d", itens.getInt(itens.getColumnIndex(DBHelper.VALORITEM))));

        }else{
            labelItem.setVisibility(View.INVISIBLE);
            labelComprado.setVisibility(View.VISIBLE);
        }
        int icon = getResources().getIdentifier("drawable/" + itens.getString(itens.getColumnIndex(DBHelper.IMGITEM)), "drawable", getPackageName());
        iconeItem.setImageResource(icon);
    }

}