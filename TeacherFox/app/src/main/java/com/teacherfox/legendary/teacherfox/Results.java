package com.teacherfox.legendary.teacherfox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends AppCompatActivity {
Boolean res=false;
    int premio=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultscreen);
        res=getIntent().getBooleanExtra("resultado", false);
        premio=getIntent().getIntExtra("coins", 0);
        TextView txresultado = (TextView)findViewById(R.id.txRes);
        TextView txmoney = (TextView)findViewById(R.id.gotMoney);
        if(res){
            txresultado.setText("Acertou!");
            txmoney.setText("+" + premio + "$");
            Avatar.money=Avatar.money+premio;
            boolean lup = addExp(10);
            if(lup){
                txresultado.setText("LEVEL " + Avatar.lvl);
            }

        }else{
            txresultado.setText("Errou");
        }
    }

    public void returnToMenu(View view){
        finish();
    }
    public boolean addExp(int x){
        Avatar.exp=Avatar.exp+x;
        boolean lvlup=false;
        for(int cont=0;cont<=5;cont++){
            if(Avatar.levels[cont]<=Avatar.exp){
                Avatar.lvl=cont;

                lvlup=true;
            }
        }
        return lvlup;

    }
}
