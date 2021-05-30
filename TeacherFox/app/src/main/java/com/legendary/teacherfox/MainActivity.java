package com.legendary.teacherfox;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.legendary.teacherfox.databinding.MainmenuBinding;

public class MainActivity extends AppCompatActivity {
    SharedPreferences saveFile;
    private MainmenuBinding tela;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = this;
        saveFile = context.getSharedPreferences("save",Context.MODE_PRIVATE);

        Avatar.nome= saveFile.getString("Nome raposa", "undefined");
        Avatar.money= saveFile.getInt("Dinheiro", 0);
        Avatar.exp= saveFile.getInt("Experiencia", 0);
        Avatar.lvl= saveFile.getInt("Nivel", 0);
        Avatar.hatnum= saveFile.getInt("Roupa", 0);
        Avatar.hattf=saveFile.getBoolean("Roupatf", true);
        Avatar.skinum=saveFile.getInt("Skin", 0);

        if(Avatar.nome.equals("undefined")){

            setContentView(R.layout.novouser);
        }else{
            tela = MainmenuBinding.inflate(getLayoutInflater());
            //setContentView(R.layout.mainmenu);
            setContentView(tela.getRoot());

            LinearLayout barra = (LinearLayout)findViewById(R.id.thebar);
            TextView nomeraposa = (TextView)barra.findViewById(R.id.avtrname);

            nomeraposa.setText(Avatar.nome);
            Toast.makeText(getApplicationContext(),"Bem vindo, " + Avatar.nome , Toast.LENGTH_SHORT).show();
            ImageButton btnperf=(ImageButton)barra.findViewById(R.id.button);
            final Intent novatelap = new Intent(this, perfil.class);
            btnperf.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    startActivity(novatelap);
                }
            });
        }



    }
    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(),"Dados salvos" , Toast.LENGTH_SHORT).show();
        if(Avatar.nome.equals("undefined")){

        }else{
        LinearLayout barra = (LinearLayout)findViewById(R.id.thebar);
        TextView dimdim = (TextView)barra.findViewById(R.id.txMoney);

            TextView level = (TextView)barra.findViewById(R.id.txLvl);
            TextView texp = (TextView)barra.findViewById(R.id.txExp);
        dimdim.setText("$" + String.valueOf(Avatar.money));
            texp.setText(String.valueOf(Avatar.exp) + "/" + Avatar.levels[Avatar.lvl+1]);
            level.setText(String.valueOf(Avatar.lvl));
            SharedPreferences.Editor editSave = saveFile.edit();
            editSave.putInt("Dinheiro", Avatar.money);
            editSave.putInt("Experiencia", Avatar.exp);
            editSave.putInt("Nivel", Avatar.lvl);
            editSave.putInt("Roupa", Avatar.hatnum);
            editSave.putInt("Skin", Avatar.skinum);
            editSave.apply();
            ImageView hatav = (ImageView) barra.findViewById(R.id.hatav);
            RelativeLayout avatah=(RelativeLayout) barra.findViewById(R.id.Avatar);
            int iconbg = getResources().getIdentifier("drawable/skin" + Avatar.skinum, "drawable", getPackageName());
            avatah.setBackgroundResource(iconbg);

                hatav.setVisibility(View.VISIBLE);
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

    }
    public void msgteste(View view){
        TextView avatar = (TextView) findViewById (R.id.nomeRaposa);
Avatar.nome=avatar.getText().toString();
        SharedPreferences.Editor editSave = saveFile.edit();
        editSave.putString("Nome raposa", Avatar.nome);
        Avatar.money=0;
        Avatar.exp=0;

        editSave.putInt("Dinheiro", Avatar.money);
        editSave.apply();
        setContentView(R.layout.mainmenu);
        LinearLayout barra = (LinearLayout)findViewById(R.id.thebar);

        TextView nomeraposa = (TextView)barra.findViewById(R.id.avtrname);

nomeraposa.setText(Avatar.nome);
        TextView txmoney = (TextView)barra.findViewById(R.id.txMoney);
        Toast.makeText(getApplicationContext(),Avatar.nome , Toast.LENGTH_SHORT).show();
        ImageButton btnperf=(ImageButton)barra.findViewById(R.id.button);
        final Intent novatelap = new Intent(this, perfil.class);
        btnperf.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(novatelap);
            }
        });


    }

    public void questao(View view){
        Intent novatela = new Intent(this, QuestActivity.class);
        novatela.putExtra("Matéria","Random");
        startActivity(novatela);
    }
    public void irLoja(View v){
        Intent novatela = new Intent(this, Loja.class);
        startActivity(novatela);
    }
    public void irEst(View v){
        Intent novatela = new Intent(this, Modo_estudo.class);
        startActivity(novatela);
    }
}
