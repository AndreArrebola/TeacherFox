package com.legendary.teacherfox;

import android.content.res.Resources;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Results extends AppCompatActivity {
Boolean res=false;
    int premio=0;
    int expnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultscreen);
        res=getIntent().getBooleanExtra("resultado", false);
        premio=getIntent().getIntExtra("coins", 0);
        TextView txresultado = (TextView)findViewById(R.id.txRes);
        TextView txmoney = (TextView)findViewById(R.id.gotMoney);
        TextView txexp = (TextView)findViewById(R.id.gotExp);
        TextView txlvl = (TextView)findViewById(R.id.txlvl);
        ImageView hatav = (ImageView)findViewById(R.id.hatavr);
        RelativeLayout foxkin=(RelativeLayout)findViewById((R.id.foxfull));

        int icon = getResources().getIdentifier("drawable/item" + Avatar.hatnum, "drawable", getPackageName());
        hatav.setImageResource(icon);
        int iconbg = getResources().getIdentifier("drawable/skin" + Avatar.skinum + "full", "drawable", getPackageName());
        foxkin.setBackgroundResource(iconbg);

        Resources r = getResources();
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positionsr[0][1], r.getDisplayMetrics());

        int height =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positionsr[0][2], r.getDisplayMetrics());
        int m1 =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positionsr[0][5], r.getDisplayMetrics());

        int m2 =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positionsr[0][6] , r.getDisplayMetrics());
        RelativeLayout.LayoutParams size = new RelativeLayout.LayoutParams(width, height);
        size.setMargins(m1, m2, 0, 0);
        hatav.setLayoutParams(size);
        if(res){
            txresultado.setText("Acertou!");
            txmoney.setText("+" + premio + "$");
            txexp.setText("+10xp");
            Avatar.money=Avatar.money+premio;
            boolean lup = addExp(10);
            if(lup){
                txlvl.setText( String.valueOf(Avatar.lvl));
            }

        }else{
            txresultado.setText("Errou");
            txexp.setText("+5xp");
            boolean lup = addExp(5);
            if(lup){
                txlvl.setText(String.valueOf(Avatar.lvl));
            }
        }
    }

    public void returnToMenu(View view){
        finish();
    }
    public boolean addExp(int x){
        Avatar.exp=Avatar.exp+x;
        boolean lvlup=false;
        for(int cont=0;cont<=15;cont++){
            if(Avatar.levels[cont]<=Avatar.exp){
                Avatar.lvl=cont;

                lvlup=true;
            }
        }
        return lvlup;

    }
}
