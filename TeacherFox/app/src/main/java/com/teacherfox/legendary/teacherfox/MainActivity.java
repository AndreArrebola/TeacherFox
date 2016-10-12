package com.teacherfox.legendary.teacherfox;

import android.app.AlertDialog;
import android.content.DialogInterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void msgteste(View view){
        TextView avatar = (TextView) findViewById (R.id.nomeRaposa);
Avatar.nome=avatar.getText().toString();
        setContentView(R.layout.mainmenu);
        LinearLayout barra = (LinearLayout)findViewById(R.id.thebar);
        TextView nomeraposa = (TextView)barra.findViewById(R.id.avtrname);
nomeraposa.setText(Avatar.nome.toString());
        Toast.makeText(getApplicationContext(),Avatar.nome , Toast.LENGTH_SHORT).show();


    }
    public void questao(View view){
        Intent novatela = new Intent(this, QuestActivity.class);
        startActivity(novatela);
    }
}
