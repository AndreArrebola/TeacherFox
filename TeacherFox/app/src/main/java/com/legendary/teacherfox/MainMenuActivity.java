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

import com.legendary.teacherfox.databinding.BarraBinding;
import com.legendary.teacherfox.databinding.MainmenuBinding;

public class MainMenuActivity extends AppCompatActivity {
    SharedPreferences saveFile;
    private MainmenuBinding tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Avatar.loadCharacter(this);

        if(Avatar.nome.equals("undefined")){
            setContentView(R.layout.novouser);
        }else{
            tela = MainmenuBinding.inflate(getLayoutInflater());
            //setContentView(R.layout.mainmenu);
            setContentView(tela.getRoot());

            BarraBinding barra = tela.thebar;
            TextView nomeRaposa = barra.avtrname;
            nomeRaposa.setText(Avatar.nome);
            Toast.makeText(getApplicationContext(),"Bem vindo, " + Avatar.nome , Toast.LENGTH_SHORT).show();
            ImageButton botaoPerfil = barra.button;
            final Intent novatelap = new Intent(this, perfil.class);
            botaoPerfil.setOnClickListener(v -> startActivity(novatelap));
        }



    }
    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(),"Dados salvos" , Toast.LENGTH_SHORT).show();
        if(!Avatar.nome.equals("undefined")){
            LinearLayout barra = (LinearLayout)findViewById(R.id.thebar);
            TextView txDinheiro = (TextView)barra.findViewById(R.id.txMoney);
            TextView level = (TextView)barra.findViewById(R.id.txLvl);
            TextView texp = (TextView)barra.findViewById(R.id.txExp);
            txDinheiro.setText("$" + String.valueOf(Avatar.money));
            texp.setText(String.valueOf(Avatar.exp) + "/" + Avatar.levels[Avatar.level +1]);
            level.setText(String.valueOf(Avatar.level));
            Avatar.saveCharacter();

            ImageView hatav = (ImageView) barra.findViewById(R.id.hatav);
            RelativeLayout avatah=(RelativeLayout) barra.findViewById(R.id.Avatar);
            int iconbg = getResources().getIdentifier("drawable/skin" + Avatar.idSkin, "drawable", getPackageName());
            avatah.setBackgroundResource(iconbg);

            hatav.setVisibility(View.VISIBLE);
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

        }

    }
    public void criarUser(View view){
        TextView avatar = (TextView) findViewById (R.id.nomeRaposa);
        Avatar.nome=avatar.getText().toString();
        Avatar.money=0;
        Avatar.exp=0;


        tela = MainmenuBinding.inflate(getLayoutInflater());
        setContentView(tela.getRoot());
        LinearLayout barra = (LinearLayout)findViewById(R.id.thebar);

        TextView nomeraposa = (TextView)barra.findViewById(R.id.avtrname);

        nomeraposa.setText(Avatar.nome);
        TextView txmoney = (TextView)barra.findViewById(R.id.txMoney);
        Toast.makeText(getApplicationContext(),Avatar.nome , Toast.LENGTH_SHORT).show();
        ImageButton botaoPerfil=(ImageButton)barra.findViewById(R.id.button);
        final Intent novaTelaPerfil = new Intent(this, perfil.class);
        botaoPerfil.setOnClickListener(v -> startActivity(novaTelaPerfil));


    }

    public void irQuestao(View view){
        Intent criarTelaQuestao = new Intent(this, QuestActivity.class);
        criarTelaQuestao.putExtra("Matéria","Random");
        startActivity(criarTelaQuestao);
    }
    public void irLoja(View v){
        Intent criarTelaLoja = new Intent(this, Loja.class);
        startActivity(criarTelaLoja);
    }
    public void irEst(View v){
        Intent criarTelaEstudo = new Intent(this, Modo_estudo.class);
        startActivity(criarTelaEstudo);
    }
}
