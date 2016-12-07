package com.teacherfox.legendary.teacherfox;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Modo_estudo extends AppCompatActivity {
    SharedPreferences saveFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modo_estudo);
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
    }
    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Dados salvos", Toast.LENGTH_SHORT).show();
        if (Avatar.nome.equals("undefined")) {

        } else {
            LinearLayout barra = (LinearLayout) findViewById(R.id.thebar);
            TextView dimdim = (TextView) barra.findViewById(R.id.txMoney);

            TextView level = (TextView) barra.findViewById(R.id.txLvl);
            TextView texp = (TextView) barra.findViewById(R.id.txExp);
            dimdim.setText(String.valueOf(Avatar.money));
            texp.setText(String.valueOf(Avatar.exp) + "/" + Avatar.levels[Avatar.lvl + 1]);
            level.setText(String.valueOf(Avatar.lvl));
            SharedPreferences.Editor editSave = saveFile.edit();
            editSave.putInt("Dinheiro", Avatar.money);
            editSave.putInt("Experiencia", Avatar.exp);
            editSave.putInt("Nivel", Avatar.lvl);
            editSave.putInt("Roupa", Avatar.hatnum);
            editSave.apply();
            ImageView hatav = (ImageView) barra.findViewById(R.id.hatav);

            hatav.setVisibility(View.VISIBLE);
            int icon = getResources().getIdentifier("drawable/item" + Avatar.hatnum, "drawable", getPackageName());
            hatav.setImageResource(icon);
            Resources r = getResources();
            int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][1], r.getDisplayMetrics());

            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][2], r.getDisplayMetrics());
            int m1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][5], r.getDisplayMetrics());

            int m2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positions[0][6], r.getDisplayMetrics());
            RelativeLayout.LayoutParams size = new RelativeLayout.LayoutParams(width, height);
            size.setMargins(m1, m2, 0, 0);
            hatav.setLayoutParams(size);


        }
    }
    public void QuestaoME(View v){
        String mat="";
        switch(v.getId()){
            case R.id.meport:
                mat="Português";
                break;
        }

        Intent result=new Intent(this, QuestActivity.class);
        result.putExtra("Matéria", mat);

        startActivity(result);
    }
}
