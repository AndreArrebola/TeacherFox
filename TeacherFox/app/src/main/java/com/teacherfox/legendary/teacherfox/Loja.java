package com.teacherfox.legendary.teacherfox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Loja extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loja);
    }
    public void setCloth(View v){
        LinearLayout barra = (LinearLayout)findViewById(R.id.thebar);
        ImageView hatav = (ImageView) barra.findViewById(R.id.hatav);
        hatav.setVisibility(View.VISIBLE);
    }
}