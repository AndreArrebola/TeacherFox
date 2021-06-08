package com.legendary.teacherfox;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by andre on 12/10/16.
 */
public class Avatar {
    static String nome;
    static int money;
    static int level;
    static int exp;
    static int idHat;
    static boolean hattf=false;
    static int idSkin;

    static SharedPreferences saveFile;

    static int[] levels={
            0,
            10,
            20,
            40,
            60,
            90,
            120,
            160,
            200,
            250,
            300,
            360,
            420,
            490,
            560,
            640,
            720
    };
    static int[][] positions={
            {1,50,50,0,0,20,40}
    };
    static int[][] positionsr={
            {1,120,120,0,0,90,115}
    };
    public static void saveCloth(Context c, int tipo, int id){
        SharedPreferences saveFile;
        saveFile = c.getSharedPreferences("save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editSave = saveFile.edit();
        if(tipo==1){
            Avatar.idHat = id;

            editSave.putInt("Roupa", Avatar.idHat);
            editSave.putBoolean("Roupatf", Avatar.hattf);
        }else{
            Avatar.idSkin = id;

            editSave.putInt("Skin", Avatar.idSkin);

        }

        editSave.apply();

    }

    public static void loadCharacter(Context context){
        saveFile = context.getSharedPreferences("save",Context.MODE_PRIVATE);

        Avatar.nome= saveFile.getString("Nome raposa", "undefined");
        Avatar.money= saveFile.getInt("Dinheiro", 0);
        Avatar.exp= saveFile.getInt("Experiencia", 0);
        Avatar.level = saveFile.getInt("Nivel", 0);
        Avatar.idHat = saveFile.getInt("Roupa", 0);
        Avatar.hattf=saveFile.getBoolean("Roupatf", true);
        Avatar.idSkin =saveFile.getInt("Skin", 0);


    }
    public static void saveCharacter(){
        SharedPreferences.Editor editSave = saveFile.edit();
        editSave.putInt("Dinheiro", Avatar.money);
        editSave.putInt("Experiencia", Avatar.exp);
        editSave.putInt("Nivel", Avatar.level);
        editSave.putInt("Roupa", Avatar.idHat);
        editSave.putInt("Skin", Avatar.idSkin);
        editSave.apply();
    }


}