package com.teacherfox.legendary.teacherfox;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences saveFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = this;
        saveFile = context.getSharedPreferences("save",Context.MODE_PRIVATE);

        Avatar.nome= saveFile.getString("Nome raposa", "undefined");
        Avatar.money= saveFile.getInt("Dinheiro", 0);
        if(Avatar.nome.equals("undefined")){
            setContentView(R.layout.activity_main);
        }else{
            setContentView(R.layout.mainmenu);
            LinearLayout barra = (LinearLayout)findViewById(R.id.thebar);
            TextView nomeraposa = (TextView)barra.findViewById(R.id.avtrname);
            nomeraposa.setText(Avatar.nome);
            Toast.makeText(getApplicationContext(),"Bem vindo, " + Avatar.nome , Toast.LENGTH_SHORT).show();
        }



    }
    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(),"Testando, " + Avatar.nome , Toast.LENGTH_SHORT).show();
        if(Avatar.nome.equals("undefined")){

        }else{
        LinearLayout barra = (LinearLayout)findViewById(R.id.thebar);
        TextView dimdim = (TextView)barra.findViewById(R.id.txMoney);
        dimdim.setText(String.valueOf(Avatar.money));
            SharedPreferences.Editor editSave = saveFile.edit();
            editSave.putInt("Dinheiro", Avatar.money);
            editSave.apply();
        }

    }
    public void msgteste(View view){
        TextView avatar = (TextView) findViewById (R.id.nomeRaposa);
Avatar.nome=avatar.getText().toString();
        SharedPreferences.Editor editSave = saveFile.edit();
        editSave.putString("Nome raposa", Avatar.nome);
        Avatar.money=0;
        editSave.putInt("Dinheiro", Avatar.money);
        editSave.apply();
        setContentView(R.layout.mainmenu);
        LinearLayout barra = (LinearLayout)findViewById(R.id.thebar);

        TextView nomeraposa = (TextView)barra.findViewById(R.id.avtrname);

nomeraposa.setText(Avatar.nome);
        TextView txmoney = (TextView)barra.findViewById(R.id.txMoney);
        Toast.makeText(getApplicationContext(),Avatar.nome , Toast.LENGTH_SHORT).show();


    }
    public void questao(View view){
        Intent novatela = new Intent(this, QuestActivity.class);
        startActivity(novatela);
    }
}
