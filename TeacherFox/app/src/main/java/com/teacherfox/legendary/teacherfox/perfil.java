package com.teacherfox.legendary.teacherfox;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);
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
        TextView dimdim = (TextView)findViewById(R.id.ptxm);

        TextView level = (TextView)findViewById(R.id.ptxn);
        TextView texp = (TextView)findViewById(R.id.ptxe);
        dimdim.setText(String.valueOf(Avatar.money));
        texp.setText(String.valueOf(Avatar.exp) + "/" + Avatar.levels[Avatar.lvl+1]);
        level.setText(String.valueOf(Avatar.lvl));
    }
}
