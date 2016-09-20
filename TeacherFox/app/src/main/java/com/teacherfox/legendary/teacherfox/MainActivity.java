package com.teacherfox.legendary.teacherfox;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void msgteste(View view){
        TextView avatar = (TextView) findViewById (R.id.nomeRaposa);
        String nomer = avatar.getText().toString();

        TextView avatarshow= (TextView) findViewById (R.id.avtrname);
        avatarshow.setText(nomer);
        setContentView(R.layout.mainmenu);

    }
    public void questao(View view){
        Intent novatela = new Intent(this, QuestActivity.class);
        startActivity(novatela);
    }
}
