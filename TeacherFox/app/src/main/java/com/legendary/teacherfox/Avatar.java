package com.legendary.teacherfox;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by andre on 12/10/16.
 */
public class Avatar {
    static String nome;
    static int money;
    static int lvl;
    static int exp;
    static int hatnum;
    static boolean hattf=false;
    static int skinum;

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
            Avatar.hatnum=id;

            editSave.putInt("Roupa", Avatar.hatnum);
            editSave.putBoolean("Roupatf", Avatar.hattf);
        }else{
            Avatar.skinum=id;

            editSave.putInt("Skin", Avatar.skinum);

        }



        editSave.apply();

    }


}